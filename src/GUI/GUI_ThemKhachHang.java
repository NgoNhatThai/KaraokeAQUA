////Huỳnh Hữu Phước
//package GUI;
//
//import java.awt.EventQueue;
//
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.SwingConstants;
//import javax.swing.JTextField;
//import javax.swing.JRadioButton;
//import com.toedter.calendar.JDateChooser;
//import javax.swing.JButton;
//import javax.swing.border.MatteBorder;
//import javax.swing.border.TitledBorder;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.awt.event.ActionEvent;
//
//import GUI.GUI_ThuePhong;
//import dao.KhachHang_dao;
//import entity.KhachHang;
//import GUI.GUI_DatPhong;
//
//
//@SuppressWarnings("unused")
//public class GUI_ThemKhachHang extends JFrame implements ActionListener{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField txtTen;
//	private JButton btnThm;
//	private JDateChooser txtNgaySinh;
//	private JTextField txtHo;
//	private JTextField txtsdt;
//	private KhachHang_dao KhachHang_dao= new KhachHang_dao();
//	private JRadioButton rdbtnNam;
//	private JRadioButton rdbtnNu;
//	private String d;
//	/**
//	 * Create the frame.
//	 */
//	public GUI_ThemKhachHang(String d) {
//		this.d=d;
//		setBounds(100, 100, 678, 281);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		setLocationRelativeTo(null);
//		contentPane.setLayout(null);
//		
//		JPanel pnTitle = new JPanel();
//		pnTitle.setBackground(Color.CYAN);
//		pnTitle.setBounds(0, 0, 664, 65);
//		contentPane.add(pnTitle);
//		pnTitle.setLayout(null);
//		
//		JLabel lblTitle = new JLabel("THÊM KHÁCH HÀNG MỚI");
//		lblTitle.setForeground(new Color(0, 0, 255));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitle.setFont(new Font("Constantia", Font.BOLD, 30));
//		lblTitle.setBounds(0, 0, 664, 65);
//		pnTitle.add(lblTitle);
//		
//		JPanel pnThongTin = new JPanel();
//		pnThongTin.setBackground(Color.WHITE);
//		pnThongTin.setBounds(0, 63, 664, 181);
//		contentPane.add(pnThongTin);
//		pnThongTin.setLayout(null);
//		pnThongTin.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thêm khách hàng"));
//		
//		JLabel lblHoKH = new JLabel("Họ:");
//		lblHoKH.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblHoKH.setBounds(10, 24, 22, 20);
//		pnThongTin.add(lblHoKH);
//		
//		txtHo = new JTextField();
//		txtHo.setColumns(10);
//		txtHo.setBounds(85, 23, 131, 19);
//		pnThongTin.add(txtHo);
//		
//		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
//		lblNgaySinh.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblNgaySinh.setBounds(10, 66, 64, 20);
//		pnThongTin.add(lblNgaySinh);
//		
//		txtNgaySinh = new JDateChooser();
//		txtNgaySinh.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
//		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
//		txtNgaySinh.setBounds(86, 66, 130, 20);
//		pnThongTin.add(txtNgaySinh);
//		
//		JLabel lblSdt = new JLabel("Số điện thoại:");
//		lblSdt.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblSdt.setBounds(237, 66, 84, 20);
//		pnThongTin.add(lblSdt);
//		
//		JLabel lblTen = new JLabel("Tên:");
//		lblTen.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblTen.setBounds(238, 24, 44, 20);
//		pnThongTin.add(lblTen);
//		
//		txtTen = new JTextField();
//		txtTen.setColumns(10);
//		txtTen.setBounds(345, 23, 131, 19);
//		pnThongTin.add(txtTen);
//		
//		txtsdt = new JTextField();
//		txtsdt.setColumns(10);
//		txtsdt.setBounds(345, 65, 131, 19);
//		pnThongTin.add(txtsdt);
//		
//		JLabel lblGioiTinh = new JLabel("Giới tính");
//		lblGioiTinh.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblGioiTinh.setBounds(510, 24, 64, 20);
//		pnThongTin.add(lblGioiTinh);
//		
//		rdbtnNam = new JRadioButton("Nam");
//		rdbtnNam.setSelected(true);
//		rdbtnNam.setFont(new Font("Constantia", Font.BOLD, 12));
//		rdbtnNam.setBackground(Color.WHITE);
//		rdbtnNam.setBounds(592, 24, 55, 21);
//		pnThongTin.add(rdbtnNam);
//		
//		rdbtnNu = new JRadioButton("Nữ");
//		rdbtnNu.setSelected(true);
//		rdbtnNu.setFont(new Font("Constantia", Font.BOLD, 12));
//		rdbtnNu.setBackground(Color.WHITE);
//		rdbtnNu.setBounds(592, 63, 55, 21);
//		pnThongTin.add(rdbtnNu);
//		
//		JButton btnHuy = new JButton("Hủy", null);
//		btnHuy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				if(d.equalsIgnoreCase("đặt")) {
//					GUI_DatPhong.checkHienThi(true);
//				}
//				else {
//					GUI_ThuePhong.checkHienThi(true);
//				}
//			}
//		});
//		btnHuy.setFont(new Font("Constantia", Font.BOLD, 15));
//		btnHuy.setFocusPainted(false);
//		btnHuy.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
//		btnHuy.setBackground(Color.WHITE);
//		btnHuy.setBounds(422, 112, 168, 42);
//		pnThongTin.add(btnHuy);
//		
//		btnThm = new JButton("Thêm", null);
//		btnThm.setFont(new Font("Constantia", Font.BOLD, 15));
//		btnThm.setFocusPainted(false);
//		btnThm.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
//		btnThm.setBackground(Color.WHITE);
//		btnThm.setBounds(85, 112, 168, 42);
//		pnThongTin.add(btnThm);
//		ButtonGroup btng = new ButtonGroup();
//		btng.add(rdbtnNam);
//		btng.add(rdbtnNu);
//		
//		btnThm.addActionListener(this);
//	}
//	//Văn Quang Phong
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		Boolean gt;
//		String ma="KH";
//		String ID = null;
//		try {
//			ID = autoId(ma);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		if(o.equals(btnThm)) {
//
//			if(txtHo.getText().trim().isEmpty()
//					|| txtTen.getText().trim().isEmpty() || txtNgaySinh.getDate().toString().trim().isEmpty()
//					|| txtsdt.getText().trim().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
//			}else if(!kiemTraNhap(txtsdt.getText(),"^([0]{1})[0-9]{8}([0-9]{1})$" )) {
//				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số điện thoại [0xxxxxxxxx]");
//			//}else if(!kiemTraNhap(txtHo.getText(),"^([A-Z]{1}[a-z]{0,5}[\s]{1}){1}([A-Z]{1}[a-z]{0,}[\s]{1}){0,4}([A-Z]{1}[a-z]{0,5}){1}$" )) {
//				//JOptionPane.showMessageDialog(null, "Viêt hoa chữ cái đầu");
//			//}else if(!kiemTraNhap(txtTen.getText(), "^([A-Z]{1}[a-z]{0,5})$")) {
//				//JOptionPane.showMessageDialog(null, "Viêt hoa chữ cái đầu");
//			}
//			else {
//				if(rdbtnNam.isSelected()) {
//					gt = true;
//				}
//				else {
//					gt = false;
//				}
//				KhachHang kh = new KhachHang(ID, txtHo.getText(), txtTen.getText(), txtsdt.getText(), gt, txtNgaySinh.getDate());
//				if(KhachHang_dao.insertKh(kh)) {
//					if(d.equalsIgnoreCase("đặt")) {
//						GUI_DatPhong.loadCboKhachHangKhiThemMoi(kh);
//						GUI_DatPhong.checkHienThi(true);
//						setVisible(false);
//					}
//					else {
//						setVisible(false);
//						GUI_ThuePhong.loadCboKhachHangKhiThemMoi(kh);
//						GUI_ThuePhong.checkHienThi(true);
//					}
//					JOptionPane.showMessageDialog(null, "Thêm Khách hàng Thành Công.");	
//				}else {
//					JOptionPane.showMessageDialog(null, "Thêm Khách hàng không thành công!");
//				}
//		}
//		
//			
//		}		
//	}
//	public boolean kiemTraNhap(String input, String patternStr) {
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher match = pattern.matcher(input);
//		return match.matches();
//	};
//	public String autoId(String ma) throws SQLException {
//		int dem = new KhachHang_dao().getTongSoKH()+1;
//		String maSo = dem + "";
//		String c;
//		if(dem<10) {
//			c ="000";
//		}
//		else if(dem>=10&&dem<100) {
//			c ="00";
//		}
//		else {
//			c="0";
//		}
//		String maKH = ma + c + maSo;
//		List<KhachHang> dsKH;
//		dsKH = KhachHang_dao.getDanhSachKhachHang();
//		for (KhachHang khachhang : dsKH) {
//			if (khachhang.getMaKH().equalsIgnoreCase(maKH)) {
//				dem += 1;
//			}
//		}
//		maSo = dem + "";
//		return ma + c + maSo;
//	}
//}
