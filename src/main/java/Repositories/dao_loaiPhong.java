package Repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Utinities.hibernate_ultil;
import Entities.*;

public class dao_loaiPhong {

	Session ss;

	public dao_loaiPhong() {
		// TODO Auto-generated constructor stub
		ss = hibernate_ultil.ss();
	}

	public List<LoaiPhong> select() {
		ss.clear();
		Query qr = ss.createQuery("select MaLoaiPhong, TenLoai from LoaiPhong");
		List<LoaiPhong> list = new ArrayList<LoaiPhong>();
		List<Object[]>a=qr.list();
		for (int i = 0; i < qr.list().size(); i++) {
			list.add(new LoaiPhong(Integer.parseInt(String.valueOf(a.get(i)[0])),String.valueOf(a.get(i)[1])));
		}
		return list;
	}
	
}
