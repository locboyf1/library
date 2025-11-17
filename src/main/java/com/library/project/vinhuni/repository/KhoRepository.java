package com.library.project.vinhuni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.vinhuni.entity.Kho;
import com.library.project.vinhuni.entity.Sach;

public interface KhoRepository extends JpaRepository<Kho, Long> {

	public Optional<Kho> findBySach(Sach sach);

}
