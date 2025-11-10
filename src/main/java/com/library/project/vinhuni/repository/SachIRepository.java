package com.library.project.vinhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.Sach;

public interface SachIRepository extends JpaRepository<Sach, Long> {

	public Sach findByMaSach(Long maSach);
}