package com.social.mobile.login;

public interface loginservice {

	loginbean findByUsername(loginbean been);

	loginbean checkin(String userid);

	loginbean getAttendanceList(String luser);

	loginbean deleteattendance(String attendanceid);

	loginbean editattendance(String attendanceid);

	loginbean checkout(String attendanceid);

	loginbean updateattendance(loginbean been);

}
