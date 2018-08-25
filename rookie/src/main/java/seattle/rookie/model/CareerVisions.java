package seattle.rookie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "career_visions")
@Data
@IdClass(value = CareerVisionsPK.class)
public class CareerVisions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public int userId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "version")
	public int version;

	@Column
	@Size(max = 100)
	private String firstEssential;

	@Column
	@Size(max = 100)
	private String secondEssential;

	@Column
	@Size(max = 100)
	private String thirdEssential;

	@Column
	@Size(max = 1000)
	private String freetext;

	@Column
	@Size(max = 1000)
	private String oneyearVision;

	@Column
	@Size(max = 1000)
	private String threeyearsVision;

	@Column
	@Size(max = 1000)
	private String fiveyearsVision;

	@Column
	private String registeredAt;

	@Column
	private String updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstEssential() {
		return firstEssential;
	}

	public void setFirstEssential(String firstEssential) {
		this.firstEssential = firstEssential;
	}

	public String getSecondEssential() {
		return secondEssential;
	}

	public void setSecondEssential(String secondEssential) {
		this.secondEssential = secondEssential;
	}

	public String getThirdEssential() {
		return thirdEssential;
	}

	public void setThirdEssential(String thirdEssential) {
		this.thirdEssential = thirdEssential;
	}

	public String getFreetext() {
		return freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public String getOneyearVision() {
		return oneyearVision;
	}

	public void setOneyearVision(String oneyearVision) {
		this.oneyearVision = oneyearVision;
	}

	public String getThreeyearsVision() {
		return threeyearsVision;
	}

	public void setThreeyearsVision(String threeyearsVision) {
		this.threeyearsVision = threeyearsVision;
	}

	public String getFiveyearsVision() {
		return fiveyearsVision;
	}

	public void setFiveyearsVision(String fiveyearsVision) {
		this.fiveyearsVision = fiveyearsVision;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
