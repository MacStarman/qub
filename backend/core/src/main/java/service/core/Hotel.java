package service.core;

public class Hotel {
    private String id;
    private PriceResponse price;
    private int rating;
    private HotelDescription description;

    public Hotel(String id, PriceResponse price, int rating, HotelDescription description) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public HotelDescription getDescription() {
        return description;
    }

    public void setDescription(HotelDescription description) {
        this.description = description;
    }
}