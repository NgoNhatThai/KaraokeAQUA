//Huỳnh Hữu Phước
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import dao.HoaDon_dao;
import dao.KhachHang_dao;
import dao.Phong_HoaDon_dao;
import dao.Phong_dao;
import dao.ThongTinSuDungPhong_dao;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinSuDungPhong;
import entity.ThongTinTaiKhoan;

import javax.swing.JButton;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JSlider;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

public class GUI_ThuePhong extends JFrame {

	@SuppressWarnings("unused")
	private static final String STATIC_ACCESS = "static-access";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtGia;
	private static JTextField txtSdt;
	private Phong ph;
	private static JComboBox<String> cboKhachHang;
	private JComboBox<String> cboMaPhong;
	private JComboBox<String> cboLoaiPhong;
	private int n;
	private JSlider slSucChua;
	public static boolean check = false;
	private String maKH;
	private static JCheckBox hienThi;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 * 
	 */
	@SuppressWarnings("deprecation")
	public GUI_ThuePhong(Phong p, ThongTinTaiKhoan tttk) throws SQLException, ParseException {
		this.ph = p;
		setSize(654, 318);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JPanel pnThongTinPhong = new JPanel();
		pnThongTinPhong.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông Tin Phòng Hát"));
		pnThongTinPhong.setBackground(Color.WHITE);
		pnThongTinPhong.setBounds(0, 56, 635, 103);
		contentPane.add(pnThongTinPhong);
		pnThongTinPhong.setLayout(null);

		JLabel lblMaPh = new JLabel("Mã phòng:");
		lblMaPh.setFont(new Font("Constantia", Font.BOLD, 13));
		lblMaPh.setBounds(52, 16, 96, 20);
		pnThongTinPhong.add(lblMaPh);

		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
		lblLoaiPhong.setBounds(354, 16, 96, 20);
		pnThongTinPhong.add(lblLoaiPhong);

		JLabel lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSucChua.setBounds(354, 46, 66, 20);
		pnThongTinPhong.add(lblSucChua);

		JLabel lblGia = new JLabel("Giá giờ:");
		lblGia.setFont(new Font("Constantia", Font.BOLD, 13));
		lblGia.setBounds(52, 48, 66, 20);
		pnThongTinPhong.add(lblGia);

		txtGia = new JTextField();
		txtGia.setForeground(Color.RED);
		txtGia.setEditable(false);
		txtGia.setOpaque(false);
		txtGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtGia.setColumns(10);
		txtGia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtGia.setBounds(128, 43, 110, 19);
		pnThongTinPhong.add(txtGia);

		cboMaPhong = new JComboBox<String>();
		cboMaPhong.setBackground(Color.WHITE);
		cboMaPhong.setForeground(Color.RED);
		cboMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cboMaPhong.setBounds(128, 14, 110, 21);
		pnThongTinPhong.add(cboMaPhong);
		cboMaPhong.addItem(ph.getMaPhong());
		cboMaPhong.setSelectedItem(ph.getMaPhong());

		cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setForeground(Color.BLUE);
		cboLoaiPhong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cboLoaiPhong.setBackground(Color.WHITE);
		cboLoaiPhong.setBounds(471, 14, 110, 21);
		pnThongTinPhong.add(cboLoaiPhong);

		if (ph.isLoaiPhong()) {
			cboLoaiPhong.removeAllItems();
			cboLoaiPhong.addItem("Phòng VIP");
		} else {
			cboLoaiPhong.removeAllItems();
			cboLoaiPhong.addItem("Phòng thường");
		}
//		cboLoaiPhong.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				boolean lp;
//				cboMaPhong.removeAllItems();
//				if (cboLoaiPhong.getSelectedIndex() == 0) {
//					lp = false;
//				} else {
//					lp = true;
//				}
//				for (Phong p1 : new Phong_dao().getDanhSachPhong()) {
//					if (p1.isLoaiPhong() == lp && p1.isTrangThai() == false) {
//						cboMaPhong.addItem(p1.getMaPhong());
//					}
//				}
//			}
//		});

		slSucChua = new JSlider();
		slSucChua.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		slSucChua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		slSucChua.setValue(25);
		slSucChua.setSnapToTicks(true);
		slSucChua.setPaintLabels(true);
		slSucChua.setMinorTickSpacing(5);
		slSucChua.setMinimum(10);
		slSucChua.setMaximum(25);
		slSucChua.setMajorTickSpacing(5);
		slSucChua.setBackground(Color.WHITE);
		slSucChua.setBounds(471, 46, 110, 35);
		pnThongTinPhong.add(slSucChua);
		Phong ph = new Phong_dao().getPhongTrongTheoMa(cboMaPhong.getSelectedItem() + "");
		slSucChua.setValue(ph.getSucChua());

		hienThi = new JCheckBox("New check box");
		hienThi.setBounds(605, 14, 24, 21);
		pnThongTinPhong.add(hienThi);
		hienThi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (hienThi.isSelected()) {
					show();
				} else {
					hide();
				}
			}
		});

		JPanel pnKhachHang = new JPanel();
		pnKhachHang.setBackground(Color.WHITE);
		pnKhachHang.setBounds(0, 159, 635, 54);
		contentPane.add(pnKhachHang);
		pnKhachHang.setLayout(null);

		JLabel lblKhachHang = new JLabel("Khách hàng:");
		lblKhachHang.setFont(new Font("Constantia", Font.BOLD, 14));
		lblKhachHang.setBounds(10, 16, 94, 22);
		pnKhachHang.add(lblKhachHang);

		cboKhachHang = new JComboBox<String>();
		cboKhachHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cboKhachHang.getSelectedItem() != null) {
					String b = cboKhachHang.getSelectedItem().toString();
					if (b != null) {
						maKH = b.substring(0, b.indexOf("-"));
					}
				}
			}
		});
		cboKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cboKhachHang.setBackground(Color.WHITE);
		cboKhachHang.setBounds(110, 17, 230, 21);
		pnKhachHang.add(cboKhachHang);

		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setFont(new Font("Constantia", Font.BOLD, 13));
		lblSdt.setBounds(421, 15, 84, 20);
		pnKhachHang.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setOpaque(false);
		txtSdt.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtSdt.setColumns(10);
		txtSdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtSdt.setBounds(515, 10, 110, 19);
		pnKhachHang.add(txtSdt);
		txtSdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sdt = txtSdt.getText();
				if (sdt.length() >= 1) {
					cboKhachHang.removeAllItems();
					for (KhachHang khachHang : new KhachHang_dao().getDSKHTheoSDT(sdt)) {
						if (khachHang != null) {
							cboKhachHang.addItem(khachHang.getMaKH() + "-" + khachHang.getHoKH() + " "
									+ khachHang.getTenKH() + "-" + khachHang.getSđt());
							maKH = khachHang.getMaKH();

						}
					}
				} else {
					cboKhachHang.removeAllItems();
				}
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 50, 666, 6);
		pnKhachHang.add(separator_1);

		JButton btnThuePhong = new JButton("Thuê phòng",
				new ImageIcon(GUI_ManHinhChinh.class.getResource("/icon/lease.png")));
		btnThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		cboMaPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		btnThuePhong.addActionListener(new ActionListener() {
			private HoaDon hd;
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					p.setTrangThai(true);
					Component[] components = GUI_DatPhong2.pnDanhSach.getComponents();
					for (Component component : components) {
						GUI_DatPhong2.pnDanhSach.remove(component);
					}
					GUI_DatPhong2.pnDanhSach.revalidate();
					GUI_DatPhong2.pnDanhSach.repaint();
					if (GUI_DatPhong2.cboLoaiPhong.getSelectedItem() != "Phòng đã đặt") {
						for (Phong pTest : GUI_DatPhong2.list) {
							if (pTest.isLoaiPhong() == false && pTest.isTrangThai() == false) {
								GUI_DatPhong2.pnDanhSach.add(new GUI_PhongDanhSach(pTest, tttk, true).DanhSachPhong());
							}
						}
						for (int i = 0; i <= 5; i++) {
							GUI_DatPhong2.pnDanhSach.add(new GUI_PhongTrong().PhongNull());
						}
					} else {
						GUI_DatPhong2.loadLaiDanhSachPhongDaDat();
					}
					new Phong_dao().updatePhong(p);
					String sdt = txtSdt.getText();
					new KhachHang_dao();
					for (KhachHang khachHang : KhachHang_dao.getDSKHTheoSDT(sdt)) {
						cboKhachHang.addItem(khachHang.getHoKH() + " " + khachHang.getTenKH());
					}

					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					java.util.Date date = new java.util.Date();
					String gioVao = sp.format(date);
					String regex = ".*QL.*", ql = null, nv = null;
					if (kiemTraNhap(tttk.getMa(), regex)) {
						ql = tttk.getMa();
						nv = null;
					} else {
						ql = null;
						nv = tttk.getMa();
					}
					hd = new HoaDon(autoIDHoaDon(), ql, nv, maKH, gioVao, null, 0.0);
					if (new HoaDon_dao().insertHoaDon(hd)) {
						new Phong_HoaDon_dao().insertPhong_HoaDon(hd, p.getMaPhong());
						ThongTinSuDungPhong td = new ThongTinSuDungPhong(p.getMaPhong(), gioVao, maKH, hd.getMaHD());
						new ThongTinSuDungPhong_dao().insertThoiDiem(td);
						p.setTrangThai(true);
						new GUI_PhongDatDanhSach(p, tttk, java.time.LocalDate.now().getDayOfMonth() + "")
								.xoaPhongDatKhiSuDung();
						if (JOptionPane.showConfirmDialog(null, "Bạn có muốn gọi thêm các dịch vụ của quán?",
								"Thêm dịch vụ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							try {
								new GUI_ThemDichVu(p, hd.getMaHD()).setVisible(true);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Thuê phòng thành công");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Lỗi!!!");
					}
			}
		});

		btnThuePhong.setFont(new Font("Constantia", Font.BOLD, 15));
		btnThuePhong.setBounds(90, 223, 168, 42);
		contentPane.add(btnThuePhong);
		btnThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThuePhong.setFont(new Font("Constantia", Font.BOLD, 17));
				btnThuePhong.setForeground(Color.BLUE);
				btnThuePhong.setBorder(new MatteBorder(0, 0, 6, 0, (Color) Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThuePhong.setFont(new Font("Constantia", Font.BOLD, 14));
				btnThuePhong.setForeground(Color.BLACK);
				btnThuePhong.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
			}
		});

		JButton btnHuy = new JButton("Hủy", new ImageIcon(GUI_ManHinhChinh.class.getResource("/icon/close.png")));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnHuy.setFont(new Font("Constantia", Font.BOLD, 15));
		btnHuy.setBounds(427, 223, 168, 42);
		contentPane.add(btnHuy);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHuy.setFont(new Font("Constantia", Font.BOLD, 17));
				btnHuy.setForeground(Color.RED);
				btnHuy.setBorder(new MatteBorder(0, 0, 6, 0, (Color) Color.RED));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHuy.setFont(new Font("Constantia", Font.BOLD, 14));
				btnHuy.setForeground(Color.BLACK);
				btnHuy.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
			}
		});

		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.CYAN);
		pnTitle.setBounds(0, 0, 635, 58);
		contentPane.add(pnTitle);
		pnTitle.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thuê phòng");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 635, 58);
		pnTitle.add(lblNewLabel);
		loadDataToTextField();
		btnThuePhong.setFocusPainted(false);
		btnHuy.setFocusPainted(false);
		btnThuePhong.setBackground(Color.WHITE);
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
		btnThuePhong.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.BLUE));
		hienThi.hide();
	}

	public static void checkHienThi(boolean b) {
		if (b) {
			hienThi.setSelected(true);
		} else {
			hienThi.setSelected(false);
		}
	}

	public static void setKhachHang(String ma) {
		KhachHang kh = new KhachHang_dao().getDSKHTheoMa(ma);
		cboKhachHang.removeAllItems();
		cboKhachHang.addItem(kh.getMaKH() + "-" + kh.getHoKH() + " " + kh.getTenKH() + "-" + kh.getSđt());
		cboKhachHang.setSelectedIndex(0);
		txtSdt.setText(kh.getSđt());
	}

	public boolean kiemTraNhap(String input, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher macth = pattern.matcher(input);
		return macth.matches();
	}

	public void loadDataToTextField() {
		@SuppressWarnings("unused")
		String n;
		if (ph.isLoaiPhong()) {
			n = "Phòng VIP";
		} else {
			n = "Phòng thường";
		}
		txtGia.setText(ph.getDonGia() + "");
	}

	public void loadDatatoCboKH() {
		List<KhachHang> ls = new KhachHang_dao().getDanhSachKhachHang();
		for (KhachHang khachHang : ls) {
			cboKhachHang.addItem(khachHang.getHoKH() + " " + khachHang.getTenKH());
		}
	}

	public static void loadCboKhachHangKhiThemMoi(KhachHang k) {
		cboKhachHang.removeAllItems();
		cboKhachHang.addItem(k.getMaKH()+"-"+k.getHoKH()+" "+k.getTenKH()+"-"+k.getSđt());
		txtSdt.setText(k.getSđt());
	}

	public String autoIDHoaDon() {
		String a = "HD";
		try {
			n = new HoaDon_dao().getTongSoHoaDon() + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("ddMMyyyy");
		String c = sp.format(date);
		String maHd = a + c + n + "";
		for (HoaDon hd : new HoaDon_dao().getDanhSachHoaDon()) {
			if (hd.getMaHD().equalsIgnoreCase(maHd)) {
				n += 1;
			}
		}
		return a + c + n + "";
	}
}
