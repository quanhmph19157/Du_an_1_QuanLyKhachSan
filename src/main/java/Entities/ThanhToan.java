package Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ThanhToan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maThanhToan;
	private Double tien;
	private String loaiThanhToan;
	@ManyToOne
	private KhachTrongPhong khachtrongphong;
	private Date ngayThanhToan;
	
	public ThanhToan() {
		//TODO Auto-generated constructor stub
	}

	
	public ThanhToan(int maThanhToan, Double tien, String loaiThanhToan, KhachTrongPhong khachtrongphong,
			Date ngayThanhToan) {
		super();
		this.maThanhToan = maThanhToan;
		this.tien = tien;
		this.loaiThanhToan = loaiThanhToan;
		this.khachtrongphong = khachtrongphong;
		this.ngayThanhToan = ngayThanhToan;
	}


	public int getMaThanhToan() {
		return maThanhToan;
	}

	public void setMaThanhToan(int maThanhToan) {
		this.maThanhToan = maThanhToan;
	}

	public Double getTien() {
		return tien;
	}

	public void setTien(Double tien) {
		this.tien = tien;
	}

	public String getLoaiThanhToan() {
		return loaiThanhToan;
	}

	public void setLoaiThanhToan(String loaiThanhToan) {
		this.loaiThanhToan = loaiThanhToan;
	}

	public KhachTrongPhong getKhachtrongphong() {
		return khachtrongphong;
	}

	public void setKhachtrongphong(KhachTrongPhong khachtrongphong) {
		this.khachtrongphong = khachtrongphong;
	}


	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}


	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	
}
