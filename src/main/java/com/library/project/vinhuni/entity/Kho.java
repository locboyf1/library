package com.library.project.vinhuni.entity;

import java.time.LocalDate;

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
	private Long maQuanLy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhieuNhap")
	private PhieuNhap phieuNhap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	private Integer soLuong;
	private String trangThai;
	private LocalDate ngayDuyet;
	private String ghiChu;
}
