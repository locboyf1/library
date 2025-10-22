package com.library.project.vinhuni.dto;

import java.time.LocalDate;

import com.library.project.vinhuni.entity.NhanVien;
import com.library.project.vinhuni.entity.TaiKhoan;

public class NhanVienDto {

	private String tenNhanVien;
	private String diaChi;
	private String soDt;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String chucVu;

	private String tenDangNhap;
	private String matKhau;

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDt() {
		return soDt;
	}

	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public void setNhanVien(NhanVien nhanVien, TaiKhoan taiKhoan) {

		this.tenNhanVien = nhanVien.getTenNhanVien();
		this.diaChi = nhanVien.getDiaChi();
		this.soDt = nhanVien.getSoDT();
		this.gioiTinh = nhanVien.getGioiTinh();
		this.ngaySinh = nhanVien.getNgaySinh();
		this.chucVu = nhanVien.getChucVu();

		this.tenDangNhap = taiKhoan.getTenDangNhap();
		this.matKhau = null;
	}
}