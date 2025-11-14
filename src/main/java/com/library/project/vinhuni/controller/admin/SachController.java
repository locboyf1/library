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

import com.library.project.vinhuni.dto.SachDto;
import com.library.project.vinhuni.entity.NhaXuatBan;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.entity.TacGia;
import com.library.project.vinhuni.entity.TheLoai;
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
		model.addAttribute("sach", new SachDto());

		List<TheLoai> theLoais = theLoaiService.findByHienTrue();
		model.addAttribute("theLoais", theLoais);

		List<TacGia> tacGias = tacGiaService.findByHienTrue();
		model.addAttribute("tacGias", tacGias);

		List<NhaXuatBan> nxbs = nhaXuatBanService.findByHienTrue();
		model.addAttribute("nxbs", nxbs);

		return "admin/sach/create";
	}

	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("sach") SachDto sachDto, BindingResult result,
			@RequestParam(name = "theLoaiIds", required = false) String theLoaiIds,
			@RequestParam(name = "tacGiaIds", required = false) String tacGiaIds,
			@RequestParam("fileAnhBia") MultipartFile fileAnhBia, Model model) throws IOException {

		if (fileAnhBia.isEmpty()) {
			result.rejectValue("anhBia", "null", "Ảnh bìa sách không được để trống");
		}

		if (result.hasErrors()) {
			List<TheLoai> theLoais = theLoaiService.findByHienTrue();
			model.addAttribute("theLoais", theLoais);

			List<TacGia> tacGias = tacGiaService.findByHienTrue();
			model.addAttribute("tacGias", tacGias);

			List<NhaXuatBan> nxbs = nhaXuatBanService.findByHienTrue();
			model.addAttribute("nxbs", nxbs);
			return "admin/sach/create";
		}
		Sach sach = sachService.getSachFromDto(sachDto);
		sachService.create(sach, fileAnhBia);
		return "redirect:/admin/sach";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long maSach, Model model) {
		Sach sach = sachService.findByMaSach(maSach);
		SachDto sachDto = new SachDto();
		sachDto.getDtoFromSach(sach);

		model.addAttribute("sach", sachDto);

		List<TheLoai> theLoais = theLoaiService.findByHienTrue();
		model.addAttribute("theLoais", theLoais);

		List<TacGia> tacGias = tacGiaService.findByHienTrue();
		model.addAttribute("tacGias", tacGias);

		List<NhaXuatBan> nxbs = nhaXuatBanService.findByHienTrue();
		model.addAttribute("nxbs", nxbs);

		return "admin/sach/update";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("sach") SachDto sachDto, BindingResult result,
			@RequestParam(name = "theLoaiIds", required = false) String theLoaiIds,
			@RequestParam(name = "tacGiaIds", required = false) String tacGiaIds,
			@RequestParam("fileAnhBia") MultipartFile fileAnhBia, Model model) throws IOException {

		if (result.hasErrors()) {
			List<TheLoai> theLoais = theLoaiService.findByHienTrue();
			model.addAttribute("theLoais", theLoais);

			List<TacGia> tacGias = tacGiaService.findByHienTrue();
			model.addAttribute("tacGias", tacGias);

			List<NhaXuatBan> nxbs = nhaXuatBanService.findByHienTrue();
			model.addAttribute("nxbs", nxbs);
			return "admin/sach/update";
		}

		Sach sach = sachService.getSachFromDto(sachDto);
		sachService.update(sach, fileAnhBia);
		return "redirect:/admin/sach";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id) {
		Sach sach = sachService.findByMaSach(id);
		sachService.show(sach);
		return "redirect:/admin/sach";
	}

}