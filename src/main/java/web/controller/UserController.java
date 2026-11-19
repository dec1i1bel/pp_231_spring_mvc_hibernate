package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/add")
	public String showAddForm() {
		return "add";
	}

	@PostMapping("/add")
	public String add(
			RedirectAttributes redirectAttributes,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email
	) {
		userService.add(new User(name, phone, email));
		redirectAttributes.addFlashAttribute("messageSuccess", String.format("Пользователь %s (телефон: %s, email: %s) успешно добавлен", name, phone, email));
		return "redirect:/";
	}

	@GetMapping("/update")
	public String showUpdateForm(
			ModelMap modelMap,
			@RequestParam("id") long id
	) {
		User user = userService.findById(id);
		modelMap.addAttribute("user", user);
		return "update";
	}

	@PostMapping("/update")
	public String update(
			RedirectAttributes redirectAttributes,
			@RequestParam("id") long id,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email
	) {
		userService.update(new User(id, name, phone, email));
		redirectAttributes.addFlashAttribute("messageSuccess", "Данные пользователя успешно сохранены");
		redirectAttributes.addAttribute("id", id);
		return "redirect:/update";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") long id) {
		userService.delete(id);
		return "redirect:/";
	}

	@GetMapping("/")
	public String getAll(ModelMap modelMap) {
		modelMap.addAttribute("users", userService.findAll());
		return "index";
	}
}