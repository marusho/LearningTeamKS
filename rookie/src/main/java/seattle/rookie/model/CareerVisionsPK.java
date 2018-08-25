package seattle.rookie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CareerVisionsPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column
	public int userId;
	@Column
	public int version;

	}