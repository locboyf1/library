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
@Table(name = "tbl_tac_gia")
public class TacGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_tac_gia")
	private Integer maTacGia;

	@NotBlank(message = "Tên tác giả không được để trống")
	@Size(max = 200, message = "Tên tác giả không được quá dài")
	@Column(name = "ten_tac_gia")
	private String tenTacGia;

	@Column(name = "bi_danh")
	private String biDanh;

	@Column(name = "anh", nullable = false, columnDefinition = "LONGTEXT")
	private String anh;

	@Size(max = 1000, message = "Mô tả không được quá dài")
	@Column(name = "mo_ta", columnDefinition = "MEDIUMTEXT")
	private String moTa;

	@NotBlank(message = "Nội dung không được để trống")
	@Column(name = "noi_dung", columnDefinition = "LONGTEXT")
	private String noiDung;

	@Column(name = "nam_sinh")
	private String namSinh;

	@Column(name = "hien")
	private Boolean hien;

	@ManyToMany(mappedBy = "tacGias")
	private List<Sach> sachs = new ArrayList<>();

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

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getNamSinh() {
		return this.namSinh;
	}

	public List<Sach> getSachs() {
		return sachs;
	}

	public void setSachs(List<Sach> sachs) {
		this.sachs = sachs;
	}
}