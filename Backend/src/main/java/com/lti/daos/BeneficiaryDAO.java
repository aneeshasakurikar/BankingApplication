package com.lti.daos;

import com.lti.dto.BeneficiaryDTO;

public interface BeneficiaryDAO {

	boolean userExsit(int beneficiaryAccountnumber);
	void saveBeneficiary(BeneficiaryDTO beneficiaryDTO);

}

