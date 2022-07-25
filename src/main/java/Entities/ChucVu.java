package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class ChucVu {
	@Id
	private String MaChucVu;
	private String TenChucVu;
	@OneToMany(mappedBy = "chucvu")
	private List<NhanVien> dsnhanvien;
	@ManyToMany(mappedBy = "dschucvu")
	private List<Quyen> dsquyen;
	public ChucVu(String maChucVu, String tenChucVu, List<NhanVien> dsnhanvien, List<Quyen> dsquyen) {
		super();
		MaChucVu = maChucVu;
		TenChucVu = tenChucVu;
		this.dsnhanvien = dsnhanvien;
		this.dsquyen = dsquyen;
	}
	public ChucVu() {
	}
	public String getMaChucVu() {
		return MaChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		MaChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return TenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		TenChucVu = tenChucVu;
	}
	public List<NhanVien> getDsnhanvien() {
		return dsnhanvien;
	}
	public void setDsnhanvien(List<NhanVien> dsnhanvien) {
		this.dsnhanvien = dsnhanvien;
	}
	public List<Quyen> getDsquyen() {
		return dsquyen;
	}
	public void setDsquyen(List<Quyen> dsquyen) {
		this.dsquyen = dsquyen;
	}
	
	
}
