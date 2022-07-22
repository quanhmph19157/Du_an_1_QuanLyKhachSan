package Entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class HoaDonPhong implements Serializable{
	@Id
	@ManyToOne
	private HoaDon hoadon;
	@Id
	@ManyToOne
	private Phong phong;
	private Timestamp NgayCheckOut;
	private float GiaPhong;
	private float PhuPhi;
	private String GhiChu;
	
	public HoaDonPhong(HoaDon hoadon, Phong phong, Timestamp ngayCheckOut, float giaPhong, float phuPhi,
			String ghiChu) {
		this.hoadon = hoadon;
		this.phong = phong;
		NgayCheckOut = ngayCheckOut;
		GiaPhong = giaPhong;
		PhuPhi = phuPhi;
		GhiChu = ghiChu;
	}
	
	public HoaDonPhong() {
	}
	
	public HoaDon getHoadon() {
		return hoadon;
	}
	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Timestamp getNgayCheckOut() {
		return NgayCheckOut;
	}
	public void setNgayCheckOut(Timestamp ngayCheckOut) {
		NgayCheckOut = ngayCheckOut;
	}
	public float getGiaPhong() {
		return GiaPhong;
	}
	public void setGiaPhong(float giaPhong) {
		GiaPhong = giaPhong;
	}
	public float getPhuPhi() {
		return PhuPhi;
	}
	public void setPhuPhi(float phuPhi) {
		PhuPhi = phuPhi;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	
}
