package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
@NamedQuery(name = "logincheck", query = "select admin.adminUserID from Admin admin where admin.adminUserID=:user and admin.adminPassword=:pass\r\n")
public class Admin {

	@Id
	private String adminId;
	private String adminName;
	private String adminPassword;

	@OneToOne
	private UserDetails user;

	public Admin() {
	}

	public Admin(String adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
