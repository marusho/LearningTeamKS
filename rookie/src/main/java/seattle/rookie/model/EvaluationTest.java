//package seattle.rookie.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.sql.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import seattle.rookie.repositories.EvaluationRepository;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
//public class EvaluationTest {
//	
//	@Autowired
//	EvaluationRepository evrepo;
//
//	@Test
//	public void test() throws Exception {
//		Evaluation evaluation = new Evaluation();
//		evaluation.setId(1);
//		evaluation.setEngineerLevel("1");
//		evaluation.setSatisfyWeight(Float.valueOf("1.6"));
//		evaluation.setCommitmentWeight(Float.valueOf("1.6"));
//		evaluation.setProposalWeight(Float.valueOf("1.6"));
//		evaluation.setInternalCommunicationWeight(Float.valueOf("1.6"));
//		evaluation.setDevelopmentWeight(Float.valueOf("1.6"));
//		evaluation.setItSkillsWeight(Float.valueOf("1.2"));
//		evaluation.setUnderstandWeight(Float.valueOf("1.2"));
//		evaluation.setCommunicationWeight(Float.valueOf("1.2"));
//		evaluation.setLeadershipWeight(Float.valueOf("1.2"));
//		evaluation.setResolveWeight(Float.valueOf("1.2"));
//		evaluation.setProfessionalWeight(Float.valueOf("0"));
//		evaluation.setFieldSalesWeight(Float.valueOf("0"));
//		evaluation.setThanksWeight(Float.valueOf("1"));
//		evaluation.setEngineWeight(Float.valueOf("1"));
//		evaluation.setAllWeight(Float.valueOf("1"));
//		evaluation.setMasterpieceWeight(Float.valueOf("1"));
//		evaluation.setStockWeight(Float.valueOf("1"));
//		evaluation.setSeattleBrandWeight(Float.valueOf("1"));
//		evaluation.setRegisteredAt(Date.valueOf("2018-06-04"));
//		evaluation.setUpdatedAt(Date.valueOf("2018-06-04"));
//		evaluation.setRegisteredBy("大竹口");
//		evaluation.setUpdatedBy("大竹口");
//		evaluation.setVersion(1);
//		Evaluation evaluationCompare = evrepo.findById(1);
//		assertThat(evaluationCompare.getEngineerLevel()).isEqualTo("1");
//		assertThat(evaluationCompare.getSatisfyWeight()).isEqualTo(Float.valueOf("1.6"));
//		assertThat(evaluationCompare.getCommitmentWeight()).isEqualTo(Float.valueOf("1.6"));
//		assertThat(evaluationCompare.getProposalWeight()).isEqualTo(Float.valueOf("1.6"));
//		assertThat(evaluationCompare.getInternalCommunicationWeight()).isEqualTo(Float.valueOf("1.6"));
//		assertThat(evaluationCompare.getDevelopmentWeight()).isEqualTo(Float.valueOf("1.6"));
//		assertThat(evaluationCompare.getItSkillsWeight()).isEqualTo(Float.valueOf("1.2"));
//		assertThat(evaluationCompare.getUnderstandWeight()).isEqualTo(Float.valueOf("1.2"));
//		assertThat(evaluationCompare.getCommunicationWeight()).isEqualTo(Float.valueOf("1.2"));
//		assertThat(evaluationCompare.getLeadershipWeight()).isEqualTo(Float.valueOf("1.2"));
//		assertThat(evaluationCompare.getResolveWeight()).isEqualTo(Float.valueOf("1.2"));
//		assertThat(evaluationCompare.getProfessionalWeight()).isEqualTo(Float.valueOf("0"));
//		assertThat(evaluationCompare.getFieldSalesWeight()).isEqualTo(Float.valueOf("0"));
//		assertThat(evaluationCompare.getThanksWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getEngineWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getAllWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getMasterpieceWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getStockWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getSeattleBrandWeight()).isEqualTo(Float.valueOf("1"));
//		assertThat(evaluationCompare.getRegisteredAt()).isEqualTo(Date.valueOf("2018-06-04"));
//		assertThat(evaluationCompare.getUpdatedAt()).isEqualTo(Date.valueOf("2018-06-04"));
//		assertThat(evaluationCompare.getRegisteredBy()).isEqualTo("大竹口");
//		assertThat(evaluationCompare.getUpdatedBy()).isEqualTo("大竹口");
//		assertThat(evaluationCompare.getVersion()).isEqualTo(1);
//		
//	}
//
//}
