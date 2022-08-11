package Entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;

	@Entity 
	public class ChucVu {
		@Id
		private String maChucVu;
		private String tenChucVu;
		private String trangThai;

		
		public ChucVu(String maChucVu, String tenChucVu, String trangThai
				) {
			this.maChucVu = maChucVu;
			this.tenChucVu = tenChucVu;
			this.trangThai = trangThai;
		
		}
		
		public ChucVu() {
		}

		public String getMaChucVu() {
			return maChucVu;
		}

		public void setMaChucVu(String string) {
			this.maChucVu = string;
		}

		public String getTenChucVu() {
			return tenChucVu;
		}

		public void setTenChucVu(String tenChucVu) {
			this.tenChucVu = tenChucVu;
		}

		public String getTrangThai() {
			return trangThai;
		}

		public void setTrangThai(String trangThai) {
			this.trangThai = trangThai;
		}

	}