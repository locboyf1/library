package com.library.project.vinhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.vinhuni.entity.ChiTietPhieuNhap;

@Repository
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, Long> {
	public ChiTietPhieuNhap findByMaCTPN(Long maChiTietPhieuNhap);
}