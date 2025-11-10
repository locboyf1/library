package com.library.project.vinhuni.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.repository.SachIRepository;

@Service
public class SachServiceImpl implements SachService {

	@Autowired
	SachIRepository sachRepository;

	private String saveUploadedFile(MultipartFile file) {
		if (file.isEmpty()) {
			return null;
		}

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "src/main/resources/static/uploads/images";
		Path uploadPath = Paths.get(uploadDir);

		try {
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			try (InputStream inputStream = file.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				return "/uploads/images/" + fileName;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void create(Sach sach, MultipartFile fileAnhBia) {
		String tenFileAnh = saveUploadedFile(fileAnhBia);

		if (tenFileAnh != null) {
			sach.setAnhBia(tenFileAnh);
		}

		sach.setNgayNhap(LocalDate.now());
		sach.setTinhTrang("Sẵn có");

		sachRepository.save(sach);
	}

	@Override
	public void update(Sach sach, MultipartFile fileAnhBia) {
		Sach sachDB = sachRepository.findByMaSach(sach.getMaSach());

		if (fileAnhBia != null && !fileAnhBia.isEmpty()) {
			String tenFileAnh = saveUploadedFile(fileAnhBia);
			if (tenFileAnh != null) {
				sach.setAnhBia(tenFileAnh);
			}
		} else {
			sach.setAnhBia(sachDB.getAnhBia());
		}

		sach.setNgayNhap(sachDB.getNgayNhap());
		sach.setTinhTrang(sachDB.getTinhTrang());

		sachRepository.save(sach);
	}

	@Override
	public Sach findByMaSach(Long maSach) {
		return sachRepository.findByMaSach(maSach);
	}

	@Override
	public List<Sach> findAll() {
		return sachRepository.findAll();
	}

	@Override
	public void show(Sach sach) {
		String tinhTrangHienTai = sach.getTinhTrang();
		if ("Sẵn có".equals(tinhTrangHienTai)) {
			sach.setTinhTrang("Đã ẩn");
		} else {
			sach.setTinhTrang("Sẵn có");
		}
		sachRepository.save(sach);
	}
}