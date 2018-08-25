package seattle.rookie.model;

import java.sql.Date;

import lombok.Data;

@Data
public class MotivDTO {

	private long userId;

	private String userName;

	private int motivationId1;
	private int motivationId2;
	private int motivationId3;
	private int motivationId4;
	private int motivationId5;
	private int motivationId6;
	private int motivationId7;

	private int month1;
	private int month2;
	private int month3;
	private int month4;
	private int month5;
	private int month6;
	private int month7;

	private String companyMotivation1;
	private String companyMotivation2;
	private String companyMotivation3;
	private String companyMotivation4;
	private String companyMotivation5;
	private String companyMotivation6;
	private String companyMotivation7;

	private String jobMotivation1;
	private String jobMotivation2;
	private String jobMotivation3;
	private String jobMotivation4;
	private String jobMotivation5;
	private String jobMotivation6;
	private String jobMotivation7;

	private String comment1;
	private String comment2;
	private String comment3;
	private String comment4;
	private String comment5;
	private String comment6;
	private String comment7;

	private boolean retireRisk1;
	private boolean retireRisk2;
	private boolean retireRisk3;
	private boolean retireRisk4;
	private boolean retireRisk5;
	private boolean retireRisk6;
	private boolean retireRisk7;

	private Date interviewDate1;
	private Date interviewDate2;
	private Date interviewDate3;
	private Date interviewDate4;
	private Date interviewDate5;
	private Date interviewDate6;
	private Date interviewDate7;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMotivationId1() {
		return motivationId1;
	}

	public void setMotivationId1(int motivationId1) {
		this.motivationId1 = motivationId1;
	}

	public int getMotivationId2() {
		return motivationId2;
	}

	public void setMotivationId2(int motivationId2) {
		this.motivationId2 = motivationId2;
	}

	public int getMotivationId3() {
		return motivationId3;
	}

	public void setMotivationId3(int motivationId3) {
		this.motivationId3 = motivationId3;
	}

	public int getMotivationId4() {
		return motivationId4;
	}

	public void setMotivationId4(int motivationId4) {
		this.motivationId4 = motivationId4;
	}

	public int getMotivationId5() {
		return motivationId5;
	}

	public void setMotivationId5(int motivationId5) {
		this.motivationId5 = motivationId5;
	}

	public int getMotivationId6() {
		return motivationId6;
	}

	public void setMotivationId6(int motivationId6) {
		this.motivationId6 = motivationId6;
	}

	public int getMotivationId7() {
		return motivationId7;
	}

	public void setMotivationId7(int motivationId7) {
		this.motivationId7 = motivationId7;
	}

	public int getMonth1() {
		return month1;
	}

	public void setMonth1(int month1) {
		this.month1 = month1;
	}

	public int getMonth2() {
		return month2;
	}

	public void setMonth2(int month2) {
		this.month2 = month2;
	}

	public int getMonth3() {
		return month3;
	}

	public void setMonth3(int month3) {
		this.month3 = month3;
	}

	public int getMonth4() {
		return month4;
	}

	public void setMonth4(int month4) {
		this.month4 = month4;
	}

	public int getMonth5() {
		return month5;
	}

	public void setMonth5(int month5) {
		this.month5 = month5;
	}

	public int getMonth6() {
		return month6;
	}

	public void setMonth6(int month6) {
		this.month6 = month6;
	}

	public int getMonth7() {
		return month7;
	}

	public void setMonth7(int month7) {
		this.month7 = month7;
	}

	public String getCompanyMotivation1() {
		return companyMotivation1;
	}

	public void setCompanyMotivation1(String companyMotivation1) {
		this.companyMotivation1 = companyMotivation1;
	}

	public String getCompanyMotivation2() {
		return companyMotivation2;
	}

	public void setCompanyMotivation2(String companyMotivation2) {
		this.companyMotivation2 = companyMotivation2;
	}

	public String getCompanyMotivation3() {
		return companyMotivation3;
	}

	public void setCompanyMotivation3(String companyMotivation3) {
		this.companyMotivation3 = companyMotivation3;
	}

	public String getCompanyMotivation4() {
		return companyMotivation4;
	}

	public void setCompanyMotivation4(String companyMotivation4) {
		this.companyMotivation4 = companyMotivation4;
	}

	public String getCompanyMotivation5() {
		return companyMotivation5;
	}

	public void setCompanyMotivation5(String companyMotivation5) {
		this.companyMotivation5 = companyMotivation5;
	}

	public String getCompanyMotivation6() {
		return companyMotivation6;
	}

	public void setCompanyMotivation6(String companyMotivation6) {
		this.companyMotivation6 = companyMotivation6;
	}

	public String getCompanyMotivation7() {
		return companyMotivation7;
	}

	public void setCompanyMotivation7(String companyMotivation7) {
		this.companyMotivation7 = companyMotivation7;
	}

	public String getJobMotivation1() {
		return jobMotivation1;
	}

	public void setJobMotivation1(String jobMotivation1) {
		this.jobMotivation1 = jobMotivation1;
	}

	public String getJobMotivation2() {
		return jobMotivation2;
	}

	public void setJobMotivation2(String jobMotivation2) {
		this.jobMotivation2 = jobMotivation2;
	}

	public String getJobMotivation3() {
		return jobMotivation3;
	}

	public void setJobMotivation3(String jobMotivation3) {
		this.jobMotivation3 = jobMotivation3;
	}

	public String getJobMotivation4() {
		return jobMotivation4;
	}

	public void setJobMotivation4(String jobMotivation4) {
		this.jobMotivation4 = jobMotivation4;
	}

	public String getJobMotivation5() {
		return jobMotivation5;
	}

	public void setJobMotivation5(String jobMotivation5) {
		this.jobMotivation5 = jobMotivation5;
	}

	public String getJobMotivation6() {
		return jobMotivation6;
	}

	public void setJobMotivation6(String jobMotivation6) {
		this.jobMotivation6 = jobMotivation6;
	}

	public String getJobMotivation7() {
		return jobMotivation7;
	}

	public void setJobMotivation7(String jobMotivation7) {
		this.jobMotivation7 = jobMotivation7;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getComment5() {
		return comment5;
	}

	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}

	public String getComment6() {
		return comment6;
	}

	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}

	public String getComment7() {
		return comment7;
	}

	public void setComment7(String comment7) {
		this.comment7 = comment7;
	}

	public boolean isRetireRisk1() {
		return retireRisk1;
	}

	public void setRetireRisk1(boolean retireRisk1) {
		this.retireRisk1 = retireRisk1;
	}

	public boolean isRetireRisk2() {
		return retireRisk2;
	}

	public void setRetireRisk2(boolean retireRisk2) {
		this.retireRisk2 = retireRisk2;
	}

	public boolean isRetireRisk3() {
		return retireRisk3;
	}

	public void setRetireRisk3(boolean retireRisk3) {
		this.retireRisk3 = retireRisk3;
	}

	public boolean isRetireRisk4() {
		return retireRisk4;
	}

	public void setRetireRisk4(boolean retireRisk4) {
		this.retireRisk4 = retireRisk4;
	}

	public boolean isRetireRisk5() {
		return retireRisk5;
	}

	public void setRetireRisk5(boolean retireRisk5) {
		this.retireRisk5 = retireRisk5;
	}

	public boolean isRetireRisk6() {
		return retireRisk6;
	}

	public void setRetireRisk6(boolean retireRisk6) {
		this.retireRisk6 = retireRisk6;
	}

	public boolean isRetireRisk7() {
		return retireRisk7;
	}

	public void setRetireRisk7(boolean retireRisk7) {
		this.retireRisk7 = retireRisk7;
	}

	public Date getInterviewDate1() {
		return interviewDate1;
	}

	public void setInterviewDate1(Date interviewDate1) {
		this.interviewDate1 = interviewDate1;
	}

	public Date getInterviewDate2() {
		return interviewDate2;
	}

	public void setInterviewDate2(Date interviewDate2) {
		this.interviewDate2 = interviewDate2;
	}

	public Date getInterviewDate3() {
		return interviewDate3;
	}

	public void setInterviewDate3(Date interviewDate3) {
		this.interviewDate3 = interviewDate3;
	}

	public Date getInterviewDate4() {
		return interviewDate4;
	}

	public void setInterviewDate4(Date interviewDate4) {
		this.interviewDate4 = interviewDate4;
	}

	public Date getInterviewDate5() {
		return interviewDate5;
	}

	public void setInterviewDate5(Date interviewDate5) {
		this.interviewDate5 = interviewDate5;
	}

	public Date getInterviewDate6() {
		return interviewDate6;
	}

	public void setInterviewDate6(Date interviewDate6) {
		this.interviewDate6 = interviewDate6;
	}

	public Date getInterviewDate7() {
		return interviewDate7;
	}

	public void setInterviewDate7(Date interviewDate7) {
		this.interviewDate7 = interviewDate7;
	}

}