package com.social.mobile.login;

import java.util.List;

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
	//
	private String empname;
	private String userId;
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private boolean sucess;
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	
	public List<loginbean> getGetattendlist() {
		return getattendlist;
	}
	public void setGetattendlist(List<loginbean> getattendlist) {
		this.getattendlist = getattendlist;
	}
	private List<loginbean> getattendlist;
	
	private int attendanceid;
	public int getAttendanceid() {
		return attendanceid;
	}
	public void setAttendanceid(int attendanceid) {
		this.attendanceid = attendanceid;
	}
	public String getAttendancecode() {
		return attendancecode;
	}
	public void setAttendancecode(String attendancecode) {
		this.attendancecode = attendancecode;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String attendancecode;
	private String intime;
	private String outtime;
	private String duration;
	private String status;
}
