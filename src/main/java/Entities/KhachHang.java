package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class KhachHang {
	@Id
	private int MaKhachHang;
	private String TenKhachHang;
	private String CMND;
	private String SDT;
	private String Email;
	@ManyToMany(mappedBy = "dskhachhang")
	private List<HoaDon> dshoadon;
	
	public KhachHang(int maKhachHang, String tenKhachHang, String cMND, String sDT, String email,
			List<HoaDon> dshoadon) {
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		CMND = cMND;
		SDT = sDT;
		Email = email;
		this.dshoadon = dshoadon;
	}
	
	public KhachHang() {
	}
	
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<HoaDon> getDshoadon() {
		return dshoadon;
	}
	public void setDshoadon(List<HoaDon> dshoadon) {
		this.dshoadon = dshoadon;
	}
	
}
