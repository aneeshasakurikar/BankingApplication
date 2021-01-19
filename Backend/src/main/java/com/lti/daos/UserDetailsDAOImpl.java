package com.lti.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public UserDetails save(UserDetails userDetails) {
		UserDetails newUserDetails = entityManager.merge(userDetails);
		return newUserDetails;
	}
	
	
	@Override
	public int getReferenceId(String aadharNumber) {
		return (int) entityManager.createQuery("select referenceId from UserDetails where aadharNumber= :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}
	
	@Override
	@Transactional
	public void updateUserStatus(String aadharNumber, Boolean adminApproval, String adminRemarks) {
		System.out.println(adminApproval + " " + adminRemarks + " " + aadharNumber);
		entityManager.createQuery(
				"update UserDetails set status = :status, adminRemarks = :adminRemarks where aadharNumber = :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).setParameter("status", adminApproval)
				.setParameter("adminRemarks", adminRemarks).executeUpdate();

	}

	@Override
	public String getUserEmailByAadharNumber(String aadharNumber) {
		return (String) entityManager.createQuery("select emailId from UserDetails where aadharNumber= :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}
	
	@Override
	public boolean isUserPresent(String aadharNumber) {
		return (Long) entityManager
				.createQuery("select count(ud.aadharNumber) from UserDetails ud where ud.aadharNumber = :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult() == 1 ? true : false;
	}

	@Override
	public List<UserDetails> viewAllUsers() {
		List<UserDetails> allUsers = entityManager.createQuery("from UserDetails ud where ud.status=0").getResultList();
		return allUsers;
	}

	@Override
	public boolean doesReferenceIdExists(int referenceId) {
		return (Long) entityManager.createQuery("select count(referenceId) from UserDetails where referenceId =:referenceId").setParameter("referenceId", referenceId)
				.getSingleResult() == 1?true:false;
	}

	@Override
	public boolean isUserApproved(int referenceId) {
		return (boolean)entityManager.createQuery("select status from UserDetails where referenceId=:referenceId").setParameter("referenceId", referenceId)
				.getSingleResult();
	}
	
	@Override
	@Transactional
	public void deleteUser(String aadharNumber) {
		entityManager.createQuery("delete from UserDetails where aadharNumber = :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).executeUpdate();

	}

	@Override
	public String getEmailByReferenceId(int referenceId) {
		return (String) entityManager.createQuery("select emailId from UserDetails where referenceId= :referenceId")
				.setParameter("referenceId", referenceId).getSingleResult();
	}
		

	

	@Override
	public int getAccountNumberByAadharNumber(String aadharNumber) {
		return (int) entityManager.createNamedQuery("getAccountNumberByAadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}


	@Override
	public UserDetails getUserDetailsByReferenceId(int referenceId) {
		return entityManager.find(UserDetails.class, referenceId);
	}


	

	
	
}
