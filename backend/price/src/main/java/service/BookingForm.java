package service;

public class BookingForm {
    public String hotelId;
    public String startDate;
    public String endDate;
    public String customerName;
    public double hotelPricePerDay;
    public int guestCount;

    public BookingForm(String HotelId, String startDate, String endDate, String customerName, double hotelPricePerDay, int guestCount){
        this.hotelId = HotelId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
        this.hotelPricePerDay = hotelPricePerDay;
        this.guestCount = guestCount;
    }

    public BookingForm() {}
}
