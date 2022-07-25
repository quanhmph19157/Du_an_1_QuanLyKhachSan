package ViewModels;

import java.sql.Date;

import javax.persistence.ManyToOne;

import Entities.KhachTrongPhong;

public class ModelThanhToan {

	private int maThanhToan;
	private Double tien;
	private String loaiThanhToan;
	private ModelKhachTrongPhong khachtrongphong;
	private Date ngayThanhToan;
	
	public ModelThanhToan() {
		//TODO Auto-generated constructor stub
	}

	
}
