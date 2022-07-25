package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class DichVu {
	@Id
	private int MaDichVu;
	private String TenDichVu;
	private float GiaNhap;
	private float GiaBan;
	private int SoLuongTon;
	private String TrangThai;
	@OneToMany(mappedBy = "dichvu")
	private List<ChiTietDichVu> ctdv;
	
	public DichVu(int maDichVu, String tenDichVu, float giaNhap, float giaBan, int soLuongTon, String trangThai,
			List<ChiTietDichVu> ctdv) {
		MaDichVu = maDichVu;
		TenDichVu = tenDichVu;
		GiaNhap = giaNhap;
		GiaBan = giaBan;
		SoLuongTon = soLuongTon;
		TrangThai = trangThai;
		this.ctdv = ctdv;
	}

	public DichVu() {
	}

	public int getMaDichVu() {
		return MaDichVu;
	}

	public void setMaDichVu(int maDichVu) {
		MaDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return TenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		TenDichVu = tenDichVu;
	}

	public float getGiaNhap() {
		return GiaNhap;
	}

	public void setGiaNhap(float giaNhap) {
		GiaNhap = giaNhap;
	}

	public float getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}

	public int getSoLuongTon() {
		return SoLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		SoLuongTon = soLuongTon;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public List<ChiTietDichVu> getCtdv() {
		return ctdv;
	}

	public void setCtdv(List<ChiTietDichVu> ctdv) {
		this.ctdv = ctdv;
	}

	
	
	
}
