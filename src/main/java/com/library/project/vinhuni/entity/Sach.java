package com.library.project.vinhuni.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// IMPORT CÁC ANNOTATION VALIDATION
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_sach")
public class Sach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_sach")
	private Long maSach;

	@NotBlank(message = "Tên sách không được để trống")
	@Size(max = 255, message = "Tên sách không quá 255 ký tự")
	@Column(name = "ten_sach", nullable = false)
	private String tenSach;

	@NotNull(message = "Số lượng không được để trống")
	@Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
	@Column(name = "so_luong")
	private Integer soLuong;

	@Column(name = "mo_ta", columnDefinition = "TEXT")
	private String moTa;

	@Column(name = "anh_bia")
	private String anhBia;

	@Column(name = "nam_xuat_ban")
	private Integer namXuatBan;

	@Column(name = "ngay_nhap")
	private LocalDate ngayNhap;

	@Column(name = "tinh_trang")
	private String tinhTrang;

	@NotNull(message = "Nhà xuất bản không được để trống")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_nxb")
	private NhaXuatBan nxb;

	@NotEmpty(message = "Phải chọn ít nhất một thể loại")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_sach_the_loai", joinColumns = @JoinColumn(name = "ma_sach"), inverseJoinColumns = @JoinColumn(name = "ma_the_loai"))
	private List<TheLoai> theLoais = new ArrayList<>();

	@NotEmpty(message = "Phải chọn ít nhất một tác giả")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_sach_tac_gia", joinColumns = @JoinColumn(name = "ma_sach"), inverseJoinColumns = @JoinColumn(name = "ma_tac_gia"))
	private List<TacGia> tacGias = new ArrayList<>();

	public Sach() {

	}

	public Long getMaSach() {
		return maSach;
	}

	public void setMaSach(Long maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getAnhBia() {
		return anhBia;
	}

	public void setAnhBia(String anhBia) {
		this.anhBia = anhBia;
	}

	public Integer getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(Integer namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public NhaXuatBan getNxb() {
		return nxb;
	}

	public void setNxb(NhaXuatBan nxb) {
		this.nxb = nxb;
	}

	public List<TheLoai> getTheLoais() {
		return theLoais;
	}

	public void setTheLoais(List<TheLoai> theLoais) {
		this.theLoais = theLoais;
	}

	public List<TacGia> getTacGias() {
		return tacGias;
	}

	public void setTacGias(List<TacGia> tacGias) {
		this.tacGias = tacGias;
	}
}