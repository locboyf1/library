package com.library.project.vinhuni.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.project.vinhuni.entity.TaiKhoan;
import com.library.project.vinhuni.repository.TaiKhoanRepository;

@Service
public class TaiKhoanService implements UserDetailsService {
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<TaiKhoan> findAll() {
		return taiKhoanRepository.findAll();
	}

	public TaiKhoan findByTenDangNhap(String tenDangNhap) {
		return taiKhoanRepository.findByTenDangNhap(tenDangNhap).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan nguoiDung = taiKhoanRepository.findByTenDangNhap(username).orElseThrow(
				() -> new UsernameNotFoundException("Không tìm thấy người dùng với tài khoản: " + username));

		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(nguoiDung.getLoaiTaiKhoan()));

		return new User(nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), authorities);
	}

	public void show(String tenDangNhap) {
		TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(tenDangNhap).orElse(null);
		taiKhoan.setTrangThai(!taiKhoan.getTrangThai());
		taiKhoanRepository.save(taiKhoan);
	}
}
