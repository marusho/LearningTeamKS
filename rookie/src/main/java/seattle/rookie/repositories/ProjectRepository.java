package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long>{

	public ProjectEntity findByProjectId(int projectid);
	public String findProjectNameByProjectId(int projectid);
	public ProjectEntity findByProjectName(String projectName);
	public List<ProjectEntity> findByCustomerNameAndProjectName(String customerName, String projectName);

}






