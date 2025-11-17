package com.library.project.vinhuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.dto.ChiTietPhieuNhapDto;
import com.library.project.vinhuni.entity.ChiTietPhieuNhap;
import com.library.project.vinhuni.entity.PhieuNhap;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.repository.ChiTietPhieuNhapRepository;

@Service
public class chiTietPhieuNhapService {
	@Autowired
	private ChiTietPhieuNhapRepository chiTietPhieuNhapRepository;

	@Autowired
	SachService sachService;

	@Autowired
	KhoService khoService;

	public void create(ChiTietPhieuNhapDto chiTietPhieuNhapDto, PhieuNhap phieuNhap) {
		Sach sach = sachService.findByMaSach(chiTietPhieuNhapDto.getMaSach());

		ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
		chiTietPhieuNhap.setPhieuNhap(phieuNhap);
		chiTietPhieuNhap.setSach(sach);
		chiTietPhieuNhap.setSoLuong(chiTietPhieuNhapDto.getSoLuong());
		chiTietPhieuNhapRepository.save(chiTietPhieuNhap);

		khoService.addBook(sach, chiTietPhieuNhapDto.getSoLuong());
	}

}
