package seattle.rookie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MasterSectorVisionsPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column
	private int sectorId;
	@Column
	private int version;

	public MasterSectorVisionsPK() {
	}
}
