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
		Query qr = ss.createQuery("from LoaiPhong");
		System.out.println(qr.list().size());
		return qr.list();
	}
	
}
