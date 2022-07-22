package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import models.DonViChiTietModel;
import models.DonViTinhModel;
import models.NhanVienModel;
import models.NhomSPVaDichVuModel;
import models.PhieuNhapKhoChiTietModel;
import models.PhieuNhapKhoModel;
import models.SanPhamVaDichVuModel;
import services.SanPhamVaDichVuService;
import utils.IoCContainer;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Nhap_view extends JFrame {
	private IoCContainer _ioCContainer = new IoCContainer();
	private SanPhamVaDichVuService _sanPhamVaDichVuService = (SanPhamVaDichVuService) _ioCContainer
			.getBean(SanPhamVaDichVuService.class + "");
	private List<SanPhamVaDichVuModel> _lisSanPhamVaDichVuModels_active = new ArrayList<SanPhamVaDichVuModel>();
	private List<DonViChiTietModel> _listDonViChiTietModel_editing = new ArrayList<DonViChiTietModel>();
	private List<PhieuNhapKhoChiTietModel> _listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
	private NhanVienModel _userAreUsing;

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txt_maPhieuNhapKho;
	private JTextField txt_hoTenNhanVien;
	private JTextField txt_tongTienHang;
	private JTextField txt_maSanPham;
	private JTextField txt_tenSanPham;
	private JTextField txt_soLuong;
	private JTextField txt_timKiemSanPhamInserted;
	private JTextField txt_timKiemSanPham;
	private JTable table_sanPhamInserted;
	private JTable table_SanPham;
	private JTextField txt_giaNhap;
	private JTextField txt_tongCong;
	private JTextField txt_ngayGioTaoHD;
	private JTextField txt_giamGia;
	private JTextField txt_vat;
	private JTextField txt_phiShip;
	private JComboBox cbx_donViTinh;
	private JButton btn_themSP;
	private JButton btn_suaSP;
	private JButton btn_xoaSP;
	private SwitchButton switchButton_nhap;
	private JTextArea txt_ghiChu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhap_view frame = new Nhap_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nhap_view() {
		_sanPhamVaDichVuService.updateListNhomSPVaDichVuModel("Hoat Dong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1264, 681);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1244, 659);
		panel_1.add(tabbedPane);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Danh Sách", null, panel_3, null);
		panel_3.setLayout(null);

		SwitchButton switchButton = new SwitchButton();
		switchButton.setBounds(20, 37, 55, 25);
		panel_3.add(switchButton);
		switchButton.setBackground(new Color(0, 153, 204));

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(357, 19, 872, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 18, 543, 29);
		panel_2_1.add(textField);
		((JComponent) textField).setBorder(null);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 1219, 539);
		panel_3.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_2_1_1_1_2 = new JPanel();
		panel_2_1_1_1_2.setLayout(null);
		panel_2_1_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_2.setBackground(Color.WHITE);
		panel_2_1_1_1_2.setBounds(93, 19, 254, 51);
		panel_3.add(panel_2_1_1_1_2);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 20, 234, 20);
		panel_2_1_1_1_2.add(dateChooser_1);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cập Nhật Nhóm Sản Phẩm", null, panel_4, null);
		panel_4.setLayout(null);

		switchButton_nhap = new SwitchButton();
		switchButton_nhap.setBackground(new Color(0, 153, 204));
		switchButton_nhap.setBounds(887, 37, 55, 25);
		panel_4.add(switchButton_nhap);

		JLabel lblNewLabel_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(877, 5, 78, 25);
		panel_4.add(lblNewLabel_1_1);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"M\u00C3 NH\u1EACP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(10, 11, 89, 51);
		panel_4.add(panel_2_1_1);

		txt_maPhieuNhapKho = new JTextField();
		txt_maPhieuNhapKho.setColumns(10);
		txt_maPhieuNhapKho.setBorder(null);
		txt_maPhieuNhapKho.setBackground(Color.WHITE);
		txt_maPhieuNhapKho.setBounds(10, 18, 69, 29);
		panel_2_1_1.add(txt_maPhieuNhapKho);

		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"H\u1ECC T\u00CAN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1.setBounds(279, 10, 139, 51);
		panel_4.add(panel_2_1_1_1_1);

		txt_hoTenNhanVien = new JTextField();
		txt_hoTenNhanVien.setColumns(10);
		txt_hoTenNhanVien.setBorder(null);
		txt_hoTenNhanVien.setBackground(Color.WHITE);
		txt_hoTenNhanVien.setBounds(10, 18, 119, 29);
		panel_2_1_1_1_1.add(txt_hoTenNhanVien);

		JPanel panel_2_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u1ED4NG TI\u1EC0N H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_1.setBounds(742, 10, 139, 51);
		panel_4.add(panel_2_1_1_1_1_1);

		txt_tongTienHang = new JTextField();
		txt_tongTienHang.setColumns(10);
		txt_tongTienHang.setBorder(null);
		txt_tongTienHang.setBackground(Color.WHITE);
		txt_tongTienHang.setBounds(10, 18, 119, 29);
		panel_2_1_1_1_1_1.add(txt_tongTienHang);

		JButton btn_them = new JButton("Thêm hóa đơn");
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_them.setBackground(new Color(255, 204, 0));
		btn_them.setBounds(965, 12, 139, 49);
		panel_4.add(btn_them);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBackground(new Color(255, 204, 0));
		btnClear.setBounds(1114, 13, 115, 49);
		panel_4.add(btnClear);

		JPanel panel_2_1_1_1_1_2 = new JPanel();
		panel_2_1_1_1_1_2.setLayout(null);
		panel_2_1_1_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Th\u00F4ng tin s\u1EA3n ph\u1EA9m nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_1_1_2.setBackground(new Color(204, 204, 204));
		panel_2_1_1_1_1_2.setBounds(10, 73, 1219, 180);
		panel_4.add(panel_2_1_1_1_1_2);

		JPanel panel_2_1_1_2 = new JPanel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"M\u00C3 S\u1EA2N PH\u1EA8M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2.setBackground(Color.WHITE);
		panel_2_1_1_2.setBounds(10, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2);

		txt_maSanPham = new JTextField();
		txt_maSanPham.setColumns(10);
		txt_maSanPham.setBorder(null);
		txt_maSanPham.setBackground(Color.WHITE);
		txt_maSanPham.setBounds(10, 18, 112, 29);
		panel_2_1_1_2.add(txt_maSanPham);

		JPanel panel_2_1_1_2_1 = new JPanel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00CAN S\u1EA2N PH\u1EA8M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_1.setBounds(152, 21, 242, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_1);

		txt_tenSanPham = new JTextField();
		txt_tenSanPham.setColumns(10);
		txt_tenSanPham.setBorder(null);
		txt_tenSanPham.setBackground(Color.WHITE);
		txt_tenSanPham.setBounds(10, 18, 222, 29);
		panel_2_1_1_2_1.add(txt_tenSanPham);

		JPanel panel_2_1_1_2_2 = new JPanel();
		panel_2_1_1_2_2.setLayout(null);
		panel_2_1_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S\u1ED0 L\u01AF\u1EE2NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2.setBounds(404, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2);

		txt_soLuong = new JTextField();
		txt_soLuong.setColumns(10);
		txt_soLuong.setBorder(null);
		txt_soLuong.setBackground(Color.WHITE);
		txt_soLuong.setBounds(10, 18, 112, 29);
		panel_2_1_1_2_2.add(txt_soLuong);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"\u0110\u01A0N V\u1ECA T\u00CDNH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(546, 21, 159, 51);
		panel_2_1_1_1_1_2.add(panel_2_2);

		cbx_donViTinh = new JComboBox();
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		cbx_donViTinh.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_donViTinh.setBackground(Color.WHITE);
		cbx_donViTinh.setBounds(3, 18, 148, 28);
		panel_2_2.add(cbx_donViTinh);

		 btn_themSP = new JButton("Thêm");
		btn_themSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_themSP.setBackground(new Color(255, 255, 255));
		btn_themSP.setBounds(1120, 17, 89, 31);
		panel_2_1_1_1_1_2.add(btn_themSP);

		 btn_suaSP = new JButton("Sửa");
		btn_suaSP.setBackground(new Color(255, 255, 255));
		btn_suaSP.setBounds(1120, 59, 89, 31);
		panel_2_1_1_1_1_2.add(btn_suaSP);

		 btn_xoaSP = new JButton("Xóa");
		btn_xoaSP.setBackground(new Color(255, 255, 255));
		btn_xoaSP.setBounds(1120, 101, 89, 31);
		panel_2_1_1_1_1_2.add(btn_xoaSP);

		JButton btnNewButton_1_3 = new JButton("Clear");
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.setBounds(1120, 143, 89, 31);
		panel_2_1_1_1_1_2.add(btnNewButton_1_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("Ghi chú:");
		lblNewLabel_1_2_1.setBounds(10, 83, 185, 22);
		panel_2_1_1_1_1_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txt_ghiChu = new JTextArea();
		txt_ghiChu.setBounds(10, 104, 1059, 65);
		panel_2_1_1_1_1_2.add(txt_ghiChu);

		JPanel panel_2_1_1_2_2_1 = new JPanel();
		panel_2_1_1_2_2_1.setLayout(null);
		panel_2_1_1_2_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"GI\u00C1 NH\u1EACP/SP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_2_1.setBounds(715, 21, 159, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_1);

		txt_giaNhap = new JTextField();
		txt_giaNhap.setColumns(10);
		txt_giaNhap.setBorder(null);
		txt_giaNhap.setBackground(Color.WHITE);
		txt_giaNhap.setBounds(10, 18, 139, 29);
		panel_2_1_1_2_2_1.add(txt_giaNhap);

		JPanel panel_2_1_1_2_2_2 = new JPanel();
		panel_2_1_1_2_2_2.setLayout(null);
		panel_2_1_1_2_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u1ED4NG C\u1ED8NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2_2.setBounds(884, 21, 185, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_2);

		txt_tongCong = new JTextField();
		txt_tongCong.setColumns(10);
		txt_tongCong.setBorder(null);
		txt_tongCong.setBackground(Color.WHITE);
		txt_tongCong.setBounds(10, 18, 165, 29);
		panel_2_1_1_2_2_2.add(txt_tongCong);

		JPanel panel_2_1_1_3 = new JPanel();
		panel_2_1_1_3.setLayout(null);
		panel_2_1_1_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_3.setBackground(new Color(204, 204, 204));
		panel_2_1_1_3.setBounds(10, 264, 599, 356);
		panel_4.add(panel_2_1_1_3);

		JPanel panel_2_1_1_4 = new JPanel();
		panel_2_1_1_4.setLayout(null);
		panel_2_1_1_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_4.setBackground(Color.WHITE);
		panel_2_1_1_4.setBounds(10, 22, 579, 51);
		panel_2_1_1_3.add(panel_2_1_1_4);

		txt_timKiemSanPhamInserted = new JTextField();
		txt_timKiemSanPhamInserted.setColumns(10);
		txt_timKiemSanPhamInserted.setBorder(null);
		txt_timKiemSanPhamInserted.setBackground(Color.WHITE);
		txt_timKiemSanPhamInserted.setBounds(10, 18, 559, 29);
		panel_2_1_1_4.add(txt_timKiemSanPhamInserted);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3.add(scrollPane_1);

		table_sanPhamInserted = new JTable();
		scrollPane_1.setViewportView(table_sanPhamInserted);

		JPanel panel_2_1_1_3_1 = new JPanel();
		panel_2_1_1_3_1.setLayout(null);
		panel_2_1_1_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_3_1.setBackground(new Color(204, 204, 204));
		panel_2_1_1_3_1.setBounds(630, 264, 599, 356);
		panel_4.add(panel_2_1_1_3_1);

		JPanel panel_2_1_1_4_1 = new JPanel();
		panel_2_1_1_4_1.setLayout(null);
		panel_2_1_1_4_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_4_1.setBackground(Color.WHITE);
		panel_2_1_1_4_1.setBounds(10, 22, 579, 51);
		panel_2_1_1_3_1.add(panel_2_1_1_4_1);

		txt_timKiemSanPham = new JTextField();
		txt_timKiemSanPham.setColumns(10);
		txt_timKiemSanPham.setBorder(null);
		txt_timKiemSanPham.setBackground(Color.WHITE);
		txt_timKiemSanPham.setBounds(10, 18, 559, 29);
		panel_2_1_1_4_1.add(txt_timKiemSanPham);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3_1.add(scrollPane_1_1);

		table_SanPham = new JTable();
		scrollPane_1_1.setViewportView(table_SanPham);
		
		JPanel panel_2_1_1_1_1_3 = new JPanel();
		panel_2_1_1_1_1_3.setLayout(null);
		panel_2_1_1_1_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "NG\u00C0Y GI\u1EDC T\u1EA0O HD NH\u1EACP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_3.setBackground(Color.WHITE);
		panel_2_1_1_1_1_3.setBounds(109, 10, 160, 51);
		panel_4.add(panel_2_1_1_1_1_3);
		
		txt_ngayGioTaoHD = new JTextField();
		txt_ngayGioTaoHD.setEditable(false);
		txt_ngayGioTaoHD.setColumns(10);
		txt_ngayGioTaoHD.setBorder(null);
		txt_ngayGioTaoHD.setBackground(Color.WHITE);
		txt_ngayGioTaoHD.setBounds(10, 18, 140, 29);
		panel_2_1_1_1_1_3.add(txt_ngayGioTaoHD);
		
		JPanel panel_2_1_1_1_1_4 = new JPanel();
		panel_2_1_1_1_1_4.setLayout(null);
		panel_2_1_1_1_1_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "GI\u1EA2M GI\u00C1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4.setBounds(428, 10, 101, 51);
		panel_4.add(panel_2_1_1_1_1_4);
		
		txt_giamGia = new JTextField();
		txt_giamGia.setColumns(10);
		txt_giamGia.setBorder(null);
		txt_giamGia.setBackground(Color.WHITE);
		txt_giamGia.setBounds(10, 18, 81, 29);
		panel_2_1_1_1_1_4.add(txt_giamGia);
		
		JPanel panel_2_1_1_1_1_4_1 = new JPanel();
		panel_2_1_1_1_1_4_1.setLayout(null);
		panel_2_1_1_1_1_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "VAT", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4_1.setBounds(539, 10, 70, 51);
		panel_4.add(panel_2_1_1_1_1_4_1);
		
		txt_vat = new JTextField();
		txt_vat.setColumns(10);
		txt_vat.setBorder(null);
		txt_vat.setBackground(Color.WHITE);
		txt_vat.setBounds(10, 18, 50, 29);
		panel_2_1_1_1_1_4_1.add(txt_vat);
		
		JPanel panel_2_1_1_1_1_4_1_1 = new JPanel();
		panel_2_1_1_1_1_4_1_1.setLayout(null);
		panel_2_1_1_1_1_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "PH\u00CD SHIP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4_1_1.setBounds(621, 10, 111, 51);
		panel_4.add(panel_2_1_1_1_1_4_1_1);
		
		txt_phiShip = new JTextField();
		txt_phiShip.setColumns(10);
		txt_phiShip.setBorder(null);
		txt_phiShip.setBackground(Color.WHITE);
		txt_phiShip.setBounds(10, 18, 91, 29);
		panel_2_1_1_1_1_4_1_1.add(txt_phiShip);
		updateTable_SanPham();
		getCurrentDateTime();

	}

	public void updateTable_SanPham() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ SẢN PHẨM");
		model.addColumn("TÊN SẢN PHẨM");
		model.addColumn("NHÓM SẢN PHẨM");
		model.addColumn("TRẠNG THÁI");
		int stt = 1;
		_lisSanPhamVaDichVuModels_active = _sanPhamVaDichVuService.getListSanPhamVaDichVuModel_active();
		for (SanPhamVaDichVuModel sanPhamVaDichVuModel : _lisSanPhamVaDichVuModels_active) {
			model.addRow(new Object[] { stt, sanPhamVaDichVuModel.getMaDichVu(), sanPhamVaDichVuModel.getTenHangHoa(),
					sanPhamVaDichVuModel.getNhomSPVaDichVuModel().getTenNhomSP(),
					sanPhamVaDichVuModel.getTrangThai() });
		}

		table_SanPham.setModel(model);
	}
	
	public void updateTable_sanPhamInserted() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MÃ SP");
		model.addColumn("TÊN SP");
		model.addColumn("S.LG");
		model.addColumn("ĐƠN VỊ TÍNH");
		model.addColumn("GIÁ NHẬP/SP");
		model.addColumn("TỔNG CỘNG");
		model.addColumn("GIÁ VỐN/SP");
		
		for (PhieuNhapKhoChiTietModel phieuNhapKhoChiTietModel : _listPhieuNhapKhoChiTietModel) {
			model.addRow(new Object[] {phieuNhapKhoChiTietModel.getSanPhamVaDichVuModel().getMaDichVu() , phieuNhapKhoChiTietModel.getSanPhamVaDichVuModel().getTenHangHoa() ,phieuNhapKhoChiTietModel.getSoLuong()});
		}
	}
	
	public void doClickOnTable_SanPham() {
		int stt = Integer.parseInt(table_SanPham.getModel().getValueAt(table_SanPham.getSelectedRow(), 0)+"");
		txt_maSanPham.setText(_lisSanPhamVaDichVuModels_active.get(stt).getMaDichVu()+"");
		txt_tenSanPham.setText(_lisSanPhamVaDichVuModels_active.get(stt).getTenHangHoa());
		List<DonViChiTietModel> listViChiTietModels = _lisSanPhamVaDichVuModels_active.get(stt).getListDonViChiTietModel();
		for (DonViChiTietModel donViChiTietModel : listViChiTietModels) {
			if(donViChiTietModel.getTrangThai().equals("Hoat Dong")) {
				_listDonViChiTietModel_editing.add(donViChiTietModel);
			}
		}
		updateCbx_donViTinh(_listDonViChiTietModel_editing);
	}
	
	public void updateCbx_donViTinh(List<DonViChiTietModel> listDonViChiTietModel) {
		String arrayDonViTinh[] = new String[listDonViChiTietModel.size()+1];
		arrayDonViTinh[0] = "--Chọn đơn vị tính--";
		int index =1;
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModel) {
			arrayDonViTinh[index] = donViChiTietModel.getDonViTinhModel().getTenDonVi();
			index++;
		}
		cbx_donViTinh.setModel(new DefaultComboBoxModel(arrayDonViTinh));
	}

	public void clearFormPhieuNhapKho() {
		txt_maPhieuNhapKho.setText("");
		txt_ngayGioTaoHD.setText("");
		txt_hoTenNhanVien.setText("");
		txt_giamGia.setText("");
		txt_vat.setText("");
		txt_phiShip.setText("");
		txt_tongTienHang.setText("");
		switchButton_nhap.setSelected(true);
		clearFormSanPham();
		_listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
		table_sanPhamInserted = new JTable();
	}
	
	
	public void clearFormSanPham() {
		txt_maSanPham.setText("");
		txt_tenSanPham.setText("");
		txt_soLuong.setText("");
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		txt_giaNhap.setText("");
		txt_tongCong.setText("");
		btn_suaSP.setEnabled(false);
		btn_xoaSP.setEnabled(false);
	}
	
	public void getCurrentDateTime() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd     HH:mm:ss");
		txt_ngayGioTaoHD.setText(dateFormat.format(date));
	}
	
	public PhieuNhapKhoModel getInforFromFormIntoPhieuNhapKho() {
		int maPhieuNhapKho = Integer.parseInt(txt_maPhieuNhapKho.getText().trim());
		Date date ;// check
		String tinhTrang ="";
		if(switchButton_nhap.isSelected()) {
			tinhTrang = "Da Thanh Toan";
		}else {
			tinhTrang = "Chua Thanh Toan";
		}
		double giamGia = Double.parseDouble(txt_giamGia.getText().trim());
		double vat = Double.parseDouble(txt_vat.getText().trim());
		double phiShip = Double.parseDouble(txt_phiShip.getText().trim());
		PhieuNhapKhoModel phieuNhapKhoModel = new PhieuNhapKhoModel(maPhieuNhapKho, "", date, tinhTrang, _userAreUsing, giamGia, vat, phiShip, _listPhieuNhapKhoChiTietModel);
		return phieuNhapKhoModel;
	}
	
	public void getInforFromFormIntoPhieuNhapKhoChiTiet() {
		PhieuNhapKhoModel phieuNhapKhoModel = getInforFromFormIntoPhieuNhapKho();
		
		double soLuong = Double.parseDouble(txt_soLuong.getText().trim());
		double giaNhap = Double.parseDouble(txt_giaNhap.getText().trim());
		String ghiChu = txt_ghiChu.getText().trim();
	}
	
	
}

