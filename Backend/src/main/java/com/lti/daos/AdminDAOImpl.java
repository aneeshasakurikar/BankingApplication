package com.lti.daos;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entities.Admin;

@Repository
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

		System.out.println("admin is: "+entityManager.find(Admin.class, adminId));
		//System.out.println("admin Id is: "+crud.findById(adminId));
		Admin admin = entityManager.find(Admin.class, adminId);
		//Optional<Admin> admin = crud.findById(adminId);
		return admin;
	}


}
