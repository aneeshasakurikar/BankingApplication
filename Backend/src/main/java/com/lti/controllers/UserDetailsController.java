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

import com.lti.dto.GetUser;
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
			userDetailsService.registerUser(user);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful! Wait for Admin Approval");
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
	
	@GetMapping(path="/viewDetails/{userId}")
	public UserDetails viewUserDetails(@PathVariable(value = "userId") int userId){
		System.out.println(userId);
		return userDetailsService.getUserById(userId);
		
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
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setFrom("contact.ltibankingservices@gmail.com");
//			message.setTo( userDetailsService.getEmail(updatedStatus.getAadharNumber()));
//			if(updatedStatus.isStatus()==false) {
//				message.setSubject("Application Rejected");
//				message.setText("Your Application to open an account at our bank is rejected. Please try again with valid details");
//			}
//			else {
//				System.out.println("true status");
//				int accountNum = userDetailsService.getAccountNumber(updatedStatus.getAadharNumber());
//				message.setSubject("Application Approved");
//				message.setText("Your Application to open an account at our bank is accepted. Register for internet banking using your user Id to avail all our services!"
//						+ "Your Account Number is: 123001");
//			}
//			System.out.println("send mail");
//			emailSender.send(message);
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
	
}
