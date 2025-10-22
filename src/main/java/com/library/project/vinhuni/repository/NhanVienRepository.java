package com.library.project.vinhuni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
	public Optional<NhanVien> findByMaNhanVien(String maNhanVien);
}
