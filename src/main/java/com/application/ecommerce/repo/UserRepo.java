package com.application.ecommerce.repo;

import com.application.ecommerce.model.User;


public interface UserRepo {
	User findByEmail(String email);
	boolean existsByEmail(String email);
	User findByUsername(String username);
}
