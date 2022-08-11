package Services;

import java.util.ArrayList;
import java.util.List;

import dao.KhachHangDao;
import Entities.KhachHang;
import models.KhachHangModel;
import utils.IoCContainer;

public class KhachHangService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<KhachHangModel> _listKhachHangModels = new ArrayList<KhachHangModel>();
	private KhachHangDao _KhachHangDao = new KhachHangDao();
	private KhachHang _KhachHang;
	private int _maxID;

	public static KhachHang updateDataKhachHangDependOnKhachHangModel(KhachHangModel KhachHangModel) {
		KhachHang KhachHang = new KhachHang();
		KhachHang.setMaKhachHang(KhachHangModel.getMaKhachHang());
		KhachHang.setTenKhachHang(KhachHangModel.getTenKhachHang());
		KhachHang.setSdt(KhachHangModel.getSdt());
		KhachHang.setEmail(KhachHangModel.getEmail());
		KhachHang.setCmnd(KhachHangModel.getCmnd());
		KhachHang.setNgaySinh(KhachHangModel.getNgaySinh());
		KhachHang.setGioiTinh(KhachHangModel.getGioiTinh());
		KhachHang.setDiaChi(KhachHangModel.getDiaChi());
		return KhachHang;
	}
	
	public static KhachHangModel updateDataKhachHangModelDependOnKhachHang(KhachHang KhachHang) {
		KhachHangModel KhachHangModel = new KhachHangModel();
		KhachHangModel.setMaKhachHang(KhachHang.getMaKhachHang());
		KhachHangModel.setTenKhachHang(KhachHang.getTenKhachHang());
		KhachHangModel.setSdt(KhachHang.getSdt());
		KhachHangModel.setEmail(KhachHang.getEmail());
		KhachHangModel.setCmnd(KhachHang.getCmnd());
		KhachHangModel.setNgaySinh(KhachHang.getNgaySinh());
		KhachHangModel.setGioiTinh(KhachHang.getGioiTinh());
		KhachHangModel.setDiaChi(KhachHang.getDiaChi());
		return KhachHangModel;
	}
	
	public static List<KhachHang> updateListKhachHangDependOnListKhachHangModel(List<KhachHangModel> listKhachHangModel) {
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		for (KhachHangModel KhachHangModel2 : listKhachHangModel) {
			KhachHang KhachHang = updateDataKhachHangDependOnKhachHangModel(KhachHangModel2);
			listKhachHang.add(KhachHang);
		}
		return listKhachHang;
	}
	
	public static List<KhachHangModel> updateListKhachHangModelDependOnListKhachHang(List<KhachHang> listKhachHang) {
		List<KhachHangModel> listKhachHangModel = new ArrayList<KhachHangModel>();
		for (KhachHang KhachHang : listKhachHang) {
			KhachHangModel KhachHangModel = updateDataKhachHangModelDependOnKhachHang(KhachHang);
			listKhachHangModel.add(KhachHangModel);
		}
		return listKhachHangModel;
	}

	public void them_sua(KhachHangModel KhachHangModel) {
		_KhachHang = updateDataKhachHangDependOnKhachHangModel(KhachHangModel);
		_KhachHangDao.them_sua(_KhachHang);
		updateListKhachHangModel();
	}

	public void updateListKhachHangModel() {
		_KhachHangDao.updateListKhachHang();
		List<KhachHang> listKhachHang = _KhachHangDao.getListKhachHang();
		_listKhachHangModels = updateListKhachHangModelDependOnListKhachHang(listKhachHang);
		//_maxID = _KhachHangDao.getMaxID();
	}

	public int getMaxID() {
		return _maxID;
	}
	
	public List<KhachHangModel> getListKhachHangModel() {
		return _listKhachHangModels;
	}

}
