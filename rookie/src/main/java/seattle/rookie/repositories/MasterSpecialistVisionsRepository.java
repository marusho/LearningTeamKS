package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MasterSpecialistVisions;

@Repository
public interface MasterSpecialistVisionsRepository extends JpaRepository<MasterSpecialistVisions, Integer>  {

	List<MasterSpecialistVisions> findAll();

}
