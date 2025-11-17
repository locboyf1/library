package com.library.project.vinhuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.Kho;
import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.repository.KhoRepository;

@Service
public class KhoService {

	@Autowired
	private KhoRepository khoRepository;

	public void addBook(Sach sach, Integer soLuong) {
		Kho kho = khoRepository.findBySach(sach).orElse(null);
		if (kho == null) {
			kho = new Kho();
			kho.setSach(sach);
			kho.setSoLuong(soLuong);
		} else {
			kho.setSoLuong(kho.getSoLuong() + soLuong);
		}
		khoRepository.save(kho);
	}

}
