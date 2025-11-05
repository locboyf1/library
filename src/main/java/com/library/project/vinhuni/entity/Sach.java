package com.library.project.vinhuni.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblSach")
public class Sach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSach")
	private Integer maSach;

	@NotBlank(message = "Tên sách không được để trống")
	@Size(max = 200, message = "Tên sách không được quá dài")
	@Column(name = "TenSach", length = 200)
	private String tenSach;

	@OneToOne
	@JoinColumn(name = "MaTheLoai", referencedColumnName = "MaTheLoai")
	private TheLoai theLoai;

	@OneToOne
	@JoinColumn(name = "MaTacGia", referencedColumnName = "MaTacGia")
	private TacGia tacGia;

	@OneToOne
	@JoinColumn(name = "MaNXB", referencedColumnName = "MaNXB")
	private NhaXuatBan nhaXuatBan;

	@NotBlank(message = "Số lượng không được để trống")
	@Size(max = 10, message = "Không được khai khống số lượng")
	@Column(name = "SoLuong", length = 10)
	private Integer soLuong;

	@Column(name = "MoTa", length = 250)
	private String moTa;

	@Column(name = "AnhBia", nullable = false, columnDefinition = "LONGTEXT")
	private String anhBia;

	@Column(name = "TinhTrang", length = 50)
	private String tinhTrang;
}
