package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.GroupListBean;
import static db.JdbcUtil.*;

public class DetailService {

	public GroupListBean getDetail(int group_num) throws Exception{
		
		GroupListBean bean=null;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount=boardDAO.UpdateReadCount(group_num);
		
		if(updateCount>0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		
		bean=boardDAO.selectDetail(group_num);
		close(con);
		
		return bean;
	}
	
}
