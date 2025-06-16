package com.social.mobile.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginserviceImpl implements loginservice{
	
	@Autowired
	private logindao logindao ;
	
	@Override
	public loginbean findByUsername(loginbean been) {
		// TODO Auto-generated method stub
		return logindao.findByUsername(been);
	}

	@Override
	public loginbean checkin(String userid) {
		// TODO Auto-generated method stub
		return logindao.checkin(userid);
	}

	@Override
	public loginbean getAttendanceList(String luser) {
		// TODO Auto-generated method stub
		return logindao.getAttendanceList(luser);
	}

	@Override
	public loginbean deleteattendance(String attendanceid) {
		// TODO Auto-generated method stub
		return logindao.deleteattendance(attendanceid);
	}

	@Override
	public loginbean editattendance(String attendanceid) {
		// TODO Auto-generated method stub
		return logindao.editattendance(attendanceid);
	}

	@Override
	public loginbean checkout(String attendanceid) {
		// TODO Auto-generated method stub
		return logindao.checkout(attendanceid);
	}

	@Override
	public loginbean updateattendance(loginbean been) {
		// TODO Auto-generated method stub
		return logindao.updateattendance(been);
	}

}
