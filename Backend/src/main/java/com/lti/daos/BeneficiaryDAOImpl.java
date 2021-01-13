package com.lti.daos;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dto.BeneficiaryDTO;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public boolean userExsit(int beneficiaryAccountnumber) {
		
		return (boolean) entityManager.createNamedQuery("doesUserExist").setParameter("accountNumber",beneficiaryAccountnumber ).getSingleResult();
	}

	@Override
	@Transactional
	public void saveBeneficiary(BeneficiaryDTO beneficiaryDTO) {
		entityManager.merge(beneficiaryDTO);
		
	}

}
