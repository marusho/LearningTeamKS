package seattle.rookie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Evaluation;

//評価基準レポジトリ

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

	public Evaluation findByEngineerLevel(String engineerlevel);
}
