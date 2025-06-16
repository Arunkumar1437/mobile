package com.social.mobile.login;

public interface loginservice {

	loginbean findByUsername(loginbean been);

	loginbean checkin(String userid);

	loginbean getAttendanceList(String luser);

}
