package seattle.rookie.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seattle.rookie.model.Motivation;

@Repository
public interface MotivationRepository extends JpaRepository<Motivation, Integer> {

 public List<Motivation> findAll();

 public Motivation findById(long id);

 public List<Motivation> findByDateGreaterThanOrderByMydataUserIdAscDateDesc(Date date);

}