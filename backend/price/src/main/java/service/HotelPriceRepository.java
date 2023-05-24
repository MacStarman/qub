package service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import service.core.HotelPrice;
import service.core.PriceResponse;

import java.util.List;

public interface HotelPriceRepository extends MongoRepository<HotelPrice, String> {
    @Query("{'location' : ?0}")
    List<HotelPrice> findPricesByLocation(String location);

    @Query("{'hotelId' : ?0}")
    HotelPrice findHotelPriceById(String hotelId);
}
