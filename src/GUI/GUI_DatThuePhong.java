////Huỳnh Hữu Phước
//package GUI;
//
//import java.awt.Color;
//import java.awt.Component;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.MatteBorder;
//import javax.swing.table.DefaultTableModel;
//
//import dao.HoaDon_SanPhamDV_dao;
//import dao.KhachHang_dao;
//import dao.Phong_dao;
//import dao.SanPhamDV_dao;
//import dao.ThongTinDat_dao;
//import dao.ThongTinSuDungPhong_dao;
//import entity.HoaDon_SanPhamDV;
//import entity.KhachHang;
//import entity.Phong;
//import entity.SanPhamDV;
//import entity.ThongTinDat;
//import entity.ThongTinSuDungPhong;
//import entity.ThongTinTaiKhoan;
//
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.TimeZone;
//
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import java.awt.GridLayout;
//
//import javax.swing.BorderFactory;
//import javax.swing.JSlider;
//import javax.swing.border.TitledBorder;
//import javax.swing.JComboBox;
//import java.awt.event.ItemListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.awt.SystemColor;
//import javax.swing.JButton;
//import javax.swing.SwingConstants;
//import javax.swing.ScrollPaneConstants;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import javax.swing.event.ChangeListener;
//import javax.swing.event.ChangeEvent;
//
//public class GUI_DatThuePhong extends JFrame implements ActionListener {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	public static JPanel pnDatThuePhong;
//	public static JTextField txtMaPhong;
//	public static JTextField txtGioVao;
//	public static JTextField txtKhachHang;
//	private JPanel pnDanhSachPhong;
//	private JLabel lblLoaiPhong;
//	public static JTextField txtLoaiPhong;
//	private JLabel lblGia;
//	public static JTextField txtGia;
//	private JLabel lblLoaiPhongTimKiem;
//	public static JSlider slSucChua;
//	public static JPanel pnPhong;
//	private static JComboBox<String> cboLoaiPhong;
//	public static JComboBox<String> cboSapXep;
//	public static ArrayList<Phong> list;
//	public static JTextField txtTrangThai;
//	private static Phong_dao phong_dao = new Phong_dao();
//	private static ThongTinTaiKhoan tttk;
//	public static JLabel lblKhachhang;
//	public static JLabel lblGioVao;
//	private static String day = java.time.LocalDate.now().getDayOfMonth() + "";
//	private static DefaultTableModel dtmDSSP;
//	private JTextField txtSdt;
//	private JLabel lblSdt;
//	private static List<ThongTinDat> ls;
//	private static Boolean b = true;
//	@SuppressWarnings("unused")
//	private static int dayOfMonthInt;
//
//
//	/**
//	 * Create the frame.
//	 */
//	@SuppressWarnings("deprecation")
//	public GUI_DatThuePhong(ThongTinTaiKhoan tttk) {
//		GUI_DatThuePhong.tttk = tttk;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1090, 640);
//		pnDatThuePhong = new JPanel();
//		pnDatThuePhong.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(pnDatThuePhong);
//		pnDatThuePhong.setLayout(null);
//		setResizable(false);
//
//		list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
//
//		JPanel pnThongTin = new JPanel();
//		pnThongTin.setBounds(0, 0, 882, 180);
//		pnDatThuePhong.add(pnThongTin);
//		pnThongTin.setLayout(null);
//		pnThongTin.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông Tin Phòng Hát"));
//
//		JLabel lblMaPhong = new JLabel("Mã phòng:");
//		lblMaPhong.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblMaPhong.setBounds(20, 12, 66, 24);
//		pnThongTin.add(lblMaPhong);
//
//		txtMaPhong = new JTextField();
//		txtMaPhong.setForeground(Color.RED);
//		txtMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		txtMaPhong.setBounds(106, 12, 96, 19);
//		pnThongTin.add(txtMaPhong);
//		txtMaPhong.setColumns(10);
//
//		lblGioVao = new JLabel("Giờ vào:");
//		lblGioVao.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblGioVao.setBounds(232, 12, 61, 24);
//		pnThongTin.add(lblGioVao);
//
//		txtGioVao = new JTextField();
//		txtGioVao.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		txtGioVao.setBounds(303, 12, 147, 19);
//		pnThongTin.add(txtGioVao);
//		txtGioVao.setColumns(10);
//
//		lblKhachhang = new JLabel("Khách hàng sử dụng:");
//		lblKhachhang.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblKhachhang.setBounds(488, 12, 147, 24);
//		pnThongTin.add(lblKhachhang);
//
//		txtKhachHang = new JTextField();
//		txtKhachHang.setFont(new Font("Constantia", Font.BOLD, 13));
//		txtKhachHang.setBounds(630, 12, 237, 19);
//		pnThongTin.add(txtKhachHang);
//		txtKhachHang.setColumns(10);
//		pnThongTin.setBackground(Color.WHITE);
//
//		lblLoaiPhong = new JLabel("Loại phòng:");
//		lblLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblLoaiPhong.setBounds(20, 44, 80, 24);
//		pnThongTin.add(lblLoaiPhong);
//
//		txtLoaiPhong = new JTextField();
//		txtLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
//		txtLoaiPhong.setBounds(106, 44, 96, 19);
//		pnThongTin.add(txtLoaiPhong);
//		txtLoaiPhong.setColumns(10);
//
//		lblGia = new JLabel("Giá/giờ:");
//		lblGia.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblGia.setBounds(232, 44, 61, 24);
//		pnThongTin.add(lblGia);
//
//		txtGia = new JTextField();
//		txtGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		txtGia.setBounds(303, 44, 147, 19);
//		pnThongTin.add(txtGia);
//		txtGia.setColumns(10);
//
//		pnDanhSachPhong = new JPanel();
//		pnDanhSachPhong.setBounds(0, 184, 1076, 419);
//		pnDatThuePhong.add(pnDanhSachPhong);
//		pnDanhSachPhong.setLayout(null);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 0, 1076, 409);
//		pnDanhSachPhong.add(scrollPane);
//
//		pnPhong = new JPanel();
//		pnPhong.setBackground(SystemColor.control);
//		scrollPane.setViewportView(pnPhong);
//		pnPhong.setLayout(new GridLayout(0, 6, 15, 10));
//
//		txtMaPhong.setOpaque(false);
//		txtMaPhong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//		txtGioVao.setOpaque(false);
//		txtGioVao.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//		txtGia.setOpaque(false);
//		txtGia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//		txtLoaiPhong.setOpaque(false);
//		txtLoaiPhong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//		txtKhachHang.setOpaque(false);
//		txtKhachHang.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//
//		JLabel lblTrangThai = new JLabel("Trạng thái:");
//		lblTrangThai.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblTrangThai.setBounds(488, 44, 80, 24);
//		pnThongTin.add(lblTrangThai);
//
//		txtTrangThai = new JTextField();
//		txtTrangThai.setOpaque(false);
//		txtTrangThai.setFont(new Font("Constantia", Font.BOLD, 13));
//		txtTrangThai.setColumns(10);
//		txtTrangThai.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
//		txtTrangThai.setBounds(578, 46, 96, 19);
//		pnThongTin.add(txtTrangThai);
//
//		JPanel pnTacVu = new JPanel();
//		pnTacVu.setBackground(Color.WHITE);
//		pnTacVu.setBorder((new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tìm kiếm và sắp xếp")));
//		pnTacVu.setBounds(880, 0, 196, 180);
//		pnDatThuePhong.add(pnTacVu);
//		pnTacVu.setLayout(null);
//
//		slSucChua = new JSlider();
//		slSucChua.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		slSucChua.setSnapToTicks(true);
//		slSucChua.setPaintLabels(true);
//		slSucChua.setMinorTickSpacing(5);
//		slSucChua.setBackground(Color.WHITE);
//		slSucChua.setMajorTickSpacing(5);
//		slSucChua.setValue(25);
//		slSucChua.setMaximum(25);
//		slSucChua.setMinimum(10);
//		slSucChua.setBounds(82, 60, 105, 35);
//		pnTacVu.add(slSucChua);
//
//		JLabel lblSucChua = new JLabel("Sức chứa:");
//		lblSucChua.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblSucChua.setBounds(11, 66, 64, 20);
//		pnTacVu.add(lblSucChua);
//
//		lblLoaiPhongTimKiem = new JLabel("Loại:");
//		lblLoaiPhongTimKiem.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblLoaiPhongTimKiem.setBounds(11, 21, 45, 20);
//		pnTacVu.add(lblLoaiPhongTimKiem);
//
//		cboLoaiPhong = new JComboBox<String>();
//		cboLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
//		cboLoaiPhong.setBackground(Color.WHITE);
//		cboLoaiPhong.setBounds(56, 19, 130, 21);
//		pnTacVu.add(cboLoaiPhong);
//
//		JLabel lblSapXep = new JLabel("Lọc:");
//		lblSapXep.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblSapXep.setBounds(11, 96, 45, 20);
//		pnTacVu.add(lblSapXep);
//
//		cboSapXep = new JComboBox<String>();
//		cboSapXep.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
//				ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
//				if (e.getItem() == "Phòng trống") {
//					txtSdt.hide();
//					lblSdt.hide();
//					for (ThongTinDat thongTinDat : ls) {
//						for (int i = 0; i < list.size(); i++) {
//							{
//								if (thongTinDat.getMaPh().equalsIgnoreCase(list.get(i).getMaPhong())
//										&& thongTinDat.getThoiGianDat().getHours()
//												- java.time.LocalTime.now().getHour() < 3
//										&& thongTinDat.getThoiGianDat().getHours()
//												- java.time.LocalTime.now().getHour() >= 0) {
//									list.remove(i);
//								}
//							}
//						}
//					}
//					scrDSSPTrongPhong.show();
//					lblGioVao.setText("Giờ vào: ");
//					lblKhachhang.setText("Khách hàng sử dụng: ");
//					txtGioVao.setText("");
//					txtKhachHang.setText("");
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//
//						for (Phong pTest : list) {
//							if (pTest.isTrangThai() == false && pTest.isLoaiPhong() == false) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 4; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					} else {
//						for (Phong pTest : list) {
//							if (pTest.isTrangThai() == false && pTest.isLoaiPhong() == true) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 4; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//				} else if (e.getItem() == "Phòng đang sử dụng") {
//					txtSdt.show();
//					lblSdt.show();
//					scrDSSPTrongPhong.show();
//					lblGioVao.setText("Giờ vào: ");
//					lblKhachhang.setText("Khách hàng sử dụng: ");
//					txtGioVao.setText("");
//					txtKhachHang.setText("");
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboLoaiPhong.getSelectedItem() == "Phòng VIP") {
//						for (Phong pTest : new Phong_dao().getDanhSachPhong()) {
//							if (pTest.isTrangThai() == true && pTest.isLoaiPhong() == true) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//
//					} else {
//						for (Phong pTest : new Phong_dao().getDanhSachPhong()) {
//							if (pTest.isTrangThai() == true && pTest.isLoaiPhong() == false) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//
//				} else {
//					for (ThongTinDat thongTinDat : ls) {
//						if (java.time.LocalDateTime.now().getHour() - thongTinDat.getThoiGianDat().getHours() >= 1) {
//							new ThongTinDat_dao().deleteThongTinDatPhong(thongTinDat.getMaPh(), thongTinDat.getMaKH(),
//									day);
//						}
//					}
//					txtSdt.show();
//					lblSdt.show();
//					scrDSSPTrongPhong.hide();
//					loadLaiDanhSachPhongDaDat();
//				}
//			}
//		});
//		cboSapXep.setFont(new Font("Constantia", Font.BOLD, 11));
//		cboSapXep.setBackground(Color.WHITE);
//		cboSapXep.setBounds(11, 116, 175, 21);
//		pnTacVu.add(cboSapXep);
//
//		txtSdt = new JTextField();
//		txtSdt.setFont(new Font("Times New Roman", Font.BOLD, 13));
//		txtSdt.addKeyListener(new KeyAdapter() {
//			private int dayOfMonthInt;
//
//			@SuppressWarnings("static-access")
//			@Override
//			public void keyReleased(KeyEvent e) {
//				Component[] components = pnPhong.getComponents();
//				for (Component component : components) {
//					pnPhong.remove(component);
//				}
//				pnPhong.revalidate();
//				pnPhong.repaint();
//				if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng"
//						|| cboSapXep.getSelectedItem() == "Phòng đã đặt") {
//					if (txtSdt.getText().length() == 10) {
//						if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//							KhachHang k = new KhachHang_dao().getKHTheoSDT(txtSdt.getText());
//							if (k != null) {
//								List<ThongTinSuDungPhong> ls = new ThongTinSuDungPhong_dao()
//										.getDanhSachPhongDangSuDungTheoMaKH(k.getMaKH());
//								for (ThongTinSuDungPhong thongTinSuDungPhong : ls) {
//									for (Phong pTest : new Phong_dao()
//											.getDanhSachPhongTrongTheoMa(thongTinSuDungPhong.getMaPh())) {
//										if (pTest.isTrangThai() == true) {
//											pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//										}
//									}
//								}for (int i = 0; i <= 5; i++) {
//									pnPhong.add(new GUI_PhongTrong().PhongNull());
//								}
//							}
//						} else {
//							SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//							java.util.Date date = new java.util.Date();
//							String dateStr = sp.format(date);
//							String year = dateStr.substring(0, dateStr.indexOf("-"));
//							String mon = dateStr.substring(dateStr.indexOf("-") + 1);
//							String month = mon.substring(0, mon.indexOf("-"));
//							String day = dateStr.substring(dateStr.indexOf("-") + 4);
//							int yearInt = Integer.parseInt(year);
//							int monthInt = Integer.parseInt(month) - 1;
//							if (lblNgayDat.getText() == "Hôm nay") {
//								dayOfMonthInt = Integer.parseInt(day);
//							} else {
//								dayOfMonthInt = Integer.parseInt(day) + 1;
//							}
//							Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//							calendar.set(yearInt, monthInt, dayOfMonthInt);
//							KhachHang k = new KhachHang_dao().getKHTheoSDT(txtSdt.getText());
//							if (k != null) {
//								List<ThongTinDat> ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgayVaMaKH(calendar.get(calendar.DAY_OF_MONTH)+"", k.getMaKH());
//								for (ThongTinDat thongTinDat : ls) {
//									for (Phong pTest : phong_dao.getDanhSachPhongTrongTheoMa(thongTinDat.getMaPh())) {
//										GUI_PhongDatDanhSach pdds = new GUI_PhongDatDanhSach(pTest, tttk,
//												calendar.get(Calendar.DAY_OF_MONTH) + "");
//										pnPhong.add(pdds.DanhSachPhong());
//										pdds.setNut(true);
//									}
//
//								}
//								for (int i = 0; i <= 5; i++) {
//									pnPhong.add(new GUI_PhongTrong().PhongNull());
//								}
//							}
//						}
//					} else if (txtSdt.getText().length() == 0) {
//						if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//							loadDanhSachPhongDangSuDung();
//						} else {
//							loadLaiDanhSachPhongDaDat();
//						}
//					}
//				}
//			}
//		});
//		txtSdt.setBounds(49, 147, 137, 19);
//		pnTacVu.add(txtSdt);
//		txtSdt.setColumns(10);
//
//		lblSdt = new JLabel("SĐT");
//		lblSdt.setFont(new Font("Constantia", Font.BOLD, 13));
//		lblSdt.setBounds(11, 150, 45, 20);
//		pnTacVu.add(lblSdt);
//
//		cboLoaiPhong.addItem("Phòng thường");
//		cboLoaiPhong.addItem("Phòng VIP");
//		cboSapXep.addItem("Phòng trống");
//		cboSapXep.addItem("Phòng đang sử dụng");
//		cboSapXep.addItem("Phòng đã đặt");
//		cboLoaiPhong.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
//				list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
//				if (cboSapXep.getSelectedItem() != "Phòng đã đặt") {
//					for (ThongTinDat thongTinDat : ls) {
//						for (int i = 0; i < list.size(); i++) {
//							{
//								if (thongTinDat.getMaPh().equalsIgnoreCase(list.get(i).getMaPhong())
//										&& thongTinDat.getThoiGianDat().getHours()
//												- java.time.LocalTime.now().getHour() < 3
//										&& thongTinDat.getThoiGianDat().getHours()
//												- java.time.LocalTime.now().getHour() >= 0) {
//									list.remove(i);
//								}
//							}
//						}
//					}
//				}
//				if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboSapXep.getSelectedItem() == "Phòng trống") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == false
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					} else if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == true
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//				} 
//				else if(cboLoaiPhong.getSelectedItem()=="Phòng VIP") {
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboSapXep.getSelectedItem() == "Phòng trống") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == false
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					} else if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == true
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//
//				}
//			}
//		});
//		slSucChua.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
//				list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
//				for (ThongTinDat thongTinDat : ls) {
//					for (int i = 0; i < list.size(); i++) {
//						{
//							if (thongTinDat.getMaPh().equalsIgnoreCase(list.get(i).getMaPhong())
//									&& thongTinDat.getThoiGianDat().getHours() - java.time.LocalTime.now().getHour() < 3
//									&& thongTinDat.getThoiGianDat().getHours()
//											- java.time.LocalTime.now().getHour() >= 0) {
//								list.remove(i);
//							}
//						}
//					}
//				}
//				if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboSapXep.getSelectedItem() == "Phòng trống") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == false
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					} else if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == true
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//				} else if (cboLoaiPhong.getSelectedItem() == "Phòng VIP") {
//					Component[] components = pnPhong.getComponents();
//					for (Component component : components) {
//						pnPhong.remove(component);
//					}
//					pnPhong.revalidate();
//					pnPhong.repaint();
//					if (cboSapXep.getSelectedItem() == "Phòng trống") {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == false
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					} else {
//						for (Phong pTest : list) {
//							if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == true
//									&& pTest.getSucChua() <= slSucChua.getValue()) {
//								pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//							}
//
//						}
//						for (int i = 0; i <= 5; i++) {
//							pnPhong.add(new GUI_PhongTrong().PhongNull());
//						}
//					}
//				}
//			}
//
//		});
////		set speed of scrollPane
//		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
//	}
//
//	public Component tabDatThuePhong() {
//		return pnDatThuePhong;
//	}
//
//	@SuppressWarnings("deprecation")
//	public static void loadDanhSachPhongTrong() {
//		ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
//		list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
//		for (ThongTinDat thongTinDat : ls) {
//			for (int i = 0; i < list.size(); i++) {
//				{
//					if (thongTinDat.getMaPh().equalsIgnoreCase(list.get(i).getMaPhong())
//							&& thongTinDat.getThoiGianDat().getHours() - java.time.LocalTime.now().getHour() < 3
//							&& thongTinDat.getThoiGianDat().getHours() - java.time.LocalTime.now().getHour() >= 0) {
//						list.remove(i);
//					}
//				}
//			}
//		}
//		if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
//			Component[] components = pnPhong.getComponents();
//			for (Component component : components) {
//				pnPhong.remove(component);
//			}
//			pnPhong.revalidate();
//			pnPhong.repaint();
//			if (cboSapXep.getSelectedItem() == "Phòng trống") {
//				for (Phong pTest : list) {
//					if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == false
//							&& pTest.getSucChua() <= slSucChua.getValue()) {
//						pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//					}
//				}
//				for (int i = 0; i <= 5; i++) {
//					pnPhong.add(new GUI_PhongTrong().PhongNull());
//				}
//			} else if (cboSapXep.getSelectedItem() == "Phòng đang sử dụng") {
//				for (Phong pTest : list) {
//					if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == true
//							&& pTest.getSucChua() <= slSucChua.getValue()) {
//						pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//					}
//
//				}
//				for (int i = 0; i <= 5; i++) {
//					pnPhong.add(new GUI_PhongTrong().PhongNull());
//				}
//			}
//		} else {
//			Component[] components = pnPhong.getComponents();
//			for (Component component : components) {
//				pnPhong.remove(component);
//			}
//			pnPhong.revalidate();
//			pnPhong.repaint();
//			if (cboSapXep.getSelectedItem() == "Phòng trống") {
//				for (Phong pTest : list) {
//					if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == false
//							&& pTest.getSucChua() <= slSucChua.getValue()) {
//						pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//					}
//
//				}
//				for (int i = 0; i <= 5; i++) {
//					pnPhong.add(new GUI_PhongTrong().PhongNull());
//				}
//			} else {
//				for (Phong pTest : list) {
//					if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == true
//							&& pTest.getSucChua() <= slSucChua.getValue()) {
//						pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//					}
//
//				}
//				for (int i = 0; i <= 5; i++) {
//					pnPhong.add(new GUI_PhongTrong().PhongNull());
//				}
//			}
//		}
//	}
//
//	public static void loadDanhSachPhongDangSuDung() {
//		Component[] components = pnPhong.getComponents();
//		for (Component component : components) {
//			pnPhong.remove(component);
//		}
//		pnPhong.revalidate();
//		pnPhong.repaint();
//		if (cboLoaiPhong.getSelectedItem() == "Phòng VIP") {
//			for (Phong pTest : new Phong_dao().getDanhSachPhong()) {
//				if (pTest.isTrangThai() == true && pTest.isLoaiPhong() == true) {
//					pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//				}
//			}
//			for (int i = 0; i <= 5; i++) {
//				pnPhong.add(new GUI_PhongTrong().PhongNull());
//			}
//
//		} else {
//			for (Phong pTest : new Phong_dao().getDanhSachPhong()) {
//				if (pTest.isTrangThai() == true && pTest.isLoaiPhong() == false) {
//					pnPhong.add(new GUI_PhongDanhSach(pTest, tttk).DanhSachPhong());
//				}
//
//			}
//			for (int i = 0; i <= 5; i++) {
//				pnPhong.add(new GUI_PhongTrong().PhongNull());
//			}
//		}
//	}
//
//	public static void loadData(String maPh, String loaiPhong, String giaVe, String trangThai, String Gio, String KH) {
//		txtMaPhong.setText(maPh);
//		txtLoaiPhong.setText(loaiPhong);
//		txtGia.setText(giaVe);
//		txtTrangThai.setText(trangThai);
//		txtGioVao.setText(Gio);
//		txtKhachHang.setText(KH);
//	}
//
//	public static void removePhongDat() {
//		btnNext.setEnabled(false);
//		btnPre.setEnabled(true);
//		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = new java.util.Date();
//		String dateStr = sp.format(date);
//		String year = dateStr.substring(0, dateStr.indexOf("-"));
//		String mon = dateStr.substring(dateStr.indexOf("-") + 1);
//		String month = mon.substring(0, mon.indexOf("-"));
//		String day = dateStr.substring(dateStr.indexOf("-") + 4);
//		int yearInt = Integer.parseInt(year);
//		int monthInt = Integer.parseInt(month) - 1;
//		int dayOfMonthInt;
//		if (btnNext.isEnabled() == true) {
//			dayOfMonthInt = Integer.parseInt(day) + 1;
//		} else {
//			dayOfMonthInt = Integer.parseInt(day);
//		}
//		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//		calendar.set(yearInt, monthInt, dayOfMonthInt);
//		Component[] components = pnPhong.getComponents();
//		for (Component component : components) {
//			pnPhong.remove(component);
//		}
//		pnPhong.revalidate();
//		pnPhong.repaint();
//		ThongTinDat_dao ttd_d = new ThongTinDat_dao();
//		List<String> dsMaPhong = new ArrayList<String>();
//		for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
//			if (dsMaPhong.size() == 0) {
//				dsMaPhong.add(ttd.getMaPh());
//			} else if (dsMaPhong.size() > 0) {
//				for (int i = 0; i < dsMaPhong.size(); i++) {
//					if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
//						b = false;
//						break;
//					}
//					b = true;
//				}
//				if (b) {
//					dsMaPhong.add(ttd.getMaPh());
//				}
//			}
//		}
//		for (String ma : dsMaPhong) {
//			for (Phong pTest : phong_dao.getDanhSachPhongTrongTheoMa(ma)) {
//				pnPhong.add(new GUI_PhongDatDanhSach(pTest, tttk, calendar.get(Calendar.DAY_OF_MONTH) + "")
//						.DanhSachPhong());
//			}
//		}
//		for (int i = 0; i <= 5; i++) {
//			pnPhong.add(new GUI_PhongTrong().PhongNull());
//		}
//	}
//
//	@SuppressWarnings({ "deprecation", "null" })
//	public static void loadLaiDanhSachPhongDaDat() {
//		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = new java.util.Date();
//		String dateStr = sp.format(date);
//		String year = dateStr.substring(0, dateStr.indexOf("-"));
//		String mon = dateStr.substring(dateStr.indexOf("-") + 1);
//		String month = mon.substring(0, mon.indexOf("-"));
//		String day = dateStr.substring(dateStr.indexOf("-") + 4);
//		int yearInt = Integer.parseInt(year);
//		int monthInt = Integer.parseInt(month) - 1;
//		int dayOfMonthInt = Integer.parseInt(day);
//		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//		calendar.set(yearInt, monthInt, dayOfMonthInt);
//		Component[] components = pnPhong.getComponents();
//		for (Component component : components) {
//			pnPhong.remove(component);
//		}
//		pnPhong.revalidate();
//		pnPhong.repaint();
//		ThongTinDat_dao ttd_d = new ThongTinDat_dao();
//		List<String> dsMaPhong = new ArrayList<String>();
//		for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
//			if (dsMaPhong.size() == 0) {
//				dsMaPhong.add(ttd.getMaPh());
//			} else if (dsMaPhong.size() > 0) {
//				for (int i = 0; i < dsMaPhong.size(); i++) {
//					if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
//						b = false;
//						break;
//					}
//					b = true;
//				}
//				if (b) {
//					dsMaPhong.add(ttd.getMaPh());
//				}
//			}
//		}
//		for (String ma : dsMaPhong) {
//			for (Phong pTest : phong_dao.getDanhSachPhongTrongTheoMa(ma)) {
//				GUI_PhongDatDanhSach pdds = new GUI_PhongDatDanhSach(pTest, tttk,
//						calendar.get(Calendar.DAY_OF_MONTH) + "");
//				pnPhong.add(pdds.DanhSachPhong());
//				pdds.setNut(true);
//			}
//		}
//		for (int i = 0; i <= 5; i++) {
//			pnPhong.add(new GUI_PhongTrong().PhongNull());
//
//		}
//	}
//
//	public boolean checkNgay() {
//		if (lblNgayDat.getText() == "Hôm nay") {
//			return true;
//		}
//		return false;
//	}
//
//	@SuppressWarnings("static-access")
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if (o.equals(btnNext)) {
//			lblNgayDat.setText("Ngày mai");
//			btnNext.setEnabled(false);
//			btnPre.setEnabled(true);
//			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date date = new java.util.Date();
//			String dateStr = sp.format(date);
//			String year = dateStr.substring(0, dateStr.indexOf("-"));
//			String mon = dateStr.substring(dateStr.indexOf("-") + 1);
//			String month = mon.substring(0, mon.indexOf("-"));
//			String day = dateStr.substring(dateStr.indexOf("-") + 4);
//			int yearInt = Integer.parseInt(year);
//			int monthInt = Integer.parseInt(month) - 1;
//			int dayOfMonthInt = Integer.parseInt(day) + 1;
//			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//			calendar.set(yearInt, monthInt, dayOfMonthInt);
//			Component[] components = pnPhong.getComponents();
//			for (Component component : components) {
//				pnPhong.remove(component);
//			}
//			pnPhong.revalidate();
//			pnPhong.repaint();
//			ThongTinDat_dao ttd_d = new ThongTinDat_dao();
//			List<String> dsMaPhong = new ArrayList<String>();
//			for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH) + "")) {
//				if (dsMaPhong.size() == 0) {
//					dsMaPhong.add(ttd.getMaPh());
//				} else if (dsMaPhong.size() > 0) {
//					System.out.println(dsMaPhong.size());
//					for (int i = 0; i < dsMaPhong.size(); i++) {
//						if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
//							b = false;
//							break;
//						}
//						b = true;
//					}
//					if (b) {
//						dsMaPhong.add(ttd.getMaPh());
//					}
//				}
//			}
//			for (String ma : dsMaPhong) {
//				for (Phong pTest : phong_dao.getDanhSachPhongTrongTheoMa(ma)) {
//					GUI_PhongDatDanhSach gui_pdsd = new GUI_PhongDatDanhSach(pTest, tttk,
//							calendar.get(Calendar.DAY_OF_MONTH) + "");
//					pnPhong.add(gui_pdsd.DanhSachPhong());
//					gui_pdsd.setNut(false);
//				}
//			}
//			for (int i = 0; i <= 5; i++) {
//				pnPhong.add(new GUI_PhongTrong().PhongNull());
//			}
//
//		} else if (o.equals(btnPre)) {
//			btnNext.setEnabled(true);
//			btnPre.setEnabled(false);
//			lblNgayDat.setText("Hôm nay");
//			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date date = new java.util.Date();
//			String dateStr = sp.format(date);
//			String year = dateStr.substring(0, dateStr.indexOf("-"));
//			String mon = dateStr.substring(dateStr.indexOf("-") + 1);
//			String month = mon.substring(0, mon.indexOf("-"));
//			String day = dateStr.substring(dateStr.indexOf("-") + 4);
//			int yearInt = Integer.parseInt(year);
//			int monthInt = Integer.parseInt(month) - 1;
//			int dayOfMonthInt = Integer.parseInt(day);
//			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
//			calendar.set(yearInt, monthInt, dayOfMonthInt);
//			Component[] components = pnPhong.getComponents();
//			for (Component component : components) {
//				pnPhong.remove(component);
//			}
//			pnPhong.revalidate();
//			pnPhong.repaint();
//			ThongTinDat_dao ttd_d = new ThongTinDat_dao();
//			List<String> dsMaPhong = new ArrayList<String>();
//			for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
//				if (dsMaPhong.size() == 0) {
//					dsMaPhong.add(ttd.getMaPh());
//				} else if (dsMaPhong.size() > 0) {
//					for (int i = 0; i < dsMaPhong.size(); i++) {
//						if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
//							b = false;
//							break;
//						}
//						b = true;
//					}
//					if (b) {
//						dsMaPhong.add(ttd.getMaPh());
//					}
//				}
//			}
//			for (String ma : dsMaPhong) {
//				for (Phong pTest : phong_dao.getDanhSachPhongTrongTheoMa(ma)) {
//					GUI_PhongDatDanhSach pdds = new GUI_PhongDatDanhSach(pTest, tttk,
//							calendar.get(Calendar.DAY_OF_MONTH) + "");
//					pnPhong.add(pdds.DanhSachPhong());
//					pdds.setNut(true);
//				}
//			}
//			for (int i = 0; i <= 5; i++) {
//				pnPhong.add(new GUI_PhongTrong().PhongNull());
//
//			}
//		}
//	}
//
//	public static void addRow(SanPhamDV sp, int sl, int i) {
//		String thanhTien = (sp.getDonGia() * sl) + "";
//		String[] a = { i + "", sp.getTenDV(), sl + "", sp.getDonGia() + " VNĐ", thanhTien + " VNĐ " };
//		dtmDSSP.addRow(a);
//	}
//
//	public static void loadDB(String maHD, boolean b) {
//		dtmDSSP.setRowCount(0);
//		if (b) {
//			int i = 1;
//			List<HoaDon_SanPhamDV> hdsp = new HoaDon_SanPhamDV_dao().getDanhSachTheoMaHD(maHD);
//			for (HoaDon_SanPhamDV hoaDon_SanPhamDV : hdsp) {
//				SanPhamDV sp = new SanPhamDV();
//				try {
//					sp = new SanPhamDV_dao().getSanPhamTheoMa(hoaDon_SanPhamDV.getMaDV());
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				addRow(sp, hoaDon_SanPhamDV.getSoLuong(), i++);
//			}
//		}
//	}
//}
