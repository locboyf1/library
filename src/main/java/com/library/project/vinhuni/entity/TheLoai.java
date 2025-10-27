package com.library.project.vinhuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbltheloai")
public class TheLoai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTheLoai")
	private Integer maTheLoai;

	@Column(name = "TenTheLoai", length = 100)
	private String tenTheLoai;

	@Column(name = "MoTa", length = 100)
	private String moTa;

	@Column(name = "BiDanh", length = 100)
	private String biDanh;

	public Integer getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(Integer maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getBiDanh() {
		return biDanh;
	}

	public void setBiDanh(String biDanh) {
		this.biDanh = biDanh;
	}
}
