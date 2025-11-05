package com.library.project.vinhuni.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "YeuThich")
public class YeuThich {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaYeuThich")
	private Integer maYeuThich;

	@OneToOne
	@JoinColumn(name = "MaDocGia", referencedColumnName = "MaDocGia")
	private DocGia docGia;

	@OneToOne
	@JoinColumn(name = "MaSach", referencedColumnName = "MaSach")
	private Sach sach;

	@Column(name = "NgayDanhDau")
	private Date ngayDanhDau;
}
