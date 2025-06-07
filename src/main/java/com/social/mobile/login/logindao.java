package com.social.mobile.login;

public interface logindao {

	loginbean findByUsername(loginbean been);

	loginbean checkin(String userid);

}
