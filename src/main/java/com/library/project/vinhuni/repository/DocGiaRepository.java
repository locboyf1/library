package com.library.project.vinhuni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.DocGia;

public interface DocGiaRepository extends JpaRepository<DocGia, Integer> {
	public Optional<DocGia> findByMaDocGia(String maDocGia);
}
