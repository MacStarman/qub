<<<<<<< HEAD
package service.core;

public class Review {
    private String hotelId;
    private String reviewerName;
    private double stars;
    private String comment;

    public Review(){}

    public Review(String hotelId, String reviewerName, double stars, String comment) {
        this.reviewerName = reviewerName;
        this.stars = stars;
        this.comment = comment;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public double getStars() {
        return stars;
    }

    public String getComment() {
        return comment;
    }
}

=======
package service.core;

public class Review {
    private String hotelId;
    private String reviewerName;
    private double stars;
    private String comment;

    public Review(){}

    public Review(String hotelId, String reviewerName, double stars, String comment) {
        this.reviewerName = reviewerName;
        this.stars = stars;
        this.comment = comment;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public double getStars() {
        return stars;
    }

    public String getComment() {
        return comment;
    }
}

>>>>>>> 7ed26a575c82056c541dccc9a7d08fdf51f5819a
