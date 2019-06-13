package com.example.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.CustomUserDetails;
import com.example.model.Role;
import com.example.model.Users;
import com.example.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Users user = usersRepository.findByName(name);
		
		 if (user == null)
		        throw new UsernameNotFoundException("username not found");
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	    for (Role role : user.getRoles()){
	        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
	    }
		
	    return new CustomUserDetails(user);
	}

}
