package com.library.project.vinhuni.entity;

import java.time.LocalDateTime;
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
@Table(name = "tblPhieuXuat")
public class PhieuXuat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maPhieuXuat;

	private LocalDateTime ngayXuat = LocalDateTime.now();
	private String ghiChu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "phieuXuat", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTietPhieuXuat> chiTietList = new ArrayList<>();

	public PhieuXuat() {
	}

	public PhieuXuat(String ghiChu, NhanVien nhanVien, List<ChiTietPhieuXuat> chiTietList) {
		this.ghiChu = ghiChu;
		this.nhanVien = nhanVien;
		this.chiTietList = chiTietList;
	}

	// --- Getters ---
	public Long getMaPhieuXuat() {
		return maPhieuXuat;
	}

	public LocalDateTime getNgayXuat() {
		return ngayXuat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public List<ChiTietPhieuXuat> getChiTietList() {
		return chiTietList;
	}

	// --- Setters ---
	public void setMaPhieuNhap(Long maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public void setNgayNhap(LocalDateTime ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public void setChiTietList(List<ChiTietPhieuXuat> chiTietList) {
		this.chiTietList = chiTietList;
	}
}