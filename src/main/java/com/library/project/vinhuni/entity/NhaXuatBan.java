package com.library.project.vinhuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblNhaXuatBan")
public class NhaXuatBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNXB")
	private Integer maNhaXuatBan;

	@NotBlank(message = "Tên nhà xuất bản không được để trống")
	@Size(max = 200, message = "Vui lòng nhập đúng tên nhà xuất bản ")
	@Column(name = "TenNXB", length = 200)
	private String tenNhaXuatBan;

	@NotBlank(message = "Email không được để trống")
	@Size(max = 100, message = "Email không được quá dài")
	@Column(name = "Email", length = 100)
	private String email;

	@NotBlank(message = "Số điện thoại không được để trống")
	@Size(max = 10, message = "Vui lòng nhập đúng định dạng")
	@Column(name = "SoDienThoai", length = 10)
	private String soDienThoai;

	@NotBlank(message = "Địa chỉ không được để trống")
	@Size(max = 500, message = "Địa chỉ không được quá dài")
	@Column(name = "DiaChi", length = 500)
	private String diaChi;

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

}
