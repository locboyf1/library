package com.library.project.vinhuni.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.entity.Sach;

public interface SachService {

	Sach findByMaSach(Long maSach);

	List<Sach> findAll();

	void create(Sach sach, MultipartFile fileAnhBia);

	void update(Sach sach, MultipartFile fileAnhBia);

	void show(Sach sach);
}