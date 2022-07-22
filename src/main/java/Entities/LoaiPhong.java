package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class LoaiPhong {
	@Id
	private int MaLoaiPhong;
	private String TenLoai;
	@OneToMany(mappedBy = "loaiphong")
	private List<Phong> DSPhong;
	
	public LoaiPhong(int maLoaiPhong, String tenLoai) {
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
	}



	public LoaiPhong(int maLoaiPhong, String tenLoai, List<Phong> dSPhong) {
		super();
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
		DSPhong = dSPhong;
	}



	public LoaiPhong() {
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
