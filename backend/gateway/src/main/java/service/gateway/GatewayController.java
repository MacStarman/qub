package service.gateway;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.*;


@RestController
public class GatewayController {

    HashMap<String,String> services = new HashMap<String,String>();

    @Value("${server.port}")
    private int port;

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
            return "localhost:" + port;
        }
    }

    @GetMapping("/services")
    public HashMap<String,String> getServices() {

        services.put("price", "http://qub-price-1:8081/price");
        services.put("ratings", "http://qub-ratings-1:8080/ratings/");
        services.put("descriptions", "http://qub-descriptions-1:8083/descriptions/");
        return services;
    }

    private ResponseEntity<HotelDescription[]> getHotelDescription(String url, BookingForm request) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<HotelDescription[]> response = template.getForEntity(url, HotelDescription[].class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()).length + " hotels found");
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no hotels found for this time or location");
        }
        return response;
    }

    private ResponseEntity<PriceResponse[]> getPrice(String url, BookingForm request) {
        System.out.println(request.location);
        RestTemplate template = new RestTemplate();
        ResponseEntity<PriceResponse[]> response = template.postForEntity(url, request, PriceResponse[].class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()).length + " prices found");
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no price found for this time or location");
        }
        return response;
    }
    private ResponseEntity<Rating[]> getRating(String url, BookingForm request) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Rating[]> response = template.getForEntity(url, Rating[].class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()).length + " raitings found");
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no ratings found for this time or location");
        }
        return response;
    }

    @PostMapping(value ="/hotels", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Hotel[]> getHotels(@RequestBody BookingForm request){
        String rating_servie_url = getServices().get("ratings");
        ResponseEntity<Rating[]> raiting_response = getRating(rating_servie_url, request);
        String description_servie_url = getServices().get("descriptions");
        ResponseEntity<HotelDescription[]> description_response = getHotelDescription(description_servie_url, request);
        String price_servie_url = getServices().get("price");
        ResponseEntity<PriceResponse[]> price_response = getPrice(price_servie_url, request);

        ArrayList<Hotel> hotel_list = new ArrayList<>();
        HotelDescription[] descriptions = description_response.getBody();
        PriceResponse[] price = price_response.getBody();
        HashMap<String,PriceResponse> price_map = new HashMap<>();
        HashMap<String,Rating> rating_list = new HashMap<>();
        for (PriceResponse item : price) {
            price_map.put(item.getHotelId(),item);
        }
        assert descriptions != null;
        for (Rating item: Objects.requireNonNull(raiting_response.getBody())) {
            rating_list.put(item.getId(),item);
        }
        for (HotelDescription description : descriptions) {
            PriceResponse l_price = price_map.get(description.getId());
            Rating l_raiting = rating_list.get(description.getId());
            hotel_list.add(new Hotel(description.getId(),l_price, l_raiting, description));
        }
        Hotel[] hotelArray = hotel_list.toArray(new Hotel[hotel_list.size()]);
        return ResponseEntity.status(HttpStatus.OK).body(hotelArray);
    }

    @PostMapping(value = "/hotel/{id}/details",  consumes = "application/json", produces = "application/json")
    public ResponseEntity<HotelDetails> getDetails(@PathVariable("id") String id) {

        String price_servie_url = getServices().get("price");
        ResponseEntity<HotelPrice> price_response = getPrice(price_servie_url, id);

        String description_servie_url = getServices().get("descriptions");
        ResponseEntity<HotelDescription> description_response = getHotelDescription(description_servie_url, id);

        String rating_servie_url = getServices().get("ratings");
        ResponseEntity<Rating> raiting_response = getRating(rating_servie_url, id);
        HotelDetails details = new HotelDetails(raiting_response.getBody(), description_response.getBody(), price_response.getBody());
        System.out.println("DESCIPTION DEBUG");
        System.out.println(description_response.getBody().getHotelLink());
        System.out.println("RATINGS DEBUG");
        System.out.println(raiting_response.getBody().getStars());
        System.out.println("PRICE DEBUG");
        System.out.println(price_response.getBody().getPricePerPersonPerNight());

        return new ResponseEntity<HotelDetails>(details, HttpStatus.OK);
    }

    private ResponseEntity<HotelDescription> getHotelDescription(String descriptionServieUrl, String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<HotelDescription> response = template.getForEntity("http://qub-descriptions-1:8083/descriptions/ "+id, HotelDescription.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()));
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no description found");
        }
        return response;
    }    

    private ResponseEntity<Rating> getRating(String ratingServieUrl, String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Rating> response = template.getForEntity(ratingServieUrl+id, Rating.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()));
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no rating found");
        }
        return response;
    }

    private ResponseEntity<HotelPrice> getPrice(String priceServieUrl, String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<HotelPrice> response = template.getForEntity(priceServieUrl + "/" + id, HotelPrice.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            System.out.println(Objects.requireNonNull(response.getBody()));
        }
        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            System.out.println("no rating found");
        }

        return response;
    }

//    @GetMapping(value = "/applications/{id}", produces = "application/json")
//    public ResponseEntity<Application> getApplication(@PathVariable Integer id
//    ){
//        Application application = applications.get(id);
//        if (application == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
//        return ResponseEntity.status(HttpStatus.OK).body(application);
//    }
//
//    @PostMapping(value = "/applications", consumes = "application/json")
//    public ResponseEntity<Application> createQuotation(
//            @RequestBody ClientInfo info) {
//        Application application = new Application(info);
//        applications.put(application.id,application);
//        List<String> urls = getServices();
//        for (String url : urls){
//            RestTemplate template = new RestTemplate();
//            ResponseEntity<Quotation> response = template.postForEntity(url, info, Quotation.class);
//            if (response.getStatusCode().equals(HttpStatus.CREATED)) { System.out.println("Location of resource: "
//                    + response.getHeaders().getLocation().toString());
//            }
//            application.quotations.add(response.getBody());
//        }
//        String url = "http://" + getHost() + "/applications/" + application.id;
//        return ResponseEntity.status(HttpStatus.OK).header("Location", url).body(application);
//    }
}
