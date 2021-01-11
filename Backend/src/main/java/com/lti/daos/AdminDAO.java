package com.lti.daos;

import com.lti.entities.Admin;

public interface AdminDAO {

	public Admin getAdminById(int adminId);

	public int getAdminByIdAndPassword(int adminId, String password);

	public boolean isAdminAvailable(int adminId);

}
	