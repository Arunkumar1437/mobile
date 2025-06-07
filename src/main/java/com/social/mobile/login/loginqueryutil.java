package com.social.mobile.login;

public class loginqueryutil {

	public static  final String getuser = "select user_name  from user_table where user_id=?";

	public static  final String userCheck = "select COALESCE(count(user_id),0) from user_table where user_id=? and active=true";

	public static  final String passCheck = "select pass from user_table where user_id=?";
	
	public static final String GET_ATTENDANCE_ID = "SELECT 'ATD' || LPAD((COALESCE(MAX(CAST(SUBSTRING(attendance_cd, 4) AS INTEGER)), 0) + 1)::TEXT, 4, '0') AS next_attenid FROM attendance_table WHERE attendance_cd LIKE 'ATD%'";

	public static final String get_detail="select emp_name as empname,user_id as userId  from emp_table where user_id=?";

	public static final String SAVE_Attendance="insert into attendance_table (attendance_cd ,user_id ,user_name,in_time ,status,created_by,created_dt) values(?,?,?,now(),'IN',?,now())";

}
