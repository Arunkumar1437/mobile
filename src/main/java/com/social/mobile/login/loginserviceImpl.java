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

}
