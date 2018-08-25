package seattle.rookie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	public Project findByProjectId(int projectid);
	public String findProjectNameByProjectId(int projectid);
	public Project findByProjectName(String projectName);
	

}





 
