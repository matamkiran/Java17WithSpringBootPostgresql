package com.application.ecommerce.repo;

import org.hibernate.SessionFactory;

import com.application.ecommerce.model.Admin;

public interface AdminRepo {
	Admin findByEmail(String email);
	boolean existsByEmail(String email);
	Admin findByAdminname(String adminname, SessionFactory sessionFactory);
	
	Admin registerAdmin(Admin admin, SessionFactory sessionFactory);

}
