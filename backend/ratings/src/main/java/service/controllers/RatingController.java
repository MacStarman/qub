package service.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import service.core.Rating;
import service.ratings.RatingRepository;
import service.core.Review;

@RestController
public class RatingController {

    @Autowired
    RatingRepository ratings;

    @GetMapping(value = "/ratings", produces = "application/json")
    public ResponseEntity<ArrayList<Rating>> getRatings() {
        ArrayList<Rating> list = new ArrayList<>();
        for (Rating rating : ratings.findAll()) {
            list.add(rating);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @GetMapping(value = "/ratings/{id}", produces = { "application/json" })
    public ResponseEntity<Rating> getRating(@PathVariable String id) {
        Rating rating = ratings.findRatingById(id);
        if (rating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }


    @PostMapping(value = "/ratings", consumes = "application/json")
    public ResponseEntity<Rating> addReview(
            @RequestBody Review review) {
        
        Rating rating;

        //If exists retrieve and delete, else create new Rating
        if(ratings.findRatingById(review.getHotelId()) == null) {
            rating = new Rating(review.getHotelId(), 0, new ArrayList<Review>());
        }
        else{
            rating = ratings.findRatingById(review.getHotelId());
            ratings.deleteById(review.getHotelId());
        }

        //Add review to hotel and add updated Rating to DB
        rating.addReview(review);
        ratings.insert(rating);

        String url = "http://" + getHost() + "/ratings/"
                + rating.getId();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", url)
                .header("Content-Location", url)
                .body(rating);
    }


    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
            return "localhost:" + port;
        }
    }

    @Value("${server.port}")
    private int port;
}