package com.ecommerce.websecurity.config.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.modelsamples.Users;
import com.ecommerce.repositorysamples.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws 
	     UsernameNotFoundException {
		
		
		Users users = usersRepo.getUsersByUsername(username);
		
		if(users == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(users);
	}

}
