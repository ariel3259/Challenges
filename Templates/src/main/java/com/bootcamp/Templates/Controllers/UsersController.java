package com.bootcamp.Templates.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.Templates.Model.Users;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", usersService.getAllUsers());
		return "/users/index";
	}
	
	@GetMapping("/create") 
	public String showFormUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "/users/create_user";
	}
	
	@PostMapping("/create")
	public String saveUser(@Validated @ModelAttribute("user") Users user, BindingResult result) {
		if(result.hasErrors()) {
			return "/users/create_user";
		}
		usersService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		Users user = usersService.getOneUser(id);
		model.addAttribute("user", user);
		return "/users/update_user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@Validated @ModelAttribute("user") Users user, BindingResult result) {
		if(result.hasErrors()) {
			return "/users/update_user";
		}
		usersService.updateUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		usersService.deleteUser(id);
		return "redirect:/users";
	}
}
