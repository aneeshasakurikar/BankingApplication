package com.lti.daos;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.entities.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	//private CrudRepository<Admin, Integer> crud;

	@Override
	public int getAdminByIdAndPassword(int adminId, String password) {

//		System.out.println((int)entityManager.createNamedQuery("logincheck").setParameter("user", adminId)
//				.setParameter("pass", password).getSingleResult());
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

//	@Override
//	public boolean isAdminAvailable(int adminId) {
//		System.out.println("userId is " + adminId);
////		Long res = (Long) entityManager.createQuery("select count(a.adminId) from Admin a where a.adminId = :id")
////				.setParameter("id", adminId).getSingleResult();
////		System.out.println("count is " + res);
//		
//		return (Long) entityManager.createQuery("select count(a.adminId) from Admin a where a.adminId = :user")
//				.setParameter("user", adminId).getSingleResult() == 1 ? true : false;
//	}

}
