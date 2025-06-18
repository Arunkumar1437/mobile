package com.social.mobile.login;

import java.net.InetAddress;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	        		result.setUsername(username);
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

	@Override
	public loginbean checkin(String userid) {
		loginbean result=new loginbean();
		 String attendanceid = jdbcTemplate.queryForObject(loginqueryutil.GET_ATTENDANCE_ID, new Object[] {}, String.class);

		result=jdbcTemplate.queryForObject(loginqueryutil.get_detail,new Object[]{userid},new BeanPropertyRowMapper<loginbean>(loginbean.class));
		
	       int row=jdbcTemplate.update(loginqueryutil.SAVE_Attendance, new Object[] {attendanceid,userid,result.getEmpname(),userid});
	       
	       if(row > 0) {
	    	   result.setSucess(true);
	       }
	       
		
	  return result;
	}

	@Override
	public loginbean getAttendanceList(String luser) {
		loginbean result=new loginbean();
		List<loginbean> getattendlist = new ArrayList<>();
		if(luser.equals("N001")) {
		getattendlist=jdbcTemplate.query(loginqueryutil.ATTEND_LIST,new Object[]{},new BeanPropertyRowMapper<loginbean>(loginbean.class));
		}else {
			getattendlist=jdbcTemplate.query(loginqueryutil.ATTEND_LIST1,new Object[]{luser},new BeanPropertyRowMapper<loginbean>(loginbean.class));
		}
		result.setGetattendlist(getattendlist);
	 return result;
	}

	@Override
	public loginbean deleteattendance(String attendanceid) {
		loginbean been =new loginbean();
		try {
			 int retsucess=jdbcTemplate.update(loginqueryutil.DELETE_ATTENDANCE, new Object[] {attendanceid});

			 if(retsucess!=0) {
				 been.setSucess(true);
			 }else {
				 been.setSucess(false);
				 System.out.println("Unable to delete Attendance :"+ attendanceid);
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return been;
	}

	@Override
	public loginbean editattendance(String attendanceid) {
		loginbean result=new loginbean();
		result=jdbcTemplate.queryForObject(loginqueryutil.EDIT_ATTENDANCE,new Object[]{attendanceid},new BeanPropertyRowMapper<loginbean>(loginbean.class));
		result.setSucess(true);
		return result;
	}

	@Override
	public loginbean checkout(String attendanceid) {
		loginbean result = new loginbean();
	    try {
	        String intimeStr = jdbcTemplate.queryForObject(loginqueryutil.GET_IN_TIME, new Object[]{attendanceid}, String.class);
	        if (intimeStr != null) {
	            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	                    .appendPattern("yyyy-MM-dd HH:mm:ss")
	                    .optionalStart().appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).optionalEnd()
	                    .toFormatter();
	            LocalDateTime intime = LocalDateTime.parse(intimeStr, formatter);
	            LocalDateTime now = LocalDateTime.now();
	            Duration duration = Duration.between(intime, now);
	            long hours = duration.toHours();
	            long minutes = duration.toMinutesPart();
	            String durationStr = hours + "h " + minutes + "m";
	            System.out.println("Worked Duration: " + durationStr);
	            int row = jdbcTemplate.update(loginqueryutil.UPDATE_ATTENDANCE, new Object[]{durationStr, attendanceid});

	            if (row > 0) {
	                result.setSucess(true);
	                result.setMessage("Checkout successful. Worked Duration: " + durationStr);
	            } else {
	                result.setSucess(false);
	                result.setMessage("Failed to update checkout time.");
	            }
	        } else {
	            result.setSucess(false);
	            result.setMessage("No in-time found for the given attendance ID.");
	        }

	    } catch (DateTimeParseException e) {
	        result.setSucess(false);
	        result.setMessage("Date parsing error: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return result;
	}

	@Override
	public loginbean updateattendance(loginbean been) {
		loginbean result = new loginbean();
	    String formattedDuration = "";
	    try {
	        if (been.getAttendancecode() != null && !been.getAttendancecode().trim().isEmpty()) {
	            int count = jdbcTemplate.queryForObject(loginqueryutil.GET_ATTEND_COUNT, new Object[]{been.getAttendancecode()}, Integer.class);
	            if (count > 0) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
	                LocalDateTime intime = LocalDateTime.parse(been.getIntime(), formatter);
	                if (been.getOuttime() != null && !been.getOuttime().isEmpty()) {
	                    LocalDateTime outtime = LocalDateTime.parse(been.getOuttime(), formatter);
	                    Duration duration = Duration.between(intime, outtime);
	                    long hours = duration.toHours();
	                    long minutes = duration.toMinutes() % 60;
	                    formattedDuration = String.format("%02d:%02d", hours, minutes);
	                } else {
	                    formattedDuration = "";
	                }
	                jdbcTemplate.update(loginqueryutil.UPDATE_ATTEND,new Object[]{been.getIntime(), been.getOuttime(), formattedDuration, been.getAttendancecode()});
	            }
	            result.setSucess(true);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

}
