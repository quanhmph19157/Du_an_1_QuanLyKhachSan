package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.KhoModel;
import models.NhomSPVaDichVuModel;
import models.SanPhamVaDichVuModel;
import services.KhoService;
import services.NhomSPVaDichVuService;
import utils.IoCContainer;
import utils.Utilities;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhomSPVaDichVu_view extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private NhomSPVaDichVuService _nhomSPVaDichVuService = (NhomSPVaDichVuService) _ioCContainer.getBean(NhomSPVaDichVuService.class+"");
	private List<NhomSPVaDichVuModel> _listNhomSPVaDichVuModels = new ArrayList<NhomSPVaDichVuModel>();
//	private int _sttNhanVienEditing;
	
	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtNhpTn;
	private JTable table;
	private JTextField txt_tenNhom;
	private JTextField txt_maNhom;
	private SwitchButton switchButton_danhSach;
	private JComboBox cbx_nhomHangHoa_filter;
	private JComboBox cbx_nhomHangHoa;
	private JTextArea txt_ghiChu;
	private SwitchButton switchButton_Nhap;
	private JButton btn_sua;
	private JButton btn_them;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhomSPVaDichVu_view frame = new NhomSPVaDichVu_view();
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
	public NhomSPVaDichVu_view() {
		_nhomSPVaDichVuService.updateListNhomSPVaDichVuModel();
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
		
		JLabel lblNewLabel = new JLabel("Trạng thái");
		lblNewLabel.setBounds(20, 11, 63, 31);
		panel_3.add(lblNewLabel);
		
		switchButton_danhSach = new SwitchButton();
		switchButton_danhSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateTable();
			}
		});
		switchButton_danhSach.setSelected(true);
		switchButton_danhSach.setBounds(20, 37, 55, 25);
		panel_3.add(switchButton_danhSach);
		switchButton_danhSach.setBackground(new Color(0, 153, 204));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(224, 19, 385, 51);
		panel_3.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Nh\u00F3m h\u00E0ng h\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		cbx_nhomHangHoa_filter = new JComboBox();
		cbx_nhomHangHoa_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		cbx_nhomHangHoa_filter.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Sản phẩm", "Dịch vụ"}));
		cbx_nhomHangHoa_filter.setBackground(Color.WHITE);
		cbx_nhomHangHoa_filter.setBounds(3, 18, 376, 28);
		cbx_nhomHangHoa_filter.setBorder(new EmptyBorder(-11, -4, -11, -1));
		panel_2.add(cbx_nhomHangHoa_filter);
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(619, 19, 610, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00ECm ki\u1EBFm Theo t\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtNhpTn = new JTextField();
		txtNhpTn.setText("Nhập tên để tìm kiếm");
		txtNhpTn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txtNhpTn, "Nhập tên để tìm kiếm");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txtNhpTn, "Nhập tên để tìm kiếm");
			}
		});
		txtNhpTn.setBackground(Color.WHITE);
		txtNhpTn.setBounds(10, 18, 543, 29);
		panel_2_1.add(txtNhpTn);
		txtNhpTn.setBorder(null);
		txtNhpTn.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 1219, 507);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable();
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cập Nhật Nhóm Sản Phẩm", null, panel_4, null);
		panel_4.setLayout(null);
		
		txt_tenNhom = new JTextField();
		txt_tenNhom.setText("Nhập tên nhóm");
		txt_tenNhom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_tenNhom, "Nhập tên nhóm");
			}
		});
		txt_tenNhom.setBounds(188, 54, 653, 46);
		panel_4.add(txt_tenNhom);
		txt_tenNhom.setColumns(10);
		
		cbx_nhomHangHoa = new JComboBox();
		cbx_nhomHangHoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbx_nhomHangHoa.setModel(new DefaultComboBoxModel(new String[] {"Sản phẩm", "Dịch vụ"}));
		cbx_nhomHangHoa.setBackground(Color.WHITE);
		cbx_nhomHangHoa.setBounds(22, 181, 1207, 46);
		panel_4.add(cbx_nhomHangHoa);
		
		txt_ghiChu = new JTextArea();
		txt_ghiChu.setBounds(22, 295, 1207, 190);
		panel_4.add(txt_ghiChu);
		
		JButton btnThm = new JButton("Làm mới");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnThm.setBackground(new Color(255, 204, 102));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(1077, 578, 152, 42);
		panel_4.add(btnThm);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhóm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(188, 22, 185, 32);
		panel_4.add(lblNewLabel_1);
		
		switchButton_Nhap = new SwitchButton();
		switchButton_Nhap.setSelected(true);
		switchButton_Nhap.setBackground(new Color(0, 153, 204));
		switchButton_Nhap.setBounds(905, 54, 55, 25);
		panel_4.add(switchButton_Nhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(842, 22, 185, 32);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhóm hàng hóa");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(22, 148, 185, 32);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ghi chú:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(22, 262, 185, 32);
		panel_4.add(lblNewLabel_1_2_1);
		
		btn_sua = new JButton("Sửa");
		btn_sua.setEnabled(false);
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhomSPVaDichVuModel nhomSPVaDichVuModel = getInforFromFormIntoNhomSPVaDichVuModel();
				_nhomSPVaDichVuService.them_sua(nhomSPVaDichVuModel);
				clearForm();
				updateTable();
			}
		});
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_sua.setBackground(new Color(255, 204, 102));
		btn_sua.setBounds(915, 578, 152, 42);
		panel_4.add(btn_sua);
		
		btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhomSPVaDichVuModel nhomSPVaDichVuModel = getInforFromFormIntoNhomSPVaDichVuModel();
				_nhomSPVaDichVuService.them_sua(nhomSPVaDichVuModel);
				clearForm();
				updateTable();
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_them.setBackground(new Color(255, 204, 102));
		btn_them.setBounds(753, 578, 152, 42);
		panel_4.add(btn_them);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã nhóm");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(22, 22, 156, 32);
		panel_4.add(lblNewLabel_1_3);
		
		txt_maNhom = new JTextField();
		txt_maNhom.setEditable(false);
		txt_maNhom.setColumns(10);
		txt_maNhom.setBounds(22, 54, 156, 46);
		panel_4.add(txt_maNhom);
		updateTable();
	}
	
	public void clearForm() {
		switchButton_Nhap.setSelected(true);
		txt_maNhom.setText("");
		txt_tenNhom.setText("Nhập tên nhóm");
		cbx_nhomHangHoa.setSelectedIndex(0);
		txt_ghiChu.setText("");
		btn_sua.setEnabled(false);
		btn_them.setEnabled(true);
		updateTable();
	}
	
	public void doClickOnTable() {	
		txt_maNhom.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tenNhom.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		cbx_nhomHangHoa.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 3));
		txt_ghiChu.setText(table.getModel().getValueAt(table.getSelectedRow(), 4)+"");
		String trangThai= table.getModel().getValueAt(table.getSelectedRow(), 5)+"";
		if(trangThai.equals("Hoạt Động")) {
			switchButton_Nhap.setSelected(true);
		}else {
			switchButton_Nhap.setSelected(false);
		}
		btn_them.setEnabled(false);
		btn_sua.setEnabled(true);
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ NHÓM");
		model.addColumn("TÊN NHÓM");
		model.addColumn("NHÓM HÀNG HÓA");
		model.addColumn("GHI CHÚ");
		model.addColumn("TRẠNG THÁI");
		_listNhomSPVaDichVuModels = _nhomSPVaDichVuService.getListNhomSPVaDichVuModel();
		
		String nhomHangHoa = cbx_nhomHangHoa_filter.getSelectedItem().toString();
		
		int stt = 1;
		if(switchButton_danhSach.isSelected()) {
			if(nhomHangHoa.equals("Tất cả")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Hoat Dong")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			if(nhomHangHoa.equals("Sản phẩm")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Hoat Dong") && nhomSPVaDichVuModel.getNhomHangHoa().equals("S?n ph?m")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			if(nhomHangHoa.equals("Dịch vụ")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Hoat Dong") && nhomSPVaDichVuModel.getNhomHangHoa().equals("D?ch v?")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			
		}
		if(!switchButton_danhSach.isSelected()) {
			if(nhomHangHoa.equals("Tất cả")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Khong Hoat Dong")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			if(nhomHangHoa.equals("Sản phẩm")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Khong Hoat Dong") && nhomSPVaDichVuModel.getNhomHangHoa().equals("S?n ph?m")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			if(nhomHangHoa.equals("Dịch vụ")) {
				for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels) {
					if(nhomSPVaDichVuModel.getTrangThai().equals("Khong Hoat Dong") && nhomSPVaDichVuModel.getNhomHangHoa().equals("D?ch v?")) {
						model.addRow(new Object[] {stt,nhomSPVaDichVuModel.getMaNhomSP(),nhomSPVaDichVuModel.getTenNhomSP(),nhomSPVaDichVuModel.getNhomHangHoa(),nhomSPVaDichVuModel.getGhiChu(),nhomSPVaDichVuModel.getTrangThai()});
						stt++;
					}
				}
			}
			
		}
		table.setModel(model);
	}
	
	
	public NhomSPVaDichVuModel getInforFromFormIntoNhomSPVaDichVuModel() {
		int maNhom = 0;
		if(txt_maNhom.getText().equals("")) {
			maNhom = 0;
		}else {
			maNhom = Integer.parseInt(txt_maNhom.getText());
		}
		String trangThai = "";
		if(switchButton_Nhap.isSelected()) {
			trangThai = "Hoat Dong";
		}else {
			trangThai = "Khong Hoat Dong";
		}
		String tenNhom = txt_tenNhom.getText().trim();
		String nhomHangHoa = cbx_nhomHangHoa.getSelectedItem().toString();
		String ghiChu = txt_ghiChu.getText().trim();
		
		List<SanPhamVaDichVuModel> listSanPhamVaDichVuModel = new ArrayList<SanPhamVaDichVuModel>();
		NhomSPVaDichVuModel nhomSPVaDichVuModel = new NhomSPVaDichVuModel(maNhom, tenNhom, nhomHangHoa, ghiChu, trangThai, listSanPhamVaDichVuModel);
		
		return nhomSPVaDichVuModel;
	}
}
