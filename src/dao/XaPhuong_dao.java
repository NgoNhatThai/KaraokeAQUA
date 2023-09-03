package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.MyConnection;
import entity.XaPhuong;


public class XaPhuong_dao {
	private  Connection con;
	public XaPhuong_dao() {
		con = MyConnection.getInstance().getConnection();
	}
	
	public List<XaPhuong> getDsXp(String id) {
		List<XaPhuong> ds = new ArrayList<XaPhuong>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from XaPhuong where quanHuyenId = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				XaPhuong xp = new XaPhuong(rs.getString("ID"), rs.getString("tenXaPhuong"), rs.getString("quanHuyenId"));
				ds.add(xp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
