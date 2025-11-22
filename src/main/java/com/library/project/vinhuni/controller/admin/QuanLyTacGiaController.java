package com.library.project.vinhuni.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.entity.TacGia;
import com.library.project.vinhuni.service.TacGiaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/tacgia")
public class QuanLyTacGiaController {

	@Autowired
	TacGiaService tacGiaService;

	@GetMapping("")
	public String index(Model model) {
		List<TacGia> tacGias = tacGiaService.findAll();
		model.addAttribute("tacGias", tacGias);
		return "admin/authors/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		TacGia tacGia = new TacGia();
		model.addAttribute("tacGia", tacGia);
		return "admin/authors/create";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("tacGia") TacGia tacGia, BindingResult result,
			@RequestParam("fileAnh") MultipartFile fileAnh) throws IOException {
		if (fileAnh.isEmpty()) {
			result.rejectValue("anh", "null", "Ảnh không được để trống");
		}
		if (result.hasErrors()) {
			return "admin/authors/create";
		}
		tacGiaService.create(tacGia, fileAnh);
		return "redirect:/admin/tacgia";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer maTacGia, Model model) {
		TacGia tacGia = tacGiaService.findByMaTacGia(maTacGia);
		model.addAttribute("tacGia", tacGia);
		return "admin/authors/update";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("tacGia") TacGia tacGia, BindingResult result, MultipartFile fileAnh)
			throws IOException {

		if (result.hasErrors()) {
			return "admin/authors/update";
		}

		tacGiaService.update(tacGia, fileAnh);
		return "redirect:/admin/tacgia";
	}

	@GetMapping("show/{id}")
	public String show(@PathVariable("id") Integer maTacGia) {
		tacGiaService.show(maTacGia);
		return "redirect:/admin/tacgia";
	}

	@GetMapping("detail/{id}")
	public String detail(@PathVariable("id") Integer maTacGia, Model model) {
		TacGia tacGia = tacGiaService.findByMaTacGia(maTacGia);
		model.addAttribute("tacGia", tacGia);
		return "admin/authors/detail";
	}
}
