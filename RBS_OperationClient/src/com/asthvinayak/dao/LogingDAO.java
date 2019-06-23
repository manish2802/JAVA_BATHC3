package com.asthvinayak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asthvinayak.constant.QueryConstant;
import com.asthvinayak.util.DButil;

public class LogingDAO {
	public static LogingDAO INSTANCE = null;

	private LogingDAO() {

	}

	public static synchronized LogingDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LogingDAO();
			return INSTANCE;
		}
		return INSTANCE;

	}

	/**
	 * For Authentication
	 * 
	 * @param userName
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public boolean getLogin(String userName, String password) {

		System.out.println("Enter into getLogin ");
		Connection con;
		PreparedStatement pmts;
		ResultSet rs;
		boolean b = false;
		try {
			con = DButil.getConnection();

			// preparedstatment
			pmts = con.prepareStatement(QueryConstant.GET_LOGIN);
			pmts.setString(1, userName);
			pmts.setString(2, password);

			// execute
			rs = pmts.executeQuery();

			// Result
			if (rs.next()) {
				b = true;
			}

			DButil.closecConnection(con, pmts, rs);
			return b;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;

	}

	public static void getTx(String userName, String password) {

		Connection con;
		PreparedStatement pmts;
		ResultSet rs;
		try {
			con = DButil.getConnection();

			// preparedstatment
			pmts = con.prepareStatement(QueryConstant.GET_LOGIN);

			// execute
			rs = pmts.executeQuery();

			// Result
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			}

			DButil.closecConnection(con, pmts, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
