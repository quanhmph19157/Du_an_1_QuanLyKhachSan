package Services;

import java.util.ArrayList;
import java.util.List;

import Entities.KhachSan;
import Entities.Phong;
import Entities.Tang;
import Repositories.dao_KhachSan;
import ViewModels.ModelKhachSan;
import ViewModels.ModelPhong;
import ViewModels.ModelTang;

public class KhachSan_services {

	dao_KhachSan dao;
	public KhachSan_services() {
		//TODO Auto-generated constructor stub
		dao=new dao_KhachSan();
	}

	public void themsua(ModelKhachSan ks) {
		dao.themSua(new KhachSan(ks.getMaKS(),ks.getTenKhachSan(),ks.getEmail(),ks.getSdt(),ks.getDiaChi()));
	}
	
	public ModelKhachSan getKs() {
		KhachSan ks=dao.getKs();
		if(ks==null) {
			List<ModelTang> t=new ArrayList<ModelTang>();
			themsua(new ModelKhachSan(1,null,null,null,null,t));
			return getKs();
		}
		return transform(ks);
	}
	
	public KhachSan transform(ModelKhachSan ks) {
		return new KhachSan(ks.getMaKS(),ks.getTenKhachSan(),ks.getEmail(),ks.getSdt(),ks.getDiaChi());
	}
	
	public ModelKhachSan transform(KhachSan ks) {
		List<ModelTang> dstang=new ArrayList<ModelTang>();
		for(Tang t:ks.getDSTang()) {
			List<ModelPhong> dsphong=new ArrayList<ModelPhong>();
			ModelKhachSan mks=new ModelKhachSan();
			mks.setMaKS(t.getKhachsan().getMaKS());
			mks.setTenKhachSan(t.getKhachsan().getTenKhachSan());
			mks.setEmail(t.getKhachsan().getEmail());
			mks.setDiaChi(t.getKhachsan().getDiaChi());
			ModelTang tang=new ModelTang(t.getMaTang(),mks,dsphong);
			for(Phong p:t.getDSPhong()) {
				tang.getDSPhong().add(new ModelPhong(p.getMaPhong(),tang,p.getLoaiphong(),p.getDSHoaDonPhong()));
			}
			dstang.add(tang);
		}
		return new ModelKhachSan(ks.getMaKS(),ks.getTenKhachSan(),ks.getEmail(),ks.getSdt(),ks.getDiaChi(),dstang);
	}
	
	
}
