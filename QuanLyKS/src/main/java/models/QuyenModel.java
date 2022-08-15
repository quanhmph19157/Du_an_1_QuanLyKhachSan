package models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import Entities.Quyen_cv;

public class QuyenModel {
	private int maQuyen;
	private String tenQuyen;
	
	public QuyenModel(int maQuyen, String tenQuyen) {
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
	}
	public QuyenModel() {
	}
	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
	
}
