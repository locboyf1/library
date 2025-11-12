package com.library.project.vinhuni.entity;

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
	private Long maCTPN;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhieuNhap")
	private PhieuNhap phieuNhap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSach")
	private Sach sach;

	private Integer soLuong;
	private Double donGia;

}