package ViewModels;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Entities.HoaDon;
import Entities.KhachHang;
import Entities.Phong;

public class ModelKhachTrongPhong {

	private String id;
	private ModelHoaDon hoadon;
	private ModelPhong phong;
	private ModelKhachHang khachhang; 
	private float GiaPhong;
	private float PhuPhi;
	private String GhiChu;
	
	public ModelKhachTrongPhong(String id, float giaPhong, float phuPhi, String ghiChu) {
		this.id = id;
		GiaPhong = giaPhong;
		PhuPhi = phuPhi;
		GhiChu = ghiChu;
	}
	
	public ModelKhachTrongPhong(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ModelHoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(ModelHoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public ModelPhong getPhong() {
		return phong;
	}

	public void setPhong(ModelPhong phong) {
		this.phong = phong;
	}

	public ModelKhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(ModelKhachHang khachhang) {
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
