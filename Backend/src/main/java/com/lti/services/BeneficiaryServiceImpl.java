package com.lti.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.BeneficiaryDAO;
import com.lti.dto.BeneficiaryDTO;


public class BeneficiaryServiceImpl implements BeneficiaryService {
	@Autowired
	BeneficiaryDAO beneficiaryDAO;
	@Autowired
	AccountDetailsDAO accountDetailsDAO;

	@Override
	public void save(BeneficiaryDTO beneficiaryDTO) {
		
		int beneficiaryAccountnumber = beneficiaryDTO.getBeneficiaryAccountnumber();
		try {
		if(!accountDetailsDAO.userExist(beneficiaryAccountnumber)) {
			throw new ServiceException("No such account exist!");
		}
		else {
			beneficiaryDAO.saveBeneficiary(beneficiaryDTO);
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
