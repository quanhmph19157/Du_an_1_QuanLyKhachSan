package Services;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entities.HoaDonPhong;
import Entities.Phong;
import Repositories.dao_Phong;
import ViewModels.ModelPhong;
public class Phong_services {
	dao_Phong dao;
	Tang_services ser_t;
	public Phong_services() {
		ser_t=new Tang_services();
		dao=new dao_Phong();
		//TODO Auto-generated constructor stub
	}

	public void themsua(Collection<ModelPhong> arr) {
		ArrayList<Phong> arr_p=new ArrayList<Phong>();
		for(ModelPhong p:arr) {
			System.out.println(p.getMaPhong());
			arr_p.add(new Phong(p.getMaPhong(),ser_t.tranform(p.getTang()),p.getLoaiphong()));
		}
		dao.themsua(arr_p);
	}
	
	public void xoa(Component comp,Collection<ModelPhong> arr) {
		ArrayList<Phong> arr_p=new ArrayList<Phong>();
		for(ModelPhong p:arr) {
			List<HoaDonPhong> hd=new ArrayList<HoaDonPhong>();
			p.setDSHoaDonPhong(hd);
			arr_p.add(new Phong(p.getMaPhong(),ser_t.tranform(p.getTang()),p.getLoaiphong(),p.getDSHoaDonPhong()));
		}
		dao.xoa(comp, arr_p);
	}
}
