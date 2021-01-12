package com.lti.services;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.AdminDAOImpl;
import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAOImpl dao;

	@Override
	public Admin adminLogin(AdminCredentials adminCredentials) throws AccountNotFoundException  {

		try {
			System.out.println("user "+adminCredentials.getAdminId());
//			System.out.println("value is "+dao.getAdminById(adminCredentials.getAdminId()));
//			if (!dao.isAdminAvailable(adminCredentials.getAdminId())) {
//				System.out.println("user not available");
//				throw new AccountNotFoundException("User Doesn't Exist");
//			}
			int adminId = dao.getAdminByIdAndPassword(adminCredentials.getAdminId(), adminCredentials.getPassword());
			//System.out.println(adminId);
			Admin admin = dao.getAdminById(adminId);
			return admin;
		} catch (Exception e) {
			 System.out.println("Incorrect details");
			throw new AccountNotFoundException("Incorrect UserId/Password");
			

		}
	}
}