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
@Table(name = "master_management_visions")
@IdClass(value = MasterManagementVisionsPK.class)
@Data
public class MasterManagementVisions implements Serializable {

	private static final long serialVersionUID = 1L;

	// 複合主キーにあたるカラムに@Idをつけています
	@Id
	@Column
	private int managementId;

	@Column
	private String managementName;

	@Column
	private Date registeredAt;

	@Column
	private Date updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	@Id
	@Column
	private int version;
}
