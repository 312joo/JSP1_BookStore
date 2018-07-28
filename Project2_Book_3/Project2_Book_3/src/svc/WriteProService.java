package svc;

import java.sql.Connection;

import dao.BoardDAO;
import vo.GroupListBean;
import static db.JdbcUtil.*;

public class WriteProService {

	public boolean registArticle(GroupListBean bean) throws Exception{
		
		boolean isWriteSuccess=false;
		Connection con= getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount=boardDAO.insertArticle(bean);
		
		if(insertCount>0) {
			commit(con);
			isWriteSuccess=true;
		}else rollback(con);
		
		close(con);
		return isWriteSuccess;
	}
}
