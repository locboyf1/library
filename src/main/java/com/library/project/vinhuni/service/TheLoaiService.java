package com.library.project.vinhuni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.Utillities.Functions;
import com.library.project.vinhuni.entity.TheLoai;
import com.library.project.vinhuni.repository.TheLoaiIRepository;

@Service
public class TheLoaiService {

	@Autowired
	TheLoaiIRepository theLoaiIRepository;

	public TheLoai findByMaTheLoai(Integer maTheLoai) {
		return theLoaiIRepository.findByMaTheLoai(maTheLoai);
	}

	public List<TheLoai> findAll() {
		return theLoaiIRepository.findAll();
	}

	public void create(TheLoai theLoai) {
		theLoai.setBiDanh(Functions.stringToAlias(theLoai.getTenTheLoai()));
		theLoaiIRepository.save(theLoai);
	}

	public void update(TheLoai theLoai) {
		theLoai.setBiDanh(Functions.stringToAlias(theLoai.getTenTheLoai()));
		theLoaiIRepository.save(theLoai);
	}

	public void show(Integer maTheLoai) {
		TheLoai theLoai = theLoaiIRepository.findByMaTheLoai(maTheLoai);
		theLoai.setHien(!theLoai.getHien());
		theLoaiIRepository.save(theLoai);

	}
}
