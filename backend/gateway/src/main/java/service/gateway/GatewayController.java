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

        if(services.put("price", "http://localhost:8081/price") == null){
            System.out.println("price failed!!!!!");
        }
        if(services.put("ratings", "http://localhost:8080/ratings") == null){
            System.out.println("ratings failed!!!!!");
        }
        if(services.put("descriptions", "http://localhost:8080/descriptions") == null){
            System.out.println("descriptions failed!!!!!");
        }
        return services;
    }

    private ResponseEntity<HotelDescription[]> getHotelDescription(String url, BookingForm request) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<HotelDescription[]> response = template.postForEntity(url, request, HotelDescription[].class);
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
        ResponseEntity<Rating[]> response = template.postForEntity(url, request, Rating[].class);
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
        String description_servie_url = getServices().get("descriptions");
        ResponseEntity<HotelDescription[]> description_response = getHotelDescription(description_servie_url, request);
        String price_servie_url = getServices().get("price");
        ResponseEntity<PriceResponse[]> price_response = getPrice(price_servie_url, request);
        String rating_servie_url = getServices().get("ratings");
        ResponseEntity<Rating[]> raiting_response = getRating(rating_servie_url, request);

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



    @PostMapping("/hotel/{id}/details")
    public ResponseEntity<HotelDetails> getDetails(@PathVariable String id) {

        String description_servie_url = getServices().get("description");
        ResponseEntity<HotelDescription> description_response = getHotelDescription(description_servie_url, id);
        String price_servie_url = getServices().get("price");
        ResponseEntity<PriceResponse> price_response = getPrice(price_servie_url, id);
        String rating_servie_url = getServices().get("rating");
        ResponseEntity<Rating> raiting_response = getRating(rating_servie_url, id);
        HotelDetails details = new HotelDetails(raiting_response.getBody(), description_response.getBody(), price_response.getBody());
        return ResponseEntity.ok().body(details);
    }

    private ResponseEntity<HotelDescription> getHotelDescription(String descriptionServieUrl, String id) {
        return null;
    }

    private ResponseEntity<Rating> getRating(String ratingServieUrl, String id) {
        return null;
    }

    private ResponseEntity<PriceResponse> getPrice(String priceServieUrl, String id) {
        return null;
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