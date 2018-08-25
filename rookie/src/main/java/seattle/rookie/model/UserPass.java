package seattle.rookie.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

//パスワード変更のためのモデル
@Data
public class UserPass {

	private int userId;

	private String password;

	@Size(min = 1, max = 50)
	@Pattern(regexp = "[a-zA-Zぁ-んァ-ン一-龥]+")
	private String userName;

	private String encodedPassword;

	@Column(unique = true)
	@Size(min = 1, max = 255)
	@Email
	private String email;

	private int deleteFlag;

	@Size(min = 8, max = 16)
	@Pattern(regexp = "(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)[a-zA-Z\\d]+", message = "password must contain at least one uppercase letter, one lowercase letter and a number.")
	private String newPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

}
