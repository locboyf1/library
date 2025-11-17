package com.library.project.vinhuni.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.Utillities.ImageProcess;
import com.library.project.vinhuni.dto.SachDto;
import com.library.project.vinhuni.entity.NhaXuatBan;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.entity.TacGia;
import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.SachRepository;

@Service
public class SachService {

	@Autowired
	SachRepository sachRepository;

	@Autowired
	TacGiaService tacGiaService;

	@Autowired
	TheLoaiService theLoaiService;

	@Autowired
	NhaXuatBanService nhaXuatBanService;

	public Sach findByMaSach(Long maSach) {
		return sachRepository.findByMaSach(maSach);
	}

	public List<Sach> findAll() {
		return sachRepository.findAll();
	}

	public Sach getSachFromDto(SachDto sachDto) {
		Sach sach = new Sach();

		List<TacGia> tacGias = tacGiaService.findAllByMaTacGiaIn(sachDto.getTacGiaIds());
		List<TheLoai> theLoais = theLoaiService.findAllByMaTheLoaiIn(sachDto.getTheLoaiIds());
		NhaXuatBan nhaXB = nhaXuatBanService.findByMaNXB(sachDto.getNxbId());

		sach.setNxb(nhaXB);
		sach.setTacGias(tacGias);
		sach.setTheLoais(theLoais);

		sach.setMaSach(sachDto.getMaSach());
		sach.setTenSach(sachDto.getTenSach());
		sach.setMoTa(sachDto.getMoTa());
		sach.setAnhBia(sachDto.getAnhBia());
		sach.setNamXuatBan(sachDto.getNamXuatBan());
		sach.setNgayNhap(sachDto.getNgayNhap());
		sach.setTinhTrang(sachDto.getTinhTrang());

		return sach;
	}

	public List<Sach> findByHienTrueOrderByNgayNhapDesc() {
		return sachRepository.findByHienTrueOrderByNgayNhapDesc();
	}

	public void create(Sach sach, MultipartFile fileAnhBia) throws IOException {
		byte[] anhBase64 = fileAnhBia.getBytes();
		String kieu = fileAnhBia.getContentType();
		sach.setAnhBia(ImageProcess.convertImage2String(anhBase64, kieu));
		sach.setNgayNhap(LocalDate.now());
		sach.setHien(true);
		sachRepository.save(sach);
	}

	public void update(Sach sach, MultipartFile fileAnhBia) throws IOException {
		Sach sachDB = sachRepository.findByMaSach(sach.getMaSach());
		if (!fileAnhBia.isEmpty()) {
			byte[] anhBase64 = fileAnhBia.getBytes();
			String kieu = fileAnhBia.getContentType();
			sach.setAnhBia(ImageProcess.convertImage2String(anhBase64, kieu));
		} else {
			sach.setAnhBia(sachDB.getAnhBia());
		}
		sach.setHien(sachDB.getHien());
		sach.setNgayNhap(sachDB.getNgayNhap());
		sachRepository.save(sach);
	}

	public void show(Sach sach) {
		sach.setHien(!sach.getHien());
		sachRepository.save(sach);
	}

	// Added to satisfy ShopController
	public Page<Sach> find(String q, Long maNxb, String sort, Pageable pageable) {
		// Basic implementation; extend with filtering later.
		return sachRepository.findAll(pageable);
	}
}
