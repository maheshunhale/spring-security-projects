package com.mahesh.springcloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mahesh.springcloud.model.User;
import com.mahesh.springcloud.repos.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found for email "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	}
	
	

}
