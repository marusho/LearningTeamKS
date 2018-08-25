package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MasterSectorVisions;

@Repository
public interface MasterSectorVisionsRepository extends JpaRepository <MasterSectorVisions, Integer> {

	List<MasterSectorVisions> findAll();

}
