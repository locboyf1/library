package com.library.project.vinhuni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.NhaXuatBan;
import com.library.project.vinhuni.repository.NhaXuatBanRepository;

@Service
public class NhaXuatBanService {
	@Autowired
	NhaXuatBanRepository nhaXuatBanRepository;

	public NhaXuatBan findByMaNXB(Integer maNXB) {
		return nhaXuatBanRepository.findByMaNhaXuatBan(maNXB);
	}

	public List<NhaXuatBan> findAll() {
		return nhaXuatBanRepository.findAll();
	}

	public void create(NhaXuatBan nhaXuatBan) {
		nhaXuatBanRepository.save(nhaXuatBan);
	}

	public void update(NhaXuatBan nhaXuatBan) {
		nhaXuatBanRepository.save(nhaXuatBan);
	}

}
