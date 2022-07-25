package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class NhanVien {
	@Id
	private String MaNhanVien;
	private String TenNhanVien;
	private String CMND;
	private String SDT;
	private String TrangThai;
	private String Email;
	private String GioiTinh;
	private String TaiKhoan;
	private String MatKhau;
	@ManyToOne
	private ChucVu chucvu;
	@OneToMany(mappedBy = "nhanvien")
	private List<HoaDon> dshoadon;
	public NhanVien(String maNhanVien, String tenNhanVien, String cMND, String sDT, String trangThai, String email,
			String gioiTinh, ChucVu chucvu, List<HoaDon> dshoadon) {
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		CMND = cMND;
		SDT = sDT;
		TrangThai = trangThai;
		Email = email;
		GioiTinh = gioiTinh;
		this.chucvu = chucvu;
		this.dshoadon = dshoadon;
	}
	
	public NhanVien(String maNhanVien, String tenNhanVien, String cMND, String sDT, String trangThai, String email,
			String gioiTinh, String taiKhoan, String matKhau, ChucVu chucvu, List<HoaDon> dshoadon) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		CMND = cMND;
		SDT = sDT;
		TrangThai = trangThai;
		Email = email;
		GioiTinh = gioiTinh;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		this.chucvu = chucvu;
		this.dshoadon = dshoadon;
	}

	public NhanVien() {
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
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
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public ChucVu getChucvu() {
		return chucvu;
	}
	public void setChucvu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}
	public List<HoaDon> getDshoadon() {
		return dshoadon;
	}
	public void setDshoadon(List<HoaDon> dshoadon) {
		this.dshoadon = dshoadon;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	
}
