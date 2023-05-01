package service.descriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<HotelDescription, Long> {
	
	@Query("select d FROM HotelDescription d WHERE d.id = ?1" )
	public HotelDescription findDescriptionByID(String id);

}
