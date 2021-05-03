package com.mahesh.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.springcloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
