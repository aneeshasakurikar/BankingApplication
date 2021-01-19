package com.lti.controllers;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.dto.UpdateUserStatus;
import com.lti.entities.UserDetails;
import com.lti.services.UserDetailsServiceImpl;

@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	
		
//	@Autowired
//	private MailSender emailSender;

	@PostMapping(path = "/register")
	public @ResponseBody Status register(@RequestBody UserDetails user) {
		try {
			int refId = userDetailsService.registerUser(user);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful! Wait for Admin Approval. Your ReferenceId is: " + refId);
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}

		
//		  {"user_id":1, "aadhar_number":"123412341234", "address_line1": "qwer",
//		  "address_line2": "qwer", "admin_remarks":"", "annual_income":"", "city":
//		  "indore", "date_of_birth": "30-10-1998", "email_id":"aneesha@gmail.com",
//		  "father_name":"deepak", "first_name":"aneesha", "landmark":"",
//		  "last_name":"sak", "middle_name":"", "mobile_number":"1234567899",
//		  "occupation_type":"service", "pincode": 456456, "source_of_income":"service",
//		  "state":"mp", "status":1, "title":"ms"}
		 

	}
	
	
	
	@GetMapping(path="/viewAllUnapprovedUsers")
	public List<UserDetails> viewAllUnapprovedUsers() 
	{
		return userDetailsService.getAllUsers();
	}
	
	@PostMapping(path="/adminApproval")
	public Status adminApproval(@RequestBody UpdateUserStatus updatedStatus) 
	{
		try 
		{
			userDetailsService.updateUserStatus(updatedStatus);
			Status status = new Status();
			status.setMessage("Updated Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			System.out.println(e);
			return status;
		}
	}
	

	@GetMapping(path="/checkStatus/{referenceId}")
	private Status checkStatus(@PathVariable(value="referenceId") int referenceId) {
		try {
			Status status = new Status();
			String userStatus = userDetailsService.checkUserStatus(referenceId);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage(userStatus);
			return status;
		}
		catch(ServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;			
		}
	}
	
}
