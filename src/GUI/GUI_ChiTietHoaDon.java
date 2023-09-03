//Huỳnh Hữu Phước
package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.HoaDon_SanPhamDV_dao;
import dao.HoaDon_dao;
import dao.SanPhamDV_dao;
import dao.ThongTinChuyenPhong_dao;
import entity.HoaDon;
import entity.HoaDon_SanPhamDV;
import entity.Phong;
import entity.SanPhamDV;
import entity.ThongTinChuyenPhong;
import entity.ThongTinTaiKhoan;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.sql.SQLException;

public class GUI_ChiTietHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private static Phong p;
	private double tongThanhToan = 0;
	private JLabel lblTongThanhToanText;
	private DecimalFormat formatter;
	@SuppressWarnings("unused")
	private Integer n;
	@SuppressWarnings("unused")
	private double thanhToan;
	private Date dt;
	private String sl;
	private double soLuong, gioVao, gioRa;
	private Date dtt;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public GUI_ChiTietHoaDon(Phong p, String maHD, ThongTinTaiKhoan tttk) throws SQLException, ParseException {
		setSize( 498, 727);
		this.p = p;
//		GUI_ThanhToan.tk = tk;
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.WHITE);
		pnTitle.setBounds(0, 0, 489, 65);
		contentPane.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("HÓA ĐƠN THANH TOÁN");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 489, 65);
		pnTitle.add(lblTitle);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setBackground(Color.WHITE);
		pnHoaDon.setBounds(0, 65, 489, 625);
		contentPane.add(pnHoaDon);
		pnHoaDon.setLayout(null);
		
		JLabel lblMaHd = new JLabel("Mã hóa đơn: ");
		lblMaHd.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaHd.setBounds(10, 10, 94, 20);
		pnHoaDon.add(lblMaHd);
		
		JLabel lblNV = new JLabel("Nhân viên thu ngân:");
		lblNV.setFont(new Font("Arial", Font.BOLD, 13));
		lblNV.setBounds(201, 10, 134, 20);
		pnHoaDon.add(lblNV);
		
		JLabel lblThoiDiem = new JLabel("Thời điểm thanh toán:");
		lblThoiDiem.setFont(new Font("Arial", Font.BOLD, 13));
		lblThoiDiem.setBounds(10, 70, 147, 20);
		pnHoaDon.add(lblThoiDiem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 489, 10);
		pnHoaDon.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 97, 489, 2);
		pnHoaDon.add(separator_1);
		
		JLabel lblDanhMuc = new JLabel("Danh mục");
		lblDanhMuc.setFont(new Font("Arial", Font.BOLD, 13));
		lblDanhMuc.setBounds(10, 101, 78, 20);
		pnHoaDon.add(lblDanhMuc);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		lblSoLuong.setBounds(214, 101, 66, 20);
		pnHoaDon.add(lblSoLuong);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Arial", Font.BOLD, 13));
		lblThanhTien.setBounds(375, 101, 72, 20);
		pnHoaDon.add(lblThanhTien);
		
		Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm aa - dd/MM/yyyy");
        String dateString = df.format(date);
		
		JPanel pnBang = new JPanel();
		pnBang.setBackground(Color.WHITE);
		pnBang.setLayout(new BoxLayout(pnBang, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(pnBang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 130, 489, 351);
		pnHoaDon.add(scrollPane);
		
		JLabel lblTongThanhToan = new JLabel("Tổng thanh toán: ");
		lblTongThanhToan.setFont(new Font("Arial", Font.BOLD, 13));
		lblTongThanhToan.setBounds(10, 551, 120, 20);
		pnHoaDon.add(lblTongThanhToan);
		
		lblTongThanhToanText = new JLabel("");
		lblTongThanhToanText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTongThanhToanText.setBounds(124, 551, 100, 20);
		pnHoaDon.add(lblTongThanhToanText);
		HoaDon hd = new HoaDon_dao().getHoaDon(maHD);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dt = sdf.parse(hd.getThoiDiemSD());
		for (ThongTinChuyenPhong ttcp : new ThongTinChuyenPhong_dao().getThongTinChuyenPhongTheoMaHD(maHD)) {
			if(ttcp!=null) {
				pnBang.add(new GUI_GioHatTrongHoaDon(p, sl, ttcp).gioHat());
				tongThanhToan+=ttcp.getTienGioPhongCu();
				dt = ttcp.getGioVaoMoi();
			}
			else {
				dt = sdf.parse(hd.getThoiDiemSD());
			}
		}
		dtt =sdf.parse(hd.getThoiDiemTT());
		gioVao = dt.getHours()+ Double.parseDouble((Double.parseDouble(dt.getMinutes()+"")/60+""));
		gioRa = dtt.getHours()+ Double.parseDouble((Double.parseDouble(dt.getMinutes()+"")/60+""));
		soLuong = gioRa-gioVao;
		double s = (double) Math.round(soLuong * 100) / 100;
		sl = s+"";
		pnBang.add(new GUI_GioHatTrongHoaDon(p, sl, null).gioHat());
		tongThanhToan += (double)  (p.getDonGia()*Double.parseDouble((date.getHours()- dt.getHours()+1+"")));
		List<HoaDon_SanPhamDV> ls = new HoaDon_SanPhamDV_dao().getDanhSachTheoMaHD(maHD);
		for (HoaDon_SanPhamDV hoaDon_SanPhamDV : ls) {
			SanPhamDV sp = new SanPhamDV_dao().getSanPhamTheoMa(hoaDon_SanPhamDV.getMaDV());
			pnBang.add(new GUI_DanhMucTrongHoaDon(sp, hoaDon_SanPhamDV.getSoLuong()).DanhMuc());
			tongThanhToan+=(sp.getDonGia()*hoaDon_SanPhamDV.getSoLuong());
		}
		for(int i = 1; i <20; i++) {
			pnBang.add(new frmDongNull().dongNull());
			i++;
		}
		
		JLabel lblGiamGia = new JLabel("Giảm giá:");
		lblGiamGia.setFont(new Font("Arial", Font.BOLD, 13));
		lblGiamGia.setBounds(10, 521, 66, 20);
		pnHoaDon.add(lblGiamGia);
		
		JLabel lblGiamGiaText = new JLabel("%");
		lblGiamGiaText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGiamGiaText.setBounds(124, 521, 110, 20);
		pnHoaDon.add(lblGiamGiaText);
		
		JLabel lblMaHdText = new JLabel("");
		lblMaHdText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaHdText.setBounds(96, 10, 120, 20);
		pnHoaDon.add(lblMaHdText);
		lblMaHdText.setText(maHD);
		
		JLabel lblNvText = new JLabel("");
		lblNvText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNvText.setBounds(341, 10, 138, 20);
		pnHoaDon.add(lblNvText);
		lblNvText.setText(tttk.getHo()+" "+tttk.getTen());
		
		JLabel lblNgayGioHienTai = new JLabel();
		lblNgayGioHienTai.setText(dateString);
		lblNgayGioHienTai.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgayGioHienTai.setBounds(167, 70, 191, 20);
		pnHoaDon.add(lblNgayGioHienTai);
		
		JLabel lblTienDua = new JLabel("Tiền khách đưa:");
		lblTienDua.setFont(new Font("Arial", Font.BOLD, 13));
		lblTienDua.setBounds(235, 491, 110, 20);
		pnHoaDon.add(lblTienDua);
		
		JLabel lblTienTra = new JLabel("Tiền trả lại:");
		lblTienTra.setFont(new Font("Arial", Font.BOLD, 13));
		lblTienTra.setBounds(235, 521, 100, 20);
		pnHoaDon.add(lblTienTra);
		
		JLabel lblTienTraLaiText = new JLabel("");
		lblTienTraLaiText.setForeground(Color.RED);
		lblTienTraLaiText.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblTienTraLaiText.setBounds(341, 517, 138, 25);
		pnHoaDon.add(lblTienTraLaiText);
		
		JLabel lblGioVao = new JLabel("Giờ vào: ");
		lblGioVao.setFont(new Font("Arial", Font.BOLD, 13));
		lblGioVao.setBounds(10, 40, 78, 20);
		pnHoaDon.add(lblGioVao);
		
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		dt = simple.parse(hd.getThoiDiemSD());
		JLabel lblGioVaoText = new JLabel();
		lblGioVaoText.setText(df.format(dt));
		lblGioVaoText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGioVaoText.setBounds(89, 40, 191, 20);
		pnHoaDon.add(lblGioVaoText);
		formatter = new DecimalFormat("###,###,###");
		lblTongThanhToanText.setText(formatter.format(tongThanhToan)+" VNĐ");
		thanhToan = tongThanhToan;
		
		JLabel lblTongHoaDonText = new JLabel("0 VNĐ");
		lblTongHoaDonText.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTongHoaDonText.setBounds(124, 491, 100, 20);
		pnHoaDon.add(lblTongHoaDonText);
		lblTongHoaDonText.setText(formatter.format(tongThanhToan)+" VNĐ");
		
		JLabel lblTongHoaDon = new JLabel("Tổng hóa đơn: ");
		lblTongHoaDon.setFont(new Font("Arial", Font.BOLD, 13));
		lblTongHoaDon.setBounds(10, 491, 110, 20);
		pnHoaDon.add(lblTongHoaDon);
		
		JLabel lblTienKhachDuaText = new JLabel("");
		lblTienKhachDuaText.setForeground(Color.RED);
		lblTienKhachDuaText.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblTienKhachDuaText.setBounds(341, 486, 138, 25);
		pnHoaDon.add(lblTienKhachDuaText);
	}
}
