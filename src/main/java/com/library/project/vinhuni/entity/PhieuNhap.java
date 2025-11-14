package com.library.project.vinhuni.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblPhieuNhap")
public class PhieuNhap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maPhieuNhap; // Khóa chính

	private LocalDate ngayNhap = LocalDate.now(); // Ngày nhập mặc định là ngày hiện tại
	private String ghiChu;
	// Đã loại bỏ: private Double tongTien; vì thư viện của bạn miễn phí

	// Mối quan hệ Many-to-One: Một Phiếu Nhập được tạo bởi một Nhân Viên
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien") // Khóa ngoại trỏ đến tblNhanVien
	private NhanVien nhanVien;

	// Mối quan hệ One-to-Many: Một Phiếu Nhập có nhiều Chi Tiết Phiếu Nhập
	@OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTietPhieuNhap> chiTietList = new ArrayList<>();

	// --- Constructors ---
	// Cần có constructor rỗng để JPA hoạt động
	public PhieuNhap() {
	}

	public PhieuNhap(String ghiChu, NhanVien nhanVien, List<ChiTietPhieuNhap> chiTietList) {
		this.ghiChu = ghiChu;
		this.nhanVien = nhanVien;
		this.chiTietList = chiTietList;
	}

	// --- Getters ---
	public Long getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public List<ChiTietPhieuNhap> getChiTietList() {
		return chiTietList;
	}

	// --- Setters ---
	public void setMaPhieuNhap(Long maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public void setChiTietList(List<ChiTietPhieuNhap> chiTietList) {
		this.chiTietList = chiTietList;
	}
}