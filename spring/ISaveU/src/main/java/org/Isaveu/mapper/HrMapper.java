package org.Isaveu.mapper;

import java.util.ArrayList;
import java.util.List;

import org.Isaveu.domain.TbHrVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.HrMapper")
// @Repository : 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시

public interface HrMapper {
//	public int hrCount() throws Exception;
	
	public ArrayList<TbHrVO> getHrAllList() throws Exception;
	// "select * from tb_hr;";
	
	public ArrayList<TbHrVO> getHrListId(String id) throws Exception;
	//"select * from tb_hr where id = ?;";
	
	public ArrayList<TbHrVO> getHrListLevel(String level) throws Exception;
	//"select * from tb_hr where level = ?;";
	
	public void hrInsert(TbHrVO hrVo) throws Exception;
	/*"INSERT INTO tb_hr 
	 * VALUES ((SELECT MAX(hr_id)+1 FROM tb_hr as e),
	 * '2222222222', 'psssword', '테스트3', '609', '010-0000-0002',
	 * 'test2@HSB.com', 'F', '20180326', '0', null,
	 * 'http://192.168.0.35:8088/SafeForYou/img/HR_profile/0000000000.png');
	 */
	
	public void fcmUpdate(TbHrVO hrVo) throws Exception;
	// "update tb_hr SET FCM = ? WHERE id = ?;";

}
