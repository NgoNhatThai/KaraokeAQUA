////Huỳnh Hữu Phước
//package GUI;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
//import java.awt.Font;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.TimeZone;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.awt.Color;
//import javax.swing.JComboBox;
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import com.raven.swing.TimePicker;
//import com.toedter.calendar.JDateChooser;
//import dao.KhachHang_dao;
//import dao.Phong_dao;
//import dao.ThongTinDat_dao;
//import entity.KhachHang;
//import entity.Phong;
//import entity.ThongTinDat;
//import entity.ThongTinTaiKhoan;
//
//import javax.swing.JTextField;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.awt.event.ItemListener;
//import java.awt.event.ItemEvent;
//import javax.swing.JSlider;
//import javax.swing.event.ChangeListener;
//import javax.swing.event.ChangeEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.border.MatteBorder;
//import GUI.GUI_DatThuePhong;
//import javax.swing.JCheckBox;
//
//@SuppressWarnings("unused")
//public class GUI_DatPhong extends JFrame implements ActionListener {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private final JPanel contentPane;
//	private final JButton btnHuy;
//	private final JButton btnDatPhong;
//	private final TimePicker timePicker;
//	private static JComboBox<String> cboKhachHang;
//	private static JTextField txtSdt;
//	private KhachHang_dao KhachHang_dao = new KhachHang_dao();
//	private Phong_dao Phong_dao = new Phong_dao();
//	private JDateChooser txtNgayHat;
//	private JComboBox<String> cboLoaiPhong;
//	private JComboBox<String> cboMaPhong;
//	private JButton btnThem;
//	private JLabel lblGiaText;
//	private String maKH;
//	private ThongTinTaiKhoan tttk;
//	private ThongTinDat ttd;
//	private String dateTime;
//	private DateFormat dateFormat;
//	private JSlider slSucChua;
//	private static JCheckBox hienThi;
//
//	/**
//	 * Create the frame.
//	 */
//	@SuppressWarnings({ "deprecation"})
//	public GUI_DatPhong(ThongTinTaiKhoan tttk, Phong p, KhachHang kh) {
//		this.tttk = tttk;
//		setSize(680, 438);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		setLocationRelativeTo(null);
//		setResizable(false);
//		JPanel pnTitle = new JPanel();
//		pnTitle.setBackground(Color.CYAN);
//		pnTitle.setBounds(0, 0, 664, 66);
//		contentPane.add(pnTitle);
//		pnTitle.setLayout(null);
//
//		JLabel lblTitle = new JLabel("ĐẶT PHÒNG");
//		lblTitle.setForeground(Color.BLUE);
//		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitle.setBounds(0, 0, 664, 67);
//		pnTitle.add(lblTitle);
//
//		JPanel pnDatPhong = new JPanel();
//		pnDatPhong.setBackground(Color.WHITE);
//		pnDatPhong.setBounds(0, 65, 664, 332);
//		contentPane.add(pnDatPhong);
//		pnDatPhong.setLayout(null);
//
//		JLabel lblKhachHang = new JLabel("Khách hàng:");
//		lblKhachHang.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblKhachHang.setBounds(267, 97, 94, 22);
//		pnDatPhong.add(lblKhachHang);
//
//		cboKhachHang = new JComboBox<String>();
//		cboKhachHang.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				if(cboKhachHang.getSelectedItem()!=null) {
//					String b = cboKhachHang.getSelectedItem() + "";
//					if (b != null) {
//						maKH = b.substring(0, b.indexOf("-"));
//					}
//				}
//			}
//		});
//		cboKhachHang.setBackground(Color.WHITE);
//		cboKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		cboKhachHang.setBounds(371, 98, 230, 21);
//		pnDatPhong.add(cboKhachHang);
//
////		btnThem = new JButton("+");
////		btnThem.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				new GUI_ThemKhachHang("đặt").setVisible(true);
////				hide();
////			}
////		});
////		btnThem.setBackground(Color.WHITE);
////		btnThem.setToolTipText("Thêm khách hàng mới");
////		btnThem.setBounds(611, 91, 45, 30);
////		pnDatPhong.add(btnThem);
//
//		JLabel lblPhongDat = new JLabel("Mã phòng có thể đặt:");
//		lblPhongDat.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblPhongDat.setBounds(267, 202, 143, 22);
//		pnDatPhong.add(lblPhongDat);
//
//		cboMaPhong = new JComboBox<String>();
//		maKH = cboMaPhong.getSelectedItem()+"";
//		cboMaPhong.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				List<Phong> p = new Phong_dao().getDanhSachPhongTrongTheoMa(cboMaPhong.getSelectedItem() + "");
//				for (Phong phong : p) {
//					lblGiaText.setText(phong.getDonGia() + "VNĐ");
//				}
//				
//			}
//		});
//		cboMaPhong.setForeground(Color.BLUE);
//		cboMaPhong.setBackground(Color.WHITE);
//		cboMaPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
//		cboMaPhong.setBounds(423, 200, 178, 21);
//		pnDatPhong.add(cboMaPhong);
//
//		JLabel lblLoaiPhong = new JLabel("Loại:");
//		lblLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblLoaiPhong.setBounds(267, 129, 45, 22);
//		pnDatPhong.add(lblLoaiPhong);
//
//		cboLoaiPhong = new JComboBox<String>();
//		cboLoaiPhong.addItemListener(new ItemListener() {
//			@SuppressWarnings("static-access")
//			public void itemStateChanged(ItemEvent e) {
//				boolean n = true, m = false;
//				if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//					n = false;
//				} else {
//					n = true;
//				}
//				if (txtNgayHat.getDate() == null||cboLoaiPhong.getSelectedIndex()==0) {
//					cboMaPhong.removeAllItems();
//				} else {
//					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//					dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					String date =  sp.format(txtNgayHat.getDate());
//					String year = date.substring(0, date.indexOf("-"));
//					String mon = date.substring(date.indexOf("-")+1);
//					String month = mon.substring(0, mon.indexOf("-"));
//					String day = date.substring(date.indexOf("-")+4);
//					int yearInt = Integer.parseInt(year);
//					int monthInt = Integer.parseInt(month)-1;
//					int dayOfMonthInt = Integer.parseInt(day);
//					Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//					calendar.set(yearInt, monthInt, dayOfMonthInt);
//					List<ThongTinDat> ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH)+"");
//					cboMaPhong.removeAllItems();
//					for (Phong p : Phong_dao.getDanhSachPhongTrongTheoLoai(n)) {
//						if (ls.size() == 0&&p.isTrangThai()==false&&p.getSucChua()<=slSucChua.getValue()) {
//							cboMaPhong.addItem(p.getMaPhong());
//						} else if(p.isTrangThai()==false){
//							for (int i = 0; i < ls.size(); i++) {
//								if (p.getMaPhong().equalsIgnoreCase(ls.get(i).getMaPh())) {
//									m = false;
//									break;
//								}
//								else {
//									m=true;
//								}
//							}
//							if(m&&p.getSucChua()<=slSucChua.getValue()&&p.isTrangThai()==false) {
//								cboMaPhong.addItem(p.getMaPhong());
//							}
//						}
//					}
//				}
//			}
//		});
//		cboLoaiPhong.setBackground(Color.WHITE);
//		cboLoaiPhong.setBounds(371, 130, 230, 21);
//		pnDatPhong.add(cboLoaiPhong);
//
//		JLabel lblGia = new JLabel("Giá/giờ:");
//		lblGia.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblGia.setBounds(267, 234, 65, 22);
//		pnDatPhong.add(lblGia);
//
//		lblGiaText = new JLabel("100000 VNĐ");
//		lblGiaText.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		lblGiaText.setBounds(367, 231, 94, 22);
//		pnDatPhong.add(lblGiaText);
//
//		btnDatPhong = new JButton("Đặt phòng", new ImageIcon(GUI_DatPhong.class.getResource("/icon/desktop.png")));
//		btnDatPhong.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnDatPhong.setFont(new Font("Constantia", Font.BOLD, 17) );
//				btnDatPhong.setForeground(Color.BLUE);
//				btnDatPhong.setBorder(new MatteBorder(0, 0, 6, 0, (Color) Color.BLUE));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnDatPhong.setFont(new Font("Constantia", Font.BOLD, 14) );
//				btnDatPhong.setForeground(Color.BLACK);
//				btnDatPhong.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
//			}
//		});
//		btnDatPhong.setFont(new Font("Constantia", Font.BOLD, 14));
//		btnDatPhong.setBounds(270, 266, 155, 37);
//		pnDatPhong.add(btnDatPhong);
//
//		btnHuy = new JButton("Hủy", new ImageIcon(GUI_DatPhong.class.getResource("/icon/close.png")));
//		btnHuy.setFont(new Font("Constantia", Font.BOLD, 14));
//		btnHuy.setBounds(480, 266, 119, 37);
//		pnDatPhong.add(btnHuy);
//		btnHuy.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnHuy.setFont(new Font("Constantia", Font.BOLD, 17) );
//				btnHuy.setForeground(Color.RED);
//				btnHuy.setBorder(new MatteBorder(0, 0, 6, 0, (Color) Color.RED));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnHuy.setFont(new Font("Constantia", Font.BOLD, 14) );
//				btnHuy.setForeground(Color.BLACK);
//				btnHuy.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
//			}
//		});
//
//		timePicker = new TimePicker();
//		timePicker.setBounds(10, 17, 247, 309);
//		pnDatPhong.add(timePicker);
//
//		txtNgayHat = new JDateChooser();
//		txtNgayHat.setBounds(370, 29, 231, 19);
//		txtNgayHat.setDateFormatString("dd-MM-yyyy");
//		pnDatPhong.add(txtNgayHat);
//
//		JLabel lblNgayHat = new JLabel("Ngày hát:");
//		lblNgayHat.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblNgayHat.setBounds(270, 29, 82, 20);
//		pnDatPhong.add(lblNgayHat);
//		pnDatPhong.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin đặt phòng"));
//
//		JLabel lblSdt = new JLabel("Số điện thoại:");
//		lblSdt.setFont(new Font("Constantia", Font.BOLD, 14));
//		lblSdt.setBounds(267, 68, 94, 22);
//		pnDatPhong.add(lblSdt);
//		
//		txtSdt = new JTextField();
//		txtSdt.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String sdt = txtSdt.getText();
//				if (sdt.length() >= 1) {
//					cboKhachHang.removeAllItems();
//					for (KhachHang khachHang : KhachHang_dao.getDSKHTheoSDT(sdt)) {
//						cboKhachHang.addItem(khachHang.getMaKH()+"-"+khachHang.getHoKH() + " " + khachHang.getTenKH()+"-"+khachHang.getSđt());
//					}
//				} else {
//					cboKhachHang.removeAllItems();
//				}
//			}
//		});
//		txtSdt.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		txtSdt.setBounds(371, 67, 230, 20);
//		pnDatPhong.add(txtSdt);
//		txtSdt.setColumns(10);
//		
//		JLabel lblSucChua = new JLabel("Sức chứa:");
//		lblSucChua.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblSucChua.setBounds(267, 161, 64, 20);
//		pnDatPhong.add(lblSucChua);
//		
//		slSucChua = new JSlider();
//		slSucChua.addChangeListener(new ChangeListener() {
//			@SuppressWarnings("static-access")
//			public void stateChanged(ChangeEvent e) {
//				boolean n = true, m = false;
//				if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//					n = false;
//				} else {
//					n = true;
//				}
//				if (txtNgayHat.getDate() == null||cboLoaiPhong.getSelectedIndex()==0) {
//					cboMaPhong.removeAllItems();
//				} else {
//					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//					dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					String date =  sp.format(txtNgayHat.getDate());
//					String year = date.substring(0, date.indexOf("-"));
//					String mon = date.substring(date.indexOf("-")+1);
//					String month = mon.substring(0, mon.indexOf("-"));
//					String day = date.substring(date.indexOf("-")+4);
//					int yearInt = Integer.parseInt(year);
//					int monthInt = Integer.parseInt(month)-1;
//					int dayOfMonthInt = Integer.parseInt(day);
//
//					Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//					calendar.set(yearInt, monthInt, dayOfMonthInt);
//					List<ThongTinDat> ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH)+"");
//					cboMaPhong.removeAllItems();
//					for (Phong p : Phong_dao.getDanhSachPhongTrongTheoLoai(n)) {
//						if (ls.size() == 0&&p.isTrangThai()==false&&p.getSucChua()<=slSucChua.getValue()) {
//							cboMaPhong.addItem(p.getMaPhong());
//						} else {
//							for (int i = 0; i < ls.size(); i++) {
//								if (p.getMaPhong().equalsIgnoreCase(ls.get(i).getMaPh())) {
//									m = false;
//									break;
//								}
//								else {
//									m=true;
//								}
//							}
//							if(m&&p.getSucChua()<=slSucChua.getValue()&&p.isTrangThai()==false) {
//								cboMaPhong.addItem(p.getMaPhong());
//							}
//						}
//					}
//				}
//			}
//		});
//		slSucChua.setValue(25);
//		slSucChua.setSnapToTicks(true);
//		slSucChua.setPaintLabels(true);
//		slSucChua.setMinorTickSpacing(5);
//		slSucChua.setMinimum(10);
//		slSucChua.setMaximum(25);
//		slSucChua.setMajorTickSpacing(5);
//		slSucChua.setBackground(Color.WHITE);
//		slSucChua.setBounds(371, 161, 230, 35);
//		pnDatPhong.add(slSucChua);
////		sự kiện
//		btnHuy.addActionListener(this);
//		btnDatPhong.addActionListener(this);
//
//		cboLoaiPhong.addItem("Chọn loại phòng");
//		cboLoaiPhong.addItem("Phòng thường");
//		cboLoaiPhong.addItem("Phòng VIP");
//		
//		btnDatPhong.setFocusPainted(false);
//		btnHuy.setFocusPainted(false);
//		btnDatPhong.setBackground(Color.WHITE);
//		btnHuy.setBackground(Color.WHITE);
//		btnHuy.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
//		btnDatPhong.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
//		
//		hienThi = new JCheckBox("New check box");
//		hienThi.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				if(hienThi.isSelected()) {
//					show();
//				}
//				else {
//					hide();				}
//			}
//		});
//		hienThi.setBounds(634, 17, 24, 21);
//		pnDatPhong.add(hienThi);
//		hienThi.hide();
//	}
//	public static void checkHienThi(boolean b) {
//		if(b) {
//			hienThi.setSelected(true);
//		}
//		else {
//			hienThi.setSelected(false);
//		}
//	}
//
//	public static void loadCboKhachHangKhiThemMoi(KhachHang k) {
//		cboKhachHang.removeAllItems();
//		cboKhachHang.addItem(k.getMaKH()+"-"+k.getHoKH()+" "+k.getTenKH()+"-"+k.getSđt());
//		txtSdt.setText(k.getSđt());
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if (o.equals(btnHuy)) {
//			this.setVisible(false);
//		} else if (o.equals(btnDatPhong)) {
//			try {
//				Date date;
//				date = txtNgayHat.getDate();
//				if (date != null && !timePicker.getSelectedTime().isEmpty() && rangBuocGioDat() && rangBuocNgayDat()
//						&& rangBuocDatSauGioHienTai() && cboKhachHang.getItemCount() != 0&&cboMaPhong.getSelectedItem()!=null) {
//					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//					dateFormat = null;
//					dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//					dateTime = sp.format(txtNgayHat.getDate()) + " " + chuyen24h();
//					try {
//						ttd = new ThongTinDat(maKH, cboMaPhong.getSelectedItem() + "",
//								dateFormat.parse(dateTime));
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					if(new ThongTinDat_dao().insertThongTinDat(ttd, dateTime)) {
//						JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
//						GUI_DatThuePhong.loadDanhSachPhongTrong();
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "Lỗi đặt phòng");
//					}
//					
//					
//					setVisible(false);
//				} else if (date == null && timePicker.getSelectedTime().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Ngày và giờ đặt không được bỏ trống");
//				} else if (cboKhachHang.getItemCount() == 0) {
//					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần đặt phòng");
//				} else if (!rangBuocGioDat()) {
//					JOptionPane.showMessageDialog(null,
//							"Giờ đặt không hợp lệ.\nChỉ được phòng sau 8h sáng và trước 23 giờ tối");
//				} else if (!rangBuocNgayDat()) {
//					JOptionPane.showMessageDialog(null, "Ngày đặt không hợp lệ.\nChỉ được phòng trong hôm nay hoặc ngày mai");
//				} else if (!rangBuocDatSauGioHienTai()) {
//					JOptionPane.showMessageDialog(null,
//							"Thời gian đặt không hợp lệ.\nKhông thể đặt phòng sớm hơn thời gian hiện tại");
//				}
//				else if(cboMaPhong.getSelectedItem()==null) {
//					JOptionPane.showMessageDialog(null,
//							"Vui lòng chọn phòng cần đặt!");
//				}
//			} catch (HeadlessException | ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//		}
//	}
//
//	public boolean rangBuocGioDat() {
//		String hour = chuyen24h().substring(0, chuyen24h().indexOf(":"));
//		int hourInt = Integer.parseInt(hour);
//		if (hourInt > 22) {
//			return false;
//		} else if (hourInt < 8) {
//			return false;
//		}
//		return true;
//	}
//
////	@SuppressWarnings("static-access")
////	public boolean rangBuocNgayDat() {
////		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
////		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////		String date =  sp.format(txtNgayHat.getDate());
////		String year = date.substring(0, date.indexOf("-"));
////		String mon = date.substring(date.indexOf("-")+1);
////		String month = mon.substring(0, mon.indexOf("-"));
////		String day = mon.substring(3);	
////		int yearInt = Integer.parseInt(year);
////		int monthInt = Integer.parseInt(month)-1;
////		int dayOfMonthInt = Integer.parseInt(day);
////		Calendar c = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
////		c.set(yearInt, monthInt, dayOfMonthInt);
////		if (txtNgayHat.getDate() == null) {
////			return false;
////		} else if (c.get(c.DAY_OF_MONTH)-java.time.LocalDate.now().getDayOfMonth()>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)==0) {	
////			return false;
////		}else if(c.get(c.DAY_OF_MONTH)>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)>=1) {
////			return false;
////		}
////		return true;
////	}
//
//	@SuppressWarnings("deprecation")
//	public boolean rangBuocDatSauGioHienTai() throws ParseException {
//		Date date = new Date();
//		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat = null;
//		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		dateTime = sp.format(txtNgayHat.getDate()) + " " + chuyen24h();
//		if (dateFormat.parse(dateTime).getHours() - date.getHours() <1&&dateFormat.parse(dateTime).getMinutes() - date.getMinutes()<=0
//				&& dateFormat.parse(dateTime).getDay() - date.getDay() == 0) {
//			return false;
//		}
//		return true;
//	}
//	public void loadDatatoCboKH() {
//		List<KhachHang> ls = new KhachHang_dao().getDanhSachKhachHang();
//		for (KhachHang khachHang : ls) {
//			cboKhachHang.addItem(khachHang.getHoKH() + " " + khachHang.getTenKH());
//		}
//	}
//	public String chuyen24h() {
//		String b = timePicker.getSelectedTime();
//		String hour = b.substring(0, b.indexOf(":"));
//		String min = b.substring(b.indexOf(":") + 1);
//		String minNoAa = min.substring(0, min.indexOf(" "));
//		int hourInt = Integer.parseInt(hour);
//		String regex = ".*P.*";
//		if (kiemTraNhap(b, regex)) {
//			hourInt = hourInt + 12;
//		}
//		return hourInt + ":" + minNoAa;
//	}
//	public boolean kiemTraNhap(String input, String patternStr) {
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher macth = pattern.matcher(input);
//		return macth.matches();
//	}
//	@SuppressWarnings("static-access")
//	public boolean rangBuocNgayDat() {
//		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String date =  sp.format(txtNgayHat.getDate());
//		String year = date.substring(0, date.indexOf("-"));
//		String mon = date.substring(date.indexOf("-")+1);
//		String month = mon.substring(0, mon.indexOf("-"));
//		String day = mon.substring(3);	
//		int yearInt = Integer.parseInt(year);
//		int monthInt = Integer.parseInt(month)-1;
//		int dayOfMonthInt = Integer.parseInt(day);
//		Calendar c = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//		c.set(yearInt, monthInt, dayOfMonthInt);
//		if (txtNgayHat.getDate() == null) {
//			return false;
//		} else if (c.get(c.DAY_OF_MONTH)-java.time.LocalDate.now().getDayOfMonth()>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)==0) {	
//			return false;
//		}else if(c.get(c.DAY_OF_MONTH)>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)>=1) {
//			return false;
//		}
//		return true;
//	}
//}
