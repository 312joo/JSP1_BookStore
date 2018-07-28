package svc;

import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.LoginDAO;
import vo.CustomerBean;
import static db.JdbcUtil.*;

public class JoinService{

	public boolean joinArticle(CustomerBean bean) {

		boolean isJoinSuccess=false;
		Connection con=getConnection();
		LoginDAO loginDAO=LoginDAO.getInstance();
		loginDAO.setConnection(con);
		int joinCount=loginDAO.insertJoinCustomer(bean);
		
		if(joinCount>0) {
			commit(con);
			isJoinSuccess=true;
		}else rollback(con);
		
		close(con);
		return isJoinSuccess;
	}
	
	public boolean idCheck(String id) {
		
		boolean isId=true; //중복임
		Connection con=getConnection();
		LoginDAO loginDAO=LoginDAO.getInstance();
		loginDAO.setConnection(con);
		int idCount=loginDAO.selectIdCheck(id);
				
		if(idCount==0) {
			commit(con);
			isId=false;	//중복아님
		}else rollback(con);
		
		close(con);
		return isId;
	}

}
