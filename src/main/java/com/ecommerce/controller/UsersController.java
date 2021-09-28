package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ecommerce.modelsamples.Users;
import com.ecommerce.repositorysamples.UsersRepository;
import com.ecommerce.servicesamples.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping("/")
	public String viewFirstPage() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String viewLoginPage() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String viewHomePage() {
		return "userhome";
	}
	
	@RequestMapping("/signup")
	public String ShowSignUpForm(Model model) {
		model.addAttribute("users",new Users());
		
		return "signupform";
	}
	
	@PostMapping("/signup")
	public String processForm(Users users) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(encodedPassword);
		
		usersRepo.save(users);
		return "success_signup";
		
	}
	
	@RequestMapping("/userslist")
	public String listUsers(Model model,@Param("username") String username) {
		List<Users> listUsers = usersService.listAll(username);
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("username",username);
		return "users";
		
	}
	

	@RequestMapping("/passwordchange/{userId}")
	public ModelAndView changeAdminPassword(@PathVariable(name="userId") int userId) {
		ModelAndView mav = new ModelAndView("passwordchange");
		Users user = usersService.get(userId);
	    mav.addObject("user",user);
		return mav;
	}
	
	@RequestMapping(value = "/saveuser",method = RequestMethod.POST)
	public String saveUsers(@ModelAttribute("user") Users user) {
          usersService.save(user);
		return "success_signup";
	}
	
	
	@RequestMapping("/admin")
	public String adminPage() {
		return "Admin";
	}
	
	
	
	
	

}
