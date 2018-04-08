package svc;

import java.sql.Connection;

import kpc.iot.smb.data.dao.LoginDAO;
import kpc.iot.smb.data.vo.TbHrVO;
import kpc.iot.smb.util.DBManager;


public class LoginService {
	public TbHrVO getLoginMeber (String id, String passwd) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = DBManager.getConnection();
		loginDAO.setConnection(con);
		TbHrVO loginMember = loginDAO.selectLoginMember(id,passwd);
		close(con);
		return loginMember;		
	}
	public static void close(Connection con) {
		try {
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con = null;
		}
	}
}
