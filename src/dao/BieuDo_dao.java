
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.MyConnection;
import entity.HoaDon;

public class BieuDo_dao {
	private Connection con;

	public BieuDo_dao() {
		con = MyConnection.getInstance().getConnection();
	}
	public float loadDoanhThuQuy1() {
    	float tongDoanhThu=0;
    	try {
			PreparedStatement smt= con.prepareStatement("select * from HoaDon where month(ThoiDiemTT) in (1,2,3)");
			ResultSet rs= smt.executeQuery();
			while (rs.next()) {
				tongDoanhThu+=rs.getFloat("TongThanhToan");
				
			}
			return tongDoanhThu;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    
    }
    public float loadDoanhThuQuy2() {
    	float tongDoanhThu=0;
    	try {
			PreparedStatement smt= con.prepareStatement("select * from HoaDon where month(ThoiDiemTT) in (4,5,6)");
			ResultSet rs= smt.executeQuery();
			while (rs.next()) {
				tongDoanhThu+=rs.getFloat("TongThanhToan");
				
			}
			return tongDoanhThu;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    
    }
    public float loadDoanhThuQuy3() {
    	float tongDoanhThu=0;
    	try {
			PreparedStatement smt= con.prepareStatement("select * from HoaDon where month(ThoiDiemTT) in (7,8,9)");
			ResultSet rs= smt.executeQuery();
			while (rs.next()) {
				tongDoanhThu+=rs.getFloat("TongThanhToan");
				
			}
			return tongDoanhThu;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    
    }
    public float loadDoanhThuQuy4() {
    	float tongDoanhThu=0;
    	try {
			PreparedStatement smt= con.prepareStatement("select * from HoaDon where month(ThoiDiemTT) in (10,11,12)");
			ResultSet rs= smt.executeQuery();
			while (rs.next()) {
				tongDoanhThu+=rs.getFloat("TongThanhToan");
				
			}
			return tongDoanhThu;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    
    }
}
	

