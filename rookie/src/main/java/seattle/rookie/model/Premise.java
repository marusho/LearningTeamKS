package seattle.rookie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//前提事項のエンティティ
@Entity
@Table(name="premises")
@Data
public class Premise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private int userId;

	@Column
	private int year;


	@Column
	private boolean term;

	@Column
	private boolean attend;

	@Column
	private boolean attitude;

	@Column
	private boolean securityAccident;

	@Column
	private String registeredAt;

	@Column
	private String updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	@Column
	private float version;

	@Column
	private boolean deleteFlag;

	public boolean getAttend() {
		return attend;
	}

	public boolean getAttitude() {
		return attitude;
	}

	public boolean getSecurityAccident() {
		return securityAccident;
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

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setAttend(boolean attend) {
		this.attend = attend;
	}

	public void setAttitude(boolean attitude) {
		this.attitude = attitude;
	}

	public void setSecurityAccident(boolean securityAccident) {
		this.securityAccident = securityAccident;
	}

}
