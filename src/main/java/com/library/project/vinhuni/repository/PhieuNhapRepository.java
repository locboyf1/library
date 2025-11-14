package com.library.project.vinhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.project.vinhuni.entity.PhieuNhap;

@Repository
public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, Long> {
	public PhieuNhap findByMaPhieuNhap(Long maPhieuNhap);

	List<PhieuNhap> findByOrderByNgayNhapDesc();

	@Query("SELECT DISTINCT pn FROM PhieuNhap pn " + "LEFT JOIN FETCH pn.nhanVien " + "LEFT JOIN FETCH pn.chiTietList ctpl " + "LEFT JOIN FETCH ctpl.sach s " + "LEFT JOIN FETCH s.nxb " + "ORDER BY pn.ngayNhap DESC")
	List<PhieuNhap> findAllWithDetailsOrderByNgayNhapDesc();
}