package com.library.project.vinhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.project.vinhuni.entity.Kho;

@Repository
public interface KhoRepository extends JpaRepository<Kho, Long> {
	public Kho findByMaKho(Long maKho);
}