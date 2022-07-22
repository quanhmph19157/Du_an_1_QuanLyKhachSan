package ViewModels;

import java.util.List;

import javax.persistence.OneToMany;

import Entities.HoaDonPhong;
import Entities.LoaiPhong;

public class ModelPhong {
	private int maPhong;
	private ModelTang tang;
	private LoaiPhong loaiphong;
	private List<HoaDonPhong> DSHoaDonPhong;
	
	public ModelPhong(int maPhong, ModelTang tang) {
		this.maPhong = maPhong;
		this.tang = tang;
	}
	
	

	public ModelPhong(int maPhong, ModelTang tang, LoaiPhong loaiphong, List<HoaDonPhong> dSHoaDonPhong) {
		this.maPhong = maPhong;
		this.tang = tang;
		this.loaiphong = loaiphong;
		DSHoaDonPhong = dSHoaDonPhong;
	}



	public ModelPhong(int maPhong, ModelTang tang, LoaiPhong loaiphong) {
		this.maPhong = maPhong;
		this.tang = tang;
		this.loaiphong = loaiphong;
	}

	public ModelPhong() {
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public ModelTang getTang() {
		return tang;
	}

	public void setTang(ModelTang tang) {
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
