package seattle.rookie.model;

import java.sql.Date;

import lombok.Data;

@Data
public class FormMotivation {

	public FormMotivation() {
	}

	public Integer motivationId;
	private boolean retireRisk;
	private Date interviewDate;
	private String comment;
	private String companyMotivation;
	private String jobMotivation;

	//Ajaxで送られてくるデータと同じようなものを
	public FormMotivation(Integer motivationId, String comment, Date interviewDate,
			String jobMotivation, String companyMotivation, boolean retireRisk) {
		this.motivationId = motivationId;
		this.comment = comment;
		this.interviewDate = interviewDate;
		this.jobMotivation = jobMotivation;
		this.companyMotivation = companyMotivation;
		this.retireRisk = retireRisk;
	}

	public boolean getRetireRisk() {
		return this.retireRisk;
	}

	public void setRetireRisk(boolean retireRisk) {
		this.retireRisk = retireRisk;
	}

	public Integer getMotivationId() {
		return this.motivationId;
	}

	public void setMotivationId(Integer motivationId) {
		this.motivationId = motivationId;
	}

	public String getComment() {
		return this.comment;
	}

	public Date getInterviewDate() {
		return this.interviewDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCompanyMotivation() {
		return this.companyMotivation;
	}

	public void setCompanyMotivation(String companyMotivation) {
		this.companyMotivation = companyMotivation;
	}

	public String getJobMotivation() {
		return this.jobMotivation;
	}

	public void setJobMotivation(String jobMotivation) {
		this.jobMotivation = jobMotivation;
	}

}
