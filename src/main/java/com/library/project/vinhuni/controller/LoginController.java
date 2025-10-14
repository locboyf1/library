package com.library.project.vinhuni.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String Login() {
		return "content/login";
	}

	@ResponseBody
	@GetMapping("/testpassword/{password}")
	public String testPasswordEncoder(@PathVariable String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = password;
		String encodedPassword = passwordEncoder.encode(rawPassword);

		return "Mật khẩu gốc: " + rawPassword + "Mật khẩu đã mã hóa: " + encodedPassword;
	}

	@GetMapping("/testform")
	public String testForm() {
		return "testform";
	}

}
