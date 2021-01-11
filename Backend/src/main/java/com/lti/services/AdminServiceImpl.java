package com.lti.services;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.daos.AdminDAO;
import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Override
	public Admin adminLogin(AdminCredentials adminCredentials) throws AccountNotFoundException {

		try {
//			System.out.println("user "+adminCredentials.getUserId());
//			System.out.println("value is "+repo.findAdminById(adminCredentials.getUserId()));
			if (!dao.isAdminAvailable(adminCredentials.getAdminId())) {
//				System.out.println("printing this");
				throw new AccountNotFoundException("User Doesn't Exist");
			}
			int adminId = dao.getAdminByIdAndPassword(adminCredentials.getAdminId(), adminCredentials.getPassword());
			Admin admin = dao.getAdminById(adminId);
//			System.out.println("Admin is service is " +admin);
			return admin;
		} catch (AccountNotFoundException e) {
			// System.out.println("Incorrect UserId/Password");
			throw new AccountNotFoundException("Incorrect UserId/Password");

		}

	}

}
