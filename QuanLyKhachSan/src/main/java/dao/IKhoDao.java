package dao;

import java.util.ArrayList;
import java.util.List;

import entities.DonViTinh;
import entities.Kho;

public interface IKhoDao {
//	public void them_sua(Kho Kho);
	public void updateListKho();
	public List<Kho> getListKho();
}
