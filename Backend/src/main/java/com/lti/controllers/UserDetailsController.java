package com.lti.controllers;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CreateUserStatus;
import com.lti.dto.RegisterStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entities.UserDetails;
import com.lti.services.UserDetailsServiceImpl;
import com.lti.status.Status;

@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@PostMapping(path = "/register")
	public @ResponseBody RegisterStatus register(@RequestBody UserDetails user) {
		try {
			int id = userDetailsService.registerUser(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful!");
			status.setRegisteredCustomerId(id);
			return status;
		} catch (ServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}

		/*
		 * {"user_id":1, "aadhar_number":"123412341234", "address_line1": "qwer",
		 * "address_line2": "qwer", "admin_remarks":"", "annual_income":"", "city":
		 * "indore", "date_of_birth": "30-10-1998", "email_id":"aneesha@gmail.com",
		 * "father_name":"deepak", "first_name":"aneesha", "landmark":"",
		 * "last_name":"sak", "middle_name":"", "mobile_number":"1234567899",
		 * "occupation_type":"service", "pincode": 456456, "source_of_income":"service",
		 * "state":"mp", "status":1, "title":"ms"}
		 */

	}
	
	//@CrossOrigin(origins =  "http://localhost:4200")
	@GetMapping(path="/viewAllUnapprovedUsers")
	public List<UserDetails> adminApproval() 
	{
		return userDetailsService.getAllUsers();
	}
}
