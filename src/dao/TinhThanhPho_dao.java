package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.MyConnection_DiaChi;
import entity.TinhThanhPho;

public class TinhThanhPho_dao {
	private Connection connection;
	private String id;

	public TinhThanhPho_dao() {
		connection = MyConnection_DiaChi.getInstance().getConnection();
	}

	public List<TinhThanhPho> getDsDC() {
		List<TinhThanhPho> ds = new ArrayList<TinhThanhPho>();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from TinhThanhPho");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TinhThanhPho ttp = new TinhThanhPho(rs.getString("ID"), rs.getString("tenTinhThanhPho"));
				ds.add(ttp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public String getIdTinhTP(String ten) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from TinhThanhPho where tenTinhThanhPho = ?");
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
