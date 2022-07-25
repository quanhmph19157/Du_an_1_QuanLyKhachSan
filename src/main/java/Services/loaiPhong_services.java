package Services;

import java.util.ArrayList;
import java.util.List;

import Entities.LoaiPhong;
import Entities.Phong;
import Repositories.dao_loaiPhong;
import ViewModels.ModelLoaiPhong;
import ViewModels.ModelPhong;
import ViewModels.ModelTang;

public class loaiPhong_services {
	dao_loaiPhong dao;
	public loaiPhong_services() {
		//TODO Auto-generated constructor stub
		dao=new dao_loaiPhong();
	}
	
	public List<ModelLoaiPhong> getLp(){
		List<ModelLoaiPhong> lp=new ArrayList<ModelLoaiPhong>();
		List<LoaiPhong> list_lp=dao.select();
		for(int i=0;i<list_lp.size();i++) {
			if(list_lp.get(i).getDSPhong()==null) {
				List<ModelPhong> lst_p=new ArrayList<ModelPhong>();
				lp.add(new ModelLoaiPhong(list_lp.get(i).getMaLoaiPhong(),list_lp.get(i).getTenLoai(),lst_p));
			}
			else {
				System.out.println("sadasd");
				List<ModelPhong> lst_p=new ArrayList<ModelPhong>();
				for(Phong p:list_lp.get(i).getDSPhong()) {
					lst_p.add(new ModelPhong(p.getMaPhong(), new ModelTang(p.getTang().getMaTang()),new ModelLoaiPhong(p.getLoaiphong().getMaLoaiPhong(),p.getLoaiphong().getTenLoai())));
				}
				lp.add(new ModelLoaiPhong(list_lp.get(i).getMaLoaiPhong(),list_lp.get(i).getTenLoai(),lst_p));
			}
		}
		return lp;
	}
}
