package com.cos.jwt.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.jwt.model.User;
import com.cos.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// http://localhost:8080/login  ==> 동작을 안 함
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService의 loadUserByUsername");
		User userEntity = userRepository.findByUsername(username);
		System.out.println("userEntity: " + userEntity);
		// session.setAttribute("loginUser", user);
		return new PrincipalDetails(userEntity);
	}
}
