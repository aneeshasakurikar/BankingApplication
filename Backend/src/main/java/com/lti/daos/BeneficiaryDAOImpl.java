package com.lti.daos;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dto.BeneficiaryDTO;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public boolean userExsit(int beneficiaryAccountnumber,int userAccountNumber) {
		
		return (boolean) entityManager.createQuery("select count(:beneficiaryAccountnumber) from Beneficiary where userAccountNumber=:userAccountNumber")
				.setParameter("beneficiaryAccountnumber", beneficiaryAccountnumber).setParameter("userAccountNumber", userAccountNumber).getSingleResult();
	}

	@Override
	@Transactional
	public void saveBeneficiary(BeneficiaryDTO beneficiaryDTO) {
		entityManager.merge(beneficiaryDTO);
		
	}

}
