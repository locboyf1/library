package com.library.project.vinhuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.library.project.vinhuni.entity.Sach;

public interface SachIRepository extends JpaRepository<Sach, Long> {

    Page<Sach> findByHienTrue(Pageable pageable);

    Sach findByMaSach(Long maSach);
}
