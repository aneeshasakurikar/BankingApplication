package com.lti.daos;

import org.springframework.data.repository.CrudRepository;

import com.lti.entities.Admin;

public interface AdminDAO extends CrudRepository<Admin, Integer>{

	public Admin getAdminById(int userId);

	public String getAdminByIdAndPassword(String userId, String password);

	public boolean isAdminAvailable(String userId);
	
}
