package Views;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entities.PhuTroi;
import Services.KhachTrongPhong_services;
import Services.ThanhToan_services;
import Services.loaiPhong_services;
import ViewModels.ModelHoaDon;
import ViewModels.ModelKhachTrongPhong;
import ViewModels.ModelLoaiPhong;
import ViewModels.ModelThanhToan;

public class view_hoadon extends JFrame {
	private JTable tbl_phong;
	private JTable tbl_dichvu;
	private JTable tbl_phutroi;
	private JTable tbl_phuphi;
	private JTable tbl_thanhtoan;
	DefaultTableModel model_p = new DefaultTableModel(new String[] { "STT", "Phòng", "Loại phòng", "tiền phòng" }, 0);
	DefaultTableModel model_dv = new DefaultTableModel(new String[] { "STT", "Dịch vụ", "số lượng", "giá" }, 0);
	DefaultTableModel model_pt = new DefaultTableModel(
			new String[] { "STT", "Phòng", "Phòng", "Loại phụ trội", "tiền phụ trội" }, 0);
	DefaultTableModel model_pht = new DefaultTableModel(new String[] { "STT", "Tiền phụ phí", "ngày phát sinh" }, 0);
	DefaultTableModel model_tt = new DefaultTableModel(new String[] { "STT", "số tiền", "ngày thanh toán" }, 0);

	KhachTrongPhong_services ser_ktp = new KhachTrongPhong_services();
	ThanhToan_services ser_tt = new ThanhToan_services();

	List<ModelKhachTrongPhong> list_ktp = ser_ktp.getList();
	List<ModelThanhToan> list_tt;

	ModelHoaDon hd;

	public view_hoadon(ModelHoaDon hd) {
		this.hd = hd;
		list_tt = ser_tt.getList(hd.getMaHoaDon());
		setDefaultCloseOperation(2);
		setSize(1280, 720);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"H\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 810, 663);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 20, 194, 19);
		panel.add(lblNewLabel);

		JLabel lblDchV = new JLabel("Dịch vụ");
		lblDchV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDchV.setBounds(427, 20, 194, 19);
		panel.add(lblDchV);

		JLabel lblPhTri = new JLabel("Phụ trội");
		lblPhTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhTri.setBounds(10, 332, 194, 19);
		panel.add(lblPhTri);

		JLabel lblPhPh = new JLabel("Phụ phí");
		lblPhPh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhPh.setBounds(427, 332, 194, 19);
		panel.add(lblPhPh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 372, 256);
		panel.add(scrollPane);

		tbl_phong = new JTable();
		tbl_phong.setModel(model_p);
		scrollPane.setViewportView(tbl_phong);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(427, 40, 372, 256);
		panel.add(scrollPane_1);

		tbl_dichvu = new JTable();
		tbl_dichvu.setModel(model_dv);
		scrollPane_1.setViewportView(tbl_dichvu);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 361, 372, 265);
		panel.add(scrollPane_2);

		tbl_phutroi = new JTable();
		tbl_phutroi.setModel(model_pt);
		scrollPane_2.setViewportView(tbl_phutroi);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(427, 361, 372, 265);
		panel.add(scrollPane_3);

		tbl_phuphi = new JTable();
		tbl_phuphi.setModel(model_pht);
		scrollPane_3.setViewportView(tbl_phuphi);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(830, 10, 426, 526);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 25, 406, 491);
		panel_1.add(scrollPane_1_1);

		tbl_thanhtoan = new JTable();
		tbl_thanhtoan.setModel(model_tt);
		scrollPane_1_1.setViewportView(tbl_thanhtoan);
	}

	public void adddata() {
		model_dv.setRowCount(0);
		model_p.setRowCount(0);
		model_pht.setRowCount(0);
		model_pt.setRowCount(0);
		model_tt.setRowCount(0);

		int stt = 0;
		for (ModelKhachTrongPhong x : list_ktp) {
			if (x.getHoadon().getMaHoaDon() == hd.getMaHoaDon()) {
				stt++;
				model_p.addRow(new Object[] { stt, x.getPhong().getMaPhong(),x.getPhong().getLoaiphong(), x.getGiaPhong() });
			}
		}

		stt = 0;
		for (ModelThanhToan x : list_tt) {
			stt++;
			model_tt.addRow(new Object[] { stt, x.getTien(), x.getNgayThanhToan() });
		}

		stt=0;
		for (ModelKhachTrongPhong x : list_ktp) {
			if (x.getHoadon().getMaHoaDon() == hd.getMaHoaDon()) {
				stt++;
				model_p.addRow(new Object[] { stt, x.getPhong().getMaPhong(),"Check in sớm", x.getPhuTroi() });
				stt++;
				model_p.addRow(new Object[] { stt, x.getPhong().getMaPhong(),"Check out muộn", x.getPhutroi2() });
			}
		}
		
		
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				new view_hoadon(new ModelHoaDon()).setVisible(true);
			}
		}).start();
	}
}
