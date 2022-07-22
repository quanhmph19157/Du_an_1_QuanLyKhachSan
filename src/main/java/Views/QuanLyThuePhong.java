package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;

import Services.KhachSan_services;
import ViewModels.ModelTang;
import ViewModels.ModelPhong;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.DateModel;
import java.util.Properties;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class QuanLyThuePhong extends JFrame{

	JPanel pnl_chinh=new JPanel();
	JPanel pnl_aside=new JPanel();
	JPanel pnl_button=new JPanel();
	JPopupMenu menu=new JPopupMenu();
	JPanel pnl_status=new JPanel();
	JTextField txt_date=new JTextField("dd/mm/yyyy");
	JButton btn_Booking=new JButton("Đặt phòng");
	JButton btn_Checkin=new JButton("Nhận phòng");
	JButton btn_checkout=new JButton("Trả phòng");
	JButton btn_chuyenPhong=new JButton("Chuyển phòng");
	JButton btn_tachDoan=new JButton("Tách đoàn");
	JButton btn_tachPhong=new JButton("Tách Phòng");
	JButton btn_dichvu=new JButton("Đặt dịch vụ");
	JCheckBox chb_tuan=new JCheckBox("7 ngày tới");
	JCheckBox chb_thang=new JCheckBox("1 tháng tới");
	
	LocalDate date;
	YearMonth ym;
	List<ModelTang>ListTang;
	KhachSan_services ser;
	SimpleDateFormat format;
	Date ngay;
	private JTextField textField;
	private JTextField textField_1;
	public QuanLyThuePhong() {
		format=new SimpleDateFormat("yyyy/MM/dd");
		ser=new KhachSan_services();
		ListTang= ser.getKs().getDSTang();
		//TODO Auto-generated constructor stub
		setting();
		pnl_chinh_autoGen();
	}

	public void setting() {
		setSize(1280,720);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnl_aside,BorderLayout.WEST);
		pnl_aside.setPreferredSize(new Dimension(250,720));
		pnl_aside.setBackground(Color.white);
		pnl_aside.setLayout(null);
		
		JLabel lbl_phong = new JLabel("Phòng");
		lbl_phong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_phong.setBounds(96, 0, 56, 29);
		pnl_aside.add(lbl_phong);
		
		JLabel lblNewLabel_1 = new JLabel("Loại phòng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 27, 230, 23);
		pnl_aside.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày check in: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 60, 98, 18);
		pnl_aside.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày check out: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 88, 107, 23);
		pnl_aside.add(lblNewLabel_2_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 168, 230, 2);
		pnl_aside.add(separator);
		
		JLabel lbl_phong_1 = new JLabel("Khách");
		lbl_phong_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_phong_1.setBounds(96, 180, 56, 29);
		pnl_aside.add(lbl_phong_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 219, 76, 23);
		pnl_aside.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 219, 156, 21);
		pnl_aside.add(comboBox);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số CMND:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 285, 230, 23);
		pnl_aside.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Điện thoại");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 318, 230, 23);
		pnl_aside.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 351, 230, 23);
		pnl_aside.add(lblNewLabel_1_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 384, 230, 2);
		pnl_aside.add(separator_1);
		
		JLabel lbl_phong_1_1 = new JLabel("Hóa đơn");
		lbl_phong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_phong_1_1.setBounds(84, 396, 82, 29);
		pnl_aside.add(lbl_phong_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Loại khách:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 252, 230, 23);
		pnl_aside.add(lblNewLabel_1_2_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(116, 56, 124, 25);
		pnl_aside.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(116, 90, 124, 23);
		pnl_aside.add(textField_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tổng tiền:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 435, 230, 23);
		pnl_aside.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Đã thanh toán:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 468, 230, 23);
		pnl_aside.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Còn lại: ");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4.setBounds(10, 501, 230, 23);
		pnl_aside.add(lblNewLabel_1_2_4);
		
		JButton btnNewButton = new JButton("Xem hóa đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(69, 534, 117, 21);
		pnl_aside.add(btnNewButton);
		setLocationRelativeTo(null);
		
		JScrollPane sc=new JScrollPane(pnl_chinh);
		sc.setPreferredSize(new Dimension(1000,720));
		sc.setMinimumSize(new Dimension(1000,720));
		pnl_chinh.setLayout(null);
		pnl_chinh.setBackground(Color.white);
		getContentPane().add(sc,BorderLayout.EAST);
		
		getContentPane().add(pnl_button,BorderLayout.NORTH);
		pnl_button.setPreferredSize(new Dimension(1200,70));
		pnl_button.add(btn_Booking);
		pnl_button.add(btn_Checkin);
		pnl_button.add(btn_checkout);
		pnl_button.add(btn_chuyenPhong);
		pnl_button.add(btn_tachDoan);
		pnl_button.add(btn_tachPhong);
		pnl_button.add(btn_dichvu);
		
		JMenuItem item_booking=new JMenuItem("Đặt phòng");
		item_booking.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("dsdasdasd");
			}
		});
		menu.add(item_booking);
		
		JPanel mapMenu=new JPanel();
		mapMenu.setPreferredSize(new Dimension(1200,40));
		mapMenu.setLayout(new FlowLayout(FlowLayout.CENTER,5,2));
		pnl_button.add(mapMenu);
		
		JLabel lbl_tu=new JLabel("Chọn ngày ");
		JLabel lbl_icon=new JLabel(new ImageIcon(new ImageIcon(this.getClass().getResource("/image/lich.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		txt_date.setPreferredSize(new Dimension(75,30));
		date=LocalDate.now();
		String ngay= String.valueOf(date.getDayOfMonth())+"/"+String.valueOf(date.getMonthValue())+"/"+String.valueOf(date.getYear());
		txt_date.setText(ngay);
		
		JButton btn_homNay=new JButton("Hôm nay");
		btn_homNay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				date=LocalDate.now();
				String ngay= String.valueOf(date.getDayOfMonth())+"/"+String.valueOf(date.getMonthValue())+"/"+String.valueOf(date.getYear());
				txt_date.setText(ngay);
			}
		});
		
		ButtonGroup time=new ButtonGroup();
		time.add(chb_thang);
		time.add(chb_tuan);
		
		chb_thang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnl_chinh.removeAll();
				pnl_chinh_autoGen();
				revalidate();
				repaint();
			}
		});
		
		chb_tuan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnl_chinh.removeAll();
				pnl_chinh_autoGen();
				revalidate();
				repaint();
			}
		});
		
		chb_tuan.setSelected(true);
		
		mapMenu.add(btn_homNay);
		mapMenu.add(lbl_tu);
		mapMenu.add(lbl_icon);
		mapMenu.add(txt_date);
		mapMenu.add(chb_tuan);
		mapMenu.add(chb_thang);
		
		pnl_status.setPreferredSize(new Dimension(1280,36));
		getContentPane().add(pnl_status,BorderLayout.SOUTH);
		
		JLabel lbl_CTrong=new JLabel();
		lbl_CTrong.setOpaque(true);
		lbl_CTrong.setBackground(Color.white);
		lbl_CTrong.setPreferredSize(new Dimension(20,20));
		lbl_CTrong.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CTrong);
		
		JLabel lbl_Trong=new JLabel("Phòng trống");
		pnl_status.add(lbl_Trong);
		
		JLabel lbl_CBooking=new JLabel();
		lbl_CBooking.setOpaque(true);
		lbl_CBooking.setBackground(Color.cyan);
		lbl_CBooking.setPreferredSize(new Dimension(20,20));
		lbl_CBooking.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CBooking);
		
		JLabel lbl_Booking=new JLabel("Phòng đặt");
		pnl_status.add(lbl_Booking);
		
		JLabel lbl_CCheckin=new JLabel();
		lbl_CCheckin.setOpaque(true);
		lbl_CCheckin.setBackground(Color.green);
		lbl_CCheckin.setPreferredSize(new Dimension(20,20));
		lbl_CCheckin.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CCheckin);
		
		JLabel lbl_Checkin=new JLabel("Có khách");
		pnl_status.add(lbl_Checkin);
		
		JLabel lbl_CCheckout=new JLabel();
		lbl_CCheckout.setOpaque(true);
		lbl_CCheckout.setBackground(new Color(77,122,160));
		lbl_CCheckout.setPreferredSize(new Dimension(20,20));
		lbl_CCheckout.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CCheckout);
		
		JLabel lbl_Checkout=new JLabel("Khách đã trả phòng");
		pnl_status.add(lbl_Checkout);
		
		JLabel lbl_CMuon=new JLabel();
		lbl_CMuon.setOpaque(true);
		lbl_CMuon.setBackground(Color.red);
		lbl_CMuon.setPreferredSize(new Dimension(20,20));
		lbl_CMuon.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CMuon);
		
		JLabel lbl_Muon=new JLabel("Ở quá hạn");
		pnl_status.add(lbl_Muon);
		
		JLabel lbl_CTre=new JLabel();
		lbl_CTre.setOpaque(true);
		lbl_CTre.setBackground(Color.PINK);
		lbl_CTre.setPreferredSize(new Dimension(20,20));
		lbl_CTre.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		pnl_status.add(lbl_CTre);
		
		JLabel lbl_Tre=new JLabel("Nhận phòng muộn");
		pnl_status.add(lbl_Tre);
		
		JLabel lbl_CDon=new JLabel();
		lbl_CDon.setOpaque(true);
		lbl_CDon.setBackground(Color.BLUE);
		lbl_CDon.setPreferredSize(new Dimension(10,10));
		lbl_CDon.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
		pnl_status.add(lbl_CDon);
		
		JLabel lbl_Don=new JLabel("Cần dọn");
		pnl_status.add(lbl_Don);
	}
	
	public void pnl_chinh_autoGen() {
		
		String[] d= txt_date.getText().split("/");
		int DAY=Integer.parseInt(d[0]);
		int month=Integer.parseInt(d[1]);
		int year=Integer.parseInt(d[2]);
		ym =YearMonth.of(year, month);
		date=LocalDate.of(year, month, DAY);
		int time;
		if(chb_thang.isSelected())time=30;
		else time=7;
		int rong=240*time+80;
		JPanel pnl_header=new JPanel();
		pnl_header.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		pnl_header.setBounds(0,0, rong, 30);
		pnl_chinh.add(pnl_header);
		JLabel lbl_Title=new JLabel("");
		lbl_Title.setFont(new Font("TAHOMA", Font.BOLD, 22));
		lbl_Title.setPreferredSize(new Dimension(80,30));
		pnl_header.add(lbl_Title);
		pnl_header.setBackground(Color.white);
		for(int i=date.getDayOfMonth();time>0;i++) {
			if(i>ym.lengthOfMonth()) {
				i=1;
				if(ym.getYear()==12)ym= YearMonth.of(Integer.parseInt(d[2])+1, 1);
				else ym= YearMonth.of(year, month+1);
			}
			JLabel lbl_day=new JLabel("Ngày "+String.valueOf(i));
			lbl_day.setFont(new Font("TAHOMA", Font.BOLD, 22));
			lbl_day.setPreferredSize(new Dimension(240,30));
			lbl_day.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.gray));
			lbl_day.setHorizontalAlignment(SwingConstants.CENTER);
			pnl_header.add(lbl_day);
			time--;
		}
		for(int i=0;i<ListTang.size();i++) {
			JLabel lbl_tang=new JLabel(String.valueOf("Tầng "+ListTang.get(i).getMaTang()));
			lbl_tang.setBounds(0, (pnl_chinh.getComponentCount())*30, rong, 30);
			lbl_tang.setFont(new Font("TAHOMA", Font.PLAIN, 22));
			pnl_chinh.add(lbl_tang);
			for(int y=0;y<ListTang.get(i).getDSPhong().size();y++) {
				JPanel pnl_phong=new JPanel();
				pnl_phong.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.gray));
				pnl_phong.setBounds(0,(pnl_chinh.getComponentCount())*30, rong, 30);
				pnl_phong.setLayout(null);
				pnl_phong.setBackground(Color.white);
				final int Y=(pnl_chinh.getComponentCount())*30;
				pnl_phong.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(SwingUtilities.isRightMouseButton(e)) {
							menu.show(pnl_chinh,e.getX(),Y);
							return;
						}
//						JPopupMenu thongbao=new JPopupMenu();
//						thongbao.add(date.get)
					}
				});
				pnl_chinh.add(pnl_phong);
				
				JLabel lbl_tenPhong=new JLabel(String.valueOf(ListTang.get(i).getDSPhong().get(y).getMaPhong()));
				lbl_tenPhong.setFont(new Font("TAHOMA", Font.PLAIN, 22));
				lbl_tenPhong.setBounds(0,0, 80, 30);
				lbl_tenPhong.setBorder(BorderFactory.createMatteBorder(0,0,0,1, Color.gray));
				pnl_phong.add(lbl_tenPhong);
				for(int x=0;x<time;x++) {
					JPanel cell=new JPanel();
					cell.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
					cell.setBounds(80+x*240, 0, 240, 30);
					cell.setOpaque(false);
					pnl_phong.add(cell);
				}
			}
		}
		pnl_chinh.setPreferredSize(new Dimension(rong,pnl_chinh.getComponentCount()*30));
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				new QuanLyThuePhong().setVisible(true);
			}
		}).start();
	}
}
