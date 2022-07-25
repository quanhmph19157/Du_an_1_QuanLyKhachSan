package dao;

import java.util.ArrayList;
import java.util.List;

import entities.PhieuNhapKho;
import entities.NhomSPVaDichVu;

public interface INhomSPVaDichVu {
	public void them_sua(NhomSPVaDichVu nhomSPVaDichVu);
	public void updateListNhomSPVaDichVu();
	public List<NhomSPVaDichVu> getListNhomSPVaDichVu();
}
