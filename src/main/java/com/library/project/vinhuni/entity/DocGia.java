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
@Table(name = "tblDocGia")
public class DocGia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaDocGia")
	private Integer maDocGia;

	@Column(name = "TenDocGia", length = 100)
	private String tenDocGia;

	@Column(name = "GioiTinh", length = 10)
	private String gioiTinh;

	@Column(name = "Lop", length = 50)
	private String lop;

	@Column(name = "SoDT", length = 20)
	private String soDT;

	@Column(name = "DiaChi", length = 255)
	private String diaChi;

	@Column(name = "NgayDangKy")
	private LocalDate ngayDangKy;

	@OneToOne(mappedBy = "docGia")
	private TaiKhoan taiKhoan;
}