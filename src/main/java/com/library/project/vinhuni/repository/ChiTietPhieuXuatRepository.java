package com.library.project.vinhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.ChiTietPhieuXuat;

public interface ChiTietPhieuXuatRepository extends JpaRepository<ChiTietPhieuXuat, Long> {
	public ChiTietPhieuXuat findByMaCTPX(Long maChiTietPhieuXuat);
}
