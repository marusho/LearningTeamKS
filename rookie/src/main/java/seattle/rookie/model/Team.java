package seattle.rookie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//チームマスタのエンティティ
@Entity
@Table(name="teams")
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int teamId;

	@Column
	private int year;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column
	private String group;

	@Column
	private String team;

	@Column
	private Date registeredAt;

	@Column
	private Date updatedAt;

	@Column
	private String registeredBy;

	@Column
	private String updatedBy;

	@Column
	private float version;

	//付け足し(森)
	public String getTeamName() {
		return team;
	}

	public String getGroup() {
		return group;
	}
	//ここまで
}
