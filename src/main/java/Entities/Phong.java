package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Phong {
	@Id
	private int maPhong;
	@ManyToOne
	private Tang tang;
	@ManyToOne
	private LoaiPhong loaiphong;
	@OneToMany(mappedBy = "phong")
	private List<HoaDonPhong> DSHoaDonPhong;
	
	public Phong(int maPhong, Tang tang, LoaiPhong loaiphong) {
		this.maPhong = maPhong;
		this.tang = tang;
		this.loaiphong = loaiphong;
	}

	public Phong(int maPhong, Tang tang, LoaiPhong loaiphong, List<HoaDonPhong> dSHoaDonPhong) {
		super();
		this.maPhong = maPhong;
		this.tang = tang;
		this.loaiphong = loaiphong;
		DSHoaDonPhong = dSHoaDonPhong;
	}

	public Phong(int maPhong, Tang tang) {
		this.maPhong = maPhong;
		this.tang = tang;
	}

	public Phong() {
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public Tang getTang() {
		return tang;
	}

	public void setTang(Tang tang) {
		this.tang = tang;
	}

	public LoaiPhong getLoaiphong() {
		return loaiphong;
	}

	public void setLoaiphong(LoaiPhong loaiphong) {
		this.loaiphong = loaiphong;
	}

	public List<HoaDonPhong> getDSHoaDonPhong() {
		return DSHoaDonPhong;
	}

	public void setDSHoaDonPhong(List<HoaDonPhong> dSHoaDonPhong) {
		DSHoaDonPhong = dSHoaDonPhong;
	}
	
	
}
