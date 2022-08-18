package ViewModels;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Entities.ChucVu;
import Entities.HoaDon;

public class ModelNhanVien {

	private String MaNhanVien;
	private String TenNhanVien;
	private String CMND;
	private String SDT;
	private String TrangThai;
	private String Email;
	private String GioiTinh;
	private String TaiKhoan;
	private String MatKhau;
	//private ModelChucVu chucvu;
	private List<ModelHoaDon> dshoadon;
}
