package com.library.project.vinhuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblTacGia")
public class TacGia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTacGia")
	private Integer maTacGia;

	@Column(name = "TenTacGia")
	private String tenTacGia;

	@Column(name = "BiDanh")
	private String biDanh;

	@Column(name = "anh", nullable = false, columnDefinition = "LONGTEXT")
	private String anh;

	@Column(name = "MoTa", columnDefinition = "MEDIUMTEXT")
	private String moTa;

	@Lob
	@Column(name = "NoiDung", columnDefinition = "LONGTEXT")
	private String noiDung;

	@Column(name = "NamSinh")
	private Integer namSinh;

	@Column(name = "hien")
	private Boolean hien;

	public Integer getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(Integer maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getBiDanh() {
		return biDanh;
	}

	public void setBiDanh(String biDanh) {
		this.biDanh = biDanh;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Boolean getHien() {
		return hien;
	}

	public void setHien(Boolean hien) {
		this.hien = hien;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setNamSinh(Integer namSinh) {
		this.namSinh = namSinh;
	}

	public Integer getNamSinh() {
		return this.namSinh;
	}
}
