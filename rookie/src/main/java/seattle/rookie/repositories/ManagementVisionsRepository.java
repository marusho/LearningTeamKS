package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.ManagementVisions;
import seattle.rookie.model.ManagementVisionsPK;

@Repository
public interface ManagementVisionsRepository extends JpaRepository<ManagementVisions, ManagementVisionsPK> {
	@Query(value="select * from management_visions mv "
			+ "inner join users u on u.user_id = mv.user_id "
			+ "inner join career_visions cv on mv.user_id = cv.user_id "
			+ "where cv.user_id = ?1 and "
			+ "mv.version = (select max(mv.version) from management_visions mv "
			+ "inner join career_visions cv on mv.user_id = cv.user_id where cv.user_id = ?1)" , nativeQuery = true)
	public List<ManagementVisions> findByUserIdOrderByVersionDesc(int userId, int version);	
}
