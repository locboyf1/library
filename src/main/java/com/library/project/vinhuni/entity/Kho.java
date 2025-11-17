package com.library.project.vinhuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblQuanLyKho")
public class Kho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaKho")
	private Long maKho;

	@OneToOne()
	@JoinColumn(name = "MaSach")
	private Sach sach;

	private Integer soLuong;

	public Kho() {
	}

	public Long getMaKho() {
		return maKho;
	}

	public void setMaKho(Long maKho) {
		this.maKho = maKho;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
}
