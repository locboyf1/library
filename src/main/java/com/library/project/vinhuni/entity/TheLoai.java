package com.library.project.vinhuni.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblTheLoai")
public class TheLoai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTheLoai")
	private Integer maTheLoai;

	@NotBlank(message = "Tên thể loại không được để trống")
	@Size(max = 100, message = "Tên thể loại không được quá dài")
	@Column(name = "TenTheLoai", length = 100)
	private String tenTheLoai;

	@Size(max = 500, message = "Mô tả không được quá dài")
	@Column(name = "MoTa", length = 500)
	private String moTa;

	@Column(name = "BiDanh", length = 100)
	private String biDanh;

	@Column(name = "Hien")
	private Boolean hien;

	@ManyToMany(mappedBy = "theLoais")
	private List<Sach> sachs = new ArrayList<>();

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

	public void setHien(Boolean hien) {
		this.hien = hien;
	}

	public Boolean getHien() {
		return this.hien;
	}

	public List<Sach> getSachs() {
		return sachs;
	}

	public void setSachs(List<Sach> sachs) {
		this.sachs = sachs;
	}
}