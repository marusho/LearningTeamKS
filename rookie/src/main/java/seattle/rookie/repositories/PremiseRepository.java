package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Premise;

//前提事項レポジトリ
@Repository
public interface PremiseRepository extends JpaRepository<Premise, Integer > {

	Premise findByUserId(int thisUserId);

	Premise findByUserIdAndYearAndTerm(int thisUserId, int i, int j);


	List<Premise> findByUserIdAndYearAndTerm(int userId, int year, boolean checkTermName);
	
	//UserId・年度・期が一致するデータの取得(POSTで使用)
	@Query("select p from Premise p "
			+ "where p.userId = ?1 "
			+ "and p.year = ?2 "
			+ "and p.term = ?3")
	Premise findPerson(int userId, int year, boolean checkTermName);

	void deleteByUserId(int id);
	
}
