package com.myblognew7.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myblognew7.entities.User;
import com.myblognew7.repositories.UserRepository;
@Service
public class CustomUserDetails implements UserDetailsService{

	@Autowired
    private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
	return null;
	}

}