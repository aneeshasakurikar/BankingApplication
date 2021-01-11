package com.lti.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.lti.entities.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public void save(UserDetails user) {

		entityManager.persist(user);

	}

	@Override
	public UserDetails getUserDetailsByUserId(int userId) {
		return entityManager.find(UserDetails.class, userId);
	}

	@Override
	public boolean isUserPresent(int userId) {
		return (Long) entityManager.createNamedQuery("checkIfUserPresent").setParameter("userId", userId)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public List<UserDetails> viewAllUsers() {
		List<UserDetails> allUsers = entityManager.createNamedQuery("getAllAccounts").getResultList();
		return allUsers;
	}

	@Override
	@Transactional
	public void updateUserStatus(int userId, String adminApproval, String adminRemarks) {
		System.out.println(adminApproval + " " + adminRemarks + " " + userId);
		entityManager.createNamedQuery("updateUserStatusByAdmin").setParameter("userId", userId)
				.setParameter("status", adminApproval).setParameter("aminRemarks", adminRemarks).executeUpdate();

	}

	@Override
	public boolean isUserApproved(int userId) {
		return (Long) entityManager.createNamedQuery("checkIfUserApproved").setParameter("userId", userId)
				.getSingleResult() > 0 ? true : false;
	}

}
