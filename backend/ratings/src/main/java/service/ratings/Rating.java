package service.ratings;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Document for mongoDB which stores average star rating and all reviews for hotel (identified by id)*/
@Document("Rating")
public class Rating {

    @Id
    private String id;

    private double stars;
    private ArrayList<Review> reviews;

    public Rating(){}

    public Rating(String id, double stars, ArrayList<Review> reviews) {
        super();
        this.id = id;
        this.stars = stars;
        this.reviews = reviews;
    }

    public void addReview(Review review) {

        reviews.add(review);

        //Update avg stars rating
        double totalStars = 0;
        for(Review r : reviews) {
            totalStars += r.getStars();
        }
        stars = totalStars/reviews.size();
    }

    public String getId() {
        return this.id;
    }

    public double getStars() {
        return this.stars;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

}