package seattle.rookie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MasterSpecialistVisionsPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column
	private int specialistId;
	@Column
	private int version;

	public MasterSpecialistVisionsPK() {
	}
}
