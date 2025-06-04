package com.social.mobile.login;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class logindaoImpl implements logindao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public loginbean findByUsername(loginbean been) {
		loginbean result=new loginbean();
	    boolean logged=false;
        boolean pass=false;
        boolean user=false;
        boolean sucess=false;
    try {
    	 int userCount = jdbcTemplate.queryForObject(loginqueryutil.userCheck, new Object[] { been.getUserid() }, Integer.class);
    	 if (userCount == 1) {
          	String username = jdbcTemplate.queryForObject(loginqueryutil.getuser, new Object[] { been.getUserid() }, String.class);

	        	String passvalid = jdbcTemplate.queryForObject(loginqueryutil.passCheck, new Object[] { been.getUserid() }, String.class);
	        	System.out.println(passvalid);
	        	if (passvalid.equals(been.getPassword())) {
	        		result.setUserid(been.getUserid());
	        		result.setLogged(true);
	   	             InetAddress localHost = InetAddress.getLocalHost();
	   	             System.out.println("Local IP Address: " + localHost.getHostAddress());
                //callcontroller.main();
                //messagecontroller.main();

	        	}else {
	        		result.setPasserror(true);
	        	}
	        } else {
	        	result.setUsererror(true);
	        }
    } catch (Exception e) {
    	e.printStackTrace();
    }
	return result;
	}

}
