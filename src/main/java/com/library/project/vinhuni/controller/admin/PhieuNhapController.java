package com.library.project.vinhuni.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.project.vinhuni.entity.PhieuNhap;
import com.library.project.vinhuni.repository.PhieuNhapRepository;
import com.library.project.vinhuni.service.PhieuNhapService;

@Controller
@RequestMapping("/admin/phieunhap")
public class PhieuNhapController {
	@Autowired
	PhieuNhapService phieuNhapService;

	@Autowired
	PhieuNhapRepository phieuNhapRepository;

	@GetMapping()
	public String index(Model model) {
		List<PhieuNhap> phieuNhaps = phieuNhapService.findByOrderByNgayNhapDesc();
		model.addAttribute("phieuNhaps", phieuNhaps);
		return "admin/phieunhap/index";
	}
}
