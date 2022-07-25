package ViewModels;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Entities.KhachTrongPhong;
import Entities.NhanVien;

public class ModelHoaDon {

	private int maHoaDon;
	private List<ModelKhachTrongPhong> dskhactrongphong;
	private ModelNhanVien nhanvien;
	private String TrangThai;
	private Date NgayCheckIn;
	private Date ngayCheckOut;
	private Date NgayTao;
	
	public ModelHoaDon() {
		//TODO Auto-generated constructor stub
	}

}
