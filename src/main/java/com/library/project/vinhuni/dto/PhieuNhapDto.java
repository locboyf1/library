package com.library.project.vinhuni.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public class PhieuNhapDto {

	@Valid
	private List<ChiTietPhieuNhapDto> chiTietList = new ArrayList<>();

	private LocalDate ngayNhap;
	@Size(max = 500, message = "Ghi chú không được quá dài")
	private String ghiChu;
	private Long maNhanVien;

	public List<ChiTietPhieuNhapDto> getChiTietList() {
		return chiTietList;
	}

	public void setChiTietList(List<ChiTietPhieuNhapDto> chiTietList) {
		this.chiTietList = chiTietList;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
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