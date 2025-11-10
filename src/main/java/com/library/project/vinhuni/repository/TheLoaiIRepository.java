package com.library.project.vinhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.TheLoai;

public interface TheLoaiIRepository extends JpaRepository<TheLoai, Integer> {
	public TheLoai findByMaTheLoai(Integer maTheLoai);

	public List<TheLoai> findByHienTrue();
}
