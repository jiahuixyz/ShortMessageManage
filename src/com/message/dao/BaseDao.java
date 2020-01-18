package com.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {

	private static Connection conn;
	private static PreparedStatement pstmt;
	protected static ResultSet rs;

	private static Connection getConnnection() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet query(String sql, Object... obj) throws SQLException {
		pstmt = getConnnection().prepareStatement(sql);
		for (int i = 0; i < obj.length; i++) {
			pstmt.setObject(i + 1, obj[i]);
		}
		return pstmt.executeQuery();
	}
	
	public static int alter(String sql,Object...obj) throws SQLException {
		pstmt=getConnnection().prepareStatement(sql);
		for (int i = 0; i < obj.length; i++) {
			pstmt.setObject(i + 1, obj[i]);
		}
		return pstmt.executeUpdate();
	}
}
