package seattle.rookie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Max;

import lombok.Data;

@Data
public class CareerVisionsForm {

	public long userId;
	public int version;

	@Column
	@Max(100)
	private String firstEssential;

	@Column
	@Max(100)
	private String secondEssential;

	@Column
	@Max(100)
	private String thirdEssential;

	@Column
	@Max(1000)
	private String freetext;

	@Column
	@Max(1000)
	private String oneyearVision;

	@Column
	@Max(1000)
	private String threeyearsVision;

	@Column
	@Max(1000)
	private String fiveyearsVision;

	@Column
	private String registeredAt;

	@Column
	private String updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	private List<Integer> managementIds = new ArrayList<>();

	public List<Integer> specialistIds = new ArrayList<>();

	public List<Integer> sectorIds = new ArrayList<>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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

	public List<Integer> getManagementIds() {
		return managementIds;
	}

	public void setManagementIds(List<Integer> managementIds) {
		this.managementIds = managementIds;
	}

	public List<Integer> getSpecialistIds() {
		return specialistIds;
	}

	public void setSpecialistIds(List<Integer> specialistIds) {
		this.specialistIds = specialistIds;
	}

	public List<Integer> getSectorIds() {
		return sectorIds;
	}

	public void setSectorIds(List<Integer> sectorIds) {
		this.sectorIds = sectorIds;
	}

}
