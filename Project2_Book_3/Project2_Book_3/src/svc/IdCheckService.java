package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;

public class IdCheckService {

	public boolean checkIdDuplicated(String id) throws Exception{
		
		Connection con=getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		
		int checkCount=loginDAO.selectIdCheck(id);
				
		//�ߺ��ƴ�
		if(checkCount==0) {
			return false;
		}
		//�ߺ���
		else {
			return true;
		}
	}
}
