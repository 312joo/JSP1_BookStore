package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BoardDAO;
import vo.GroupListBean;

public class ModifyService {
	
	public boolean modifyArticle(GroupListBean bean) throws Exception{
		
		boolean isModifySuccess=false;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.UpdateArticle(bean);

		if(updateCount>0) {
			commit(con);
			isModifySuccess=true;
		}
		else {
			rollback(con);
		}
		

		close(con);
		
		return isModifySuccess;		
		
	}
}
