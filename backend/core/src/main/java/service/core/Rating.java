package service.core;


import java.util.ArrayList;


/* Document for mongoDB which stores average star rating and all reviews for hotel (identified by id)*/
public class Rating {

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