//@author AikoFukuda
//@Date 6/6/2018

package seattle.rookie.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "management_visions")
@Data
@IdClass(value = ManagementVisionsPK.class)
public class ManagementVisions implements Serializable {

	private static final long serialVersionUID = 1L;

	// 複合主キーに当たるカラムに@Idをつけています
	@Id
	@Column(name = "user_id")
	private int userId;

	@Id
	@Column(name = "management_id")
	private int managementId;

	@Column
	private Date registeredAt;

	@Column
	private Date updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	@Id
	@Column(name = "version")
	private int version;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getManagementId() {
		return managementId;
	}

	public void setManagementId(int managementId) {
		this.managementId = managementId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
