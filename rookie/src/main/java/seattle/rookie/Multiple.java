package seattle.rookie;

import org.springframework.stereotype.Service;

import seattle.rookie.model.Evaluation;
import seattle.rookie.model.MultipledResult;
import seattle.rookie.model.MyData;
import seattle.rookie.model.Result;
import seattle.rookie.model.Team;

@Service
public class Multiple {
	
//	CSVに出力する結果を計算するメソッド
	public MultipledResult multipleResult(Result rb, int num, Evaluation eval, MyData mydata, String attendance, String attitude,
			String securityAccident, Team team) {
		MultipledResult mr = new MultipledResult(eval);
		mr.setTeamName(team.getTeam());
		String thisName = mydata.getUserName();
		mr.setUserName(thisName);
		mr.setEngineerLevel(rb.getEngineerLevel());
		mr.setAttendstr(attendance);
		mr.setAttitudestr(attitude);
		mr.setSecurityAccidentstr(securityAccident);

		mr.setSatisfyScoreBefore(rb.getSatisfyScore());
		mr.setCommitmentScoreBefore(rb.getCommitmentScore());
		mr.setProposalScoreBefore(rb.getProposalScore());
		mr.setInternalCommunicationScoreBefore(rb.getInternalCommunicationScore());
		mr.setDevelopmentScoreBefore(rb.getDevelopmentScore());
		mr.setItSkillsScoreBefore(rb.getItSkillsScore());
		mr.setUnderstandScoreBefore(rb.getUnderstandScore());
		mr.setLeadershipScoreBefore(rb.getLeadershipScore());
		mr.setResolveScoreBefore(rb.getResolveScore());
		mr.setCommunicationScoreBefore(rb.getCommunicationScore());
		mr.setProfessionalScoreBefore(rb.getProfessionalScore());
		mr.setFieldSalesScoreBefore(rb.getFieldSalesScore());
		mr.setThanksScoreBefore(rb.getThanksScore());
		mr.setEngineScoreBefore(rb.getEngineScore());
		mr.setAllScoreBefore(rb.getAllScore());
		mr.setMasterpieceScoreBefore(rb.getMasterpieceScore());
		mr.setStockScoreBefore(rb.getStockScore());
		mr.setSeattleBrandScoreBefore(rb.getSeattleBrandScore());
		mr.setTotalScoreBefore(rb.getTotalScore());

		mr.setSatisfyScore(mr.mulSatisfyScore(rb.getSatisfyScore()));
		mr.setCommitmentScore(mr.mulCommitmentScore(rb.getCommitmentScore()));
		mr.setProposalScore(mr.mulProposalScore(rb.getProposalScore()));
		mr.setInternalCommunicationScore(mr.mulInternalCommunicationScore(rb.getInternalCommunicationScore()));
		mr.setDevelopmentScore(mr.mulDevelopmentScore(rb.getDevelopmentScore()));
		mr.setItSkillsScore(mr.mulItSkillsScore(rb.getItSkillsScore()));
		mr.setUnderstandScore(mr.mulUnderstandScore(rb.getUnderstandScore()));
		mr.setLeadershipScore(mr.mulLeadershipScore(rb.getLeadershipScore()));
		mr.setResolveScore(mr.mulResolveScore(rb.getResolveScore()));
		mr.setCommunicationScore(mr.mulCommunicationScore(rb.getCommunicationScore()));
		mr.setProfessionalScore(mr.mulProfessionalScore(rb.getProfessionalScore()));
		mr.setFieldSalesScore(mr.mulFieldSalesScore(rb.getFieldSalesScore()));
		mr.setThanksScore(mr.mulThanksScore(rb.getThanksScore()));
		mr.setEngineScore(mr.mulEngineScore(rb.getEngineScore()));
		mr.setAllScore(mr.mulAllScore(rb.getAllScore()));
		mr.setMasterpieceScore(mr.mulMasterpieceScore(rb.getMasterpieceScore()));
		mr.setStockScore(mr.mulStockScore(rb.getStockScore()));
		mr.setSeattleBrandScore(mr.mulSeattleBrandScore(rb.getSatisfyScore()));
		mr.sumAchievementBefore();
		mr.sumAbilityBefore();
		mr.sumPassionBefore();
		mr.sumAchievement();
		mr.sumAbility();
		mr.sumPassion();
		mr.sumTotalScore();
		return mr;
	}
	
//	評価シートに出力するための計算を行うメソッド
	MultipledResult multipleResult(Result rb, int num, Evaluation eval, MyData mydata, boolean attendance, boolean attitude,
			boolean securityAccident, Team team) {
		MultipledResult mr = new MultipledResult(eval);
		mr.setTeamName(team.getTeam());
		String thisName = mydata.getUserName();
		mr.setUserName(thisName);
		mr.setEngineerLevel(rb.getEngineerLevel());
		mr.setAttend(attendance);
		mr.setAttitude(attitude);
		mr.setSecurityAccident(securityAccident);
		mr.setSatisfyScoreBefore(rb.getSatisfyScore());
		mr.setCommitmentScoreBefore(rb.getCommitmentScore());
		mr.setProposalScoreBefore(rb.getProposalScore());
		mr.setInternalCommunicationScoreBefore(rb.getInternalCommunicationScore());
		mr.setDevelopmentScoreBefore(rb.getDevelopmentScore());
		mr.setItSkillsScoreBefore(rb.getItSkillsScore());
		mr.setUnderstandScoreBefore(rb.getUnderstandScore());
		mr.setLeadershipScoreBefore(rb.getLeadershipScore());
		mr.setResolveScoreBefore(rb.getResolveScore());
		mr.setCommunicationScoreBefore(rb.getCommunicationScore());
		mr.setProfessionalScoreBefore(rb.getProfessionalScore());
		mr.setFieldSalesScoreBefore(rb.getFieldSalesScore());
		mr.setThanksScoreBefore(rb.getThanksScore());
		mr.setEngineScoreBefore(rb.getEngineScore());
		mr.setAllScoreBefore(rb.getAllScore());
		mr.setMasterpieceScoreBefore(rb.getMasterpieceScore());
		mr.setStockScoreBefore(rb.getStockScore());
		mr.setSeattleBrandScoreBefore(rb.getSeattleBrandScore());
		mr.setTotalScoreBefore(rb.getTotalScore());
		mr.setRemark(rb.getRemark());

		mr.setSatisfyScore(mr.mulSatisfyScore(rb.getSatisfyScore()));
		mr.setCommitmentScore(mr.mulCommitmentScore(rb.getCommitmentScore()));
		mr.setProposalScore(mr.mulProposalScore(rb.getProposalScore()));
		mr.setInternalCommunicationScore(mr.mulInternalCommunicationScore(rb.getInternalCommunicationScore()));
		mr.setDevelopmentScore(mr.mulDevelopmentScore(rb.getDevelopmentScore()));
		mr.setItSkillsScore(mr.mulItSkillsScore(rb.getItSkillsScore()));
		mr.setUnderstandScore(mr.mulUnderstandScore(rb.getUnderstandScore()));
		mr.setLeadershipScore(mr.mulLeadershipScore(rb.getLeadershipScore()));
		mr.setResolveScore(mr.mulResolveScore(rb.getResolveScore()));
		mr.setCommunicationScore(mr.mulCommunicationScore(rb.getCommunicationScore()));
		mr.setProfessionalScore(mr.mulProfessionalScore(rb.getProfessionalScore()));
		mr.setFieldSalesScore(mr.mulFieldSalesScore(rb.getFieldSalesScore()));
		mr.setThanksScore(mr.mulThanksScore(rb.getThanksScore()));
		mr.setEngineScore(mr.mulEngineScore(rb.getEngineScore()));
		mr.setAllScore(mr.mulAllScore(rb.getAllScore()));
		mr.setMasterpieceScore(mr.mulMasterpieceScore(rb.getMasterpieceScore()));
		mr.setStockScore(mr.mulStockScore(rb.getStockScore()));
		mr.setSeattleBrandScore(mr.mulSeattleBrandScore(rb.getSatisfyScore()));
		mr.sumAchievementBefore();
		mr.sumAbilityBefore();
		mr.sumPassionBefore();
		mr.sumAchievement();
		mr.sumAbility();
		mr.sumPassion();
		mr.sumTotalScore();
		return mr;
	}
	
}
