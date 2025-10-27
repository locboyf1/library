package com.library.project.vinhuni.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.TheLoaiIRepository;
import com.library.project.vinhuni.service.TheLoaiService;

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

}
