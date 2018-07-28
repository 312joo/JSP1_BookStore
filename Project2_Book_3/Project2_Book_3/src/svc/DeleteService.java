package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class DeleteService {

	public boolean removeArticle(int group_num) {
		
		boolean isRemoveSuccess=false;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount=boardDAO.DeleteArticle(group_num);
		
		if(deleteCount>0) {
			commit(con);
			isRemoveSuccess=true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		
		return isRemoveSuccess;
	}
}
