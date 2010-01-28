package edu.vwa.easyfeedback.admin.client.service;

import java.io.Serializable;

/**
 * Datenklasse, die den Login-Status, Userinformationen und die Login-/Logout-Uris beinhaltet.
 * @author Pesco (von Julian aus r12 übernommen)
 */
public class LoginInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8913175735244045054L;
	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String emailAddress;
	private String nickname;

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
