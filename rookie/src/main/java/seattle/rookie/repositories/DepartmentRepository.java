package seattle.rookie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public Department findByDepartmentId(int departmentid);

	public String findOrguserNameByDepartmentId(int departmentid);

	public Department findByDepartmentName(String departmentuserName);
}
