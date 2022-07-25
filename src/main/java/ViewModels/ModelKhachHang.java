package ViewModels;

import java.sql.Date;
import java.util.List;

import javax.persistence.ManyToMany;

import Entities.HoaDon;

public class ModelKhachHang {

	private int MaKhachHang;
	private String TenKhachHang;
	private String CMND;
	private String SDT;
	private String Email;
	private Date NgaySinh;
	private String GioiTinh;
	private String DiaChi;
	private List<ModelKhachTrongPhong> dskhachtrongphong;
	
	public ModelKhachHang() {
		//TODO Auto-generated constructor stub
	}

	public ModelKhachHang(int maKhachHang, String tenKhachHang, String cMND, String sDT, String email, Date ngaySinh,
			String gioiTinh, String diaChi, List<ModelKhachTrongPhong> dskhachtrongphong) {
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
	
	public ModelKhachHang(int maKhachHang, String tenKhachHang, String cMND, String sDT, String email, Date ngaySinh,
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

	public List<ModelKhachTrongPhong> getDskhachtrongphong() {
		return dskhachtrongphong;
	}

	public void setDskhachtrongphong(List<ModelKhachTrongPhong> dskhachtrongphong) {
		this.dskhachtrongphong = dskhachtrongphong;
	}



	
}
