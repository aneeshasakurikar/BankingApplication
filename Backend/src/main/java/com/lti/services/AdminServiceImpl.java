package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.daos.AdminDAO;
import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;
import com.lti.exceptions.ServiceException;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Admin adminLogin(AdminCredentials adminCredentials) {

		try {
//			System.out.println("user "+adminCredentials.getUserId());
//			System.out.println("value is "+repo.findAdminById(adminCredentials.getUserId()));
			if (!adminDAO.isAdminAvailable(adminCredentials.getUserId())) {
//				System.out.println("printing this");
				throw new ServiceException("User Not Exist");
			}
			String userId = adminDAO.getAdminByIdAndPassword(adminCredentials.getUserId(), adminCredentials.getPassword());
			Admin admin = adminDAO.getAdminById(userId);
//			System.out.println("Admin is service is " +admin);
			return admin;
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Incorrect UserId/Password");
		}

	}

}
