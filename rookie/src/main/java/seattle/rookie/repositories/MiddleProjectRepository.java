package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MiddleProject;

@Repository
public interface MiddleProjectRepository extends JpaRepository<MiddleProject,Integer>{
	
	public List<MiddleProject> findByUserId(int userId);
	public List<MiddleProject> findAllByOrderByIdDesc();
	public List<MiddleProject> findByUserIdOrderByIdDesc(int userId);
	
	public MiddleProject findById(int id);
	
}

