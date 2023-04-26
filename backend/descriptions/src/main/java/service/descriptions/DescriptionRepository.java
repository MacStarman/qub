package service.descriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DescriptionRepository extends JpaRepository<HotelDescription, Long> {
	
	@Query("SELECT d FROM descriptions d WHERE d.descID = ?1")
	public HotelDescription findDescriptionByID(String id);

}
