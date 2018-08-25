package seattle.rookie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SectorVisionsPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private int userId;
	@Column
	private int sectorId;
	@Column
	private int version;

	public SectorVisionsPK() {

	}

}
