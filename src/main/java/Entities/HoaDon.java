package Entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;

import Utinities.hibernate_ultil;
@Entity
public class HoaDon {
	@Id
	private int maHoaDon;
	@OneToMany(mappedBy = "hoadon")
	private List<KhachTrongPhong> dskhactrongphong;
	@ManyToOne
	private NhanVien nhanvien;
	private String TrangThai;
	private Date NgayCheckIn;
	private Date ngayCheckOut;
	private Date NgayTao;
	public HoaDon(int maHoaDon, List<KhachTrongPhong> dskhactrongphong, NhanVien nhanvien, String trangThai,
			Date ngayCheckIn, Date ngayCheckOut, Date ngayTao) {
 		this.maHoaDon = maHoaDon;
		this.dskhactrongphong = dskhactrongphong;
		this.nhanvien = nhanvien;
		TrangThai = trangThai;
		NgayCheckIn = ngayCheckIn;
		this.ngayCheckOut = ngayCheckOut;
		NgayTao = ngayTao;
	}
	public HoaDon() {
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public List<KhachTrongPhong> getDskhactrongphong() {
		return dskhactrongphong;
	}
	public void setDskhactrongphong(List<KhachTrongPhong> dskhactrongphong) {
		this.dskhactrongphong = dskhactrongphong;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public Date getNgayCheckIn() {
		return NgayCheckIn;
	}
	public void setNgayCheckIn(Date ngayCheckIn) {
		NgayCheckIn = ngayCheckIn;
	}
	public Date getNgayCheckOut() {
		return ngayCheckOut;
	}
	public void setNgayCheckOut(Date ngayCheckOut) {
		this.ngayCheckOut = ngayCheckOut;
	}
	public Date getNgayTao() {
		return NgayTao;
	}
	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}
	
	
	
	
}
