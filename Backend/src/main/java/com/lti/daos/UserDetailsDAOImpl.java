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
	@Transactional
	public void updateUserStatus(String aadharNumber, Boolean adminApproval, String adminRemarks) {
		System.out.println(adminApproval + " " + adminRemarks + " " + aadharNumber);
		entityManager.createQuery(
				"update UserDetails set status = :status, adminRemarks = :adminRemarks where aadharNumber = :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).setParameter("status", adminApproval)
				.setParameter("adminRemarks", adminRemarks).executeUpdate();

	}

	@Override
	@Transactional
	public void deleteUser(String aadharNumber) {
		entityManager.createQuery("delete from UserDetails where aadharNumber = :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).executeUpdate();

	}

	@Override
	public int getUserId(String aadharNumber) {
		return (int) entityManager.createQuery("select userId from UserDetails where aadharNumber= :aadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}
	
	@Override
	public UserDetails getUserDetailsByUserId(int userId) {
		
		return entityManager.find(UserDetails.class, userId);
	}

	@Override
	public boolean isUserApproved(int userId) {
		return (boolean) entityManager.createNamedQuery("checkIfUserApproved").setParameter("userId", userId)
				.getSingleResult();
	}

	@Override
	public String getUserEmailByAadharNumber(String aadharNumber) {
		return (String) entityManager.createNamedQuery("getEmailByAadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}

	@Override
	public int getAccountNumberByAadharNumber(String aadharNumber) {
		return (int) entityManager.createNamedQuery("getAccountNumberByAadharNumber")
				.setParameter("aadharNumber", aadharNumber).getSingleResult();
	}

	@Override
	public boolean doesUserIdExists(int userId) {
		return (long) entityManager.createQuery("select count(userId) from UserDetails where userId =:userId").setParameter("userId", userId)
				.getSingleResult() == 1?true:false;
	}
	
}
