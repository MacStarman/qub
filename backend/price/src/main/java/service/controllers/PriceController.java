package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.*;
import service.core.BookingForm;
import service.core.HotelPrice;
import service.core.PriceResponse;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class PriceController {
    @Autowired
    HotelPriceRepository prices;
    private PriceService service = new PriceService();

    @Value("${server.port}")
    private int port;

    @GetMapping(value="/price", produces="application/json")
    public ResponseEntity<Collection<HotelPrice>> seePrices() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(prices.findAll());
    }
    
    @PostMapping(value="/price", consumes={"application/json"})
    public ResponseEntity<PriceResponse[]> calculatePrice(@RequestBody BookingForm bookingForm) {
        List<HotelPrice> hotelPrices = prices.findPricesByLocation(bookingForm.location);
        List<PriceResponse> responseList = new ArrayList<>();

        for(HotelPrice hp : hotelPrices) {
                System.out.println(hp.hotelId);
               responseList.add(new PriceResponse(hp.hotelId, bookingForm.startDate, bookingForm.endDate, service.computePrice(bookingForm, hp.pricePerPersonPerNight)));
        }

        PriceResponse[] responses = new PriceResponse[responseList.size()];
        responseList.toArray(responses);

    	return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping(value="/price/{id}")
    public ResponseEntity<HotelPrice> getPrice(@PathVariable String id) {
        HotelPrice response = prices.findHotelPriceById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping(value="/addprice", consumes="application/json")
    public ResponseEntity<HotelPrice> makePrice(
            @RequestBody HotelPrice hotelPrice) {
        prices.insert(hotelPrice);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelPrice);
    }

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
            return "localhost:" + port;
        }
    }
}
