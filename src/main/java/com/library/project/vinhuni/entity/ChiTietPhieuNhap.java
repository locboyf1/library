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
@Table(name = "tblChiTietPhieuNhap")
public class ChiTietPhieuNhap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mactpn")
	private Long maCTPN;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "maPhieuNhap")
	private PhieuNhap phieuNhap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSach")
	private Sach sach;

	private Integer soLuong;

	public ChiTietPhieuNhap() {
	}

	public Long getMaCTPN() {
		return maCTPN;
	}

	public PhieuNhap getPhieuNhap() {
		return phieuNhap;
	}

	public Sach getSach() {
		return sach;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setMaCTPN(Long maCTPN) {
		this.maCTPN = maCTPN;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
}