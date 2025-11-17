package com.library.project.vinhuni.entity;

import jakarta.persistence.CascadeType;
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
@Table(name = "tblChiTietPhieuXuat")
public class ChiTietPhieuXuat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mactpx")
	private Long maCTPX;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "maPhieuXuat")
	private PhieuXuat phieuXuat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSach")
	private Sach sach;

	private Integer soLuong;

	public ChiTietPhieuXuat() {
	}

	public Long getMaCTPX() {
		return maCTPX;
	}

	public PhieuXuat getPhieuXuat() {
		return phieuXuat;
	}

	public Sach getSach() {
		return sach;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setMaCTPN(Long maCTPN) {
		this.maCTPX = maCTPN;
	}

	public void setPhieuXuat(PhieuXuat phieuXuat) {
		this.phieuXuat = phieuXuat;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
}