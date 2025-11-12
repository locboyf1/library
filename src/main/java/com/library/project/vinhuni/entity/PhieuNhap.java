package com.library.project.vinhuni.entity;

import java.time.LocalDate;
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
	private Long maPhieuNhap;

	private LocalDate ngayNhap = LocalDate.now();
	private String ghiChu;
	private Double tongTien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChiTietPhieuNhap> chiTietList;

}