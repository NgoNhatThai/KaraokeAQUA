//Huỳnh Hữu Phước
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import dao.HoaDon_dao;
import dao.KhachHang_dao;
import dao.NhanSu_dao;
import entity.HoaDon;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GUI_ThongKeHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDSHD;
	private JTable tblDsHoaDon;
	private List<HoaDon> dshd= new ArrayList<>();
	public static JPanel pnBieuDo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongKeHoaDon frame = new GUI_ThongKeHoaDon();
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
	public GUI_ThongKeHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1090, 610);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnBieuDo = new JPanel();
		pnBieuDo.setBackground(SystemColor.control);
		pnBieuDo.setBounds(0, 155, 865, 414);
		contentPane.add(pnBieuDo);
		pnBieuDo.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Biểu đồ thống kê"));
		
		JPanel pnDanhSachHoaDon = new JPanel();
		pnDanhSachHoaDon.setBackground(Color.WHITE);
		pnDanhSachHoaDon.setBounds(0, 0, 865, 153);
		contentPane.add(pnDanhSachHoaDon);
		pnDanhSachHoaDon.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách hóa đơn"));
		pnDanhSachHoaDon.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 845, 128);
		pnDanhSachHoaDon.add(scrollPane);
		
		tblDsHoaDon = new JTable(dtmDSHD = new DefaultTableModel(
				new String[] { "Mã HĐ", "Mã KH", "Mã Phòng", "Thành tiền","Ngày lập"  }, 0)) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblDsHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDsHoaDon.getTableHeader().setBackground(Color.CYAN);
		tblDsHoaDon.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblDsHoaDon.getTableHeader().setForeground(Color.BLUE);
		tblDsHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dshd= new HoaDon_dao().getDanhSachHoaDon();
		
		scrollPane.setViewportView(tblDsHoaDon);
		
		
		JPanel pnTacVu = new JPanel();
		pnTacVu.setBackground(Color.WHITE);
		pnTacVu.setBounds(875, 0, 191, 569);
		contentPane.add(pnTacVu);
		pnTacVu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn tác vụ"));
		pnTacVu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ:");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 23, 36, 20);
		pnTacVu.add(lblNewLabel);
		
		JDateChooser txtNsx = new JDateChooser();
		txtNsx.setOpaque(false);
		txtNsx.setEnabled(true);
		txtNsx.setDateFormatString("dd-MM-yyyy");
		txtNsx.setBackground(Color.WHITE);
		txtNsx.setBounds(50, 23, 136, 20);
		pnTacVu.add(txtNsx);
		
		JDateChooser txtNsx_1 = new JDateChooser();
		txtNsx_1.setOpaque(false);
		txtNsx_1.setEnabled(true);
		txtNsx_1.setDateFormatString("dd-MM-yyyy");
		txtNsx_1.setBackground(Color.WHITE);
		txtNsx_1.setBounds(50, 60, 136, 20);
		pnTacVu.add(txtNsx_1);
		
		JLabel lblNewLabel_1 = new JLabel("Đến:");
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 60, 45, 20);
		pnTacVu.add(lblNewLabel_1);
		
		JLabel lblTheoThang = new JLabel("Tháng");
		lblTheoThang.setFont(new Font("Constantia", Font.BOLD, 13));
		lblTheoThang.setBounds(10, 103, 171, 20);
		pnTacVu.add(lblTheoThang);
		
		JComboBox<String> cboThang = new JComboBox<String>();
		cboThang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cboThang.setEnabled(false);
		cboThang.setBackground(Color.WHITE);
		cboThang.setBounds(70, 101, 111, 21);
		pnTacVu.add(cboThang);
		
		pnBieuDo.add(new GUI_BieuDoThongKe().loadChart());
		pnBieuDo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		JFreeChart pieChart = createChart(createDataset());
//        ChartPanel chartPanel = new ChartPanel(pieChart);
//		pnBieuDo.add(GUI_BieuDoThongKe.createChart(GUI_BieuDoThongKe.createDataset()));
	}
	public Component tabThongkeHoaDon() {
		return contentPane;
	}
	public void loadHoaDon() {
		for (HoaDon hoaDon : dshd) {
			String tenKH= new KhachHang_dao().getDSKHTheoMa(hoaDon.getMaKH()).getTenKH();
			String tenNV= new NhanSu_dao().getNS(hoaDon.getMaNV()).getTenNV();
			String a[]= {hoaDon.getMaHD(), tenKH, hoaDon.getTongThanhToan()+"", tenNV,hoaDon.getThoiDiemTT()};
			dtmDSHD.addRow(a);
		}
	}
}
