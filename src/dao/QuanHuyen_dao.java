package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.MyConnection;
import entity.QuanHuyen;

public class QuanHuyen_dao {
	private  Connection con;
	private String id;
	public QuanHuyen_dao() {
		con = MyConnection.getInstance().getConnection();
	}
	
	public List<QuanHuyen> getDsQH(String id) {
		List<QuanHuyen> ds = new ArrayList<QuanHuyen>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from QuanHuyen where tinhThanhPhoId = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				QuanHuyen qh = new QuanHuyen(rs.getString("ID"), rs.getString("tenQuanHuyen"), rs.getString("tinhThanhPhoId"));
				ds.add(qh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public String getIdQuanHuyen(String ten) {
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from QuanHuyen where tenQuanHuyen = ?");
			stmt.setString(1, ten);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
}

