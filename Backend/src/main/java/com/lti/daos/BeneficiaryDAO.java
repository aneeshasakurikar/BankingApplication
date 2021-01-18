package com.lti.daos;

import java.util.List;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.ViewBeneficiaryDTO;
import com.lti.entities.Beneficiary;

public interface BeneficiaryDAO {

	
	void saveBeneficiary(Beneficiary beneficiary);
	boolean userExsit(int beneficiaryAccountnumber, int userAccountNumber);
	List<Integer> getAllBeneficiary(int account_number);

}

