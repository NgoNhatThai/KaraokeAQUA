package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Phong_dao;
import entity.Phong;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;

public class GUI_QuanLyPhong extends JFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaPh;
	private JTextField txtGia;
	private JTextField textField;
	private JTable tblDSPhong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private DefaultTableModel dtmDSP;
	private Phong_dao Phong_dao = new Phong_dao();
	private JSpinner spSucChua;
	private List<Phong> dsph;
	private JButton btnLuu;
	private JComboBox<String> cboLoaiPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyPhong frame = new GUI_QuanLyPhong();
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
	public GUI_QuanLyPhong() {
		System.out.println("ok");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnThongTinSP = new JPanel();
		pnThongTinSP.setLayout(null);
		pnThongTinSP.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin sản phẩm"));
		pnThongTinSP.setBackground(Color.WHITE);
		pnThongTinSP.setBounds(0, 0, 876, 112);
		contentPane.add(pnThongTinSP);

		JLabel lblMaPh = new JLabel("Mã phòng:");
		lblMaPh.setFont(new Font("Constantia", Font.BOLD, 13));
		lblMaPh.setBounds(10, 31, 96, 20);
		pnThongTinSP.add(lblMaPh);

		txtMaPh = new JTextField();
		txtMaPh.setOpaque(false);
		txtMaPh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtMaPh.setColumns(10);
		txtMaPh.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtMaPh.setBounds(101, 31, 96, 19);
		pnThongTinSP.add(txtMaPh);

		JLabel lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSucChua.setBounds(528, 29, 66, 20);
		pnThongTinSP.add(lblSucChua);

		spSucChua = new JSpinner();
		spSucChua.setBounds(604, 30, 53, 20);
		pnThongTinSP.add(spSucChua);

		JLabel lblGia = new JLabel("Giá giờ:");
		lblGia.setFont(new Font("Constantia", Font.BOLD, 13));
		lblGia.setBounds(667, 31, 66, 20);
		pnThongTinSP.add(lblGia);

		txtGia = new JTextField();
		txtGia.setOpaque(false);
		txtGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtGia.setColumns(10);
		txtGia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtGia.setBounds(743, 31, 110, 19);
		pnThongTinSP.add(txtGia);

		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
		lblLoaiPhong.setBounds(243, 31, 96, 20);
		pnThongTinSP.add(lblLoaiPhong);
		
		btnLuu = new JButton("Lưu", null);
		btnLuu.setFont(new Font("Arial", Font.BOLD, 13));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(677, 69, 166, 33);
		pnThongTinSP.add(btnLuu);
		
		cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setFont(new Font("Constantia", Font.BOLD, 13));
		cboLoaiPhong.setBackground(Color.WHITE);
		cboLoaiPhong.setBounds(329, 29, 151, 21);
		cboLoaiPhong.addItem("Phòng thường");
		cboLoaiPhong.addItem("Phòng VIP");
		pnThongTinSP.add(cboLoaiPhong);

		JPanel pnThaoTac = new JPanel();
		pnThaoTac.setLayout(null);
		pnThaoTac.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn tác vụ"));
		pnThaoTac.setBackground(Color.WHITE);
		pnThaoTac.setBounds(879, 0, 197, 215);
		contentPane.add(pnThaoTac);

		btnThem = new JButton("Thêm phòng hát", new ImageIcon(GUI_NhanSu.class.getResource("/icon/add.png")));
		btnThem.setBounds(10, 13, 177, 33);
		pnThaoTac.add(btnThem);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnThem.getText() != "Hủy") {
					btnThem.setFont(new Font("Constantia", Font.BOLD, 17));
					btnThem.setForeground(Color.GREEN);
					btnLuu.setEnabled(true);
				} else {
					btnThem.setFont(new Font("Constantia", Font.BOLD, 17));
					btnThem.setForeground(Color.RED);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThem.setFont(new Font("Constantia", Font.BOLD, 14));
				btnThem.setForeground(Color.BLACK);
			}
		});
		btnThem.setToolTipText("");
		btnThem.setFont(new Font("Constantia", Font.BOLD, 14));

		btnThem.setContentAreaFilled(false);
		btnThem.setFocusPainted(false);
		btnThem.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GREEN));
		pnThaoTac.add(btnThem);

		btnXoa = new JButton("Xóa phòng hát", new ImageIcon(GUI_NhanSu.class.getResource("/icon/delete.png")));
		btnXoa.setBounds(10, 66, 177, 33);
		pnThaoTac.add(btnXoa);
		btnXoa.setFont(new Font("Constantia", Font.BOLD, 14));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnXoa.setFont(new Font("Constantia", Font.BOLD, 17));
				btnXoa.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnXoa.setFont(new Font("Constantia", Font.BOLD, 14));
				btnXoa.setForeground(Color.BLACK);
			}
		});
		btnXoa.setContentAreaFilled(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.red));
		pnThaoTac.add(btnXoa);

		btnSua = new JButton("Cập nhật", new ImageIcon(GUI_NhanSu.class.getResource("/icon/update.png")));
		btnSua.setBounds(10, 119, 177, 33);
		pnThaoTac.add(btnSua);
		btnSua.setFont(new Font("Constantia", Font.BOLD, 14));
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSua.setFont(new Font("Constantia", Font.BOLD, 17));
				btnSua.setForeground(new Color(65, 105, 225));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSua.setFont(new Font("Constantia", Font.BOLD, 14));
				btnSua.setForeground(Color.BLACK);
			}
		});
		btnSua.setContentAreaFilled(false);
		btnSua.setFocusPainted(false);
		btnSua.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(65, 105, 225)));
		pnThaoTac.add(btnSua);
	
		btnXoaTrang = new JButton("Xóa trắng", new ImageIcon(GUI_NhanSu.class.getResource("/icon/deleteText.png")));
		btnXoaTrang.setBounds(10, 172, 177, 33);
		pnThaoTac.add(btnXoaTrang);
		btnXoaTrang.setFont(new Font("Constantia", Font.BOLD, 14));
		btnXoaTrang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnXoaTrang.setFont(new Font("Constantia", Font.BOLD, 17));
				btnXoaTrang.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnXoaTrang.setFont(new Font("Constantia", Font.BOLD, 14));
				btnXoaTrang.setForeground(Color.BLACK);
			}
		});
		btnXoaTrang.setContentAreaFilled(false);
		btnXoaTrang.setFocusPainted(false);
		btnXoaTrang.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.YELLOW));
		pnThaoTac.add(btnXoaTrang);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.WHITE);
		pnTimKiem.setLayout(null);
		pnTimKiem.setBounds(-2, 116, 878, 99);
		contentPane.add(pnTimKiem);

		JLabel lblTim = new JLabel("Tìm theo:");
		lblTim.setFont(new Font("Constantia", Font.BOLD, 14));
		lblTim.setBounds(35, 40, 68, 23);
		pnTimKiem.add(lblTim);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(188, 40, 206, 21);
		pnTimKiem.add(textField);

		JButton btnTim = new JButton((Icon) null);
		btnTim.setFocusPainted(false);
		btnTim.setContentAreaFilled(false);
		btnTim.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		btnTim.setBounds(398, 34, 45, 32);
		pnTimKiem.add(btnTim);

		JLabel lblSapXep = new JLabel("Sắp xếp theo:");
		lblSapXep.setFont(new Font("Constantia", Font.BOLD, 14));
		lblSapXep.setBounds(522, 39, 106, 23);
		pnTimKiem.add(lblSapXep);

		JComboBox<String> cboSapXep = new JComboBox<String>();
		cboSapXep.setFont(new Font("Constantia", Font.PLAIN, 13));
		cboSapXep.setBounds(633, 40, 216, 21);
		pnTimKiem.add(cboSapXep);

		JComboBox<String> jcboTimNV = new JComboBox<String>();
		jcboTimNV.setFont(new Font("Constantia", Font.BOLD, 13));
		jcboTimNV.setBounds(104, 39, 77, 21);
		pnTimKiem.add(jcboTimNV);

		JPanel pnDS = new JPanel();
		pnDS.setLayout(null);
		pnDS.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh Sách Phòng Hát"));
		pnDS.setBackground(Color.WHITE);
		pnDS.setBounds(-1, 218, 1077, 385);
		contentPane.add(pnDS);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1057, 355);
		pnDS.add(scrollPane);

		tblDSPhong = new JTable(
				dtmDSP = new DefaultTableModel(new String[] { "Mã Phòng", "Loại Phòng", "Giá/ giờ", "Sức chứa" }, 0)) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//dtmDSP.setRowCount(8);

		tblDSPhong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDSPhong.getTableHeader().setBackground(Color.CYAN);
		tblDSPhong.setFont(new Font("Times New Roman", Font.BOLD, 15));
		scrollPane.setViewportView(tblDSPhong);
		loadDB();
		//Phan dang ki su kien:
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		
		tblDSPhong.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowSelected = tblDSPhong.getSelectedRow();
				try {
					reviewRowSelected(rowSelected);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tblDSPhong.setSelectionForeground(Color.RED);
				tblDSPhong.setSelectionBackground(new Color(255, 255, 153));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public Component tabQuanLyPhong() {
		return contentPane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void addRow(Phong ph) {
		String loaiPhong = ph.isLoaiPhong() ? "Phòng VIP" : "Phòng thường";
		String[] a = { ph.getMaPhong(), loaiPhong, ph.getDonGia() + " VNĐ/ Giờ", ph.getSucChua() + "" };
		dtmDSP.addRow(a);
	}

	public void loadDB() {
		dsph = Phong_dao.getDanhSachPhong();
		for (Phong ph : dsph) {
			addRow(ph);
		}
	}
	public void reviewRowSelected(int rowSelected) throws ParseException {
		txtMaPh.setText(tblDSPhong.getValueAt(rowSelected, 0) + "");
		cboLoaiPhong.setSelectedItem(tblDSPhong.getValueAt(rowSelected, 1) + "");
		txtGia.setText(tblDSPhong.getValueAt(rowSelected, 2) + "");
		spSucChua.setValue(Integer.parseInt(dtmDSP.getValueAt(rowSelected, 3).toString()));
	}
	
	public void createMaTuDong() {
		int dem = dsph.size();
		System.out.println(dem);
		String c;
		if(dem<10) {
			c ="000";
		}
		else if(dem>=10&&dem<100) {
			c ="00";
		}
		else {
			c="0";
		}
		String newID= "PH" + c + dem;
		while (!new Phong_dao().kiemTraMaPhong(newID)) {
			System.out.println("co");
			dem++;
			newID= "PH" + c + dem;
		}
		txtMaPh.setText(newID);
		/*
		 * String maNV = "PH" + c + maSo; List<NhanSu> dsNS; dsNS =
		 * NhanSu_dao.getDanhSachNhanSu(); for (NhanSu nhanSu : dsNS) { if
		 * (nhanSu.getMaNV().equalsIgnoreCase(maNV)) { dem += 1; } } maSo = dem + "";
		 * return "PH" + c + maSo;
		 */
	}
	public boolean kiemTraThongTinPhong(Phong p) {
		String maPhong=txtMaPh.getText();
		String gia = txtGia.getText().substring(0, txtGia.getText().indexOf(" "));
		double donGiaPhong= Double.parseDouble(gia);
		int sucChua= Integer.parseInt(spSucChua.getValue()+"");
		if(maPhong.equals("")||donGiaPhong<=0||sucChua<=0) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng thông tin phòng!");
			return false;
		}
		Pattern regexMaPhong = Pattern.compile("^PH[0-9]{4}$");
		if(regexMaPhong.matcher(maPhong).matches()!=true) {
			JOptionPane.showMessageDialog(null, "Mã phòng phải theo định dạng [NVxxxx] !");
			return false;
		}
		
		
		return true;
	}
	public void xoaTrang() {
		txtGia.setText("");
		txtMaPh.setText("");
		spSucChua.setValue(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object=e.getSource();
		if(object.equals(btnXoaTrang)) {
			System.out.println("ok");
			txtGia.setText("");
			txtMaPh.setText("");
			spSucChua.setValue(0);
		}
		else if (object.equals(btnXoa)) {
			System.out.println("ok");
			int n= tblDSPhong.getSelectedRow();
			if(n!=-1) {
				String maPhong= tblDSPhong.getValueAt(n, 0)+"";
				int xacNhan=JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa phòng có mã " +maPhong+"?", "Xóa", JOptionPane.YES_NO_OPTION);
				if(xacNhan==JOptionPane.YES_OPTION) {
					System.out.println("ok");
					if(new Phong_dao().deletePhong(maPhong))
						JOptionPane.showMessageDialog(null, "Xóa phòng thành công!");
					dtmDSP.setRowCount(0);
					loadDB();
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần xóa trên danh sách trước!");
			}
		}
		else if(object.equals(btnThem)) {
			if(btnThem.getText().equals("Thêm phòng hát")) {
				btnThem.setText("Hủy");
				btnLuu.setEnabled(true);
				createMaTuDong();
			}
			else {
				btnThem.setText("Thêm phòng hát");
				btnLuu.setEnabled(false);
			}
			
		}
		else if (object.equals(btnLuu)) {
			if(btnThem.getText()=="Hủy") {
				
				boolean isLoai= true;
				boolean isTinhTrang=false;
				if(cboLoaiPhong.getSelectedItem().equals("Phòng thường"))
					isLoai=false;
				Phong p= new Phong(txtMaPh.getText(), isLoai, isTinhTrang, Double.parseDouble(txtGia.getText()), Integer.parseInt(spSucChua.getValue()+""), true  );
				if(kiemTraThongTinPhong(p)) {
					new Phong_dao().addPhong(p);
					JOptionPane.showMessageDialog(null, "Lưu phòng thành công!");
					xoaTrang();
					loadDB();
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm phòng hát");
				} else {
					JOptionPane.showMessageDialog(null, "Lưu thất bại!");
				}
			}
		}
		else if (object.equals(btnSua)) {
			int viTri=tblDSPhong.getSelectedRow();
			if(viTri!=-1) {
				String maPhong= tblDSPhong.getValueAt(viTri, 0)+"";
				Boolean loaiPhong=false;
				if(cboLoaiPhong.getSelectedItem()==("Phòng VIP"))
					loaiPhong=true;
				String gia = txtGia.getText().substring(0, txtGia.getText().indexOf(" "));
				Phong phong=new Phong(maPhong, loaiPhong, false, Double.parseDouble(gia), Integer.parseInt(spSucChua.getValue()+""), true);
				int n=JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa thông tin phòng "+maPhong, "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					if(kiemTraThongTinPhong(phong)) {
						if(new Phong_dao().capNhatPhong(phong)) {
							JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
							dtmDSP.setRowCount(0);
							loadDB();
						}
						else {
							JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại!");
						}
							
					}
					else {
						JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại thông tin cần sửa");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần sửa trên danh sách trước!");
			}
		}
		
	}
	
}
