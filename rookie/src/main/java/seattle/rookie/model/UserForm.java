package seattle.rookie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

//バリデーションのためのモデル
@Data
public class UserForm {

	public long userId;

	@Size(min = 8, max = 16)

	@Pattern(regexp = "(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)[a-zA-Z\\d]+", message = "password must contain at least one uppercase letter, one lowercase letter and a number.")

	private String password;

	@Size(min = 1, max = 50)
	@Pattern(regexp = "[a-zA-Zぁ-んァ-ン一-龥]+")
	private String userName;

	private String encodedPassword;

	@Column(unique = true)
	@Size(min = 1, max = 255)
	@Email
	private String email;

	@Column
	private String gender;

	private int deleteFlag;

	@Size(min = 8, max = 16)
	@Pattern(regexp = "(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)[a-zA-Z\\d]+", message = "password must contain at least one uppercase letter, one lowercase letter and a number.")
	private String newPassword;

	private Date enteredDate;

	private Date leaveDate;

	private String engineerLevel;

	//ここから
	// 	 @NotEmpty
	// 	 @NotNull
	private String selectedItem1;
	// 	@NotEmpty
	// 	@NotNull
	private String selectedItem2;
	// 	@NotEmpty
	// 	@NotNull
	private String selectedItem3;

	// 	@NotEmpty
	// 	@NotNull
	private String selectedProject1;

	// 	@NotEmpty
	// 	@NotNull
	private String selectedProject2;
	// 	@NotEmpty
	// 	@NotNull
	private String selectedProject3;
	
	private Date birthday;

	public MyData mydata;

	private String selectedEngineerLevel;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getEngineerLevel() {
		return engineerLevel;
	}

	public void setEngineerLevel(String engineerLevel) {
		this.engineerLevel = engineerLevel;
	}

	public String getSelectedItem1() {
		return selectedItem1;
	}

	public void setSelectedItem1(String selectedItem1) {
		this.selectedItem1 = selectedItem1;
	}

	public String getSelectedItem2() {
		return selectedItem2;
	}

	public void setSelectedItem2(String selectedItem2) {
		this.selectedItem2 = selectedItem2;
	}

	public String getSelectedItem3() {
		return selectedItem3;
	}

	public void setSelectedItem3(String selectedItem3) {
		this.selectedItem3 = selectedItem3;
	}

	public String getSelectedProject1() {
		return selectedProject1;
	}

	public void setSelectedProject1(String selectedProject1) {
		this.selectedProject1 = selectedProject1;
	}

	public String getSelectedProject2() {
		return selectedProject2;
	}

	public void setSelectedProject2(String selectedProject2) {
		this.selectedProject2 = selectedProject2;
	}

	public String getSelectedProject3() {
		return selectedProject3;
	}

	public void setSelectedProject3(String selectedProject3) {
		this.selectedProject3 = selectedProject3;
	}

	public MyData getMydata() {
		return mydata;
	}

	public void setMydata(MyData mydata) {
		this.mydata = mydata;
	}

	public String getSelectedEngineerLevel() {
		return selectedEngineerLevel;
	}

	public void setSelectedEngineerLevel(String selectedEngineerLevel) {
		this.selectedEngineerLevel = selectedEngineerLevel;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
