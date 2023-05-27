package service.core;

public class HotelDetails {
    private Rating rating;
    private HotelDescription description;
    private HotelPrice price;

    public HotelDescription getDescription() {
        return description;
    }

    public HotelPrice getPrice() {
        return price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setDescription(HotelDescription description) {
        this.description = description;
    }
    public void setPrice(HotelPrice price) {
        this.price = price;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public HotelDetails(Rating rating, HotelDescription description, HotelPrice price) {
        this.rating = rating;
        this.description = description;
        this.price = price;
    }
}
