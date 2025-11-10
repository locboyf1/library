package com.library.project.vinhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.NhaXuatBan;

public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer> {
	public NhaXuatBan findByMaNhaXuatBan(Integer maNhaXuatBan);

	List<NhaXuatBan> findByHienTrue();
}
