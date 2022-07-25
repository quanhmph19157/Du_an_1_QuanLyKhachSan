package dao;

import java.util.ArrayList;
import java.util.List;

import entities.SanPhamVaDichVu;

public interface ISanPhamVaDichVuDao {
	public void them_sua(SanPhamVaDichVu sanPhamVaDichVu);
	public void updateListSanPhamVaDichVu();
	public List<SanPhamVaDichVu> getListSanPhamVaDichVu();
}
