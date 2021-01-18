package com.lti.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.BeneficiaryDAO;
import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.ViewBeneficiaryDTO;
import com.lti.entities.Beneficiary;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	@Autowired
	BeneficiaryDAO beneficiaryDAO;
	@Autowired
	AccountDetailsDAO accountDetailsDAO;

	@Override
	public void save(BeneficiaryDTO beneficiaryDTO) {
		
		if(!accountDetailsDAO.accountExists(beneficiaryDTO.getUserAccountnumber())) {
			throw new ServiceException("enter Valid Account Number");
		}
		if(!accountDetailsDAO.accountExists(beneficiaryDTO.getBeneficiaryAccountnumber())) {
			throw new ServiceException("No such account exist!");
		}
		if(beneficiaryDAO.userExsit(beneficiaryDTO.getBeneficiaryAccountnumber(), beneficiaryDTO.getUserAccountnumber())) {
			throw new ServiceException("Beneficiary Already Exists");
		}
		
			Beneficiary beneficiary = new Beneficiary();
			beneficiary.setUserAccountNumber(beneficiaryDTO.getUserAccountnumber());
			beneficiary.setBeneficiaryAccountNumber(beneficiaryDTO.getBeneficiaryAccountnumber());
			beneficiary.setBeneficiaryName(beneficiaryDTO.getBeneficiaryName());
			beneficiary.setBeneficiaryNickName(beneficiaryDTO.getBeneficiaryNickname());
			beneficiaryDAO.saveBeneficiary(beneficiary);
				
	}

	public List<Integer> getBeneficiaryList(int intUserId) {
		
		int account_number = accountDetailsDAO.getAccountNumber(intUserId);
		return beneficiaryDAO.getAllBeneficiary(account_number);
	}

}
