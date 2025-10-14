package com.library.project.vinhuni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblNhanVien")
public class NhanVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNhanVien")
	private Integer maNhanVien;

	@Column(name = "TenNhanVien", length = 100)
	private String tenNhanVien;

	@Column(name = "GioiTinh", length = 10)
	private String gioiTinh;

	@Column(name = "NgaySinh")
	private LocalDate ngaySinh;

	@Column(name = "SoDT", length = 20)
	private String soDT;

	@Column(name = "DiaChi", length = 255)
	private String diaChi;

	@Column(name = "ChucVu", length = 50)
	private String chucVu;

	@OneToOne(mappedBy = "nhanVien")
	private TaiKhoan taiKhoan;
}