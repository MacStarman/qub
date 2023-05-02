package service.core;

public class Hotel {
    private String id;
    private PriceResponse price;
    private Rating rating;
    private HotelDescription description;

    public Hotel(String id, PriceResponse price, Rating rating, HotelDescription description) {
        this.id = id;
        this.price = price;
        this.rating = rating;
        this.description = description;
    }

    public Hotel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriceResponse getPrice() {
        return price;
    }

    public void setPrice(PriceResponse price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public HotelDescription getDescription() {
        return description;
    }

    public void setDescription(HotelDescription description) {
        this.description = description;
    }
}