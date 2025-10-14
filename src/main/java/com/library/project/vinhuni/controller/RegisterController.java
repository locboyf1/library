package com.library.project.vinhuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.project.vinhuni.entity.TaiKhoan;
import com.library.project.vinhuni.repository.TaiKhoanRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private TaiKhoanRepository taiKhoanRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public String register() {
		return "content/register";
	}

	@PostMapping
	@Transactional
	public String register(@RequestParam("username") String tenDangNhap, @RequestParam("password") String matKhau) {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setTenDangNhap(tenDangNhap);

		String matKhauMaHoa = passwordEncoder.encode(matKhau);
		taiKhoan.setMatKhau(matKhauMaHoa);

		taiKhoan.setLoaiTaiKhoan("docgia");

		taiKhoanRepository.save(taiKhoan);

		return "redirect:/login?success";
	}
}