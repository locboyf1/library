package com.library.project.vinhuni.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public class PhieuXuatDto {

	@Valid
	private List<ChiTietPhieuXuatDto> chiTietList = new ArrayList<>();

	private LocalDate ngayXuat;
	@Size(max = 500, message = "Ghi chú không được quá dài")
	private String ghiChu;
	private Long maNhanVien;

	public List<ChiTietPhieuXuatDto> getChiTietList() {
		return chiTietList;
	}

	public void setChiTietList(List<ChiTietPhieuXuatDto> chiTietList) {
		this.chiTietList = chiTietList;
	}

	public LocalDate getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(LocalDate ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Long getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

}