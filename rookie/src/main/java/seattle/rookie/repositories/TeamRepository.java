package seattle.rookie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import seattle.rookie.model.Team;

//チームマスタのレポジトリ
public interface TeamRepository extends JpaRepository<Team, Integer> {

	public Team findByTeamId(int teamId);

	public Team findByTeam(String teamName);
	
	@Query("select t.team from Team t")
	public List<String> getTeamNameList();

}
