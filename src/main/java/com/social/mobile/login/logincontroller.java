package com.social.mobile.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		 loginbean hrmsbean=new loginbean();
			hrmsbean=loginservice.checkin(userid);
	     return hrmsbean;
	    }
}
