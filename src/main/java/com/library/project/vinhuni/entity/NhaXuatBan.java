package com.library.project.vinhuni.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_nha_xuat_ban")
public class NhaXuatBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manxb")
	private Integer maNhaXuatBan;

	@NotBlank(message = "Tên nhà xuất bản không được để trống")
	@Size(max = 200, message = "Vui lòng nhập đúng tên nhà xuất bản ")
	@Column(name = "ten_nxb", length = 200)
	private String tenNhaXuatBan;

	@NotBlank(message = "Email không được để trống")
	@Size(max = 100, message = "Email không được quá dài")
	@Column(name = "email", length = 100)
	private String email;

	@NotBlank(message = "Số điện thoại không được để trống")
	@Size(max = 10, message = "Vui lòng nhập đúng định dạng")
	@Column(name = "so_dien_thoai", length = 10)
	private String soDienThoai;

	@NotBlank(message = "Địa chỉ không được để trống")
	@Size(max = 500, message = "Địa chỉ không được quá dài")
	@Column(name = "dia_chi", length = 500)
	private String diaChi;

	@Column(name = "hien", nullable = false)
	private Boolean hien;

	@OneToMany(mappedBy = "nxb")
	private List<Sach> sachs = new ArrayList<>();

	public Integer getMaNhaXuatBan() {
		return maNhaXuatBan;
	}

	public void setMaNhaXuatBan(Integer maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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