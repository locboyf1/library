package com.library.project.vinhuni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "tblTaiKhoan")
public class TaiKhoan {

	@Id
	@Column(name = "TenDangNhap", length = 50)
	private String tenDangNhap;

	@Column(name = "MatKhau", length = 255, nullable = false)
	private String matKhau;

	@Column(name = "LoaiTaiKhoan", length = 20)
	private String loaiTaiKhoan;

	@Column(name = "TrangThai", nullable = false)
	private Boolean trangThai;

	@OneToOne
	@JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien")
	private NhanVien nhanVien;

	@OneToOne
	@JoinColumn(name = "MaDocGia", referencedColumnName = "MaDocGia")
	private DocGia docGia;

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setDocGia(DocGia docGia) {

		this.docGia = docGia;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}
}