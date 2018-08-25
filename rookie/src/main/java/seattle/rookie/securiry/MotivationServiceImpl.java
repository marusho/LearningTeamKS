//package seattle.rookie.securiry;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//import seattle.rookie.model.Motivation;
//import seattle.rookie.repositories.MotivationRepository;
//
//// モチベーションテーブルの全てのレコードを取得
//@Service
//@Transactional
//public class MotivationServiceImpl implements MotivationRepository {
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Override
//	public List<Motivation> getMotivationList() {
//		return entityManager.createQuery("select e from Motivation e", Motivation.class).getResultList();
//	}
//	
//}
