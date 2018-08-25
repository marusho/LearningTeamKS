package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MiddleDepartment;

@Repository
public interface MiddleDepartmentRepository extends JpaRepository<MiddleDepartment, Long> {

//	public List<Record> findByUserid(int id);
	public List<MiddleDepartment> findAll();
	public List<MiddleDepartment> findAllByOrderByIdDesc();
//	public List<MiddleDepartment> findByUserOrderByUserIdDesc(int userId);
//	public List<MiddleDepartment> findByMydataOrderByMydataDesc(MyData mydata);
	public MiddleDepartment findById(int id);
//    public List<Record> findRecord(@Param("userId") int userId);
//	public List<MiddleDepartment> findByMydata(MyData mydata);
//	public List<MiddleDepartment> findByMydataOrderByIdDesc(MyData mydata);
	public List<MiddleDepartment> findByUserIdOrderByIdDesc(int userId);
	public List<MiddleDepartment> findByUserId(int userId);
}
