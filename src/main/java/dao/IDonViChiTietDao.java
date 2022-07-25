package dao;

import java.util.ArrayList;
import java.util.List;

import entities.DichVuPhong;
import entities.DonViChiTiet;

public interface IDonViChiTietDao {
	public void them_sua(DonViChiTiet donViChiTiet);
	public void updateListDonViChiTiet();
	public List<DonViChiTiet> getListDonViChiTiet();
}
