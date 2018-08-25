package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.SpecialistVisions;
import seattle.rookie.model.SpecialistVisionsPK;

@Repository
public interface SpecialistVisionsRepository extends JpaRepository<SpecialistVisions, SpecialistVisionsPK> {

	@Query(value="select * from specialist_visions sv "
			+ "inner join users u on u.user_id = sv.user_id "
			+ "inner join career_visions cv on sv.user_id = cv.user_id where cv.user_id = ?1 and sv.version = (select max(sv.version) from specialist_visions sv inner join career_visions cv on sv.user_id = cv.user_id where cv.user_id = ?1)" , nativeQuery = true)
	List<SpecialistVisions> findByUserIdOrderByVersionDesc(int userId, int version);

}
