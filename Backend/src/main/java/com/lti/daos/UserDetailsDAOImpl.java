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
	public UserDetails getUserDetailsByUserId(int userId) {
		return entityManager.find(UserDetails.class, userId);
	}

	@Override
	public boolean isUserPresent(String aadharNumber) {
		return (Long) entityManager.createNamedQuery("checkIfUserPresent").setParameter("aadharNumber", aadharNumber)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public List<UserDetails> viewAllUsers() {
		List<UserDetails> allUsers = entityManager.createNamedQuery("getAllUnapprovedUsers").getResultList();
		return allUsers;
	}

	@Override
	@Transactional
	public void updateUserStatus(int userId, Boolean adminApproval, String adminRemarks) {
		System.out.println(adminApproval + " " + adminRemarks + " " + userId);
		entityManager.createNamedQuery("updateUserStatus").setParameter("userId", userId)
				.setParameter("status", adminApproval).setParameter("adminRemarks", adminRemarks).executeUpdate();

	}

	@Override
	public boolean isUserApproved(int userId) {
		return (boolean) entityManager.createNamedQuery("checkIfUserApproved").setParameter("userId", userId).getSingleResult();
	}

}
