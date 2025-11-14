package com.library.project.vinhuni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblQuanLyKho")
public class Kho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaKho")
	private Long maKho;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhieuNhap")
	private PhieuNhap phieuNhap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	private String trangThai;
	private LocalDate ngayDuyet;
	private String ghiChu;

	// --- Constructors ---
	public Kho() {
	}

	public Kho(PhieuNhap phieuNhap, NhanVien nhanVien, String trangThai, LocalDate ngayDuyet, String ghiChu) {
		this.phieuNhap = phieuNhap;
		this.nhanVien = nhanVien;
		this.trangThai = trangThai;
		this.ngayDuyet = ngayDuyet;
		this.ghiChu = ghiChu;
	}

	public Long getKho() {
		return maKho;
	}

	public PhieuNhap getPhieuNhap() {
		return phieuNhap;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public LocalDate getNgayDuyet() {
		return ngayDuyet;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setMaKho(Long maKho) {
		this.maKho = maKho;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void setNgayDuyet(LocalDate ngayDuyet) {
		this.ngayDuyet = ngayDuyet;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
