package Entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class KhachHang {
	@Id
	private int MaKhachHang;
	private String TenKhachHang;
	private String CMND;
	private String SDT;
	private String Email;
	private Date NgaySinh;
	private String GioiTinh;
	private String DiaChi;
	@OneToMany(mappedBy = "khachhang")
	private List<KhachTrongPhong> dskhachtrongphong;
	
	public KhachHang(int maKhachHang, String tenKhachHang, String cMND, String sDT, String email, Date ngaySinh,
			String gioiTinh, String diaChi) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		CMND = cMND;
		SDT = sDT;
		Email = email;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
	}

	public KhachHang(int maKhachHang, String tenKhachHang, String cMND, String sDT, String email, Date ngaySinh,
			String gioiTinh, String diaChi, List<KhachTrongPhong> dskhachtrongphong) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		CMND = cMND;
		SDT = sDT;
		Email = email;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		this.dskhachtrongphong = dskhachtrongphong;
	}

	public KhachHang() {
	}
	
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

	public List<KhachTrongPhong> getDskhachtrongphong() {
		return dskhachtrongphong;
	}

	public void setDskhachtrongphong(List<KhachTrongPhong> dskhachtrongphong) {
		this.dskhachtrongphong = dskhachtrongphong;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	
}
