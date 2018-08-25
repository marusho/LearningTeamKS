package seattle.rookie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

//評価結果エンティティ
@Data
public class EvaluationCreateForm {

	//基本情報↓

	@Column
	private int id;

	@Column
	private int userId;

	@Column
	@NotEmpty
	private String engineerLevel;

	@Column
	@NotEmpty
	private String teamName;

	@Column
	@NotNull
	private int teamId;

	@Column
	@NotNull
	private boolean attend;

	@Column
	@NotNull
	private boolean attitude;

	@Column
	@NotNull
	private boolean securityAccident;

	//前提事項↓
	@Column(nullable=true)
	private String attendString;

	@Column(nullable=true)
	private String attitudeString;

	@Column(nullable=true)
	private String securityAccidentString;

//	htmlから読み込んだデータをbooleanに読み替える
	public boolean checkAttend(String attendString) {
		if(attendString.contains("checked")) {
			this.attend=true;
		}else {
			this.attend=false;
		}
		return attend;
	}

	public boolean checkAttitude(String attitudeString) {
		if(attitudeString.contains("checked")) {
			this.attitude=true;
		}else {
			this.attitude=false;
		}
		return attitude;
	}

	public boolean checkSecurityAccident(String securityAccidentString) {
		if(securityAccidentString.contains("checked")) {
			this.securityAccident=true;
		}else {
			this.securityAccident=false;
		}
		return securityAccident;
	}
	//↑ここまで

	//評価素点↓
	@Column
	@NotNull
	private float satisfyScore;

	@Column
	@NotNull
	private float commitmentScore;

	@Column
	@NotNull
	private float proposalScore;

	@Column
	@NotNull
	private float internalCommunicationScore;


	@Column
	@NotNull
	private float developmentScore;

	@Column
	@NotNull
	private float itSkillsScore;

	@Column
	@NotNull
	private float understandScore;

	@Column
	@NotNull
	private float leadershipScore;

	@Column
	@NotNull
	private float resolveScore;


	@Column
	@NotNull
	private float communicationScore;

	@Column
	@NotNull
	private float professionalScore;

	@Column
	@NotNull
	private float fieldSalesScore;

	@Column
	@NotNull
	private float thanksScore;

	@Column
	@NotNull
	private float engineScore;

	@Column
	@NotNull
	private float allScore;

	@Column
	@NotNull
	private float masterpieceScore;

	@Column
	@NotNull
	private float stockScore;

	@Column
	@NotNull
	private float seattleBrandScore;

	@Column
	@NotNull
	@Size(min=0, max=200)
	private String remark;

	@Column
	@NotNull
	private float totalScore;
	//↑ここまで

	@Column
	@NotNull
	private int year;

	@Column
	@NotNull
	private boolean term;

	@Column
	private boolean deleteFlag;

	@Column(name="registered_at")
	private Date registeredAt;

	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="registered_by")
	private String registeredBy;

	@Column(name="updated_by")
	private String updatedBy;

	@Column
	private int version;

	private String termName;

	public boolean checkTermName(String termName) {
        if (termName.equals("上期")) {
            this.term=false;
        } else {
            this.term=true;
        }

        return term;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public String getAttendString() {
		return attendString;
	}

	public void setAttendString(String attendString) {
		this.attendString = attendString;
	}

	public String getAttitudeString() {
		return attitudeString;
	}

	public void setAttitudeString(String attitudeString) {
		this.attitudeString = attitudeString;
	}

	public String getSecurityAccidentString() {
		return securityAccidentString;
	}

	public void setSecurityAccidentString(String securityAccidentString) {
		this.securityAccidentString = securityAccidentString;
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

	public boolean isTerm() {
		return term;
	}

	public void setTerm(boolean term) {
		this.term = term;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
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

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}



}
