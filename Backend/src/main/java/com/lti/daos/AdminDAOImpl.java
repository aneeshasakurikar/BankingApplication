package com.lti.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lti.entities.Admin;

public class AdminDAOImpl implements AdminDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int getAdminByIdAndPassword(int adminId, String password) {

		return  (int) entityManager.createNamedQuery("logincheck").setParameter("user", adminId)
				.setParameter("pass", password).getSingleResult();
	}

	@Override
	public Admin getAdminById(int adminId) {

		return entityManager.find(Admin.class, adminId);
	}

	@Override
	public boolean isAdminAvailable(int adminId) {
		System.out.println("userId is " + adminId);
		Long res = (Long) entityManager.createQuery("select count(a.adminId) from Admin a where a.adminId = :id")
				.setParameter("id", adminId).getSingleResult();
		System.out.println("count is " + res);
		return (Long) entityManager.createQuery("select count(a.adminId) from Admin a where a.adminId = :user")
				.setParameter("user", adminId).getSingleResult() == 1 ? true : false;
	}

}
