package seattle.rookie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Data;


//評価結果テーブルとつながるエンティティ
@Entity
@Table(name="evaluation_results")
@Where(clause="delete_flag=0")
@Data
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private int userId;

	@Column(name="engineer_level")
	private String engineerLevel;

	@Column
	private int teamId;

	@Column
	private float satisfyScore;

	@Column
	@NotNull
	private float commitmentScore;

	@Column
	private float proposalScore;

	@Column
	private float internalCommunicationScore;

	@Column
	private float developmentScore;

	@Column
	private float itSkillsScore;

	@Column
	private float understandScore;

	@Column
	private float leadershipScore;

	@Column
	private float resolveScore;

	@Column
	private float communicationScore;

	@Column
	private float professionalScore;

	@Column
	private float fieldSalesScore;

	@Column
	private float thanksScore;

	@Column
	private float engineScore;

	@Column
	private float allScore;

	@Column
	private float masterpieceScore;

	@Column
	private float stockScore;

	@Column
	private float seattleBrandScore;

	@Column
	private String remark;

	@Column
	private float totalScore;

	@Column(name="year")
	private int year;

	@Column
	private boolean term;

	@Column
	private boolean deleteFlag;

	@Column(name="registered_at")
	private String registeredAt;

	@Column(name="updated_at")
	private String updatedAt;

	@CreatedBy
	@Column(name="registered_by")
	private String registeredBy;

	@LastModifiedBy
	@Column(name="updated_by")
	private String updatedBy;

	@Column
	private int version;

	public boolean getTerm() {
		return term;
	}

	//初期値０のコンストラクタ
	public Result() {
		satisfyScore = 0;
		commitmentScore = 0;
		proposalScore = 0;
		internalCommunicationScore = 0;
		developmentScore = 0;
		itSkillsScore = 0;
		understandScore = 0;
		leadershipScore = 0;
		resolveScore = 0;
		communicationScore = 0;
		professionalScore = 0;
		fieldSalesScore = 0;
		thanksScore = 0;
		engineScore = 0;
		allScore = 0;
		masterpieceScore = 0;
		stockScore = 0;
		seattleBrandScore = 0;
		remark = "特になし";
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

	public float getSatisfyScore() {
		return satisfyScore;
	}

	public void setSatisfyScore(float satisfyScore) {
		this.satisfyScore = satisfyScore;
	}

	public float getCommitmentScore() {
		return commitmentScore;
	}

	public void setCommitmentScore(float commitmentScore) {
		this.commitmentScore = commitmentScore;
	}

	public float getProposalScore() {
		return proposalScore;
	}

	public void setProposalScore(float proposalScore) {
		this.proposalScore = proposalScore;
	}

	public float getInternalCommunicationScore() {
		return internalCommunicationScore;
	}

	public void setInternalCommunicationScore(float internalCommunicationScore) {
		this.internalCommunicationScore = internalCommunicationScore;
	}

	public float getDevelopmentScore() {
		return developmentScore;
	}

	public void setDevelopmentScore(float developmentScore) {
		this.developmentScore = developmentScore;
	}

	public float getItSkillsScore() {
		return itSkillsScore;
	}

	public void setItSkillsScore(float itSkillsScore) {
		this.itSkillsScore = itSkillsScore;
	}

	public float getUnderstandScore() {
		return understandScore;
	}

	public void setUnderstandScore(float understandScore) {
		this.understandScore = understandScore;
	}

	public float getLeadershipScore() {
		return leadershipScore;
	}

	public void setLeadershipScore(float leadershipScore) {
		this.leadershipScore = leadershipScore;
	}

	public float getResolveScore() {
		return resolveScore;
	}

	public void setResolveScore(float resolveScore) {
		this.resolveScore = resolveScore;
	}

	public float getCommunicationScore() {
		return communicationScore;
	}

	public void setCommunicationScore(float communicationScore) {
		this.communicationScore = communicationScore;
	}

	public float getProfessionalScore() {
		return professionalScore;
	}

	public void setProfessionalScore(float professionalScore) {
		this.professionalScore = professionalScore;
	}

	public float getFieldSalesScore() {
		return fieldSalesScore;
	}

	public void setFieldSalesScore(float fieldSalesScore) {
		this.fieldSalesScore = fieldSalesScore;
	}

	public float getThanksScore() {
		return thanksScore;
	}

	public void setThanksScore(float thanksScore) {
		this.thanksScore = thanksScore;
	}

	public float getEngineScore() {
		return engineScore;
	}

	public void setEngineScore(float engineScore) {
		this.engineScore = engineScore;
	}

	public float getAllScore() {
		return allScore;
	}

	public void setAllScore(float allScore) {
		this.allScore = allScore;
	}

	public float getMasterpieceScore() {
		return masterpieceScore;
	}

	public void setMasterpieceScore(float masterpieceScore) {
		this.masterpieceScore = masterpieceScore;
	}

	public float getStockScore() {
		return stockScore;
	}

	public void setStockScore(float stockScore) {
		this.stockScore = stockScore;
	}

	public float getSeattleBrandScore() {
		return seattleBrandScore;
	}

	public void setSeattleBrandScore(float seattleBrandScore) {
		this.seattleBrandScore = seattleBrandScore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(String registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getRegisteredBy() {
		return registeredBy;
	}

	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setTerm(boolean term) {
		this.term = term;
	}

}

