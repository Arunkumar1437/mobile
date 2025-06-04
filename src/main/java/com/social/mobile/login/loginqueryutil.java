package com.social.mobile.login;

public class loginqueryutil {

	public static  final String getuser = "select user_name  from user_table where user_id=?";

	public static  final String userCheck = "select COALESCE(count(user_id),0) from user_table where user_id=? and active=true";

	public static  final String passCheck = "select pass from user_table where user_id=?";
}
