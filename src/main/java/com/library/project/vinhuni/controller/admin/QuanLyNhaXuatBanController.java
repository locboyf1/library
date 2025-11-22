package com.library.project.vinhuni.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.project.vinhuni.entity.NhaXuatBan;
import com.library.project.vinhuni.repository.NhaXuatBanRepository;
import com.library.project.vinhuni.service.NhaXuatBanService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/nhaxuatban")
public class QuanLyNhaXuatBanController {
	@Autowired
	NhaXuatBanService nhaXuatBanService;

	@Autowired
	NhaXuatBanRepository nhaXuatBanRepository;

	@GetMapping()
	public String index(Model model) {
		List<NhaXuatBan> nhaXuatBans = nhaXuatBanService.findAll();
		model.addAttribute("nhaXuatBans", nhaXuatBans);
		return "admin/nhaxuatban/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		NhaXuatBan nhaXuatBan = new NhaXuatBan();
		model.addAttribute("nhaXuatBan", nhaXuatBan);
		return "admin/nhaxuatban/create";
	}

	@PostMapping("/create")
	public String create(@Validated @ModelAttribute("nhaXuatBan") NhaXuatBan nhaXuatBan, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/nhaxuatban/create";
		}
		nhaXuatBanService.create(nhaXuatBan);
		return "redirect:/admin/nhaxuatban";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer maNhaXuatBan, Model model) {
		NhaXuatBan nhaXuatBan = nhaXuatBanService.findByMaNXB(maNhaXuatBan);
		model.addAttribute("nhaXuatBan", nhaXuatBan);
		return "admin/nhaxuatban/update";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("nhaXuatBan") NhaXuatBan nhaXuatBan, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/nhaxuatban/update";
		}

		nhaXuatBanService.update(nhaXuatBan);
		return "redirect:/admin/nhaxuatban";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id) {
		NhaXuatBan nhaXuatBan = nhaXuatBanService.findByMaNXB(id);
		nhaXuatBanService.show(nhaXuatBan);

		return "redirect:/admin/nhaxuatban";
	}

}
