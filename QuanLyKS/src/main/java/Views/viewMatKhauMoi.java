/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import ViewModels.ModelNhanVien;
import utils.Utilities;

import java.util.List;
import javax.swing.JOptionPane;
import Services.NhanVienService;

/**
 *
 * @author TIENTVPH18954
 */
public class viewMatKhauMoi extends javax.swing.JFrame {
	NhanVienService nhanVien_services = new NhanVienService();
	String email;

	public viewMatKhauMoi(String email) {
		initComponents();
		this.email = email;
		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		btn_luu = new javax.swing.JButton();
		txt_xacnhanmatkhaumoi = new javax.swing.JPasswordField();
		txt_matkhaumoi = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("CẬP NHẬP MẬT KHẨU MỚI");
		jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jLabel2.setText("Mật khẩu mới:");

		jLabel3.setText("Nhập lại mật khẩu mới:");

		btn_luu.setText("LƯU");
		btn_luu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_luuActionPerformed(evt);
			}
		});

		txt_xacnhanmatkhaumoi.setText("jPasswordField1");

		txt_matkhaumoi.setText("jPasswordField1");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(152, 152, 152).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(57, 57, 57)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txt_xacnhanmatkhaumoi, javax.swing.GroupLayout.DEFAULT_SIZE, 202,
												Short.MAX_VALUE)
										.addComponent(txt_matkhaumoi)))
						.addGroup(layout.createSequentialGroup().addGap(159, 159, 159).addComponent(btn_luu,
								javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(94, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_matkhaumoi, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txt_xacnhanmatkhaumoi, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btn_luu,
						javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(22, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_luuActionPerformed
		List<ModelNhanVien> listModelNhanVien = nhanVien_services.findList(email);
		System.out.println("modelNhanVien: " + listModelNhanVien.get(0).toString());
		String matkhaumoi = txt_matkhaumoi.getText();
		String xnmatkhaumoi = txt_xacnhanmatkhaumoi.getText();
		if (!(matkhaumoi.equals(xnmatkhaumoi))) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp nhau!");
			return;
		}
		if (matkhaumoi.equals(xnmatkhaumoi)) {
			ModelNhanVien modelNhanVien = listModelNhanVien.get(0);
			String matkhaumoi1 = Utilities.hashingPassword(matkhaumoi);
			System.out.println("passwword: "+ matkhaumoi1);
			modelNhanVien.setPassword(matkhaumoi1);
			System.out.println("Model NhanVien: "+ modelNhanVien.toString());
			nhanVien_services.save(modelNhanVien);
			JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
			this.dispose();
		}
	}// GEN-LAST:event_btn_luuActionPerformed

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
			java.util.logging.Logger.getLogger(viewMatKhauMoi.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(viewMatKhauMoi.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(viewMatKhauMoi.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(viewMatKhauMoi.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new viewMatKhauMoi("aaa").setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_luu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPasswordField txt_matkhaumoi;
	private javax.swing.JPasswordField txt_xacnhanmatkhaumoi;
	// End of variables declaration//GEN-END:variables
}
