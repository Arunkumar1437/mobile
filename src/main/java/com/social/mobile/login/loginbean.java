package com.social.mobile.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class loginbean {
	

	private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private String userid;
	private int count;
	private boolean usererror;
    private boolean emailerror;
    private boolean passerror;
    private boolean logged;
    private String errorMessage;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isUsererror() {
		return usererror;
	}
	public void setUsererror(boolean usererror) {
		this.usererror = usererror;
	}
	public boolean isEmailerror() {
		return emailerror;
	}
	public void setEmailerror(boolean emailerror) {
		this.emailerror = emailerror;
	}
	public boolean isPasserror() {
		return passerror;
	}
	public void setPasserror(boolean passerror) {
		this.passerror = passerror;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	} 
		
}
