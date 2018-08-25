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
@Table(name = "master_sector_visions")
@IdClass(value = MasterSectorVisionsPK.class)
@Data
public class MasterSectorVisions implements Serializable {

	private static final long serialVersionUID = 1L;

	// 複合主キーにあたるカラムに@Idをつけています
	@Id
	@Column
	private int sectorId;

	@Column
	private String sectorName;

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
