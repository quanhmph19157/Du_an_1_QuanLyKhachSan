package ViewModels;

import java.util.List;

import javax.persistence.OneToMany;

import Entities.Phong;

public class ModelLoaiPhong {

	private int MaLoaiPhong;
	private String TenLoai;
	private List<Phong> DSPhong;
	
	public ModelLoaiPhong() {
		//TODO Auto-generated constructor stub
	}

	public ModelLoaiPhong(int maLoaiPhong, String tenLoai) {
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
	}

	public int getMaLoaiPhong() {
		return MaLoaiPhong;
	}

	public void setMaLoaiPhong(int maLoaiPhong) {
		MaLoaiPhong = maLoaiPhong;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public List<Phong> getDSPhong() {
		return DSPhong;
	}

	public void setDSPhong(List<Phong> dSPhong) {
		DSPhong = dSPhong;
	}
	
	
}
