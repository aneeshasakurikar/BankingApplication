package com.lti.repository;

import com.lti.entities.Admin;

public interface AdminRepository {

	public Admin getAdminById(String userId);

	public String getAdminByIdAndPassword(String userId, String password);

	public boolean isAdminAvailable(String userId);

}
