package com.library.project.vinhuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.dto.ChiTietPhieuXuatDto;
import com.library.project.vinhuni.entity.ChiTietPhieuXuat;
import com.library.project.vinhuni.entity.Kho;
import com.library.project.vinhuni.entity.PhieuXuat;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.repository.ChiTietPhieuXuatRepository;

@Service
public class ChiTietPhieuXuatService {
	@Autowired
	ChiTietPhieuXuatRepository chiTietPhieuXuatRepository;

	@Autowired
	SachService sachService;

	@Autowired
	KhoService khoService;

	public void create(ChiTietPhieuXuatDto chiTietPhieuXuatDto, PhieuXuat phieuXuat) {
		Sach sach = sachService.findByMaSach(chiTietPhieuXuatDto.getMaSach());

		Integer soLuongXuat = chiTietPhieuXuatDto.getSoLuong();
		Kho kho = khoService.findBySach(sach);
		if (kho != null) {
			if (soLuongXuat > kho.getSoLuong()) {
				soLuongXuat = kho.getSoLuong();
			}
		} else {
			soLuongXuat = 0;
		}
		ChiTietPhieuXuat chiTietPhieuXuat = new ChiTietPhieuXuat();
		chiTietPhieuXuat.setPhieuXuat(phieuXuat);
		chiTietPhieuXuat.setSach(sach);
		chiTietPhieuXuat.setSoLuong(soLuongXuat);
		chiTietPhieuXuatRepository.save(chiTietPhieuXuat);

		khoService.subtractBook(sach, soLuongXuat);
	}
}
