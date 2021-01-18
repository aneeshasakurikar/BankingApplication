package com.lti.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.ViewBeneficiaryDTO;
import com.lti.entities.Beneficiary;

@Repository
public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public boolean userExsit(int beneficiaryAccountnumber,int userAccountNumber) {
		
		return (Long) entityManager.createQuery("select count(beneficiaryAccountNumber) from Beneficiary"
				+ " where beneficiaryAccountNumber=:beneficiaryAccountnumber and userAccountNumber=:userAccountNumber")
				.setParameter("beneficiaryAccountnumber", beneficiaryAccountnumber).setParameter("userAccountNumber", userAccountNumber).getSingleResult()
				==1?true:false;
		
	}

	@Override
	@Transactional
	public void saveBeneficiary(Beneficiary beneficiary) {
		entityManager.merge(beneficiary);
		
	}

	@Override
	public List<Integer> getAllBeneficiary(int account_number) {
		return entityManager.createQuery("select beneficiaryAccountNumber from Beneficiary where userAccountNumber= :account_number").setParameter("account_number", account_number)
				.getResultList();
	}

}
