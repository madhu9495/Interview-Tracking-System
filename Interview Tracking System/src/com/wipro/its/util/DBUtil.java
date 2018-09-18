package com.wipro.its.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static Connection con;

	public static Connection getDBConnection(String driverType) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "batch4", "batch4");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
