package com.library.project.vinhuni.dto;

import java.time.LocalDate;
import java.util.List;

public class PhieuNhapDto {

	private LocalDate ngayNhap;
	private String ghiChu;
	private Long maNhanVien;

	private List<ChiTietPhieuNhapDto> chiTietList;
}