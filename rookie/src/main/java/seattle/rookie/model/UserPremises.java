package seattle.rookie.model;

import lombok.Data;

@Data
public class UserPremises {
	private boolean attend;
	private boolean attitude;
	private boolean securityAccident;
	public boolean isAttend() {
		return attend;
	}
	public void setAttend(boolean attend) {
		this.attend = attend;
	}
	public boolean isAttitude() {
		return attitude;
	}
	public void setAttitude(boolean attitude) {
		this.attitude = attitude;
	}
	public boolean isSecurityAccident() {
		return securityAccident;
	}
	public void setSecurityAccident(boolean securityAccident) {
		this.securityAccident = securityAccident;
	}


}
