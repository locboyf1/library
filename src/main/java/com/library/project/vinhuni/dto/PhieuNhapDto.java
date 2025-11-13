package com.library.project.vinhuni.dto;

import java.time.LocalDate;
import java.util.ArrayList; // Cần import
import java.util.List;

public class PhieuNhapDto {

	// 1. KHAI BÁO & KHỞI TẠO LIST: Phải khởi tạo ArrayList để tránh lỗi
	// NullPointerException
	private List<ChiTietPhieuNhapDto> chiTietList = new ArrayList<>();

	// ... các thuộc tính header khác ...
	private LocalDate ngayNhap;
	private String ghiChu;
	private Long maNhanVien;

	// --- 2. GETTER ĐÚNG CÁCH (Trả về List<ChiTietPhieuNhapDto>) ---
	// Loại bỏ (hoặc sửa) phương thức getChiTietList() hiện tại của bạn.
	// Phương thức đúng phải trả về List<ChiTietPhieuNhapDto>
	public List<ChiTietPhieuNhapDto> getChiTietList() {
		return chiTietList;
	}

	// --- 3. SETTER (Cần thiết để Spring MVC/Thymeleaf binding) ---
	public void setChiTietList(List<ChiTietPhieuNhapDto> chiTietList) {
		this.chiTietList = chiTietList;
	}

	// --- Các Getters/Setters khác cho ngayNhap, ghiChu, maNhanVien ---

	// Ví dụ cho trường ngayNhap:
	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	// ... và các trường khác ...
}