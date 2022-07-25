package services;

import java.util.ArrayList;
import java.util.List;

import dao.DonViChiTietDao;
import entities.DonViChiTiet;
import models.DonViChiTietModel;
import utils.IoCContainer;

public class DonViChiTietService implements IDonViChiTietService{
	private IoCContainer ioCContainer = new IoCContainer();
	private List<DonViChiTietModel> _listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
	private DonViChiTietDao _DonViChiTietDao = (DonViChiTietDao) ioCContainer.getBean(DonViChiTietDao.class.toString());
	private DonViChiTiet _DonViChiTiet;
	private DonViChiTietModel _DonViChiTietModel = (DonViChiTietModel) IoCContainer.getBean(DonViChiTietModel.class.toString());
	private int maxID;

	public static DonViChiTiet modelToEntity(DonViChiTietModel DonViChiTietModel) {
		DonViChiTiet DonViChiTiet = new DonViChiTiet();
		DonViChiTiet.setMaDonViChiTiet(DonViChiTietModel.getMaDonViChiTiet());
		DonViChiTiet.setDonViTinh(DonViTinhService.modelToEntity(DonViChiTietModel.getDonViTinhModel()));
		DonViChiTiet.setSanPhamVaDichVu(SanPhamVaDichVuService.modelToEntity(DonViChiTietModel.getSanPhamVaDichVuModel()));
		DonViChiTiet.setGiaTriQuyDoi(DonViChiTietModel.getGiaTriQuyDoi());
		DonViChiTiet.setGiaBan(DonViChiTietModel.getGiaBan());
		DonViChiTiet.setTrangThai(DonViChiTietModel.getTrangThai());
		return DonViChiTiet;
	}
	public static DonViChiTietModel entityToModel(DonViChiTiet donViChiTiet) {
		DonViChiTietModel donViChiTietModel = new DonViChiTietModel();
		donViChiTietModel.setMaDonViChiTiet(donViChiTiet.getMaDonViChiTiet());
		donViChiTietModel.setDonViTinhModel(DonViTinhService.entityToModel(donViChiTiet.getDonViTinh()));
		donViChiTietModel.setSanPhamVaDichVuModel(SanPhamVaDichVuService.entityToModel(donViChiTiet.getSanPhamVaDichVu()));
		donViChiTietModel.setGiaTriQuyDoi(donViChiTiet.getGiaTriQuyDoi());
		donViChiTietModel.setGiaBan(donViChiTiet.getGiaBan());
		donViChiTietModel.setTrangThai(donViChiTiet.getTrangThai());
		return donViChiTietModel;
	}
	
	public static List<DonViChiTiet> listModelToListEntities(List<DonViChiTietModel> listDonViChiTietModel) {
		List<DonViChiTiet> listDonViChiTiet = new ArrayList<DonViChiTiet>();
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModel) {
			DonViChiTiet donViChiTiet = modelToEntity(donViChiTietModel);
			listDonViChiTiet.add(donViChiTiet);
		}
		return listDonViChiTiet;
	}
	
	public static List<DonViChiTietModel> listEntitiesTolistModel(List<DonViChiTiet> listDonViChiTiet) {
		List<DonViChiTietModel> listDonViChiTietModel = new ArrayList<DonViChiTietModel>();
		for (DonViChiTiet donViChiTiet : listDonViChiTiet) {
			DonViChiTietModel donViChiTietModel = entityToModel(donViChiTiet);
			listDonViChiTietModel.add(donViChiTietModel);
		}
		return listDonViChiTietModel;
	}

	public void them_sua(DonViChiTietModel DonViChiTietModel) {
		_DonViChiTiet = modelToEntity(DonViChiTietModel);
		_DonViChiTietDao.them_sua(_DonViChiTiet);
		_listDonViChiTietModels.add(DonViChiTietModel); // check lai
	}

	
	public void updateListDonViChiTietModel() {
		_DonViChiTietDao.updateListDonViChiTiet();
		List<DonViChiTiet> listDonViChiTiet = _DonViChiTietDao.getListDonViChiTiet();
		_listDonViChiTietModels = listEntitiesTolistModel(listDonViChiTiet);
		maxID = _DonViChiTietDao.getMaxID();
	}

	public List<DonViChiTietModel> getListDonViChiTietModel() {
		return _listDonViChiTietModels;
	}
	
	public int getMaxID() {
		return maxID;
	}

}
