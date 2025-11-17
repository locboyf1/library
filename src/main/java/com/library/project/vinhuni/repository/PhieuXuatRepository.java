package com.library.project.vinhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.PhieuXuat;

public interface PhieuXuatRepository extends JpaRepository<PhieuXuat, Long> {
	public List<PhieuXuat> findByOrderByNgayXuatDesc();
}
