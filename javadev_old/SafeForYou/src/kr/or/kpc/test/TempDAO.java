package kr.or.kpc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpc.iot.smb.util.DBManager;

public class TempDAO {
	private static final String INSERT_SQL = "insert into tbl_temp values(null, ?, ?, ?, now() );";
	private static final String LIST_SQL = "select * from tbl_temp where loc = ? order by num desc limit 0, 10;";

	public void insertTemp(TempVO vo){

		try(Connection conn = DBManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1, vo.getLoc());
			stmt.setString(2, vo.getType());
			stmt.setString(3, vo.getTemperature());
			int cnt = stmt.executeUpdate();
			System.out.println(cnt == 1 ? "success" : "fail");
		}catch(SQLException e){
			System.out.println("insert error : " + e);
		}
	}
	public ArrayList<TempVO> getTempList(TempVO vo ){
		ArrayList<TempVO> list = new ArrayList<TempVO>();
		try(Connection conn = DBManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(LIST_SQL);
			stmt.setString(1, vo.getLoc());
			ResultSet rst = stmt.executeQuery();
			TempVO temp = null;
			while(rst.next()){
				temp = new TempVO();
				temp.setNum(rst.getString(1));
				temp.setLoc(rst.getString(2));
				temp.setType(rst.getString(3));
				temp.setTemperature(rst.getString(4));
				temp.setIdate(rst.getString(5));
				list.add(temp);
			}
		}catch(SQLException e){System.out.println("list error : " + e);}
		return list;
	}
}