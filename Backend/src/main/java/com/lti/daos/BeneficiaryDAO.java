package com.lti.daos;

import com.lti.dto.BeneficiaryDTO;

public interface BeneficiaryDAO {

	
	void saveBeneficiary(BeneficiaryDTO beneficiaryDTO);
	boolean userExsit(int beneficiaryAccountnumber, int userAccountNumber);

}

