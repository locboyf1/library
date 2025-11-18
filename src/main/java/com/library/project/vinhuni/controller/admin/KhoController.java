package com.library.project.vinhuni.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.project.vinhuni.dto.PhieuNhapDto;
import com.library.project.vinhuni.dto.PhieuXuatDto;
import com.library.project.vinhuni.entity.NhanVien;
import com.library.project.vinhuni.entity.PhieuNhap;
import com.library.project.vinhuni.entity.PhieuXuat;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.entity.TaiKhoan;
import com.library.project.vinhuni.repository.PhieuNhapRepository;
import com.library.project.vinhuni.service.NhanVienService;
import com.library.project.vinhuni.service.PhieuNhapService;
import com.library.project.vinhuni.service.PhieuXuatService;
import com.library.project.vinhuni.service.SachService;
import com.library.project.vinhuni.service.TaiKhoanService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/kho")
public class KhoController {
	@Autowired
	PhieuXuatService phieuXuatService;

	@Autowired
	PhieuNhapService phieuNhapService;

	@Autowired
	SachService sachService;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	PhieuNhapRepository phieuNhapRepository;

	@GetMapping()
	public String index(Model model) {
		List<PhieuNhap> phieuNhaps = phieuNhapService.findByOrderByNgayNhapDesc();
		model.addAttribute("phieuNhaps", phieuNhaps);

		List<PhieuXuat> phieuXuats = phieuXuatService.findByOrderByNgayXuatDesc();
		model.addAttribute("phieuXuats", phieuXuats);
		return "admin/kho/index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		List<Sach> sachs = sachService.findAll();
		model.addAttribute("sachs", sachs);

		PhieuNhapDto phieuNhapDto = new PhieuNhapDto();
		model.addAttribute("phieuNhapDto", phieuNhapDto);

		return "admin/kho/add";
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute("phieuNhapDto") PhieuNhapDto phieuNhapDto, BindingResult result, @AuthenticationPrincipal TaiKhoan taiKhoan, Model model) {

		if (phieuNhapDto.getChiTietList().size() == 0) {
			result.rejectValue("ChiTietList", "null", "Phải có ít nhất một sách được nhập");
		}

		if (result.hasErrors()) {
			List<Sach> sachs = sachService.findAll();
			model.addAttribute("sachs", sachs);
			return "admin/kho/add";
		}

		TaiKhoan taiKhoanDB = taiKhoanService.findByTenDangNhap(taiKhoan.getTenDangNhap());
		NhanVien nhanVien = taiKhoanDB.getNhanVien();

		phieuNhapService.createPhieuNhap(phieuNhapDto, nhanVien);
		return "redirect:/admin/kho";
	}

	@GetMapping("/subtract")
	public String subtract(Model model) {
		List<Sach> sachs = sachService.findAll();
		model.addAttribute("sachs", sachs);

		PhieuXuatDto phieuXuatDto = new PhieuXuatDto();
		model.addAttribute("phieuXuatDto", phieuXuatDto);

		return "admin/kho/subtract";
	}

	@PostMapping("/subtract")
	public String subtract(@Valid @ModelAttribute("phieuXuatDto") PhieuXuatDto phieuXuatDto, BindingResult result, @AuthenticationPrincipal TaiKhoan taiKhoan, Model model) {

		if (phieuXuatDto.getChiTietList().size() == 0) {
			result.rejectValue("ChiTietList", "null", "Phải có ít nhất một sách được xuất");
		}

		if (result.hasErrors()) {
			List<Sach> sachs = sachService.findAll();
			model.addAttribute("sachs", sachs);
			return "admin/kho/subtract";
		}

		TaiKhoan taiKhoanDB = taiKhoanService.findByTenDangNhap(taiKhoan.getTenDangNhap());
		NhanVien nhanVien = taiKhoanDB.getNhanVien();

		phieuXuatService.createPhieuXuat(phieuXuatDto, nhanVien);
		return "redirect:/admin/kho";
	}
}
