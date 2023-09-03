//Huỳnh Hữu Phước
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GUI_PhanCong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtCaTruc;
	private JTable tblDanhSachCaTruc;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDSCT;
	private JTable tblDanhSachNhanVienRanh;
	private JTable tblDanhSachNhanVienTrucCa;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDSNVR;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDSNVTC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PhanCong frame = new GUI_PhanCong();
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
	public GUI_PhanCong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBackground(Color.WHITE);
		pnThongTin.setBounds(0, 0, 880, 67);
		contentPane.add(pnThongTin);
		pnThongTin.setLayout(null);
		pnThongTin.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông Tin phân công"));
		
		JLabel lblMaNV = new JLabel("Mã NV: ");
		lblMaNV.setFont(new Font("Constantia", Font.BOLD, 13));
		lblMaNV.setBounds(584, 24, 55, 20);
		pnThongTin.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setOpaque(false);
		txtMaNV.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		txtMaNV.setBounds(649, 23, 117, 19);
		pnThongTin.add(txtMaNV);
		
		JLabel lblCaTruc = new JLabel("Ca trực: ");
		lblCaTruc.setFont(new Font("Constantia", Font.BOLD, 13));
		lblCaTruc.setBounds(321, 24, 63, 20);
		pnThongTin.add(lblCaTruc);
		
		txtCaTruc = new JTextField();
		txtCaTruc.setOpaque(false);
		txtCaTruc.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtCaTruc.setEditable(false);
		txtCaTruc.setColumns(10);
		txtCaTruc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		txtCaTruc.setBounds(393, 23, 117, 19);
		pnThongTin.add(txtCaTruc);
		
		JLabel lblNgayTruc = new JLabel("Ngày trực:");
		lblNgayTruc.setFont(new Font("Constantia", Font.BOLD, 13));
		lblNgayTruc.setBounds(69, 24, 71, 20);
		pnThongTin.add(lblNgayTruc);
		
		JDateChooser txtNgayTruc = new JDateChooser();
		txtNgayTruc.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayTruc.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtNgayTruc.setEnabled(false);
		txtNgayTruc.setDateFormatString("dd-MM-yyyy");
		txtNgayTruc.setBounds(144, 24, 130, 20);
		pnThongTin.add(txtNgayTruc);
		
		JPanel pnThaoTac = new JPanel();
		pnThaoTac.setLayout(null);
		pnThaoTac.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn tác vụ"));
		pnThaoTac.setBackground(Color.WHITE);
		pnThaoTac.setBounds(879, 0, 197, 175);
		contentPane.add(pnThaoTac);
		
		JButton btnPhnCng = new JButton("Phân công", null);
		btnPhnCng.setToolTipText("");
		btnPhnCng.setFont(new Font("Constantia", Font.BOLD, 14));
		btnPhnCng.setFocusPainted(false);
		btnPhnCng.setContentAreaFilled(false);
		btnPhnCng.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GREEN));
		btnPhnCng.setBounds(10, 13, 177, 33);
		pnThaoTac.add(btnPhnCng);
		
		JButton btnXoa = new JButton("Hủy phân công", null);
		btnXoa.setFont(new Font("Constantia", Font.BOLD, 14));
		btnXoa.setFocusPainted(false);
		btnXoa.setContentAreaFilled(false);
		btnXoa.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.red));
		btnXoa.setBounds(10, 132, 177, 33);
		pnThaoTac.add(btnXoa);
		
		JButton btnSua = new JButton("Phân công tự động", null);
		btnSua.setFont(new Font("Constantia", Font.BOLD, 14));
		btnSua.setFocusPainted(false);
		btnSua.setContentAreaFilled(false);
		btnSua.setBorder(new MatteBorder(0, 0, 2, 0, (Color)  new Color(65,105,225)));
		btnSua.setBounds(10, 72, 177, 33);
		pnThaoTac.add(btnSua);
		
		JPanel pnDanhSachCaTruc = new JPanel();
		pnDanhSachCaTruc.setBackground(Color.WHITE);
		pnDanhSachCaTruc.setBounds(0, 67, 880, 108);
		contentPane.add(pnDanhSachCaTruc);
		pnDanhSachCaTruc.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách ca trực"));
		pnDanhSachCaTruc.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 14, 860, 89);
		pnDanhSachCaTruc.add(scrollPane);
		
		tblDanhSachCaTruc = new JTable(dtmDSCT = new DefaultTableModel(
				new String[] { "Mã ca","Ca trực", "Thời gian","Ngày trực", "Ghi chú" }, 0)) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tblDanhSachCaTruc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDanhSachCaTruc.getTableHeader().setBackground(Color.CYAN);
		scrollPane.setViewportView(tblDanhSachCaTruc);
		
		JPanel pnDanhSachNhanVienRanh = new JPanel();
		pnDanhSachNhanVienRanh.setBounds(0, 172, 538, 431);
		contentPane.add(pnDanhSachNhanVienRanh);
		pnDanhSachNhanVienRanh.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách nhân viên chưa phân công"));
		pnDanhSachNhanVienRanh.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 14, 518, 411);
		pnDanhSachNhanVienRanh.add(scrollPane_1);
		
		tblDanhSachNhanVienRanh = new JTable(dtmDSNVR = new DefaultTableModel(
				new String[] { "Mã NV", "Họ", "Tên", "SĐT" }, 0)) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane_1.setViewportView(tblDanhSachNhanVienRanh);
		tblDanhSachNhanVienRanh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDanhSachNhanVienRanh.getTableHeader().setBackground(Color.CYAN);
		
		JPanel pnDanhSachNhanVienTrucCa = new JPanel();
		pnDanhSachNhanVienTrucCa.setBounds(538, 172, 538, 431);
		contentPane.add(pnDanhSachNhanVienTrucCa);
		pnDanhSachNhanVienTrucCa.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách nhân viên trực ca"));
		pnDanhSachNhanVienTrucCa.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 14, 518, 411);
		pnDanhSachNhanVienTrucCa.add(scrollPane_2);
		tblDanhSachNhanVienTrucCa = new JTable(dtmDSNVTC = new DefaultTableModel(
				new String[] { "Mã NV", "Họ", "Tên", "SĐT" }, 0)) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane_2.setViewportView(tblDanhSachNhanVienTrucCa);
		tblDanhSachNhanVienTrucCa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDanhSachNhanVienTrucCa.getTableHeader().setBackground(Color.CYAN);
	}
	public Component tabPhanCong() {
		return contentPane;
	}
}
