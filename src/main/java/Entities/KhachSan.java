package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class KhachSan {
	@Id
	private int maKS;
	private String TenKhachSan;
	private String Email;
	private String sdt;
	private String DiaChi;
	@OneToMany(mappedBy = "khachsan")
	private List<Tang> DSTang;

	public KhachSan(int maKS, String tenKhachSan, String email, String sdt, String diaChi) {
		super();
		this.maKS = maKS;
		TenKhachSan = tenKhachSan;
		Email = email;
		this.sdt = sdt;
		DiaChi = diaChi;
	}

	public KhachSan(int maKS, String tenKhachSan, String email, String sdt, String diaChi, List<Tang> dSTang) {
		super();
		this.maKS = maKS;
		TenKhachSan = tenKhachSan;
		Email = email;
		this.sdt = sdt;
		DiaChi = diaChi;
		DSTang = dSTang;
	}

	public KhachSan() {
	}

	public int getMaKS() {
		return maKS;
	}

	public void setMaKS(int maKS) {
		this.maKS = maKS;
	}

	public String getTenKhachSan() {
		return TenKhachSan;
	}

	public void setTenKhachSan(String tenKhachSan) {
		TenKhachSan = tenKhachSan;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<Tang> getDSTang() {
		return DSTang;
	}

	public void setDSTang(List<Tang> dSTang) {
		DSTang = dSTang;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	
}
