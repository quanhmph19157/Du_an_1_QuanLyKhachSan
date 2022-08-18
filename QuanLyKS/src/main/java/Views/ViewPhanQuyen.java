/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Repositories.dao_QuyenChucVu;
import Services.ChucVuService;
import Services.QuyenChucVu_services;
import Services.Quyen_services;
import ViewModels.ModelChucVu;
import ViewModels.ModelQuyen;
import ViewModels.ModelQuyenChucVu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author TIENTVPH18954
 */
public class ViewPhanQuyen extends javax.swing.JFrame {

	List<JCheckBox> checkBoxs = new ArrayList<>();
	DefaultComboBoxModel _deComboBoxModel;
	ChucVuService _ChucVu_services = new ChucVuService();
	List<ModelChucVu> _lisChucVus = _ChucVu_services.SelectAll();
	Quyen_services _quQuyen_services = new Quyen_services();
	dao_QuyenChucVu _daoQuyenChucVu = new dao_QuyenChucVu();
	List<ModelQuyenChucVu> _liQuyenChucVus = new ArrayList<>();
	List<ModelQuyen> _lisQuyens = _quQuyen_services.SelectAll();
	QuyenChucVu_services quyenChucVu_services = new QuyenChucVu_services();

	public ViewPhanQuyen() {
		initComponents();
		addListCheckBox();
		cbxChucVu();
		checkQuyen();
		loadQuyen();
		loadDateQuyen();
		setLocationRelativeTo(null);
	}

	void checkQuyen() {
		if (_quQuyen_services.SelectAll().isEmpty()) {
			_quQuyen_services.save(new ModelQuyen(1, "Quản lí thuê phòng"));
			_quQuyen_services.save(new ModelQuyen(2, "Quản lí khách sạn"));
			_quQuyen_services.save(new ModelQuyen(3, "Quản lý khách hàng"));
			_quQuyen_services.save(new ModelQuyen(4, "Quản lí nhân viên"));
			_quQuyen_services.save(new ModelQuyen(5, "Quản lí chức vụ"));
			_quQuyen_services.save(new ModelQuyen(6, "Quản lí phòng"));
			_quQuyen_services.save(new ModelQuyen(7, "Quản lí thống kê"));
			_quQuyen_services.save(new ModelQuyen(8, "Quản lí dịch vụ"));
		}
	}

	String getMaChucVu(String ma) {
		for (ModelChucVu x : _lisChucVus) {
			if (x.getTenChucVu().equals(ma)) {
				return x.getMaChucVu();
			}
		}
		return null;
	}

	void addListCheckBox() {
		checkBoxs.add(cb_thuephong);
		checkBoxs.add(cb_khachsan);
		checkBoxs.add(cb_khachhang);
		checkBoxs.add(cb_nhanvien);
		checkBoxs.add(cb_chucvu);
		checkBoxs.add(cb_phong);
		checkBoxs.add(cb_thongke);
		checkBoxs.add(cb_dichvu);
	}

	void loadQuyen() {
		_liQuyenChucVus = new ArrayList<>();
		ModelChucVu modelChucVu = _lisChucVus.get(cbx_tenchucvu.getSelectedIndex());
		_liQuyenChucVus = quyenChucVu_services.SelectAll();
		for (ModelQuyenChucVu x : _liQuyenChucVus) {
			if (x.getChucVuModel().getMaChucVu().equals(modelChucVu.getMaChucVu())) {
				System.out.println("x: " + x.getQuyenModel().getTenQuyen());
				for (int i = 0; i < checkBoxs.size(); i++) {
					if (x.getQuyenModel().getTenQuyen().equals(checkBoxs.get(i).getText())) {
						System.out.println(x.getQuyenModel().getTenQuyen().equals(checkBoxs.get(i).getText()));
						System.out.println(checkBoxs.get(i));
						checkBoxs.get(i).setSelected(true);
					}
				}
			}
		}
	}

	void loadDateQuyen() {

	}

	void cbxChucVu() {
		_deComboBoxModel = new DefaultComboBoxModel();
		for (ModelChucVu x : _lisChucVus) {
			_deComboBoxModel.addElement(x.getTenChucVu());
		}
		cbx_tenchucvu.setModel(_deComboBoxModel);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel2 = new javax.swing.JLabel();
		cbx_tenchucvu = new javax.swing.JComboBox<>();
		cb_thuephong = new javax.swing.JCheckBox();
		cb_khachsan = new javax.swing.JCheckBox();
		cb_khachhang = new javax.swing.JCheckBox();
		cb_nhanvien = new javax.swing.JCheckBox();
		cb_chucvu = new javax.swing.JCheckBox();
		cb_phong = new javax.swing.JCheckBox();
		cb_thongke = new javax.swing.JCheckBox();
		cb_dichvu = new javax.swing.JCheckBox();
		btn_xacnhan = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("PHÂN QUYỀN");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel2.setText("Phân Quyền:");

		cbx_tenchucvu.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbx_tenchucvu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbx_tenchucvuActionPerformed(evt);
			}
		});

		cb_thuephong.setText("Quản lí thuê phòng");

		cb_khachsan.setText("Quản lí khách sạn");

		cb_khachhang.setText("Quản lý khách hàng");

		cb_nhanvien.setText("Quản lí nhân viên");

		cb_chucvu.setText("Quản lí chức vụ");

		cb_phong.setText("Quản lí phòng");

		cb_thongke.setText("Quản lí thống kê");

		cb_dichvu.setText("Quản lí dịch vụ");

		btn_xacnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btn_xacnhan.setText("XÁC NHẬN");
		btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_xacnhanActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jSeparator1)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(79, 79, 79)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												cbx_tenchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(65, 65, 65).addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(cb_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(74, 74, 74)
												.addComponent(cb_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(cb_thuephong, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(74, 74, 74).addComponent(cb_khachsan,
														javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(74, 74, 74).addComponent(cb_phong,
														javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(cb_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(74, 74, 74).addComponent(cb_dichvu,
														javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup().addGap(177, 177, 177).addComponent(btn_xacnhan,
										javax.swing.GroupLayout.PREFERRED_SIZE, 173,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(84, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbx_tenchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(50, 50, 50)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cb_thuephong, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_khachsan, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cb_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cb_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_dichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(48, 48, 48).addComponent(btn_xacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 27, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_xacnhanActionPerformed
		String tenQuyen;

		ModelChucVu modelChucVu = _lisChucVus.get(cbx_tenchucvu.getSelectedIndex());
		System.out.println("a: " + modelChucVu.getTenChucVu());
		System.out.println("ma: " + modelChucVu.getMaChucVu());
		quyenChucVu_services.delete(modelChucVu.getMaChucVu());
		for (int i = 0; i < checkBoxs.size(); i++) {
			if (checkBoxs.get(i).isSelected()) {
				quyenChucVu_services
						.save(new ModelQuyenChucVu(new ModelQuyen(i + 1, checkBoxs.get(i).getText()), modelChucVu));
			}
		}
	}// GEN-LAST:event_btn_xacnhanActionPerformed

	private void cbx_tenchucvuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbx_tenchucvuActionPerformed
		cb_thuephong.setSelected(false);
		cb_phong.setSelected(false);
		cb_chucvu.setSelected(false);
		cb_dichvu.setSelected(false);
		cb_khachhang.setSelected(false);
		cb_khachsan.setSelected(false);
		cb_nhanvien.setSelected(false);
		cb_thongke.setSelected(false);
		_liQuyenChucVus = new ArrayList<>();
		ModelChucVu modelChucVu = _lisChucVus.get(cbx_tenchucvu.getSelectedIndex());
		_liQuyenChucVus = quyenChucVu_services.SelectAll();
		for (ModelQuyenChucVu x : _liQuyenChucVus) {
			if (x.getChucVuModel().getMaChucVu().equals(modelChucVu.getMaChucVu())) {
				System.out.println("x: " + x.getQuyenModel().getTenQuyen());
				for (int i = 0; i < checkBoxs.size(); i++) {
					if (x.getQuyenModel().getTenQuyen().equals(checkBoxs.get(i).getText())) {
						System.out.println(x.getQuyenModel().getTenQuyen().equals(checkBoxs.get(i).getText()));
						System.out.println(checkBoxs.get(i));
						checkBoxs.get(i).setSelected(true);
					}
				}
			}
		}
	}// GEN-LAST:event_cbx_tenchucvuActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ViewPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewPhanQuyen().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_xacnhan;
	private javax.swing.JCheckBox cb_chucvu;
	private javax.swing.JCheckBox cb_dichvu;
	private javax.swing.JCheckBox cb_khachhang;
	private javax.swing.JCheckBox cb_khachsan;
	private javax.swing.JCheckBox cb_nhanvien;
	private javax.swing.JCheckBox cb_phong;
	private javax.swing.JCheckBox cb_thongke;
	private javax.swing.JCheckBox cb_thuephong;
	private javax.swing.JComboBox<String> cbx_tenchucvu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JSeparator jSeparator1;
	// End of variables declaration//GEN-END:variables
}
