package com.lti.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.Status.StatusType;
import com.lti.services.BeneficiaryServiceImpl;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
public class BeneficiaryController {

	@Autowired
	BeneficiaryServiceImpl beneficiaryService;
	
	@PostMapping(path="/addBeneficiary")
	private Status addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO ) {
		try {
			beneficiaryService.save(beneficiaryDTO);
			Status status = new Status();
			status.setMessage("Beneficiary Added");
			status.setStatus(statusType.SUCCESS);
			return status;
		}
		catch(ServiceException e) 
		{
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(statusType.FAILURE);
			return status;
		}
		
	}
	
	@GetMapping(path="/viewBeneficiaryList")
	private void viewBeneficiaryList(){
		
	}
}
