package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Services.ChucVuService;
import Services.KhoService;
import models.ChucVuModel;
import models.KhoModel;
import models.PhieuKiemKhoModel;
import models.SanPhamVaDichVuModel;
import utils.Utilities;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChucVu_view extends JFrame {
	private ChucVuService _chucVuService = new ChucVuService();
	private List<ChucVuModel> _listChucVuModels = new ArrayList<ChucVuModel>();
	
	private JPanel contentPane;
	private JTextField txt_tenChucVu;
	private JTextField txt_timKiem;
	private JTextField txt_maChucVu;
	private JTable table;
	private JComboBox cbx_trangThai;
	private JButton btnSua;
	private JButton btnThem;
	private JComboBox cbx_trangThai_danhSach;
	private int _maxID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChucVu_view frame = new ChucVu_view();
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
	public ChucVu_view() {
		_chucVuService.updateListChucVuModel();
		_maxID = _chucVuService.getMaxID();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Danh s\u00E1ch kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1.setBackground(new Color(204, 204, 204));
		panel_2_1_1_1.setBounds(10, 11, 1219, 98);
		contentPane.add(panel_2_1_1_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00EAn ch\u1EE9c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2.setBackground(Color.WHITE);
		panel_2_1_2.setBounds(217, 21, 301, 51);
		panel_2_1_1_1.add(panel_2_1_2);
		
		txt_tenChucVu = new JTextField();
		txt_tenChucVu.setColumns(10);
		txt_tenChucVu.setBorder(null);
		txt_tenChucVu.setBackground(Color.WHITE);
		txt_tenChucVu.setBounds(10, 18, 281, 29);
		panel_2_1_2.add(txt_tenChucVu);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		panel_2_2_1_1_1.setLayout(null);
		panel_2_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1.setBounds(528, 21, 187, 51);
		panel_2_1_1_1.add(panel_2_2_1_1_1);
		
		 cbx_trangThai = new JComboBox();
		cbx_trangThai.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai.setBackground(Color.WHITE);
		cbx_trangThai.setBounds(10, 18, 167, 28);
		panel_2_2_1_1_1.add(cbx_trangThai);
		
		JPanel panel_2_1_2_2 = new JPanel();
		panel_2_1_2_2.setLayout(null);
		panel_2_1_2_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "M\u00E3 ch\u1EE9c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2_2.setBackground(Color.WHITE);
		panel_2_1_2_2.setBounds(10, 21, 197, 51);
		panel_2_1_1_1.add(panel_2_1_2_2);
		
		txt_maChucVu = new JTextField();
		txt_maChucVu.setColumns(10);
		txt_maChucVu.setBorder(null);
		txt_maChucVu.setBackground(Color.WHITE);
		txt_maChucVu.setBounds(10, 18, 177, 29);
		panel_2_1_2_2.add(txt_maChucVu);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChucVuModel chucVuModel = getInforFromFormIntoChucVuModel();
		 		_chucVuService.them_sua(chucVuModel);
		 		JOptionPane.showMessageDialog(null, "Thêm thành công");
		 		updateTable();
		 		_maxID++;
		 		clearForm();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBackground(new Color(255, 204, 0));
		btnThem.setBounds(793, 21, 128, 51);
		panel_2_1_1_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChucVuModel chucVuModel = getInforFromFormIntoChucVuModel();
				_chucVuService.them_sua(chucVuModel);
		 		updateTable();
		 		clearForm();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setEnabled(false);
		btnSua.setBackground(new Color(255, 204, 0));
		btnSua.setBounds(931, 21, 128, 51);
		panel_2_1_1_1.add(btnSua);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBackground(new Color(255, 204, 0));
		btnClear.setBounds(1069, 21, 140, 51);
		panel_2_1_1_1.add(btnClear);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Danh s\u00E1ch kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBackground(new Color(204, 204, 204));
		panel_2_1_1_1_1.setBounds(10, 131, 1244, 539);
		contentPane.add(panel_2_1_1_1_1);
		
		JPanel panel_2_1_2_1 = new JPanel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2_1.setBackground(Color.WHITE);
		panel_2_1_2_1.setBounds(207, 21, 1027, 51);
		panel_2_1_1_1_1.add(panel_2_1_2_1);
		
		txt_timKiem = new JTextField();
		txt_timKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_timKiem, "Nhập tên để tìm kiếm");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_timKiem, "Nhập tên để tìm kiếm");
			}
		});
		
		txt_timKiem.setText("Nhập tên để tìm kiếm");
		txt_timKiem.setColumns(10);
		txt_timKiem.setBorder(null);
		txt_timKiem.setBackground(Color.WHITE);
		txt_timKiem.setBounds(10, 18, 1007, 29);
		panel_2_1_2_1.add(txt_timKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 1224, 431);
		panel_2_1_1_1_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2_2_1_1_1_1 = new JPanel();
		panel_2_2_1_1_1_1.setLayout(null);
		panel_2_2_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1_1.setBounds(10, 21, 187, 51);
		panel_2_1_1_1_1.add(panel_2_2_1_1_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 167, 28);
		panel_2_2_1_1_1_1.add(cbx_trangThai_danhSach);
		txt_maChucVu.setText(_maxID+"");
		updateTable();
		txt_timKiem.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				updateTable();
			}
		});
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
	}
	
	public void clearForm() {
		cbx_trangThai.setSelectedIndex(0);
		txt_maChucVu.setText(_maxID+"");
		txt_tenChucVu.setText("");
		btnSua.setEnabled(false);
		btnThem.setEnabled(true);
	
	}
	
	public void doClickOnTable() {
		txt_maChucVu.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tenChucVu.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		String trangThai = table.getModel().getValueAt(table.getSelectedRow(), 3)+"";
		cbx_trangThai.setSelectedItem(trangThai);
		btnThem.setEnabled(false);
		btnSua.setEnabled(true);
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ CHỨC VỤ");
		model.addColumn("TÊN CHỨC VỤ");
		model.addColumn("TRẠNG THÁI");
		List<ChucVuModel> listChucVuModels = _chucVuService.getListChucVuModel();
		_listChucVuModels = new ArrayList<ChucVuModel>();
		int stt = 1;
		
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Hoat Dong")) {
				for (ChucVuModel chucVuModel : listChucVuModels) {
					if(chucVuModel.getTrangThai().equals("Hoat Dong")) {
						_listChucVuModels.add(chucVuModel);
					}
				}
			}
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Khong Hoat Dong")) {
				for (ChucVuModel chucVuModel : listChucVuModels) {
					if(chucVuModel.getTrangThai().equals("Khong Hoat Dong")) {
						_listChucVuModels.add(chucVuModel);
					}
				}
			}
		
		String keySearch = txt_timKiem.getText();
		if(keySearch.equals("") || keySearch.equals("Nhập tên để tìm kiếm")) {
			for (ChucVuModel chucVuModel : _listChucVuModels) {
				model.addRow(new Object[] {stt,chucVuModel.getMaChucVu(),chucVuModel.getTenChucVu(),chucVuModel.getTrangThai()});
				stt++;
			}
		}else {
			for (ChucVuModel chucVuModel : _listChucVuModels) {
				if(chucVuModel.getTenChucVu().toLowerCase().indexOf(keySearch.toLowerCase())>=0) {
					model.addRow(new Object[] {stt,chucVuModel.getMaChucVu(),chucVuModel.getTenChucVu(),chucVuModel.getTrangThai()});
					stt++;
				}
			}
		}
			
		table.setModel(model);
	}
	
	public ChucVuModel getInforFromFormIntoChucVuModel() {
		String maChucVu = "0";
		if(txt_maChucVu.getText().equals("")) {
			maChucVu = "0";
		}else {
			maChucVu = txt_maChucVu.getText().trim();
		}
		String trangThai = cbx_trangThai.getSelectedItem().toString();
		String tenChucVu = txt_tenChucVu.getText().trim();
		ChucVuModel chucVuModel = new ChucVuModel( maChucVu, tenChucVu, trangThai);
		return chucVuModel;
	}
}
