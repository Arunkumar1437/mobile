package com.social.mobile.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobileapp")
public class logincontroller {
	
	 @Autowired
		private loginservice loginservice ;
	
	 @PostMapping("/login")
	    public loginbean login(@RequestBody loginbean been) {
			loginbean bean=new loginbean();
			try {
				bean=loginservice.findByUsername(been);

			}catch(Exception e) {
				e.printStackTrace();
			}    	return bean;
	    }
	 
	 @PutMapping("/checkin/{userid}")
	    public loginbean checkin(@PathVariable String userid) {
		 loginbean loginbean=new loginbean();
			loginbean=loginservice.checkin(userid);
	     return loginbean;
	    }
	 
	 @GetMapping("/getAttendanceList")
		public loginbean getAttendanceList(@RequestParam String luser) {
		    return loginservice.getAttendanceList(luser);
		}
	 
	 @PutMapping("/checkout")
	    public loginbean checkout(@RequestParam String attendanceid) {
		 loginbean loginbean=new loginbean();
		 loginbean=loginservice.checkout(attendanceid);
	     return loginbean;
	    }
		
		@DeleteMapping("/deleteattendance")
		public loginbean deleteattendance(@RequestParam String attendanceid) {
		    return loginservice.deleteattendance(attendanceid);
		}
		
		@GetMapping("/editattendance")
	    public loginbean editattendance(@RequestParam String attendanceid) {
			loginbean loginbean=new loginbean();
			loginbean=loginservice.editattendance(attendanceid);
	     return loginbean;
	    }
		
		@PostMapping("/updateattendance")
	    public  loginbean updateattendance(@RequestBody loginbean been) {
			loginbean result=new loginbean();
	    	try {
	    		result =loginservice.updateattendance(been);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return result;
	    }
}
