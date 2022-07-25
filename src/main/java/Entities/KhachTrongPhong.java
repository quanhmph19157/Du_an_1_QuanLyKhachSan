package Entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class KhachTrongPhong implements Serializable{
	@Id
	private String id;
	@ManyToOne
	private HoaDon hoadon;
	@ManyToOne
	private Phong phong;
	@ManyToOne
	private KhachHang khachhang; 
	private float GiaPhong;
	private float PhuPhi;
	private String GhiChu;
	@OneToMany (mappedBy = "khachtrongphong")
	private List<ThanhToan> dsthanhtoan;
	public KhachTrongPhong(String id, HoaDon hoadon, Phong phong, KhachHang khachhang, float giaPhong, float phuPhi,
			String ghiChu) {
		super();
		this.id = id;
		this.hoadon = hoadon;
		this.phong = phong;
		this.khachhang = khachhang;
		GiaPhong = giaPhong;
		PhuPhi = phuPhi;
		GhiChu = ghiChu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
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
