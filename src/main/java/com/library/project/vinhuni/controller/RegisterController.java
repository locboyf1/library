package com.library.project.vinhuni.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.project.vinhuni.dto.DocGiaDto;
import com.library.project.vinhuni.entity.DocGia;
import com.library.project.vinhuni.entity.TaiKhoan;
import com.library.project.vinhuni.repository.DocGiaRepository;
import com.library.project.vinhuni.repository.TaiKhoanRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private DocGiaRepository docGiaRepository;

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
	public String register(@ModelAttribute DocGiaDto user) {
		DocGia docGia = new DocGia();
		docGia.setTenDocGia(user.getTenDocGia());
		docGia.setDiaChi(user.getDiaChi());
		docGia.setGioiTinh(user.getGioiTinh());
		docGia.setLop(user.getLop());
		docGia.setNgayDangKy(LocalDate.now());
		docGia.setSoDT(user.getSoDt());

		DocGia savedDocGia = docGiaRepository.save(docGia);

		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setTenDangNhap(user.getTenDangNhap());
		String matKhauMaHoa = passwordEncoder.encode(user.getMatKhau());
		taiKhoan.setMatKhau(matKhauMaHoa);
		taiKhoan.setLoaiTaiKhoan("docgia");

		taiKhoan.setDocGia(savedDocGia);

		taiKhoanRepository.save(taiKhoan);

		return "redirect:/login?success";
	}
}