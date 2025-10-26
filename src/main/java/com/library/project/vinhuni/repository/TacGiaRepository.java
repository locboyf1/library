package com.library.project.vinhuni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.TacGia;

public interface TacGiaRepository extends JpaRepository<TacGia, Integer> {
	Optional<TacGia> findByMaTacGia(Integer maTacGia);
}
