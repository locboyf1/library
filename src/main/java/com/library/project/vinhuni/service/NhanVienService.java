package com.library.project.vinhuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.NhanVien;
import com.library.project.vinhuni.repository.NhanVienRepository;

@Service
public class NhanVienService {

	@Autowired
	NhanVienRepository nhanVienRepository;

	public NhanVien findByMaNhanVien(Integer maNhanVien) {

		return nhanVienRepository.findById(maNhanVien).orElse(null);
	}

}
