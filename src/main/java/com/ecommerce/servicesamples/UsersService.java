package com.ecommerce.servicesamples;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.modelsamples.Users;
import com.ecommerce.repositorysamples.UsersRepository;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;
	
	public List<Users> listAll(String username) {
		if(username != null) {
			return usersRepo.findByUsername(username);
		}
		return usersRepo.findAll();
	}
	
	public void save(Users users) {
		usersRepo.save(users);
	}
	
	public Users get(int userId) {
		return usersRepo.findById(userId).get();
	}

}
