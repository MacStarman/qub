package service;

import org.springframework.data.mongodb.repository.MongoRepository;
import service.core.PriceResponse;

public interface PriceResponseRepository extends MongoRepository<PriceResponse, String> {

}
