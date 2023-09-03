package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection_DiaChi {
	private Connection connection;
	private static 	MyConnection_DiaChi instance;
	
	public MyConnection_DiaChi() {
		String url ="jdbc:sqlserver://localhost:1433;databaseName=QLDiaChi";
		try {
			connection = DriverManager.getConnection(url,"sa","123456"); //sửa password thành nhom16
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static MyConnection_DiaChi getInstance() {
		if (instance==null) {
			instance = new MyConnection_DiaChi();
		}
		return instance;
	}
	 public Connection getConnection() {
		return connection;
	}
	 public void disconnect() {
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
