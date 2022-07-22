package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ChiTietDichVu implements Serializable{
	@Id
	@ManyToOne
	private DichVu dichvu;
	@Id
	@ManyToOne
	private HoaDon hoadon;
	private int SoLuong;
	public ChiTietDichVu(DichVu dichvu, HoaDon hoadon, int soLuong) {
		this.dichvu = dichvu;
		this.hoadon = hoadon;
		SoLuong = soLuong;
	}
	public ChiTietDichVu() {
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	public HoaDon getHoadon() {
		return hoadon;
	}
	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
	
}
