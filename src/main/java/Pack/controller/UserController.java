package Pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Pack.dto.UserDTO;
import Pack.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping("signUp")
	public String signUpGet() {
		return "signUp/signUpView";
	}
	
	@PostMapping("signUp")
	public String signUpPost(Model model, UserDTO dto) {
		model.addAttribute("result", service.signUp(dto));
		return "signUp/signUpEndView";
	}
	
	@PostMapping("login")
	public String login(Model model, UserDTO dto) {		
		model.addAttribute("user", service.login(dto));		
		return "login/loginEndView";
	}
}
