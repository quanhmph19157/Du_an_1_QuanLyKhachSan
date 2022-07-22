package Entities;

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
	private List<HoaDonPhong> DSHoaDonPhong;
	@OneToMany(mappedBy = "hoadon")
	private List<ChiTietDichVu> dsdichvu;
	@ManyToMany
	private List<KhachHang> dskhachhang;
	@ManyToOne
	private NhanVien nhanvien;
	private String TrangThai;
	private Timestamp NgayCheckIn;
	private Timestamp NgayTao;
	
	
	
	public HoaDon(int maHoaDon, List<HoaDonPhong> dSHoaDonPhong, List<ChiTietDichVu> dsdichvu,
			List<KhachHang> dskhachhang, NhanVien nhanvien, String trangThai, Timestamp ngayCheckIn,
			Timestamp ngayTao) {
		this.maHoaDon = maHoaDon;
		DSHoaDonPhong = dSHoaDonPhong;
		this.dsdichvu = dsdichvu;
		this.dskhachhang = dskhachhang;
		this.nhanvien = nhanvien;
		TrangThai = trangThai;
		NgayCheckIn = ngayCheckIn;
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

	public List<HoaDonPhong> getDSHoaDonPhong() {
		return DSHoaDonPhong;
	}

	public void setDSHoaDonPhong(List<HoaDonPhong> dSHoaDonPhong) {
		DSHoaDonPhong = dSHoaDonPhong;
	}

	public List<ChiTietDichVu> getDsdichvu() {
		return dsdichvu;
	}

	public void setDsdichvu(List<ChiTietDichVu> dsdichvu) {
		this.dsdichvu = dsdichvu;
	}

	public List<KhachHang> getDskhachhang() {
		return dskhachhang;
	}

	public void setDskhachhang(List<KhachHang> dskhachhang) {
		this.dskhachhang = dskhachhang;
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

	public Timestamp getNgayCheckIn() {
		return NgayCheckIn;
	}

	public void setNgayCheckIn(Timestamp ngayCheckIn) {
		NgayCheckIn = ngayCheckIn;
	}

	public Timestamp getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		NgayTao = ngayTao;
	}

}
