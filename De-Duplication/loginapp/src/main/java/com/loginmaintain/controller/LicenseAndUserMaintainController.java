package com.loginmaintain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LicenseAndUserMaintainController {
	
	

	@RequestMapping("/")
	public String homePage(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "Welcome to User Maintainence using projectsolutionsaaquib2019@gmail.com") String name) {
		model.addAttribute("name", name);
		return "welcome";
	}

}
