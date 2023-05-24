package service.core;

public class HotelDetails {
    private Rating rating;
    private HotelDescription description;
    private HotelPrice price;

    public HotelDetails(Rating rating, HotelDescription description, HotelPrice price) {
        this.rating = rating;
        this.description = description;
        this.price = price;
    }
}
