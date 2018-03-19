package kpc.iot.smb.data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kpc.iot.smb.data.VO.TbEventVO;
import kpc.iot.smb.util.DBManager;

public class EventDAO {
	private static final String INSERT_SQL = "insert into tb_event values (null,?,now(),?,?,?,?,?);";
	private static final String Select_SQL_ID = "select * from tb_hr where id = ?;";
	
	public void insertEvent(TbEventVO vo) {
		
		try(Connection conn = DBManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1, vo.getModule_id());
			stmt.setFloat(2, vo.getTemp());
			stmt.setFloat(3, vo.getSmoke());
			stmt.setFloat(4, vo.getGyro());
			stmt.setFloat(5, vo.getFire());
			stmt.setString(6, vo.getIssue());
			int cnt = stmt.executeUpdate();
			System.out.println(cnt == 1 ? "EventDAO Insert Success" : "EventDAO Insert Fail");
		}catch(SQLException e) {
			System.out.println("EventDAO Insert:" +  e);
		}
		
		
	}
	
}
