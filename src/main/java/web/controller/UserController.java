package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserServiceImp;

@Controller
public class UserController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("users", new UserServiceImp().findAll());
		return "index";
	}
	
}