package com.library.project.vinhuni.controller.admin;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.entity.TacGia;
import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.TacGiaRepository;
import com.library.project.vinhuni.repository.TheLoaiIRepository;
import com.library.project.vinhuni.service.NhaXuatBanService;
import com.library.project.vinhuni.service.SachService;
import com.library.project.vinhuni.service.TacGiaService;
import com.library.project.vinhuni.service.TheLoaiService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/sach")
public class SachController {

	@Autowired
	SachService sachService;

	@Autowired
	TheLoaiService theLoaiService;
	@Autowired
	TacGiaService tacGiaService;
	@Autowired
	NhaXuatBanService nhaXuatBanService;

	@Autowired
	TheLoaiIRepository theLoaiRepository;
	@Autowired
	TacGiaRepository tacGiaRepository;

	private void addDropdownDataToModel(Model model) {
		model.addAttribute("theLoais", theLoaiService.findAll());
		model.addAttribute("tacGias", tacGiaService.findAll());
		model.addAttribute("nxbs", nhaXuatBanService.findAll());
	}

	@GetMapping()
	public String index(Model model) {
		List<Sach> sachs = sachService.findAll();
		model.addAttribute("sachs", sachs);
		return "admin/sach/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("sach", new Sach());
		addDropdownDataToModel(model);
		return "admin/sach/create";
	}

	@PostMapping("/create")
	public String create(@Validated @ModelAttribute("sach") Sach sach, BindingResult result,
			@RequestParam(name = "theLoaiIds", required = false) String theLoaiIds,
			@RequestParam(name = "tacGiaIds", required = false) String tacGiaIds,
			@RequestParam("fileAnhBia") MultipartFile fileAnhBia, Model model) {

		setTheLoaiIdsFromString(sach, theLoaiIds);
		setTacGiaIdsFromString(sach, tacGiaIds);

		if (result.hasErrors()) {
			addDropdownDataToModel(model);
			return "admin/sach/create";
		}

		sachService.create(sach, fileAnhBia);
		return "redirect:/admin/sach";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long maSach, Model model) {
		Sach sach = sachService.findByMaSach(maSach);
		model.addAttribute("sach", sach);
		addDropdownDataToModel(model);
		return "admin/sach/update";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("sach") Sach sach, BindingResult result,
			@RequestParam(name = "theLoaiIds", required = false) String theLoaiIds,
			@RequestParam(name = "tacGiaIds", required = false) String tacGiaIds,
			@RequestParam("fileAnhBia") MultipartFile fileAnhBia, Model model) {

		setTheLoaiIdsFromString(sach, theLoaiIds);
		setTacGiaIdsFromString(sach, tacGiaIds);

		if (result.hasErrors()) {
			addDropdownDataToModel(model);
			return "admin/sach/update";
		}

		sachService.update(sach, fileAnhBia);
		return "redirect:/admin/sach";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id) {
		Sach sach = sachService.findByMaSach(id);
		sachService.show(sach);
		return "redirect:/admin/sach";
	}

	private void setTheLoaiIdsFromString(Sach sach, String theLoaiIds) {
		if (theLoaiIds != null && !theLoaiIds.isEmpty()) {
			List<TheLoai> theLoais = new ArrayList<>();
			String[] ids = theLoaiIds.split(",");
			for (String id : ids) {
				theLoaiRepository.findById(Integer.parseInt(id)).ifPresent(theLoais::add);
			}
			sach.setTheLoais(theLoais);
		} else {
			sach.setTheLoais(new ArrayList<>());
		}
	}

	private void setTacGiaIdsFromString(Sach sach, String tacGiaIds) {
		if (tacGiaIds != null && !tacGiaIds.isEmpty()) {
			List<TacGia> tacGias = new ArrayList<>();
			String[] ids = tacGiaIds.split(",");
			for (String id : ids) {
				tacGiaRepository.findById(Integer.parseInt(id)).ifPresent(tacGias::add);
			}
			sach.setTacGias(tacGias);
		} else {
			sach.setTacGias(new ArrayList<>());
		}
	}
}