package com.asthvinayak.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {

	public final static String URL = "jdbc:mysql://127.0.0.1:3306/cust_inboard";
	public final static String USER_NAME = "root";
	public final static String PASSWORD = "";

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * For getting connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		return con;
	}

	/**
	 * 
	 * @param con
	 * @param pstm
	 * @param rs
	 * @throws SQLException
	 */
	public static void closecConnection(Connection con, PreparedStatement pstm, ResultSet rs) throws SQLException {
		if (null != rs) {
			rs.close();
		}
		if (null != pstm) {
			pstm.close();
		}
		if (null != con) {
			con.close();
		}

	}

}
