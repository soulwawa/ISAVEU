package kr.or.kpc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public static Connection getConnection() {
		try {
			//���ڿ��� ���޵Ǵ� Ŭ������ �����ϴ� Ŭ������ �޸𸮷� �ε��ϴ� ��Ȱ.
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.0.13:3306/mydb", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	public static void close(ResultSet rst, PreparedStatement stmt, Connection conn) {
		try {
			if(rst != null)
				rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rst = null;
		}
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}

