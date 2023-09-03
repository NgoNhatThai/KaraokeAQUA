//Huỳnh Hữu Phước
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.MyConnection;
import entity.NhanSu;
import entity.TaiKhoan;
import entity.ThongTinTaiKhoan;

public class NhanSu_dao {
	private Connection con;
	private String sql;
	private PreparedStatement prstmt;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private NhanSu ns;

	public NhanSu_dao() {
		con = MyConnection.getInstance().getConnection();
	}

	public List<NhanSu> getDanhSachNhanSu() {
		List<NhanSu> dsns = new ArrayList<>();
		try {
			preparedStatement = con.prepareStatement(
					"SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai, NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien order by MaNhanVien");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanSu ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"),
						resultSet.getString("TenNV"), resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"),
						resultSet.getInt("tuoi"), resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"), resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
				dsns.add(ns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsns;
	}

	public List<NhanSu> getDanhSachNhanSuTheoTen() {
		List<NhanSu> dsns = new ArrayList<>();
		try {
			preparedStatement = con.prepareStatement(
					"SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai,  NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien order by TenNV");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanSu ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"),
						resultSet.getString("TenNV"), resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"),
						resultSet.getInt("tuoi"), resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"),resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
				dsns.add(ns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsns;
	}

	public List<NhanSu> getDanhSachNhanSuTheoTuoi() {
		List<NhanSu> dsns = new ArrayList<>();
		try {
			preparedStatement = con.prepareStatement(
					"SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai, NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien order by Tuoi");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanSu ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"),
						resultSet.getString("TenNV"), resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"),
						resultSet.getInt("tuoi"), resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"),resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
				dsns.add(ns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsns;
	}

	public boolean insertNS(NhanSu i) {
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into NhanVien(MaNhanVien, HoNV, TenNV, GioiTinh, NgaySinh, DiaChi, SoDienThoai, TenTaiKhoan, MaCaTruc) values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, i.getMaNV());
			stmt.setString(2, i.getHoNV());
			stmt.setString(3, i.getTenNV());
			stmt.setBoolean(4, i.getGioiTinh());
			stmt.setDate(5, new java.sql.Date(i.getNgaySinh().getTime()));
			stmt.setString(6, i.getDiaChi());
			stmt.setString(7, i.getSDT());
			stmt.setString(8, i.getMaNV());
			stmt.setString(9, null);

			int n = stmt.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteNS(String mans) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from NhanVien where MaNhanVien = ?");
			stmt.setString(1, mans);
			int n = stmt.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<NhanSu> getDSNS(String MaNhanVien) {
		List<NhanSu> dsNS = new ArrayList<NhanSu>();
		sql = "SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai, NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien where MaNhanVien = ?";
		try {
			prstmt = con.prepareStatement(sql);
			prstmt.setString(1, MaNhanVien);
			resultSet = prstmt.executeQuery();
			NhanSu ns;
			while (resultSet.next()) {
				ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"), resultSet.getString("TenNV"),
						resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"), resultSet.getInt("tuoi"),
						resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"), resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
				dsNS.add(ns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNS;
	}
	public NhanSu getNS(String MaNhanVien) {
		sql = "SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai, NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien where MaNhanVien = ?";
		try {
			prstmt = con.prepareStatement(sql);
			prstmt.setString(1, MaNhanVien);
			resultSet = prstmt.executeQuery();
			while (resultSet.next()) {
				ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"), resultSet.getString("TenNV"),
						resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"), resultSet.getInt("tuoi"),
						resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"), resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ns;
	}
	public List<NhanSu> getDSNSTheoTen(String tenNV) {
		List<NhanSu> dsNS = new ArrayList<NhanSu>();
		sql = "SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai, NhanVien.DiaChi, NhanVien.TenTaiKhoan , NhanVien.TrangThai FROM  NhanVien  WHERE TenNV LIKE ?";
		try {
			String forSql = "%"+tenNV+"%";
			prstmt = con.prepareStatement(sql);
			prstmt.setString(1, forSql);
			resultSet = prstmt.executeQuery();
			NhanSu ns;
			while (resultSet.next()) {
				ns = new NhanSu(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"), resultSet.getString("TenNV"),
						resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"), resultSet.getInt("tuoi"),
						resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"), resultSet.getString("TenTaiKhoan"), resultSet.getBoolean("TrangThai"));
				dsNS.add(ns);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNS;
	}

	public ThongTinTaiKhoan getThongTinTabCaNhan(TaiKhoan tk) {
		try {
			preparedStatement = con.prepareStatement(
					"SELECT NhanVien.MaNhanVien, NhanVien.HoNV, NhanVien.TenNV, NhanVien.GioiTinh, NhanVien.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NhanVien.NgaySinh), NhanVien.SoDienThoai,  NhanVien.DiaChi, NhanVien.TenTaiKhoan, NhanVien.TrangThai FROM  NhanVien where TenTaiKhoan = ?");
			preparedStatement.setString(1, tk.getTenTK());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ThongTinTaiKhoan tttk = new ThongTinTaiKhoan(resultSet.getString("MaNhanVien"), resultSet.getString("HoNV"),
						resultSet.getString("TenNV"), resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh"),
						resultSet.getInt("tuoi"), resultSet.getString("SoDienThoai"), resultSet.getString("DiaChi"), resultSet.getString("TenTaiKhoan"));
				return tttk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getTongSoNhanSu() throws SQLException {
		preparedStatement = con.prepareStatement(
				"SELECT * FROM NhanVien");
		resultSet = preparedStatement.executeQuery();
		int n = 0;
		while (resultSet.next()) {
			n+=1;
		}
		return n;
	}
}
