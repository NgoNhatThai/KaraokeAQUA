package GUI;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import dao.KhachHang_dao;
import dao.Phong_dao;
import dao.ThongTinDat_dao;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinDat;
import entity.ThongTinTaiKhoan;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.raven.swing.TimePicker;
import java.awt.event.HierarchyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class GUI_DatPhong2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtSdt;
	public static JPanel pnDanhSach;
	private static List<ThongTinDat> ls;
	private static String day = java.time.LocalDate.now().getDayOfMonth() + "";
	public static ArrayList<Phong> list;
	private static ThongTinTaiKhoan tttk;
	private boolean m;
	private static SimpleDateFormat dateFormat;
	private static JDateChooser txtNgayHat;
	@SuppressWarnings("static-access")
	private List<Phong> lsPhong = (ArrayList<Phong>) new Phong_dao().getDanhSachPhongTrongTheoLoai(false);
	public static JComboBox<String> cboLoaiPhong;
	private boolean n;
	private static JLabel lblGioDat;
	private static TimePicker timePicker;
	private static JComboBox<String> cboKhachHang;
	private static Date at;
	private static JButton btnPre;
	private static JButton btnNext;
	private JLabel lblTitle;
	private static String dateTime;
	private static boolean b;
	private static ThongTinDat ttd;
	private static String maKH;
	private static String sdtKH;
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public GUI_DatPhong2(ThongTinTaiKhoan tttk) throws ParseException {
		this.tttk = tttk;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		timePicker = new TimePicker();
		timePicker.setBounds(-1111, 0, 247, 351);
		contentPane.add(timePicker);
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông Tin Đặt Phòng"));
		pnThongTin.setBackground(Color.WHITE);
		pnThongTin.setBounds(0, 0, 883, 98);
		contentPane.add(pnThongTin);
		pnThongTin.setLayout(null);
		
		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setFont(new Font("Constantia", Font.BOLD, 14));
		lblSdt.setBounds(10, 60, 94, 22);
		pnThongTin.add(lblSdt);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtSdt.setColumns(10);
		txtSdt.setBounds(133, 58, 230, 20);
		pnThongTin.add(txtSdt);
		
		JLabel lblKhachHang = new JLabel("Khách hàng:");
		lblKhachHang.setFont(new Font("Constantia", Font.BOLD, 14));
		lblKhachHang.setBounds(411, 58, 94, 22);
		pnThongTin.add(lblKhachHang);
		
		cboKhachHang = new JComboBox<String>();
		cboKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cboKhachHang.setBackground(Color.WHITE);
		cboKhachHang.setBounds(529, 56, 289, 21);
		pnThongTin.add(cboKhachHang);
		
		JButton btnThem = new JButton("+");
		btnThem.setToolTipText("Thêm khách hàng mới");
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(828, 54, 45, 30);
		pnThongTin.add(btnThem);
		
		JLabel lblNgayHat = new JLabel("Ngày hát:");
		lblNgayHat.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNgayHat.setBounds(411, 24, 82, 20);
		pnThongTin.add(lblNgayHat);
		
		JLabel lblGiohat = new JLabel("Giờ đặt:");
		lblGiohat.setFont(new Font("Constantia", Font.BOLD, 14));
		lblGiohat.setBounds(10, 26, 94, 20);
		pnThongTin.add(lblGiohat);
		
		lblGioDat = new JLabel("00:00");
		lblGioDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timePicker.showPopup(contentPane, 360, 0);
			}
		});
		lblGioDat.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		lblGioDat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGioDat.setBounds(133, 26, 94, 20);
		pnThongTin.add(lblGioDat);
		
		timePicker.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				String aa;
				String hour = chuyen24h().substring(0, chuyen24h().indexOf(":"));
				int hourInt = Integer.parseInt(hour);
				if(hourInt>=0&&hourInt<12) {
					aa=" AM";
				}
				else {
					aa=" PM";
				}
				lblGioDat.setText(chuyen24h()+aa);
			}
		});
		
		JPanel pntacvu = new JPanel();
		pntacvu.setBackground(Color.WHITE);
		pntacvu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Sắp xếp"));
		pntacvu.setBounds(881, 0, 185, 98);
		contentPane.add(pntacvu);
		pntacvu.setLayout(null);
		
		JLabel lblLoaiPhongTimKiem = new JLabel("Loại:");
		lblLoaiPhongTimKiem.setFont(new Font("Constantia", Font.BOLD, 13));
		lblLoaiPhongTimKiem.setBounds(10, 40, 45, 20);
		pntacvu.add(lblLoaiPhongTimKiem);
		
		cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
		cboLoaiPhong.setBackground(Color.WHITE);
		cboLoaiPhong.setBounds(56, 40, 119, 21);
		pntacvu.add(cboLoaiPhong);
		
		JPanel pnDanhSachPhong = new JPanel();
		pnDanhSachPhong.setLayout(null);
		pnDanhSachPhong.setBounds(0, 136, 1066, 467);
		contentPane.add(pnDanhSachPhong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1066, 437);
		pnDanhSachPhong.add(scrollPane);
		
		pnDanhSach = new JPanel();
		scrollPane.setViewportView(pnDanhSach);
		pnDanhSach.setLayout(new GridLayout(0, 6, 15, 25));
		txtNgayHat = new JDateChooser();

		txtNgayHat.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
							if(rangBuocNgayDat()) {
								try {
									loadDanhSachPhong();
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Không thể đặt trước quá 1 ngày hoặc trước ngày hiện tại");
								try {
									 at = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now()+"");
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								txtNgayHat.setDate(at);
							}
			            }
			        }
			    });
		
		Date at =new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now()+"");
		txtNgayHat.setDate(at);
		txtNgayHat.setDateFormatString("dd-MM-yyyy");
		txtNgayHat.setBounds(529, 24, 231, 19);
		pnThongTin.add(txtNgayHat);
		
		lblTitle = new JLabel("PHÒNG THƯỜNG CÓ THỂ ĐẶT");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setBackground(Color.CYAN);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Constantia", Font.BOLD, 25));
		lblTitle.setBounds(0, 97, 1066, 43);
		contentPane.add(lblTitle);
		
		btnPre = new JButton("<");
		btnPre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPre.setBounds(280, 100, 45, 30);
		contentPane.add(btnPre);
		
		btnNext = new JButton(">");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(743, 100, 45, 30);
		contentPane.add(btnNext);
		btnPre.hide();
		btnNext.hide();
		
		txtSdt.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyReleased(KeyEvent e) {
				String sdt = txtSdt.getText();
				if (sdt.length() >= 1) {
					cboKhachHang.removeAllItems();
					new KhachHang_dao();
					for (KhachHang khachHang : KhachHang_dao.getDSKHTheoSDT(sdt)) {
						cboKhachHang.addItem(khachHang.getMaKH()+"-"+khachHang.getHoKH() + " " + khachHang.getTenKH()+"-"+khachHang.getSđt());
						maKH = khachHang.getMaKH();
					}
					
				} else {
					cboKhachHang.removeAllItems();
				}
			}
		});
		
		cboLoaiPhong.addItem("Phòng thường");
		cboLoaiPhong.addItem("Phòng VIP");
		cboLoaiPhong.addItem("Phòng đã đặt");
		cboLoaiPhong.addItemListener(new ItemListener() {	
			public void itemStateChanged(ItemEvent e) {
				ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
				list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
				if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
					lblTitle.setText("PHÒNG THƯỜNG CÓ THỂ ĐẶT");
					thayDoiCbo();
					btnPre.hide();
					btnNext.hide();
					txtNgayHat.show();
					lblNgayHat.show();
					lblGioDat.setBounds(133, 26, 94, 20);
				}
				else if(cboLoaiPhong.getSelectedItem()=="Phòng VIP") {
					lblTitle.setText("PHÒNG VIP CÓ THỂ ĐẶT");
					thayDoiCbo();
					btnPre.hide();
					btnNext.hide();
					txtNgayHat.show();
					lblNgayHat.show();
					lblGioDat.setBounds(133, 26, 94, 20);
			}
				else {
					btnPre.setEnabled(false);
					lblTitle.setText("PHÒNG ĐÃ ĐẶT HÔM NAY");
					removeComponent();
					loadLaiDanhSachPhongDaDat();
					btnPre.show();
					btnNext.show();
					txtNgayHat.hide();
					lblNgayHat.hide();
					lblGioDat.setBounds(133, 26, 144, 20);
				}
			}
		});
		btnNext.addActionListener(this);
		btnPre.addActionListener(this);
		
//		set speed of scrollPane
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);

	}

	public void removeComponent() {
		Component[] components = pnDanhSach.getComponents();
		for (Component component : components) {
			pnDanhSach.remove(component);
		}
		pnDanhSach.revalidate();
		pnDanhSach.repaint();
	}


	public static void loadLaiDanhSachPhongDaDat() {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateStr = sp.format(date);
		String year = dateStr.substring(0, dateStr.indexOf("-"));
		String mon = dateStr.substring(dateStr.indexOf("-") + 1);
		String month = mon.substring(0, mon.indexOf("-"));
		String day = dateStr.substring(dateStr.indexOf("-") + 4);
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month) - 1;
		int dayOfMonthInt = Integer.parseInt(day);
		if(btnNext.isEnabled()==true) {
			dayOfMonthInt = Integer.parseInt(day);
		}
		else {
			dayOfMonthInt = Integer.parseInt(day)+1;
		}
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		calendar.set(yearInt, monthInt, dayOfMonthInt);
		Component[] components = pnDanhSach.getComponents();
		for (Component component : components) {
			pnDanhSach.remove(component);
		}
		pnDanhSach.revalidate();
		pnDanhSach.repaint();
		ThongTinDat_dao ttd_d = new ThongTinDat_dao();
		List<String> dsMaPhong = new ArrayList<String>();
		for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
			if (dsMaPhong.size() == 0) {
				dsMaPhong.add(ttd.getMaPh());
			} else if (dsMaPhong.size() > 0) {
				for (int i = 0; i < dsMaPhong.size(); i++) {
					if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
						b = false;
						break;
					}
					b = true;
				}
				if (b) {
					dsMaPhong.add(ttd.getMaPh());
				}
			}
		}
		for (String ma : dsMaPhong) {
			for (Phong pTest : new Phong_dao().getDanhSachPhongTrongTheoMa(ma)) {
				GUI_PhongDatDanhSach pdds = new GUI_PhongDatDanhSach(pTest, tttk,
						calendar.get(Calendar.DAY_OF_MONTH) + "");
				pnDanhSach.add(pdds.DanhSachPhong());
			}
		}
		for (int i = 0; i <= 5; i++) {
			pnDanhSach.add(new GUI_PhongTrong().PhongNull());

		}
	}
	public void loadDanhSachPhong() throws ParseException {
		removeComponent();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date =  sp.format(txtNgayHat.getDate());
		String year = date.substring(0, date.indexOf("-"));
		String mon = date.substring(date.indexOf("-")+1);
		String month = mon.substring(0, mon.indexOf("-"));
		String day = date.substring(date.indexOf("-")+4);
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month)-1;
		int dayOfMonthInt = Integer.parseInt(day);
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		calendar.set(yearInt, monthInt, dayOfMonthInt);
		@SuppressWarnings("static-access")
		List<ThongTinDat> ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH)+"");
		for (Phong p : lsPhong){
			if (ls.size() == 0&&p.isTrangThai()==false) {
				pnDanhSach.add(new GUI_PhongDanhSach(p, tttk, true).DanhSachPhong());
			} else if(p.isTrangThai()==false){
				for (int i = 0; i < ls.size(); i++) {
					if (p.getMaPhong().equalsIgnoreCase(ls.get(i).getMaPh())) {
						m = false;
						break;
					}
					else {
						m=true;
					}
				}
				if(m&&p.isTrangThai()==false) {
					pnDanhSach.add(new GUI_PhongDanhSach(p, tttk, true).DanhSachPhong());
				}
			}
		}
	}
	public void thayDoiCbo() {
		if(cboLoaiPhong.getSelectedItem()=="Phòng thường") {
			n = false;
		}
		else if(cboLoaiPhong.getSelectedItem()=="Phòng VIP"){
			n=true;
		}
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date =  sp.format(txtNgayHat.getDate());
		String year = date.substring(0, date.indexOf("-"));
		String mon = date.substring(date.indexOf("-")+1);
		String month = mon.substring(0, mon.indexOf("-"));
		String day = date.substring(date.indexOf("-")+4);
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month)-1;
		int dayOfMonthInt = Integer.parseInt(day);
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		calendar.set(yearInt, monthInt, dayOfMonthInt);
		@SuppressWarnings("static-access")
		List<ThongTinDat> ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH)+"");
		removeComponent();
		new Phong_dao();
		for (Phong p : Phong_dao.getDanhSachPhongTrongTheoLoai(n)) {
			if (ls.size() == 0&&p.isTrangThai()==false) {
				pnDanhSach.add(new GUI_PhongDanhSach(p, tttk, true).DanhSachPhong());
			} else if(p.isTrangThai()==false){
				for (int i = 0; i < ls.size(); i++) {
					if (p.getMaPhong().equalsIgnoreCase(ls.get(i).getMaPh())) {
						m = false;
						break;
					}
					else {
						m=true;
					}
				}
				if(m&&p.isTrangThai()==false) {
					pnDanhSach.add(new GUI_PhongDanhSach(p, tttk, true).DanhSachPhong());
				}
			}
		}
	}
	public static String chuyen24h() {
		String b = timePicker.getSelectedTime();
		String hour = b.substring(0, b.indexOf(":"));
		String min = b.substring(b.indexOf(":") + 1);
		String minNoAa = min.substring(0, min.indexOf(" "));
		int hourInt = Integer.parseInt(hour);
		String regex = ".*P.*";
		if (kiemTraNhap(b, regex)) {
			hourInt = hourInt + 12;
			if(hourInt==24)
				hourInt=12;
		}
		else {
			if(hourInt == 12)
				hourInt = 00;
		}
		return hourInt + ":" + minNoAa ;
	}
	public static boolean kiemTraNhap(String input, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher macth = pattern.matcher(input);
		return macth.matches();
	}
	public static boolean checkNull() {
		if(lblGioDat.getText()!=null&&txtNgayHat.getDate()!=null&&txtSdt.getText()!=null&&cboKhachHang.getSelectedItem()!=null) {
			return true;
		}
		else return false;
	}
	public Component tabDatPhong() {
		return contentPane;
	}
	@SuppressWarnings("static-access")
	public static boolean rangBuocNgayDat() {
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date =  sp.format(txtNgayHat.getDate());
			String year = date.substring(0, date.indexOf("-"));
			String mon = date.substring(date.indexOf("-")+1);
			String month = mon.substring(0, mon.indexOf("-"));
			String day = mon.substring(3);	
			int yearInt = Integer.parseInt(year);
			int monthInt = Integer.parseInt(month)-1;
			int dayOfMonthInt = Integer.parseInt(day);
			Calendar c = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
			c.set(yearInt, monthInt, dayOfMonthInt);
			if (txtNgayHat.getDate() == null) {
				return false;
			} else if (c.get(c.DAY_OF_MONTH)-java.time.LocalDate.now().getDayOfMonth()>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)==0||c.get(c.DAY_OF_MONTH)-java.time.LocalDate.now().getDayOfMonth()<0&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)==0) {	
				return false;
			}else if(c.get(c.DAY_OF_MONTH)>1&&c.get(c.MONTH)-(java.time.LocalDate.now().getMonthValue()-1)>=1) {
				return false;
			}
			return true;
		}
	public static void removePhongDat() {
		btnNext.setEnabled(false);
		btnPre.setEnabled(true);
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateStr = sp.format(date);
		String year = dateStr.substring(0, dateStr.indexOf("-"));
		String mon = dateStr.substring(dateStr.indexOf("-") + 1);
		String month = mon.substring(0, mon.indexOf("-"));
		String day = dateStr.substring(dateStr.indexOf("-") + 4);
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month) - 1;
		int dayOfMonthInt= Integer.parseInt(day);
		if (btnNext.isEnabled() == true) {
			dayOfMonthInt = Integer.parseInt(day) + 1;
		} else {
			dayOfMonthInt = Integer.parseInt(day);
		}
		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		calendar.set(yearInt, monthInt, dayOfMonthInt);
		Component[] components = pnDanhSach.getComponents();
		for (Component component : components) {
			pnDanhSach.remove(component);
		}
		pnDanhSach.revalidate();
		pnDanhSach.repaint();
		ThongTinDat_dao ttd_d = new ThongTinDat_dao();
		List<String> dsMaPhong = new ArrayList<String>();
		for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
			if (dsMaPhong.size() == 0) {
				dsMaPhong.add(ttd.getMaPh());
			} else if (dsMaPhong.size() > 0) {
				for (int i = 0; i < dsMaPhong.size(); i++) {
					if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
						b = false;
						break;
					}
					b = true;
				}
				if (b) {
					dsMaPhong.add(ttd.getMaPh());
				}
			}
		}
		for (String ma : dsMaPhong) {
			for (Phong pTest : new Phong_dao().getDanhSachPhongTrongTheoMa(ma)) {
				pnDanhSach.add(new GUI_PhongDatDanhSach(pTest, tttk, calendar.get(Calendar.DAY_OF_MONTH) + "")
						.DanhSachPhong());
			}
		}
		for (int i = 0; i <= 5; i++) {
			pnDanhSach.add(new GUI_PhongTrong().PhongNull());
		}
	}
	public static void DatPhong(String maPh) {
		try {
			Date date;
			date = txtNgayHat.getDate();
			if (date != null && !timePicker.getSelectedTime().isEmpty() && rangBuocGioDat() && rangBuocNgayDat()
					&& rangBuocDatSauGioHienTai() && cboKhachHang.getItemCount() != 0) {
				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat = null;
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				dateTime = sp.format(txtNgayHat.getDate()) + " " + chuyen24h();
				try {
					ttd = new ThongTinDat(maKH, maPh,
							dateFormat.parse(dateTime));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(new ThongTinDat_dao().insertThongTinDat(ttd, dateTime)) {
					JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
					GUI_DatPhong2.loadDanhSachPhongTrong();
				}
				else {
					JOptionPane.showMessageDialog(null, "Lỗi đặt phòng");
				}
				
			} else if (date == null && timePicker.getSelectedTime().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ngày và giờ đặt không được bỏ trống");
			} else if (cboKhachHang.getItemCount() == 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần đặt phòng");
			} else if (!rangBuocGioDat()) {
				JOptionPane.showMessageDialog(null,
						"Giờ đặt không hợp lệ.\nChỉ được phòng sau 8h sáng và trước 23 giờ tối");
			} else if (!rangBuocNgayDat()) {
				JOptionPane.showMessageDialog(null, "Ngày đặt không hợp lệ.\nChỉ được phòng trong hôm nay hoặc ngày mai");
			} else if (!rangBuocDatSauGioHienTai()) {
				JOptionPane.showMessageDialog(null,
						"Thời gian đặt không hợp lệ.\nKhông thể đặt phòng sớm hơn thời gian hiện tại");
			}
		} catch (HeadlessException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public static boolean rangBuocGioDat() {
		String hour = chuyen24h().substring(0, chuyen24h().indexOf(":"));
		int hourInt = Integer.parseInt(hour);
		if (hourInt > 22) {
			return false;
		} else if (hourInt < 8) {
			return false;
		}
		return true;
	}
	@SuppressWarnings("deprecation")
	public static boolean rangBuocDatSauGioHienTai() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateTime = sp.format(txtNgayHat.getDate()) + " " + chuyen24h();
		if (dateFormat.parse(dateTime).getHours() - date.getHours() <1&&dateFormat.parse(dateTime).getMinutes() - date.getMinutes()<=0
				&& dateFormat.parse(dateTime).getDay() - date.getDay() == 0) {
			return false;
		}
		return true;
	}
	@SuppressWarnings("deprecation")
	public static void loadDanhSachPhongTrong() throws ParseException {
		 at = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now()+"");
		txtNgayHat.setDate(at);
		ls = new ThongTinDat_dao().getDanhSachPhongDaDatTheoNgay(day);
		list = (ArrayList<Phong>) new Phong_dao().getDanhSachPhong();
		for (ThongTinDat thongTinDat : ls) {
			for (int i = 0; i < list.size(); i++) {
				{
					if (thongTinDat.getMaPh().equalsIgnoreCase(list.get(i).getMaPhong())
							&& thongTinDat.getThoiGianDat().getHours() - java.time.LocalTime.now().getHour() < 3
							&& thongTinDat.getThoiGianDat().getHours() - java.time.LocalTime.now().getHour() >= 0) {
						list.remove(i);
					}
				}
			}
		}
		if (cboLoaiPhong.getSelectedItem() == "Phòng thường") {
			Component[] components = pnDanhSach.getComponents();
			for (Component component : components) {
				pnDanhSach.remove(component);
			}
			pnDanhSach.revalidate();
			pnDanhSach.repaint();
				for (Phong pTest : list) {
					if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == false) {
						pnDanhSach.add(new GUI_PhongDanhSach(pTest, tttk, true).DanhSachPhong());
					}
				}
				for (int i = 0; i <= 5; i++) {
					pnDanhSach.add(new GUI_PhongTrong().PhongNull());
				}
				for (Phong pTest : list) {
					if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == true) {
						pnDanhSach.add(new GUI_PhongDanhSach(pTest, tttk, true).DanhSachPhong());
					}

				}
				for (int i = 0; i <= 5; i++) {
					pnDanhSach.add(new GUI_PhongTrong().PhongNull());
				}
			}
		 else {
			Component[] components = pnDanhSach.getComponents();
			for (Component component : components) {
				pnDanhSach.remove(component);
			}
			pnDanhSach.revalidate();
			pnDanhSach.repaint();
				for (Phong pTest : list) {
					if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == false) {
						pnDanhSach.add(new GUI_PhongDanhSach(pTest, tttk, true).DanhSachPhong());
					}

				}
				for (int i = 0; i <= 5; i++) {
					pnDanhSach.add(new GUI_PhongTrong().PhongNull());
				}
				for (Phong pTest : list) {
					if (pTest.isLoaiPhong() == true && pTest.isTrangThai() == true) {
						pnDanhSach.add(new GUI_PhongDanhSach(pTest, tttk, true).DanhSachPhong());
					}

				}
				for (int i = 0; i <= 5; i++) {
					pnDanhSach.add(new GUI_PhongTrong().PhongNull());
				}
			}
		}
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnNext)) {
			lblTitle.setText("PHÒNG ĐÃ ĐẶT NGÀY MAI");
			btnNext.setEnabled(false);
			btnPre.setEnabled(true);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();
			String dateStr = sp.format(date);
			String year = dateStr.substring(0, dateStr.indexOf("-"));
			String mon = dateStr.substring(dateStr.indexOf("-") + 1);
			String month = mon.substring(0, mon.indexOf("-"));
			String day = dateStr.substring(dateStr.indexOf("-") + 4);
			int yearInt = Integer.parseInt(year);
			int monthInt = Integer.parseInt(month) - 1;
			int dayOfMonthInt = Integer.parseInt(day) + 1;
			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
			calendar.set(yearInt, monthInt, dayOfMonthInt);
			Component[] components = pnDanhSach.getComponents();
			for (Component component : components) {
				pnDanhSach.remove(component);
			}
			pnDanhSach.revalidate();
			pnDanhSach.repaint();
			ThongTinDat_dao ttd_d = new ThongTinDat_dao();
			List<String> dsMaPhong = new ArrayList<String>();
			for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(calendar.DAY_OF_MONTH) + "")) {
				if (dsMaPhong.size() == 0) {
					dsMaPhong.add(ttd.getMaPh());
				} else if (dsMaPhong.size() > 0) {
					System.out.println(dsMaPhong.size());
					for (int i = 0; i < dsMaPhong.size(); i++) {
						if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
							b = false;
							break;
						}
						b = true;
					}
					if (b) {
						dsMaPhong.add(ttd.getMaPh());
					}
				}
			}
			for (String ma : dsMaPhong) {
				for (Phong pTest : new Phong_dao().getDanhSachPhongTrongTheoMa(ma)) {
					GUI_PhongDatDanhSach gui_pdsd = new GUI_PhongDatDanhSach(pTest, tttk,
							calendar.get(Calendar.DAY_OF_MONTH) + "");
					pnDanhSach.add(gui_pdsd.DanhSachPhong());
				}
			}
			for (int i = 0; i <= 5; i++) {
				pnDanhSach.add(new GUI_PhongTrong().PhongNull());
			}

		} else if (o.equals(btnPre)) {
			btnNext.setEnabled(true);
			btnPre.setEnabled(false);
			lblTitle.setText("PHÒNG ĐÃ ĐẶT HÔM NAY");
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();
			String dateStr = sp.format(date);
			String year = dateStr.substring(0, dateStr.indexOf("-"));
			String mon = dateStr.substring(dateStr.indexOf("-") + 1);
			String month = mon.substring(0, mon.indexOf("-"));
			String day = dateStr.substring(dateStr.indexOf("-") + 4);
			int yearInt = Integer.parseInt(year);
			int monthInt = Integer.parseInt(month) - 1;
			int dayOfMonthInt = Integer.parseInt(day);
			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
			calendar.set(yearInt, monthInt, dayOfMonthInt);
			Component[] components = pnDanhSach.getComponents();
			for (Component component : components) {
				pnDanhSach.remove(component);
			}
			pnDanhSach.revalidate();
			pnDanhSach.repaint();
			ThongTinDat_dao ttd_d = new ThongTinDat_dao();
			List<String> dsMaPhong = new ArrayList<String>();
			for (ThongTinDat ttd : ttd_d.getDanhSachPhongDaDatTheoNgay(calendar.get(Calendar.DAY_OF_MONTH) + "")) {
				if (dsMaPhong.size() == 0) {
					dsMaPhong.add(ttd.getMaPh());
				} else if (dsMaPhong.size() > 0) {
					for (int i = 0; i < dsMaPhong.size(); i++) {
						if (ttd.getMaPh().equalsIgnoreCase(dsMaPhong.get(i))) {
							b = false;
							break;
						}
						b = true;
					}
					if (b) {
						dsMaPhong.add(ttd.getMaPh());
					}
				}
			}
			for (String ma : dsMaPhong) {
				for (Phong pTest : new Phong_dao().getDanhSachPhongTrongTheoMa(ma)) {
					GUI_PhongDatDanhSach pdds = new GUI_PhongDatDanhSach(pTest, tttk,
							calendar.get(Calendar.DAY_OF_MONTH) + "");
					pnDanhSach.add(pdds.DanhSachPhong());
					
				}
			}
			for (int i = 0; i <= 5; i++) {
				pnDanhSach.add(new GUI_PhongTrong().PhongNull());

			}
		}
	}
	public static void loadThongTinDatPhong(String gioDat, String sdt, String KH) {
		lblGioDat.setText(gioDat);
		txtSdt.setText(sdt);
		cboKhachHang.removeAllItems();
		cboKhachHang.addItem(KH);
	}
	
}
