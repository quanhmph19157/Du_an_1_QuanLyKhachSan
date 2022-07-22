package Services;

import java.util.ArrayList;
import java.util.List;

import Entities.LoaiPhong;
import Repositories.dao_loaiPhong;
import ViewModels.ModelLoaiPhong;

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
			lp.add(new ModelLoaiPhong(list_lp.get(i).getMaLoaiPhong(),list_lp.get(i).getTenLoai()));
		}
		return lp;
	}
}
