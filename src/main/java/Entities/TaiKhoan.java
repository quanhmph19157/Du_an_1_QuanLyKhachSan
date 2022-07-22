package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class TaiKhoan {
	@Id
	private String TK;
	private String pass;
	@ManyToOne
	private NhanVien nhanvien;
}
