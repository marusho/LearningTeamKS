package seattle.rookie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.CareerVisions;
import seattle.rookie.model.CareerVisionsPK;

@Repository
public interface CareerVisionsRepository extends JpaRepository<CareerVisions, CareerVisionsPK> {

	@Query(value="select * from career_visions cv "
			+ "inner join users u on u.user_id = cv.user_id "
			+ "where cv.user_id = ?1 order by cv.version desc limit 1", nativeQuery = true)
	public Optional<CareerVisions> findByUserIdOrderByVersionDesc(int userId, int version);
	
}