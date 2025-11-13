package com.library.project.vinhuni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.PhieuNhap;
import com.library.project.vinhuni.repository.PhieuNhapRepository;

@Service
public class PhieuNhapService {
	@Autowired
	PhieuNhapRepository phieuNhapRepository;

	public List<PhieuNhap> findByOrderByNgayNhapDesc() {
		return phieuNhapRepository.findByOrderByNgayNhapDesc();
	}
}
