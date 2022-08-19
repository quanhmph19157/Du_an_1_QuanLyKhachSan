package dao;


import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import Entities.ChucVu;
import Entities.NhanVien;
import utils.DB_Connection;

public class ChucVuDao implements IChucVuDao{
	private static ArrayList<ChucVu> _listChucVus = new ArrayList<ChucVu>();
	private int maxID;
	
	public void them_sua(ChucVu chucVu) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(chucVu);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListChucVu() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from chucVu");
		query.addEntity(ChucVu.class);
		_listChucVus = (ArrayList<ChucVu>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listChucVus);
	}
	
	public void getMaxID(ArrayList<ChucVu> listChucVu) {
		if(listChucVu.size()==0) {
			maxID =1;
		}else {
			maxID = Integer.parseInt(listChucVu.get((listChucVu.size()-1)).getMaChucVu());
			maxID++;
		}
	}

	public ArrayList<ChucVu> getListChucVu() {
		return _listChucVus;
	}
	
	public int getMaxID() {
		return maxID;
	}
}

