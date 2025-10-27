package com.library.project.vinhuni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.TheLoaiIRepository;

@Service
public class TheLoaiService {

	@Autowired
	TheLoaiIRepository theLoaiIRepository;

	public TheLoai findByMaTheLoai(String maTheLoai) {
		return theLoaiIRepository.findByMaTheLoai(maTheLoai);
	}

	public List<TheLoai> findAll() {
		return theLoaiIRepository.findAll();
	}
}
