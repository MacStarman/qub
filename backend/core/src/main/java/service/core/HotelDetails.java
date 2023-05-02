package service.core;

public class HotelDetails {
    private Rating rating;
    private HotelDescription description;
    private PriceResponse price;

    public HotelDetails(Rating rating, HotelDescription description, PriceResponse price) {
        this.rating = rating;
        this.description = description;
        this.price = price;
    }
}
