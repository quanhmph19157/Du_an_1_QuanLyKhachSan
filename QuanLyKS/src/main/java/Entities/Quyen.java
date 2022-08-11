package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Quyen {
	@Id
	private int MaQUyen;
	private String TenQuyen;
	@ManyToMany
	private List<ChucVu> dschucvu;
	public Quyen(int maQUyen, String tenQuyen, List<ChucVu> dschucvu) {
		MaQUyen = maQUyen;
		TenQuyen = tenQuyen;
		this.dschucvu = dschucvu;
	}
	public Quyen() {
	}
	public int getMaQUyen() {
		return MaQUyen;
	}
	public void setMaQUyen(int maQUyen) {
		MaQUyen = maQUyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	public List<ChucVu> getDschucvu() {
		return dschucvu;
	}
	public void setDschucvu(List<ChucVu> dschucvu) {
		this.dschucvu = dschucvu;
	}
	
	
}
