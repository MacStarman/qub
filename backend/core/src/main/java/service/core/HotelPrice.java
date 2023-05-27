package service.core;

public class HotelPrice {

    public String hotelId;
    public String location;
    public double pricePerPersonPerNight;

    public String getHotelId() {
        return hotelId;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerPersonPerNight() {
        return pricePerPersonPerNight;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void setPricePerPersonPerNight(double pricePerPersonPerNight) {
        this.pricePerPersonPerNight = pricePerPersonPerNight;
    }
}
