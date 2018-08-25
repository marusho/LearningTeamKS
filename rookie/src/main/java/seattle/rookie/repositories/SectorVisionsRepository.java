package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.SectorVisions;
import seattle.rookie.model.SectorVisionsPK;

@Repository
public interface SectorVisionsRepository extends JpaRepository<SectorVisions, SectorVisionsPK> {
	@Query(value="select * from sector_visions ev "
			+ "inner join users u on u.user_id = ev.user_id "
			+ "inner join career_visions cv on ev.user_id = cv.user_id "
			+ "where cv.user_id = ?1 and "
			+ "ev.version = (select max(ev.version) from sector_visions ev "
			+ "inner join career_visions cv on ev.user_id = cv.user_id where cv.user_id = ?1)" , nativeQuery = true)
	List<SectorVisions> findByUserIdOrderByVersionDesc(int userId, int version);

}
