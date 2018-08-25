package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MasterManagementVisions;

@Repository
public interface MasterManagementVisionsRepository extends JpaRepository<MasterManagementVisions, Integer> {

	List<MasterManagementVisions> findAll();

}
