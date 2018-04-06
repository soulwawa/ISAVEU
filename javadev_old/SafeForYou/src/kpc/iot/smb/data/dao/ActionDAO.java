package kpc.iot.smb.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kpc.iot.smb.data.vo.TbActionIdVO;
import kpc.iot.smb.util.DBManager;

public class ActionDAO {
	//rasp(camera)
	private static final String INSERT_SQL = "insert into tb_action (module_id, url, time) values (2, ?, now());";
	
	public void insertPicture(TbActionIdVO vo) {
		try(Connection conn = DBManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1, vo.getUrl());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
