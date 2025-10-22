package com.library.project.vinhuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.DocGia;
import com.library.project.vinhuni.repository.DocGiaRepository;

@Service
public class DocGiaService {
	@Autowired
	DocGiaRepository docGiaRepository;

	public DocGia findByMaDocGia(String maDocGia) {
		return docGiaRepository.findByMaDocGia(maDocGia).orElse(null);
	}
}
