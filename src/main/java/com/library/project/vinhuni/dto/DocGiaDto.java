package com.library.project.vinhuni.dto;

import com.library.project.vinhuni.entity.DocGia;
import com.library.project.vinhuni.entity.TaiKhoan;

public class DocGiaDto {

	private String tenDocGia;
	private String diaChi;
	private String soDt;
	private String gioiTinh;
	private String lop;

	private String tenDangNhap;
	private String matKhau;

	public String getTenDocGia() {
		return tenDocGia;
	}

	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
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

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
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

	public void setDocGia(DocGia docGia, TaiKhoan taiKhoan) {
		this.tenDocGia = docGia.getTenDocGia();
		this.diaChi = docGia.getDiaChi();
		this.soDt = docGia.getSoDT();
		this.gioiTinh = docGia.getGioiTinh();
		this.lop = docGia.getLop();

		this.tenDangNhap = taiKhoan.getTenDangNhap();
		this.matKhau = null;
	}

}
