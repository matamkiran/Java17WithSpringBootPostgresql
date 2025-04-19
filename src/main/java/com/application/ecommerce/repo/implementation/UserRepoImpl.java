package com.application.ecommerce.repo.implementation;

import org.springframework.stereotype.Repository;

import com.application.ecommerce.model.User;
import com.application.ecommerce.repo.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
