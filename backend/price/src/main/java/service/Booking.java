package service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Bookings")
public class Booking {
    @Id
    public long BookingId;
    public String hotelId;
    public String customerName;
    public String startDate;
    public String endDate;
    public double price;

    public Booking() {}

    public Booking(long BookingId, String hotelId, String customerName, String startDate, String endDate, double price) {
        this.BookingId = BookingId;
        this.hotelId = hotelId;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
}
