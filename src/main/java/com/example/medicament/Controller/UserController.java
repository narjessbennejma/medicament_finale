package com.example.medicament.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.medicament.entities.Role;
import com.example.medicament.entities.User;
import com.example.medicament.repos.RoleRepository;
import com.example.medicament.security.SecurityConfig;
import com.example.medicament.service.RoleService;
import com.example.medicament.service.UserService;

@Controller
public class UserController {
	
	
	
	@Autowired
	UserService userService;

	@RequestMapping("/showCreateUser")
	public String showCreateU(ModelMap modelMap)
	{
		
	modelMap.addAttribute("user", new User());

	List<Role> role = userService.getRoles();
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("listeroles",role);
	return "formUser";
	}
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formUser";
	SecurityConfig sec = new SecurityConfig();
	PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user.setEnabled(true);

	userService.saveUser(user);
	return "redirect:/ListeUsers";
	}

	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		User user =userService.getUsers(id);
		user.setRoles(null);
		userService.updateUsers(user);
		userService.deleteUserById(id);
		Page<User> u = userService.getAllUsersParPage(page,
				size);
		modelMap.addAttribute("users", u);
		modelMap.addAttribute("pages", new int[u.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeUsers";
	}

	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id,ModelMap modelMap)
	{
	User u= userService.getUsers(id);
	List<Role> role = userService.getRoles();
	modelMap.addAttribute("user", u);
	modelMap.addAttribute("listeroles",role);
	modelMap.addAttribute("mode", "edit");

	return "formUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		SecurityConfig sec = new SecurityConfig();
		 PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	 userService.updateUsers(user);
	 List<User> ge= userService.getAllUsers();
	 List<Role> role = userService.getRoles();
	 modelMap.addAttribute("users", ge);
	modelMap.addAttribute("listeroles",role);
	return "listeUsers";
	}

	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<User> u = userService.getAllUsersParPage(page, size);
	modelMap.addAttribute("users", u);

	modelMap.addAttribute("pages", new int[u.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeUsers";
	}

	
	}