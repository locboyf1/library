package com.library.project.vinhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.Sach;

public interface SachRepository extends JpaRepository<Sach, Long> {

	List<Sach> findByHienTrueOrderByNgayNhapDesc();

	Sach findByMaSach(Long maSach);
}
