package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Services.KhachSan_services;
import ViewModels.ModelKhachSan;

public class ThongTinKhachSan extends JPanel{

	JTextField txt_name=new JTextField();
	JTextField txt_email=new JTextField();
	JTextField txt_sdt=new JTextField();
	JTextField txt_diachi=new JTextField();
	JButton btn_conf=new JButton("Xác nhận");
	
	KhachSan_services ser;
	
	public ThongTinKhachSan() {
		//TODO Auto-generated constructor stub
		ser=new KhachSan_services();
		getInfo();
		setting();
		event();
	}
	
	private void setting() {
		setPreferredSize(new Dimension(240, 360));
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		setBackground(Color.white);
		setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
		
		JLabel lbl_til=new JLabel("Thông tin khách sạn");
		lbl_til.setFont(new Font("TAHOMA",Font.PLAIN,20));
		lbl_til.setPreferredSize(new Dimension(460,40));
		lbl_til.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl_til);
		
		JPanel pnl_form=new JPanel();
		pnl_form.setPreferredSize(new Dimension(240,270));
		pnl_form.setLayout(new FlowLayout(FlowLayout.LEFT,19,10));
		pnl_form.setBackground(Color.white);
		add(pnl_form);
		add(btn_conf);
		
		JLabel lbl_name=new JLabel("Tên khách sạn:      ");
		JLabel lbl_Email=new JLabel("Email khách sạn:    ");
		JLabel lbl_SDT=new JLabel("Số điện thoại:         ");
		JLabel lbl_diachi=new JLabel("Địa chỉ khách sạn: ");
		
		txt_name.setPreferredSize(new Dimension(200,30));
		txt_email.setPreferredSize(new Dimension(200,30));
		txt_sdt.setPreferredSize(new Dimension(200,30));
		txt_diachi.setPreferredSize(new Dimension(200,30));
		
		pnl_form.add(lbl_name);
		pnl_form.add(txt_name);
		pnl_form.add(lbl_Email);
		pnl_form.add(txt_email);
		pnl_form.add(lbl_SDT);
		pnl_form.add(txt_sdt);
		pnl_form.add(lbl_diachi);
		pnl_form.add(txt_diachi);
	}
	
	private void event() {
		btn_conf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String rg="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
		                + "\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:"
		                + "[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
		                + "\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f"
		                + "\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		        if(!txt_email.getText().matches(rg)){
		        	JOptionPane.showMessageDialog(txt_email, "Email không đúng định dạng");
		            return;
		        }
		        if(!txt_sdt.getText().matches("0\\d{9,10}")){
		        	JOptionPane.showMessageDialog(txt_email, "Số điện thoại không hợp lệ");
		            return ;
		        }
				int chon=JOptionPane.showConfirmDialog(txt_name, "Xác nhận thông tin khách sạn?", "Thông báo", 2);
				if(chon==0) {
					ser.themsua(new ModelKhachSan(1, txt_name.getText(), txt_email.getText(), txt_sdt.getText(),txt_diachi.getText()));
					JOptionPane.showMessageDialog(txt_name, "Sửa thông tin thành công");
				}
			}
		});
	}

	private void getInfo() {
		ModelKhachSan ks=ser.getKs();
		if(ks==null)return;
		txt_diachi.setText(ks.getDiaChi());
		txt_email.setText(ks.getEmail());
		txt_name.setText(ks.getTenKhachSan());
		txt_sdt.setText(ks.getSdt());
	}
}
