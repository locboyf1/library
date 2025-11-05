package com.library.project.vinhuni.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "tblDanhGia")
public class DanhGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaDanhGia")
	private Integer maDanhGia;

	@OneToOne
	@JoinColumn(name = "MaDocGia", referencedColumnName = "MaDocGia")
	private DocGia docGia;

	@OneToOne
	@JoinColumn(name = "MaSach", referencedColumnName = "MaSach")
	private Sach sach;

	@Column(name = "NoiDung", length = 200)
	private String NoiDung;

	@Min(value = 1, message = "Số sao phải ít nhất là 1")
	@Max(value = 5, message = "Số sao không được vượt quá 5")
	@Column(name = "SoSao")
	private Float soSao;

	@Column(name = "NgayDanhGia")
	private java.sql.Date ngayDanhGia;
}
