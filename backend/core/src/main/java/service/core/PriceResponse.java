package service.core;

public class PriceResponse {
    private int BookingId;
    private String hotelId;

    private String startDate;

    private String endDate;

    private double price;

    public PriceResponse(int bookingId, String hotelId, String customerName, String startDate, String endDate, double price) {
        BookingId = bookingId;
        this.hotelId = hotelId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public PriceResponse() {

    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
