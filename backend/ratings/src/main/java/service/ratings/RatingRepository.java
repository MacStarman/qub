package service.ratings;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import service.core.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
    
    @Query("{id:'?0'}")
    Rating findRatingById(String id);
    
    public long count();

}