package seattle.rookie.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ProjectDto {

	private int projectId;

	private String customerName;

	private String projectName;

	private Date registered_at;

	private Date updated_at;

	private String registered_by;

	private String updated_by;

	private float version;

	private String expansionPossibilities;

	private int increaseNumber;

	private String salesRepresentativeName;

	/**
	 * @return projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId セットする projectId
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	/**
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName セットする customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName セットする projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return registered_at
	 */
	public Date getRegistered_at() {
		return registered_at;
	}

	/**
	 * @param registered_at セットする registered_at
	 */
	public void setRegistered_at(Date registered_at) {
		this.registered_at = registered_at;
	}

	/**
	 * @return updated_at
	 */
	public Date getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at セットする updated_at
	 */
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * @return registered_by
	 */
	public String getRegistered_by() {
		return registered_by;
	}

	/**
	 * @param registered_by セットする registered_by
	 */
	public void setRegistered_by(String registered_by) {
		this.registered_by = registered_by;
	}

	/**
	 * @return updated_by
	 */
	public String getUpdated_by() {
		return updated_by;
	}

	/**
	 * @param updated_by セットする updated_by
	 */
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	/**
	 * @return version
	 */
	public float getVersion() {
		return version;
	}

	/**
	 * @param version セットする version
	 */
	public void setVersion(float version) {
		this.version = version;
	}

	/**
	 * @return expansionPossibilities
	 */
	public String getExpansionPossibilities() {
		return expansionPossibilities;
	}

	/**
	 * @param expansionPossibilities セットする expansionPossibilities
	 */
	public void setExpansionPossibilities(String expansionPossibilities) {
		this.expansionPossibilities = expansionPossibilities;
	}

	/**
	 * @return increaseNumber
	 */
	public int getIncreaseNumber() {
		return increaseNumber;
	}

	/**
	 * @param increaseNumber セットする increaseNumber
	 */
	public void setIncreaseNumber(int increaseNumber) {
		this.increaseNumber = increaseNumber;
	}

	/**
	 * @return salesRepresentativeName
	 */
	public String getSalesRepresentativeName() {
		return salesRepresentativeName;
	}

	/**
	 * @param salesRepresentativeName セットする salesRepresentativeName
	 */
	public void setSalesRepresentativeName(String salesRepresentativeName) {
		this.salesRepresentativeName = salesRepresentativeName;
	}
}
