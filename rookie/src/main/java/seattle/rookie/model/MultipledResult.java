package seattle.rookie.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class MultipledResult {
	public Evaluation getEval() {
		return eval;
	}
	public void setEval(Evaluation eval) {
		this.eval = eval;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getEngineerLevel() {
		return engineerLevel;
	}
	public void setEngineerLevel(String engineerLevel) {
		this.engineerLevel = engineerLevel;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public boolean isAttend() {
		return attend;
	}
	public void setAttend(boolean attend) {
		this.attend = attend;
	}
	public boolean isAttitude() {
		return attitude;
	}
	public void setAttitude(boolean attitude) {
		this.attitude = attitude;
	}
	public boolean isSecurityAccident() {
		return securityAccident;
	}
	public void setSecurityAccident(boolean securityAccident) {
		this.securityAccident = securityAccident;
	}
	public String getAttendstr() {
		return attendstr;
	}
	public void setAttendstr(String attendstr) {
		this.attendstr = attendstr;
	}
	public String getAttitudestr() {
		return attitudestr;
	}
	public void setAttitudestr(String attitudestr) {
		this.attitudestr = attitudestr;
	}
	public String getSecurityAccidentstr() {
		return securityAccidentstr;
	}
	public void setSecurityAccidentstr(String securityAccidentstr) {
		this.securityAccidentstr = securityAccidentstr;
	}
	public float getSatisfyScoreBefore() {
		return satisfyScoreBefore;
	}
	public void setSatisfyScoreBefore(float satisfyScoreBefore) {
		this.satisfyScoreBefore = satisfyScoreBefore;
	}
	public float getCommitmentScoreBefore() {
		return commitmentScoreBefore;
	}
	public void setCommitmentScoreBefore(float commitmentScoreBefore) {
		this.commitmentScoreBefore = commitmentScoreBefore;
	}
	public float getProposalScoreBefore() {
		return proposalScoreBefore;
	}
	public void setProposalScoreBefore(float proposalScoreBefore) {
		this.proposalScoreBefore = proposalScoreBefore;
	}
	public float getInternalCommunicationScoreBefore() {
		return internalCommunicationScoreBefore;
	}
	public void setInternalCommunicationScoreBefore(float internalCommunicationScoreBefore) {
		this.internalCommunicationScoreBefore = internalCommunicationScoreBefore;
	}
	public float getDevelopmentScoreBefore() {
		return developmentScoreBefore;
	}
	public void setDevelopmentScoreBefore(float developmentScoreBefore) {
		this.developmentScoreBefore = developmentScoreBefore;
	}
	public float getItSkillsScoreBefore() {
		return itSkillsScoreBefore;
	}
	public void setItSkillsScoreBefore(float itSkillsScoreBefore) {
		this.itSkillsScoreBefore = itSkillsScoreBefore;
	}
	public float getUnderstandScoreBefore() {
		return understandScoreBefore;
	}
	public void setUnderstandScoreBefore(float understandScoreBefore) {
		this.understandScoreBefore = understandScoreBefore;
	}
	public float getLeadershipScoreBefore() {
		return leadershipScoreBefore;
	}
	public void setLeadershipScoreBefore(float leadershipScoreBefore) {
		this.leadershipScoreBefore = leadershipScoreBefore;
	}
	public float getResolveScoreBefore() {
		return resolveScoreBefore;
	}
	public void setResolveScoreBefore(float resolveScoreBefore) {
		this.resolveScoreBefore = resolveScoreBefore;
	}
	public float getCommunicationScoreBefore() {
		return communicationScoreBefore;
	}
	public void setCommunicationScoreBefore(float communicationScoreBefore) {
		this.communicationScoreBefore = communicationScoreBefore;
	}
	public float getProfessionalScoreBefore() {
		return professionalScoreBefore;
	}
	public void setProfessionalScoreBefore(float professionalScoreBefore) {
		this.professionalScoreBefore = professionalScoreBefore;
	}
	public float getFieldSalesScoreBefore() {
		return fieldSalesScoreBefore;
	}
	public void setFieldSalesScoreBefore(float fieldSalesScoreBefore) {
		this.fieldSalesScoreBefore = fieldSalesScoreBefore;
	}
	public float getThanksScoreBefore() {
		return thanksScoreBefore;
	}
	public void setThanksScoreBefore(float thanksScoreBefore) {
		this.thanksScoreBefore = thanksScoreBefore;
	}
	public float getEngineScoreBefore() {
		return engineScoreBefore;
	}
	public void setEngineScoreBefore(float engineScoreBefore) {
		this.engineScoreBefore = engineScoreBefore;
	}
	public float getAllScoreBefore() {
		return allScoreBefore;
	}
	public void setAllScoreBefore(float allScoreBefore) {
		this.allScoreBefore = allScoreBefore;
	}
	public float getMasterpieceScoreBefore() {
		return masterpieceScoreBefore;
	}
	public void setMasterpieceScoreBefore(float masterpieceScoreBefore) {
		this.masterpieceScoreBefore = masterpieceScoreBefore;
	}
	public float getStockScoreBefore() {
		return stockScoreBefore;
	}
	public void setStockScoreBefore(float stockScoreBefore) {
		this.stockScoreBefore = stockScoreBefore;
	}
	public float getSeattleBrandScoreBefore() {
		return seattleBrandScoreBefore;
	}
	public void setSeattleBrandScoreBefore(float seattleBrandScoreBefore) {
		this.seattleBrandScoreBefore = seattleBrandScoreBefore;
	}
	public float getTotalScoreBefore() {
		return totalScoreBefore;
	}
	public void setTotalScoreBefore(float totalScoreBefore) {
		this.totalScoreBefore = totalScoreBefore;
	}
	public float getSumAchievementBefore() {
		return sumAchievementBefore;
	}
	public void setSumAchievementBefore(float sumAchievementBefore) {
		this.sumAchievementBefore = sumAchievementBefore;
	}
	public float getSumAbilityBefore() {
		return sumAbilityBefore;
	}
	public void setSumAbilityBefore(float sumAbilityBefore) {
		this.sumAbilityBefore = sumAbilityBefore;
	}
	public float getSumPassionBefore() {
		return sumPassionBefore;
	}
	public void setSumPassionBefore(float sumPassionBefore) {
		this.sumPassionBefore = sumPassionBefore;
	}
	public BigDecimal getSumAchievement() {
		return sumAchievement;
	}
	public void setSumAchievement(BigDecimal sumAchievement) {
		this.sumAchievement = sumAchievement;
	}
	public BigDecimal getSumAbility() {
		return sumAbility;
	}
	public void setSumAbility(BigDecimal sumAbility) {
		this.sumAbility = sumAbility;
	}
	public BigDecimal getSumPassion() {
		return sumPassion;
	}
	public void setSumPassion(BigDecimal sumPassion) {
		this.sumPassion = sumPassion;
	}
	public BigDecimal getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<BigDecimal> getList() {
		return list;
	}
	public void setList(List<BigDecimal> list) {
		this.list = list;
	}
	public BigDecimal getSatisfyScore() {
		return satisfyScore;
	}
	public void setSatisfyScore(BigDecimal satisfyScore) {
		this.satisfyScore = satisfyScore;
	}
	public BigDecimal getCommitmentScore() {
		return commitmentScore;
	}
	public void setCommitmentScore(BigDecimal commitmentScore) {
		this.commitmentScore = commitmentScore;
	}
	public BigDecimal getProposalScore() {
		return proposalScore;
	}
	public void setProposalScore(BigDecimal proposalScore) {
		this.proposalScore = proposalScore;
	}
	public BigDecimal getInternalCommunicationScore() {
		return internalCommunicationScore;
	}
	public void setInternalCommunicationScore(BigDecimal internalCommunicationScore) {
		this.internalCommunicationScore = internalCommunicationScore;
	}
	public BigDecimal getDevelopmentScore() {
		return developmentScore;
	}
	public void setDevelopmentScore(BigDecimal developmentScore) {
		this.developmentScore = developmentScore;
	}
	public BigDecimal getItSkillsScore() {
		return itSkillsScore;
	}
	public void setItSkillsScore(BigDecimal itSkillsScore) {
		this.itSkillsScore = itSkillsScore;
	}
	public BigDecimal getUnderstandScore() {
		return understandScore;
	}
	public void setUnderstandScore(BigDecimal understandScore) {
		this.understandScore = understandScore;
	}
	public BigDecimal getLeadershipScore() {
		return leadershipScore;
	}
	public void setLeadershipScore(BigDecimal leadershipScore) {
		this.leadershipScore = leadershipScore;
	}
	public BigDecimal getResolveScore() {
		return resolveScore;
	}
	public void setResolveScore(BigDecimal resolveScore) {
		this.resolveScore = resolveScore;
	}
	public BigDecimal getCommunicationScore() {
		return communicationScore;
	}
	public void setCommunicationScore(BigDecimal communicationScore) {
		this.communicationScore = communicationScore;
	}
	public BigDecimal getProfessionalScore() {
		return professionalScore;
	}
	public void setProfessionalScore(BigDecimal professionalScore) {
		this.professionalScore = professionalScore;
	}
	public BigDecimal getFieldSalesScore() {
		return fieldSalesScore;
	}
	public void setFieldSalesScore(BigDecimal fieldSalesScore) {
		this.fieldSalesScore = fieldSalesScore;
	}
	public BigDecimal getThanksScore() {
		return thanksScore;
	}
	public void setThanksScore(BigDecimal thanksScore) {
		this.thanksScore = thanksScore;
	}
	public BigDecimal getEngineScore() {
		return engineScore;
	}
	public void setEngineScore(BigDecimal engineScore) {
		this.engineScore = engineScore;
	}
	public BigDecimal getAllScore() {
		return allScore;
	}
	public void setAllScore(BigDecimal allScore) {
		this.allScore = allScore;
	}
	public BigDecimal getMasterpieceScore() {
		return masterpieceScore;
	}
	public void setMasterpieceScore(BigDecimal masterpieceScore) {
		this.masterpieceScore = masterpieceScore;
	}
	public BigDecimal getStockScore() {
		return stockScore;
	}
	public void setStockScore(BigDecimal stockScore) {
		this.stockScore = stockScore;
	}
	public BigDecimal getSeattleBrandScore() {
		return seattleBrandScore;
	}
	public void setSeattleBrandScore(BigDecimal seattleBrandScore) {
		this.seattleBrandScore = seattleBrandScore;
	}

	Evaluation eval;
//	評価基準コンストラクタ
	public MultipledResult(Evaluation eval){
		this.eval=eval;
	}

	private int id;

	private int userId;

	 private String userName;

	 private String teamName;

	 private String engineerLevel;

	 private int teamId;

	 private boolean attend;

	 private boolean attitude;

	 private boolean securityAccident;

	 private String attendstr;

	 private String attitudestr;

	 private String securityAccidentstr;

	 private float satisfyScoreBefore;

	 private float commitmentScoreBefore;

	 private float proposalScoreBefore;

	 private float internalCommunicationScoreBefore;


	 private float developmentScoreBefore;

	 private float itSkillsScoreBefore;

	 private float understandScoreBefore;

 	private float leadershipScoreBefore;

	 private float resolveScoreBefore;


	 private float communicationScoreBefore;

	 private float professionalScoreBefore;

	 private float fieldSalesScoreBefore;

	 private float thanksScoreBefore;

	 private float engineScoreBefore;

	 private float allScoreBefore;

	 private float masterpieceScoreBefore;

	 private float stockScoreBefore;

 	private float seattleBrandScoreBefore;

 	private float totalScoreBefore;

 	private float sumAchievementBefore;

 	private float sumAbilityBefore;

 	private float sumPassionBefore;


 	private BigDecimal sumAchievement;

 	private BigDecimal sumAbility;

 	private BigDecimal sumPassion;

 	private BigDecimal totalScore;

 	private String remark;

// 	成果の合計
 	public void sumAchievementBefore() {
		sumAchievementBefore=satisfyScoreBefore+commitmentScoreBefore
				   +proposalScoreBefore+internalCommunicationScoreBefore
				   +developmentScoreBefore;
		setSumAchievementBefore(sumAchievementBefore);
	}
//	能力の合計
 	public void sumAbilityBefore() {
		sumAbilityBefore=itSkillsScoreBefore+understandScoreBefore
				   +leadershipScoreBefore+resolveScoreBefore
				   +communicationScoreBefore+professionalScoreBefore
				   +professionalScoreBefore+fieldSalesScoreBefore;
		setSumAbilityBefore(sumAbilityBefore);
	}
//	情意の合計
 	public void sumPassionBefore() {
		sumPassionBefore=thanksScoreBefore+engineScoreBefore+allScoreBefore+masterpieceScoreBefore
				   +stockScoreBefore+seattleBrandScoreBefore;
		setSumPassionBefore(sumPassionBefore);
	}

//	計算後の情意の合計
 	public void sumAchievement() {
 		BigDecimal sumAchievement=satisfyScore.add(commitmentScore)
				   .add(proposalScore).add(internalCommunicationScore)
				   .add(developmentScore);
		setSumAchievement(sumAchievement);
	}

// 	計算後の能力の合計
 	public void sumAbility() {
		BigDecimal sumAbility=itSkillsScore.add(understandScore)
				   .add(leadershipScore).add(resolveScore)
				   .add(communicationScore).add(professionalScore)
				   .add(professionalScore).add(fieldSalesScore);
		setSumAbility(sumAbility);
	}

// 	計算後の情意の合計
	public void sumPassion() {
		BigDecimal sumPassion=thanksScore.add(engineScore).add(allScore).add(masterpieceScore)
				   .add(stockScore).add(seattleBrandScore);
		setSumPassion(sumPassion);
		}

//	計算後の合計
	public void sumTotalScore() {
		BigDecimal totalScore=sumAchievement.add(sumAbility).add(sumPassion);
		setTotalScore(totalScore);
	}



//	以下誤差を排除した重み付け計算
	List<BigDecimal> list = new ArrayList<BigDecimal>();

	private BigDecimal satisfyScore;
	public BigDecimal mulSatisfyScore(float mulSatisfyScore) {
		float satisfyScoreMul = mulSatisfyScore * eval.getSatisfyWeight();
		BigDecimal satisfyScore = new BigDecimal(satisfyScoreMul);
		satisfyScore = satisfyScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(satisfyScore);
		return satisfyScore;
	}

	private BigDecimal commitmentScore;

	public BigDecimal mulCommitmentScore(float mulCommitmentScore) {
		float commitmentScoreMul = mulCommitmentScore * eval.getCommitmentWeight();
		BigDecimal commitmentScore = new BigDecimal(commitmentScoreMul);
		commitmentScore = commitmentScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(commitmentScore);
		return commitmentScore;
	}

	private BigDecimal proposalScore;

	public BigDecimal mulProposalScore(float mulProposalScore) {
		float proposalScoreMul = mulProposalScore * eval.getProposalWeight();
		BigDecimal proposalScore = new BigDecimal(proposalScoreMul);
		proposalScore = proposalScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(proposalScore);
		return proposalScore;
	}

	private BigDecimal internalCommunicationScore;

	public BigDecimal mulInternalCommunicationScore(float mulInternalCommunicationScore) {
		float internalCommunicationScoreMul = mulInternalCommunicationScore * eval.getInternalCommunicationWeight();
		BigDecimal internalCommunicationScore = new BigDecimal(internalCommunicationScoreMul);
		internalCommunicationScore = internalCommunicationScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(internalCommunicationScore);
		return internalCommunicationScore;
	}

	private BigDecimal developmentScore;

	public BigDecimal mulDevelopmentScore(float mulDevelopmentScore) {
		float developmentScoreMul = mulDevelopmentScore * eval.getDevelopmentWeight();
		BigDecimal developmentScore = new BigDecimal(developmentScoreMul);
		developmentScore = developmentScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(developmentScore);
		return developmentScore;
	}

	private BigDecimal itSkillsScore;

	public BigDecimal mulItSkillsScore(float mulItSkillsScore) {
		float itSkillsScoreMul = mulItSkillsScore * eval.getItSkillsWeight();
		BigDecimal itSkillsScore = new BigDecimal(itSkillsScoreMul);
		itSkillsScore = itSkillsScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(itSkillsScore);
		return itSkillsScore;
	}

	private BigDecimal understandScore;

	public BigDecimal mulUnderstandScore(float mulUnderstandScore) {
		float understandScoreMul = mulUnderstandScore * eval.getUnderstandWeight();
		BigDecimal understandScore = new BigDecimal(understandScoreMul);
		understandScore = understandScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(understandScore);
		return understandScore;
	}

	private BigDecimal leadershipScore;

	public BigDecimal mulLeadershipScore(float mulLeadershipScore) {
		float leadershipScoreMul = mulLeadershipScore * eval.getLeadershipWeight();
		BigDecimal leadershipScore = new BigDecimal(leadershipScoreMul);
		leadershipScore = leadershipScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(leadershipScore);
		return leadershipScore;
	}

	private BigDecimal resolveScore;

	public BigDecimal mulResolveScore(float mulResoleveScore) {
		float resolveScoreMul = mulResoleveScore * eval.getResolveWeight();
		BigDecimal resolveScore = new BigDecimal(resolveScoreMul);
		resolveScore = resolveScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(resolveScore);
		return resolveScore;
	}

	private BigDecimal communicationScore;

	public BigDecimal mulCommunicationScore(float mulCommunicationScore) {
		float communicationScoreMul = mulCommunicationScore * eval.getCommunicationWeight();
		BigDecimal communicationScore = new BigDecimal(communicationScoreMul);
		communicationScore = communicationScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(communicationScore);
		return communicationScore;
	}

	private BigDecimal professionalScore;

	public BigDecimal mulProfessionalScore(float mulProfessionalScore) {
		float professionalScoreMul = mulProfessionalScore * eval.getProfessionalWeight();
		BigDecimal professionalScore = new BigDecimal(professionalScoreMul);
		professionalScore = professionalScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(professionalScore);
		return professionalScore;
	}

	private BigDecimal fieldSalesScore;

	public BigDecimal mulFieldSalesScore(float mulFieldSalesScore) {
		float fieldSalesScoreMul = mulFieldSalesScore * eval.getFieldSalesWeight();
		BigDecimal fieldSalesScore = new BigDecimal(fieldSalesScoreMul);
		fieldSalesScore = fieldSalesScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(fieldSalesScore);
		return fieldSalesScore;
	}

	private BigDecimal thanksScore;

	public BigDecimal mulThanksScore(float mulThanksScore) {
		float thanksScoreMul = mulThanksScore * eval.getThanksWeight();
		BigDecimal thanksScore = new BigDecimal(thanksScoreMul);
		thanksScore = thanksScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(thanksScore);
		return thanksScore;
	}

	private BigDecimal engineScore;

	public BigDecimal mulEngineScore(float mulEngineScore) {
		float engineScoreMul = mulEngineScore * eval.getEngineWeight();
		BigDecimal engineScore = new BigDecimal(engineScoreMul);
		engineScore = engineScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(engineScore);
		return engineScore;
	}

	private BigDecimal allScore;

	public BigDecimal mulAllScore(float mulAllScore) {
		float allScoreMul = mulAllScore * eval.getAllWeight();
		BigDecimal allScore = new BigDecimal(allScoreMul);
		allScore = allScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(allScore);
		return allScore;
	}

	private BigDecimal masterpieceScore;

	public BigDecimal mulMasterpieceScore(float mulMasterpieceScore) {
		float masterpieceScoreMul = mulMasterpieceScore * eval.getMasterpieceWeight();
		BigDecimal masterpieceScore = new BigDecimal(masterpieceScoreMul);
		masterpieceScore = masterpieceScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(masterpieceScore);
		return masterpieceScore;
	}

	private BigDecimal stockScore;

	public BigDecimal mulStockScore(float mulStockScore) {
		float stockScoreMul = mulStockScore * eval.getStockWeight();
		BigDecimal stockScore = new BigDecimal(stockScoreMul);
		stockScore = stockScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(stockScore);
		return stockScore;
	}

	private BigDecimal seattleBrandScore;

	public BigDecimal mulSeattleBrandScore(float mulSeattleBrandScore) {
		float seattleBrandScoreMul = mulSeattleBrandScore * eval.getSeattleBrandWeight();
		BigDecimal seattleBrandScore = new BigDecimal(seattleBrandScoreMul);
		seattleBrandScore = seattleBrandScore.setScale(1, BigDecimal.ROUND_HALF_UP);
		list.add(seattleBrandScore);
		return seattleBrandScore;
	}


}

