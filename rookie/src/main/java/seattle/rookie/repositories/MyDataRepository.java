// @author aiko fukuda

package seattle.rookie.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
	public MyData findByUserId(long userId);

	public Page<MyData> findAll(Pageable pageable);

	public Page<MyData> findByDeleteFlagOrderByUserNameAsc(Pageable pageable, int i);

	// ネイティブクエリ文:ユーザーテーブルと中間プロジェクトテーブルの結合テーブル
	// MyDataエンティティをuと設定し、uの名前を選択する
	@Query("select distinct u from MyData u " + "left outer join MiddleProject mp on u.userId = mp.userId "
			+ "left outer join Project p on mp.projectId = p.projectId "
			+ "left outer join MiddleDepartment md on u.userId = md.userId "
			+ "left outer join Department d on md.departmentId = d.departmentId " + "where u.gender = 1 "
			+ "and u.deleteFlag = 0 " + "and mp.deleteFlag = 0 " + "and md.deleteFlag = 0 " + "and u.userName like ?1 "
			+ "and p.projectName like ?2 " + "and d.departmentName like ?3")
	public Page<MyData> findBySearchGender1(Pageable pageable, String userName, String projectName,
			String departmentName);

	@Query("select distinct u from MyData u " + "left outer join MiddleProject mp on u.userId = mp.userId "
			+ "left outer join Project p on mp.projectId = p.projectId "
			+ "left outer join MiddleDepartment md on u.userId = md.userId "
			+ "left outer join Department d on md.departmentId = d.departmentId " + "where u.gender = 0 "
			+ "and u.deleteFlag = 0 " + "and mp.deleteFlag = 0 " + "and md.deleteFlag = 0 " + "and u.userName like ?1 "
			+ "and p.projectName like ?2 " + "and d.departmentName like ?3")
	public Page<MyData> findBySearchGender0(Pageable pageable, String userName, String projectName,
			String departmentName);

	@Query("select distinct u from MyData u " + "left outer join MiddleProject mp on u.userId = mp.userId "
			+ "left outer join Project p on mp.projectId = p.projectId "
			+ "left outer join MiddleDepartment md on u.userId = md.userId "
			+ "left outer join Department d on md.departmentId = d.departmentId " + "where u.userName like ?1 "
			+ "and u.deleteFlag = 0 " + "and mp.deleteFlag = 0 " + "and md.deleteFlag = 0 "
			+ "and p.projectName like ?2 " + "and d.departmentName like ?3")
	public Page<MyData> findBySearchGender0And1(Pageable pageable, String userName, String projectName,
			String departmentName);

	public MyData findByEmail(String email);

	public MyData findByUserName(String userName);

	public Page<MyData> findByUserNameLikeAndDeleteFlagOrderByUserNameAsc(Pageable pageable, String userNameKey, int i);

	public Page<MyData> findByUserNameLikeOrderByUserNameAsc(Pageable pageable, String newNameKey);

	public MyData findByUserIdAndDeleteFlag(long userId, int deleteFlag);



}