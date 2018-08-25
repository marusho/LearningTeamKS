package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Result;

//評価結果レポジトリ
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    
	Result findById(int id);
	List<Result> findByUserId(int userId);

	List<Result> findByYearAndTerm(int year, boolean term);

	public List<Result> findByUserIdAndYearAndTerm(int userId, int year, boolean checkTermName);
	
	@Query("select r.year from Result r group by r.year order by r.year desc")
	public List<Integer> findYear();
	
	@Query(value = "select r from Result r where r.userId = ?1 and r.term = ?2 and r.year = (select Max(r.year) from r where r.userId = ?1)")
	Result findLatestData(int userId, boolean checkTermName);
	
	//UserId・年度・期が一致するデータの取得(POSTで使用) 
	@Query("select r from Result r "
			+ "where r.userId = ?1 "
			+ "and r.year = ?2 "
			+ "and r.term = ?3")
	Result findPerson(int userId, int year, boolean checkTermName);
	
	List<Result> findByEngineerLevelAndYearAndTerm(int level, int i, boolean b);
	Result findByTeamId(int i);
	void deleteByUserId(int id);
	
	


}
