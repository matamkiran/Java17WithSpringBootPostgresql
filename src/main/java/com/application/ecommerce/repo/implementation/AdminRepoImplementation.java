package com.application.ecommerce.repo.implementation;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.application.ecommerce.model.Admin;
import com.application.ecommerce.repo.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AdminRepoImplementation implements AdminRepo{
	
	
	 @PersistenceContext
	    private EntityManager entityManager;

	   

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		return false;
	}

	@Override
	public Admin findByAdminname(String adminname,SessionFactory sessionFactory) {
		return (Admin) sessionFactory.getCurrentSession().createQuery("From Admin where id=1");
	}

	@Override
	@Transactional
	public Admin registerAdmin(Admin admin, SessionFactory sessionFactory) {
		
		   if (admin.getId() == null) {
	            entityManager.persist(admin);  // for new
	        } else {
	            entityManager.merge(admin);    // for existing
	        }
		  return admin;
	}
}
