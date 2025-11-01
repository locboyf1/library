package com.library.project.vinhuni.controller.admin;

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

import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.TheLoaiIRepository;
import com.library.project.vinhuni.service.TheLoaiService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/theloai")
public class TheLoaiController {

	@Autowired
	TheLoaiService theLoaiService;

	@Autowired
	TheLoaiIRepository theLoaiIRepository;

	@GetMapping()
	public String index(Model model) {
		List<TheLoai> theLoais = theLoaiService.findAll();
		model.addAttribute("theLoais", theLoais);
		return "admin/theloai/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		TheLoai theLoai = new TheLoai();
		model.addAttribute("theLoai", theLoai);
		return "admin/theloai/create";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("theLoai") TheLoai theLoai, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "admin/theloai/create";
		}

		theLoaiService.create(theLoai);
		return "redirect:/admin/theloai";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer maTheLoai, Model model) {
		TheLoai theLoai = theLoaiService.findByMaTheLoai(maTheLoai);
		model.addAttribute("theLoai", theLoai);
		return "admin/theloai/update";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("theLoai") TheLoai theLoai, BindingResult result) {

		if (result.hasErrors()) {
			return "admin/theloai/update";
		}

		theLoaiService.update(theLoai);
		return "redirect:/admin/theloai";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer maTheLoai) {
		theLoaiService.show(maTheLoai);
		return "redirect:/admin/theloai";
	}
}
