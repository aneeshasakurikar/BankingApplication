package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
@NamedQuery(name = "logincheck", query = "select admin.adminId from Admin admin where admin.adminId=:user and admin.adminPassword=:pass")
public class Admin {

	@Id
	private int adminId;
	private String adminName;
	private String adminPassword;

//	@OneToOne
//	private UserDetails user;

	public Admin() {
	}

	public Admin(int adminId, String adminName, String adminPassword) {
		
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
