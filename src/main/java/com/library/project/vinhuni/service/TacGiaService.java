package com.library.project.vinhuni.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.Utillities.Functions;
import com.library.project.vinhuni.Utillities.ImageProcess;
import com.library.project.vinhuni.entity.TacGia;
import com.library.project.vinhuni.repository.TacGiaRepository;

@Service
public class TacGiaService {

	@Autowired
	TacGiaRepository tacGiaRepository;

	public List<TacGia> findAll() {
		return tacGiaRepository.findAll();
	};

	public List<TacGia> findAllByMaTacGiaIn(List<Integer> maTacGias) {
		return tacGiaRepository.findAllById(maTacGias);
	}

	public List<TacGia> findByHienTrue() {
		return tacGiaRepository.findByHienTrue();
	}

	public TacGia findByMaTacGia(Integer maTacGia) {
		return tacGiaRepository.findByMaTacGia(maTacGia).orElse(null);
	}

	public void create(TacGia tacGia, MultipartFile fileAnh) throws IOException {
		byte[] anh = fileAnh.getBytes();
		String kieuAnh = fileAnh.getContentType();
		String anhBase64 = ImageProcess.convertImage2String(anh, kieuAnh);
		tacGia.setAnh(anhBase64);
		tacGia.setBiDanh(Functions.stringToAlias(tacGia.getTenTacGia()));

		tacGiaRepository.save(tacGia);
	}

	public void update(TacGia tacGia, MultipartFile fileAnh) throws IOException {
		if (fileAnh.isEmpty()) {
			TacGia tacGiaDatabase = tacGiaRepository.findByMaTacGia(tacGia.getMaTacGia()).orElse(null);
			tacGia.setAnh(tacGiaDatabase.getAnh());
		} else {
			byte[] anh = fileAnh.getBytes();
			String kieuAnh = fileAnh.getContentType();
			String anhBase64 = ImageProcess.convertImage2String(anh, kieuAnh);
			tacGia.setAnh(anhBase64);
		}
		tacGia.setBiDanh(Functions.stringToAlias(tacGia.getTenTacGia()));
		tacGiaRepository.save(tacGia);
	}

	public void show(Integer maTacGia) {
		TacGia tacGia = tacGiaRepository.findByMaTacGia(maTacGia).orElse(null);
		tacGia.setHien(!tacGia.getHien());
		tacGiaRepository.save(tacGia);
	}
}
