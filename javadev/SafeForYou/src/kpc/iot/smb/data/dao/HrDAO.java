package kpc.iot.smb.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpc.iot.smb.data.vo.TbHrVO;
import kpc.iot.smb.util.DBManager;

public class HrDAO {
	private static final String Select_SQL_ID = "select * from tb_hr where id = ?;";
	
	public ArrayList<TbHrVO> getHrList(TbHrVO vo){
		ArrayList<TbHrVO> list = new ArrayList<TbHrVO>(); 
			try(Connection conn = DBManager.getConnection()){
				PreparedStatement stmt = conn.prepareStatement(Select_SQL_ID);
				stmt.setString(1, vo.getId());
//				System.out.println(stmt);
				ResultSet rst = stmt.executeQuery();
				TbHrVO hrVo = null;
				while(rst.next()) {
					hrVo = new TbHrVO();
					hrVo.setHr_id(rst.getInt(1));
					hrVo.setId(rst.getString(2));
					hrVo.setPw(rst.getString(3));
					hrVo.setName(rst.getString(4));
					hrVo.setLocation_id(rst.getInt(5));
					hrVo.setTel(rst.getString(6));
					hrVo.setEmail(rst.getString(7));
					hrVo.setSex(rst.getString(8));
					hrVo.setBirthday(rst.getString(9));
					hrVo.setLevel(rst.getString(10));
					hrVo.setFcm(rst.getString(11));
					hrVo.setProfile(rst.getString(12));
					list.add(hrVo);
				}
			}catch (SQLException e) {
				System.out.println("Select ID Error: " + e);
			}return list;
	}
	
}
