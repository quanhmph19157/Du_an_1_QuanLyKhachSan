package ViewModels;

import java.util.List;

import javax.persistence.OneToMany;

import Entities.Phong;

public class ModelLoaiPhong {

	private int MaLoaiPhong;
	private String TenLoai;
	private List<ModelPhong> DSPhong;
	
	public ModelLoaiPhong() {
		//TODO Auto-generated constructor stub
	}

	public ModelLoaiPhong(int maLoaiPhong, String tenLoai) {
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
	}
	
	

	public ModelLoaiPhong(int maLoaiPhong, String tenLoai, List<ModelPhong> dSPhong) {
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
		DSPhong = dSPhong;
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

	public List<ModelPhong> getDSPhong() {
		return DSPhong;
	}

	public void setDSPhong(List<ModelPhong> dSPhong) {
		DSPhong = dSPhong;
	}
	
	
}
