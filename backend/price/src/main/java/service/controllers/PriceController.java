package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Booking;
import service.BookingForm;
import service.BookingRepository;
import service.PriceService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

@RestController
public class PriceController {
    @Autowired
    BookingRepository bookings;
    private PriceService service = new PriceService();

    @Value("${server.port}")
    private int port;

    @GetMapping(value="/bookings", produces="application/json")
    public ResponseEntity<Collection<Booking>> seeBookings() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookings.findAll());
    }

    @GetMapping(value="/bookings/{id}", produces={"application/json"})
    public ResponseEntity<Booking> getBooking(@PathVariable String id) {
        Booking booking = bookings.findBookingById(id);
        if(booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @PostMapping(value="/bookings", consumes="application/json")
    public ResponseEntity<Booking> book(
            @RequestBody BookingForm bookingForm) {
        double fullPrice = service.computePrice(bookingForm);
        Booking booking = new Booking(bookings.count(), bookingForm.hotelId, bookingForm.customerName, bookingForm.startDate, bookingForm.endDate, fullPrice);
        bookings.insert(booking);

        String url = "http://" + getHost() + "/quotation/"
                + booking.hotelId;

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", url)
                .header("Content-Location", url)
                .body(booking);
    }

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
            return "localhost:" + port;
        }
    }
}
