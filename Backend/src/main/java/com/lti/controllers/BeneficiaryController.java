package com.lti.controllers;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.ViewBeneficiaryDTO;
import com.lti.services.BeneficiaryServiceImpl;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@CrossOrigin(origins =  "http://localhost:4200")
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
			status.setStatus(StatusType.SUCCESS);
			return status;
		}
		catch(ServiceException e) 
		{
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILED);
			return status;
		}
		
	}
	

	@GetMapping(path="/viewBeneficiaryList/{userId}")
	private List<Integer> viewBeneficiaryList(@PathVariable(value = "userId") String userId){
		int intUserId = Integer.parseInt(userId);
		return beneficiaryService.getBeneficiaryList(intUserId);
	}
}
