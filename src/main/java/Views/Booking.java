package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import Services.KhachHang_services;
import ViewModels.ModelKhachHang;
import ViewModels.ModelThanhToan;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Booking extends JPanel {
	private JTextField txt_cmnd;
	private JTextField txt_ten;
	private JTextField txt_sdt;
	private JTextField txt_email;
	private JTextField txt_quocTich;
	private JTextField txt_gioIn;
	private JTextField txt_gioOut;
	private JTable table;
	JPanel pnl_autogengia = new JPanel();
	JPanel pnl_Phong = new JPanel();
	DefaultTableModel model_ds;
	DefaultTableModel model_k;
	private LocalDate date;
	JDateChooser dcs_checkin = new JDateChooser();
	JDateChooser dcs_checkout = new JDateChooser();
	JCheckBox chb_le;
	JCheckBox chb_doan;
	JTextField txt_doan = new JTextField();

	List<ModelKhachHang> list_kh;
	List<ModelKhachHang> list_new_kh;
	List<ModelKhachHang> list_choose_kh;
	List<ModelThanhToan> list_tt;
	private JTextField textField;
	KhachHang_services ser_kh;

	public Booking() {
		// TODO Auto-generated constructor stub
		ser_kh=new KhachHang_services();
		list_kh=ser_kh.getList();
		list_choose_kh=new ArrayList<ModelKhachHang>();
		list_new_kh=new ArrayList<ModelKhachHang>();
		list_kh=new ArrayList<ModelKhachHang>();
		list_tt = new ArrayList<ModelThanhToan>();
		date = LocalDate.now();
		setting();
	}

	void setting() {
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		setLayout(new BorderLayout());
		JPanel pnl_time = new JPanel();
		JPanel pnl_khachHang = new JPanel();
		JPanel pnl_Gia = new JPanel();
		pnl_Gia.setBorder(new TitledBorder(null, "Thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnl_time, BorderLayout.NORTH);
		add(pnl_khachHang, BorderLayout.WEST);
		add(pnl_Phong, BorderLayout.CENTER);
		add(pnl_Gia, BorderLayout.EAST);

		pnl_time.setBorder(BorderFactory.createTitledBorder("Thời Gian"));
		pnl_time.setPreferredSize(new Dimension(1280, 50));
		pnl_khachHang.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		pnl_khachHang.setPreferredSize(new Dimension(427, 670));
		pnl_khachHang.setLayout(null);
		pnl_Gia.setPreferredSize(new Dimension(426, 670));
		pnl_Gia.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 503, 407, 157);
		panel_1.setLayout(null);
		pnl_Gia.add(panel_1);

		pnl_autogengia.setBounds(10, 21, 407, 472);
		pnl_Gia.add(pnl_autogengia);
		pnl_Phong.setBorder(new TitledBorder(null, "Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Phong.setPreferredSize(new Dimension(426, 670));
		pnl_Phong.setLayout(null);

		JLabel lblNewLabel = new JLabel("Số CMND/Pasport");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(22, 40, 132, 21);
		pnl_khachHang.add(lblNewLabel);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTnKhchHng.setBounds(22, 71, 132, 21);
		pnl_khachHang.add(lblTnKhchHng);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSinThoi.setBounds(22, 102, 132, 21);
		pnl_khachHang.add(lblSinThoi);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(22, 133, 132, 21);
		pnl_khachHang.add(lblEmail);

		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGiiTnh.setBounds(22, 164, 132, 21);
		pnl_khachHang.add(lblGiiTnh);

		JLabel lblNewLabel_4_1 = new JLabel("Ngày sinh");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(22, 196, 132, 21);
		pnl_khachHang.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Quốc tịch");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(22, 227, 132, 21);
		pnl_khachHang.add(lblNewLabel_4_2);

		txt_cmnd = new JTextField();
		txt_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_cmnd.setBounds(164, 40, 253, 23);
		pnl_khachHang.add(txt_cmnd);
		txt_cmnd.setColumns(10);

		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_ten.setColumns(10);
		txt_ten.setBounds(164, 71, 253, 23);
		pnl_khachHang.add(txt_ten);

		txt_sdt = new JTextField();
		txt_sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(164, 102, 253, 23);
		pnl_khachHang.add(txt_sdt);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_email.setColumns(10);
		txt_email.setBounds(164, 131, 253, 23);
		pnl_khachHang.add(txt_email);

		txt_quocTich = new JTextField();
		txt_quocTich.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_quocTich.setColumns(10);
		txt_quocTich.setBounds(164, 225, 253, 23);
		pnl_khachHang.add(txt_quocTich);

		JComboBox cbx_gender = new JComboBox();
		cbx_gender.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cbx_gender.setBounds(164, 164, 253, 21);
		pnl_khachHang.add(cbx_gender);

		table = new JTable();
		table.setBounds(403, 288, -378, 360);
		pnl_khachHang.add(table);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 300, 407, 319);
		pnl_khachHang.add(tabbedPane);

		JPanel pnl_khachTrongDoan = new JPanel();
		tabbedPane.addTab("Khách trong đoàn", null, pnl_khachTrongDoan, null);
		pnl_khachTrongDoan.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnl_danhsach = new JPanel();
		tabbedPane.addTab("Danh sách", null, pnl_danhsach, null);

		model_k=new DefaultTableModel(
				new String[] { "CMND/passport", "Họ và tên", "Số điện thoại", "Email", "Giới tính" }, 0);
		JTable tbl_khach = new JTable(model_k);
		JScrollPane sc_ktd = new JScrollPane(tbl_khach);
		sc_ktd.setMinimumSize(new Dimension(400, 350));
		sc_ktd.setPreferredSize(new Dimension(400, 350));
		pnl_khachTrongDoan.add(sc_ktd);

		model_ds=new DefaultTableModel(
				new String[] { "CMND/passport", "Họ và tên", "Số điện thoại", "Email", "Giới tính" }, 0);
		for(ModelKhachHang kh:list_kh) {
			model_ds.addRow(new Object[] {kh.getCMND(),kh.getTenKhachHang(),kh.getSDT(),kh.getEmail(),kh.getGioiTinh()});
		}
		final JTable tbl_ds = new JTable(model_ds);
		tbl_ds.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(tbl_ds.getSelectedRow()!=-1) {
					int ds[]=tbl_ds.getSelectedRows();
					for(int a:ds) {
						list_choose_kh.add(list_kh.get(a));
						model_ds.removeRow(a);
						model_k.addRow(new Object[] {list_kh.get(a).getCMND(),list_kh.get(a).getTenKhachHang(),list_kh.get(a).getSDT(),list_kh.get(a).getEmail(),list_kh.get(a).getGioiTinh()});
					}
				}
			}
		});
		JScrollPane sc_ds = new JScrollPane(tbl_ds);
		sc_ds.setMinimumSize(new Dimension(400, 350));
		sc_ds.setPreferredSize(new Dimension(400, 350));
		pnl_danhsach.add(sc_ds);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(164, 196, 253, 19);
		pnl_khachHang.add(dateChooser);
		
		JButton btn_them_k = new JButton("Thêm");
		btn_them_k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_them_k.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_them_k.setBounds(63, 258, 296, 32);
		pnl_khachHang.add(btn_them_k);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(77, 629, 119, 32);
		pnl_khachHang.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(220, 629, 119, 32);
		pnl_khachHang.add(btnNewButton_1);

		pnl_time.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JLabel lbl_checkin = new JLabel("Giờ check in:");
		lbl_checkin.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		pnl_time.add(lbl_checkin);

		dcs_checkin.setPreferredSize(new Dimension(110, 20));
		dcs_checkin
				.setMinSelectableDate(new Date(date.getYear() - 1900, date.getMonthValue() - 1, date.getDayOfMonth()));
		System.out.println(date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth());
		dcs_checkin.setDateFormatString("dd/MM/yyyy");
		dcs_checkin.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if (dcs_checkin.getDate() != null) {
					dcs_checkout.setEnabled(true);
					dcs_checkout.setDate(null);
					dcs_checkout.setMinSelectableDate(dcs_checkin.getDate());
					System.out.println(dcs_checkin.getDate());
					System.out.println(new Date(date.getYear() - 1900, date.getMonthValue(), date.getDayOfMonth()));
				}
			}
		});
		pnl_time.add(dcs_checkin);

		txt_gioIn = new JTextField("12:00");
		txt_gioIn.setFont(new Font("TAHOMA", Font.PLAIN, 17));
		pnl_time.add(txt_gioIn);

		JLabel lbl_checkin_1 = new JLabel("Giờ check out:");
		lbl_checkin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnl_time.add(lbl_checkin_1);

		dcs_checkout.setPreferredSize(new Dimension(110, 20));
		dcs_checkout.setEnabled(false);
		pnl_time.add(dcs_checkout);

		txt_gioOut = new JTextField("14:00");
		txt_gioOut.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		pnl_time.add(txt_gioOut);

		JLabel lbl_loai = new JLabel("Loại khách: ");
		lbl_loai.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		pnl_time.add(lbl_loai);

		chb_le = new JCheckBox("khách lẻ");
		chb_le.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt_doan.setEnabled(false);
				txt_doan.setText("");
			}
		});
		chb_le.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		pnl_time.add(chb_le);

		chb_doan = new JCheckBox("khách đoàn");
		chb_doan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt_doan.setEnabled(true);
			}
		});
		chb_doan.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		pnl_time.add(chb_doan);

		ButtonGroup btg_khach = new ButtonGroup();
		btg_khach.add(chb_doan);
		btg_khach.add(chb_le);
		chb_le.setSelected(true);
		txt_doan.setEnabled(false);
		txt_doan.setText("");

		JLabel lbl_tenDoan = new JLabel("tên đoàn");
		lbl_tenDoan.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		pnl_time.add(lbl_tenDoan);

		pnl_time.add(txt_doan);
		txt_doan.setFont(new Font("TAHOMA", Font.PLAIN, 16));
		txt_doan.setPreferredSize(new Dimension(300, 20));

		JButton btn_them_gia = new JButton("Thêm");
		btn_them_gia.setBounds(149,0,100,28);
		pnl_autogengia.add(btn_them_gia);
		pnl_autogengia.setLayout(null);
		btn_them_gia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnl_autogengia.removeAll();
				thanhToan();
				revalidate();
				repaint();
			}
		});

	}

	void thanhToan() {
		JPanel panel = new JPanel();
		panel.setBounds(3, 5, 400, 119);
		panel.setBackground(Color.white);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Loại thanh toán");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 118, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Người thanh toán");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 30, 118, 19);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày thanh toán");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 59, 118, 20);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tiền đã trả");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 89, 118, 23);
		panel.add(lblNewLabel_1_3);

		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel<String>(new String[] { "Tiền cọc" }));
		comboBox.setBounds(151, 2, 246, 21);
		panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(151, 31, 246, 21);
		panel.add(comboBox_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày thanh toán");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(151, 59, 118, 20);
		panel.add(lblNewLabel_1_2_1);

		textField = new JTextField();
		textField.setBounds(151, 89, 246, 23);
		panel.add(textField);
		textField.setColumns(10);
		pnl_autogengia.add(panel);
	}
}
