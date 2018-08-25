package seattle.rookie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//エンジニアレベル・評価基準エンティティ
@Entity
@Table(name="engineer_levels")
@Data
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String engineerLevel;

	@Column
	private float satisfyWeight;

	@Column
	private float commitmentWeight;

	@Column
	private float proposalWeight;

	@Column
	private float internalCommunicationWeight;


	@Column
	private float developmentWeight;

	@Column
	private float itSkillsWeight;

	@Column
	private float understandWeight;

	@Column
	private float communicationWeight;

	@Column
	private float leadershipWeight;

	@Column
	private float resolveWeight;

	@Column
	private float professionalWeight;

	@Column
	private float fieldSalesWeight;

	@Column
	private float thanksWeight;

	@Column
	private float engineWeight;

	@Column
	private float allWeight;

	@Column
	private float masterpieceWeight;

	@Column
	private float stockWeight;

	@Column
	private float seattleBrandWeight;

	@Column
	private Date registeredAt;

	@Column
	private Date updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	@Column
	private float version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEngineerLevel() {
		return engineerLevel;
	}

	public void setEngineerLevel(String engineerLevel) {
		this.engineerLevel = engineerLevel;
	}

	public float getSatisfyWeight() {
		return satisfyWeight;
	}

	public void setSatisfyWeight(float satisfyWeight) {
		this.satisfyWeight = satisfyWeight;
	}

	public float getCommitmentWeight() {
		return commitmentWeight;
	}

	public void setCommitmentWeight(float commitmentWeight) {
		this.commitmentWeight = commitmentWeight;
	}

	public float getProposalWeight() {
		return proposalWeight;
	}

	public void setProposalWeight(float proposalWeight) {
		this.proposalWeight = proposalWeight;
	}

	public float getInternalCommunicationWeight() {
		return internalCommunicationWeight;
	}

	public void setInternalCommunicationWeight(float internalCommunicationWeight) {
		this.internalCommunicationWeight = internalCommunicationWeight;
	}

	public float getDevelopmentWeight() {
		return developmentWeight;
	}

	public void setDevelopmentWeight(float developmentWeight) {
		this.developmentWeight = developmentWeight;
	}

	public float getItSkillsWeight() {
		return itSkillsWeight;
	}

	public void setItSkillsWeight(float itSkillsWeight) {
		this.itSkillsWeight = itSkillsWeight;
	}

	public float getUnderstandWeight() {
		return understandWeight;
	}

	public void setUnderstandWeight(float understandWeight) {
		this.understandWeight = understandWeight;
	}

	public float getCommunicationWeight() {
		return communicationWeight;
	}

	public void setCommunicationWeight(float communicationWeight) {
		this.communicationWeight = communicationWeight;
	}

	public float getLeadershipWeight() {
		return leadershipWeight;
	}

	public void setLeadershipWeight(float leadershipWeight) {
		this.leadershipWeight = leadershipWeight;
	}

	public float getResolveWeight() {
		return resolveWeight;
	}

	public void setResolveWeight(float resolveWeight) {
		this.resolveWeight = resolveWeight;
	}

	public float getProfessionalWeight() {
		return professionalWeight;
	}

	public void setProfessionalWeight(float professionalWeight) {
		this.professionalWeight = professionalWeight;
	}

	public float getFieldSalesWeight() {
		return fieldSalesWeight;
	}

	public void setFieldSalesWeight(float fieldSalesWeight) {
		this.fieldSalesWeight = fieldSalesWeight;
	}

	public float getThanksWeight() {
		return thanksWeight;
	}

	public void setThanksWeight(float thanksWeight) {
		this.thanksWeight = thanksWeight;
	}

	public float getEngineWeight() {
		return engineWeight;
	}

	public void setEngineWeight(float engineWeight) {
		this.engineWeight = engineWeight;
	}

	public float getAllWeight() {
		return allWeight;
	}

	public void setAllWeight(float allWeight) {
		this.allWeight = allWeight;
	}

	public float getMasterpieceWeight() {
		return masterpieceWeight;
	}

	public void setMasterpieceWeight(float masterpieceWeight) {
		this.masterpieceWeight = masterpieceWeight;
	}

	public float getStockWeight() {
		return stockWeight;
	}

	public void setStockWeight(float stockWeight) {
		this.stockWeight = stockWeight;
	}

	public float getSeattleBrandWeight() {
		return seattleBrandWeight;
	}

	public void setSeattleBrandWeight(float seattleBrandWeight) {
		this.seattleBrandWeight = seattleBrandWeight;
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

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}


}