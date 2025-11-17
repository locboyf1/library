package com.library.project.vinhuni.dto;

import jakarta.validation.constraints.NotNull;

public class ChiTietPhieuNhapDto {
	@NotNull(message = "Sách không được để trống")
	private Long maSach;
	private Integer soLuong;

	public Long getMaSach() {
		return maSach;
	}

	public void setMaSach(Long maSach) {
		this.maSach = maSach;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

}