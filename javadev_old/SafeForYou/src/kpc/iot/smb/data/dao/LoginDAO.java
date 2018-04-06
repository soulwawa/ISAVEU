package kpc.iot.smb.data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import kpc.iot.smb.data.vo.TbHrVO;

public class LoginDAO {
	private static LoginDAO loginDAO;
	private Connection con;
	
	private LoginDAO() {
	}
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public TbHrVO selectLoginMember(String id, String pwd) {
		TbHrVO loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from tb_hr where id = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginMember = new TbHrVO();
				loginMember.setHr_id(rs.getInt(1));
				loginMember.setId(rs.getString(2));
				loginMember.setPw(rs.getString(3));
				loginMember.setName(rs.getString(4));
				loginMember.setLocation_id(rs.getInt(5));
				loginMember.setTel(rs.getString(6));
				loginMember.setEmail(rs.getString(7));
				loginMember.setSex(rs.getString(8));
				loginMember.setBirthday(rs.getString(9));
				loginMember.setLevel(rs.getString(10));
				loginMember.setFcm(rs.getString(11));
				loginMember.setFcm(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					close(rs);
					close(pstmt);
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		return loginMember;
	}
	
	public static void close(ResultSet rst) {
		try {
			if(rst != null)
				rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rst = null;
		}
	}
	
	public static void close(PreparedStatement stmt) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
	}
}
