package com.library.project.vinhuni.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.dto.ChiTietPhieuXuatDto;
import com.library.project.vinhuni.dto.PhieuXuatDto;
import com.library.project.vinhuni.entity.NhanVien;
import com.library.project.vinhuni.entity.PhieuXuat;
import com.library.project.vinhuni.repository.ChiTietPhieuXuatRepository;
import com.library.project.vinhuni.repository.PhieuXuatRepository;

@Service
public class PhieuXuatService {
	@Autowired
	PhieuXuatRepository phieuXuatRepository;

	@Autowired
	ChiTietPhieuXuatRepository chiTietPhieuXuatRepository;

	@Autowired
	ChiTietPhieuXuatService chiTietPhieuXuatService;

	public List<PhieuXuat> findByOrderByNgayXuatDesc() {
		return phieuXuatRepository.findByOrderByNgayXuatDesc();
	}

	public void createPhieuXuat(PhieuXuatDto phieuXuatDto, NhanVien nhanVien) {
		PhieuXuat phieuXuat = new PhieuXuat();
		phieuXuat.setGhiChu(phieuXuatDto.getGhiChu());
		phieuXuat.setNhanVien(nhanVien);
		phieuXuat.setNgayNhap(LocalDateTime.now());

		PhieuXuat phieuXuatDaLuu = phieuXuatRepository.save(phieuXuat);

		List<ChiTietPhieuXuatDto> chiTietList = phieuXuatDto.getChiTietList();
		Collection<ChiTietPhieuXuatDto> chiTiets = chiTietList.stream().collect(Collectors.toMap(ChiTietPhieuXuatDto::getMaSach, soLuong -> soLuong, (soLuongCu, soLuongMoi) -> {
			soLuongCu.setSoLuong(soLuongCu.getSoLuong() + soLuongMoi.getSoLuong());
			return soLuongCu;
		})).values();
		chiTietList = new ArrayList<>(chiTiets);
		for (ChiTietPhieuXuatDto chiTiet : chiTietList) {
			chiTietPhieuXuatService.create(chiTiet, phieuXuatDaLuu);
		}

	}
}
