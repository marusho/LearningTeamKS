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
@Table(name = "master_specialist_visions")
@IdClass(value = MasterSpecialistVisionsPK.class)
@Data
public class MasterSpecialistVisions implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int specialistId;

	@Column
	private String specialistName;

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
