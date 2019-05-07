package seattle.rookie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "project")
@Data
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	public int projectId;

	@Column(name="project_name")
	private String projectName;

	@Column
	private Date registered_at;

	@Column
	private Date updated_at;

	@Column
	private String registered_by;

	@Column
	private String updated_by;

	@Column
	private float version;

	@Column(name="expansion_possibilities",nullable = true)
	public int expansionPossibilities;

	@Column(name="increase_number",nullable = true)
	public int increaseNumber;

	@Column(name="sales_representative",nullable = true)
	public int salesRepresentative;

	@Column(name="customer_name",nullable = true)
	public String customerName;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getRegistered_at() {
		return registered_at;
	}

	public void setRegistered_at(Date registered_at) {
		this.registered_at = registered_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getRegistered_by() {
		return registered_by;
	}

	public void setRegistered_by(String registered_by) {
		this.registered_by = registered_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	/**
	 * @return expansionPossibilities
	 */
	public int getExpansionPossibilities() {
		return expansionPossibilities;
	}

	/**
	 * @param expansionPossibilities セットする expansionPossibilities
	 */
	public void setExpansionPossibilities(int expansionPossibilities) {
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
	 * @return salesRepresentative
	 */
	public int getSalesRepresentative() {
		return salesRepresentative;
	}

	/**
	 * @param salesRepresentative セットする salesRepresentative
	 */
	public void setSalesRepresentative(int salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
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

}
