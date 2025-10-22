package com.library.project.vinhuni.controller.admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.project.vinhuni.dto.DocGiaDto;
import com.library.project.vinhuni.dto.NhanVienDto;
import com.library.project.vinhuni.entity.DocGia;
import com.library.project.vinhuni.entity.NhanVien;
import com.library.project.vinhuni.entity.TaiKhoan;
import com.library.project.vinhuni.repository.DocGiaRepository;
import com.library.project.vinhuni.repository.NhanVienRepository;
import com.library.project.vinhuni.repository.TaiKhoanRepository;
import com.library.project.vinhuni.service.TaiKhoanService;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

	@Autowired
	TaiKhoanRepository taiKhoanRepository;

	@Autowired
	NhanVienRepository nhanVienRepository;

	@Autowired
	DocGiaRepository docGiaRepository;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	public String index(Model model) {
		List<TaiKhoan> taiKhoans = taiKhoanService.findAll();
		model.addAttribute("taiKhoans", taiKhoans);
		return "admin/users/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("userNhanVien", new NhanVienDto());
		model.addAttribute("userDocGia", new DocGiaDto());
		return "admin/users/create";
	}

	@PostMapping("/create/nhanvien")
	public String createNhanVien(@ModelAttribute NhanVienDto userNhanVien) {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setNhanVien(userNhanVien);

		NhanVien nhanVienUpdated = nhanVienRepository.save(nhanVien);

		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setNhanVien(nhanVienUpdated);
		taiKhoan.setLoaiTaiKhoan("nhanvien");
		String matKhauMaHoa = passwordEncoder.encode(userNhanVien.getMatKhau());
		taiKhoan.setMatKhau(matKhauMaHoa);
		taiKhoan.setTenDangNhap(userNhanVien.getTenDangNhap());

		taiKhoanRepository.save(taiKhoan);
		return "redirect:/admin/users";
	}

	@PostMapping("/create/docgia")
	public String createDocGia(@ModelAttribute DocGiaDto userDocGia) {
		DocGia docGia = new DocGia();
		docGia.setDocGia(userDocGia);
		docGia.setNgayDangKy(LocalDate.now());

		DocGia docGiaUpdated = docGiaRepository.save(docGia);

		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setDocGia(docGiaUpdated);
		taiKhoan.setLoaiTaiKhoan("docgia");
		String matKhauMaHoa = passwordEncoder.encode(userDocGia.getMatKhau());
		taiKhoan.setMatKhau(matKhauMaHoa);
		taiKhoan.setTenDangNhap(userDocGia.getTenDangNhap());

		taiKhoanRepository.save(taiKhoan);
		return "redirect:/admin/users";
	}

	@PostMapping("/update")
	public String update(Model model, @RequestParam("tenDangNhap") String tenDangNhap) {
		TaiKhoan taiKhoan = taiKhoanService.findByTenDangNhap(tenDangNhap);

		if (taiKhoan.getLoaiTaiKhoan().equals("nhanvien")) {
			NhanVienDto nhanVienDto = new NhanVienDto();
			nhanVienDto.setNhanVien(taiKhoan.getNhanVien(), taiKhoan);
			model.addAttribute("user", nhanVienDto);
			model.addAttribute("maNhanVien", taiKhoan.getNhanVien().getMaNhanVien());
			return "/admin/users/updateNhanVien";
		} else {
			DocGiaDto docGiaDto = new DocGiaDto();
			docGiaDto.setDocGia(taiKhoan.getDocGia(), taiKhoan);
			model.addAttribute("user", docGiaDto);
			model.addAttribute("maDocGia", taiKhoan.getDocGia().getMaDocGia());
			return "/admin/users/updateDocGia";
		}
	}

	@PostMapping("/update/nhanvien")
	public String updateNhanVien(@ModelAttribute("user") NhanVienDto user,
			@RequestParam("maNhanVien") String maNhanVien) {
		NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien).orElse(null);
		nhanVien.setNhanVien(user);

		NhanVien nhanVienUpdated = nhanVienRepository.save(nhanVien);

		TaiKhoan taiKhoan = taiKhoanService.findByTenDangNhap(user.getTenDangNhap());
		taiKhoan.setNhanVien(nhanVienUpdated);
		taiKhoan.setLoaiTaiKhoan("nhanvien");

		taiKhoanRepository.save(taiKhoan);

		return "redirect:/admin/users";
	}

	@PostMapping("/update/docgia")
	public String updateNhanVien(@ModelAttribute("user") DocGiaDto user, @RequestParam("maDocGia") String maDocGia) {
		DocGia docGia = docGiaRepository.findByMaDocGia(maDocGia).orElse(null);
		docGia.setDocGia(user);

		DocGia docGiaUpdated = docGiaRepository.save(docGia);

		TaiKhoan taiKhoan = taiKhoanService.findByTenDangNhap(user.getTenDangNhap());
		taiKhoan.setDocGia(docGiaUpdated);
		taiKhoan.setLoaiTaiKhoan("docgia");

		taiKhoanRepository.save(taiKhoan);
		return "redirect:/admin/users";
	}

}
