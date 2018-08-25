package seattle.rookie.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
//@author mayu endo
//Motivationテーブルとつながるエンティティ
@Entity
@Table(name = "motivation")
@Data
public class Motivation{

//	MyData（被所有者）とMotivation（所有者） user_idで一対多
	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id")
	private MyData mydata;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	public Integer id;

	@Column
	private String companyMotivation;

	@Column
	private String jobMotivation;

	@Column
	private boolean retireRisk;

	@Column
	private Date interviewDate;

	@Column
	@Length(min=0, max=600, message="コメント範囲を超過しました。600文字以下にして下さい。")
	private String comment;

	@Column(nullable = false)
//	@NotEmpty
	private Date date;

	@Column
	private Date registeredAt;

	@Column
	private Date updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;
	@Column
	private Integer version;

	public Date setDate() {
		return date;
	}

	public boolean getRetireRisk() {
		return retireRisk;
	}

	public void setRetireRisk(boolean retireRisk) {
		this.retireRisk = retireRisk;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCompanyMotivation(String companyMotivation) {
		this.companyMotivation = companyMotivation;
	}

	public void setJobMotivation(String jobMotivation) {
		this.jobMotivation = jobMotivation;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public MyData getMydata() {
		return mydata;
	}

	public void setMydata(MyData mydata) {
		this.mydata = mydata;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCompanyMotivation() {
		return companyMotivation;
	}

	public String getJobMotivation() {
		return jobMotivation;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public String getComment() {
		return comment;
	}

}
