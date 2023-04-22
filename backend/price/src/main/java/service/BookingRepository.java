package service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookingRepository extends MongoRepository<Booking, String> {
    @Query("{id:'?0'}")
    Booking findBookingById(String id);
}
