package svc;
import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BookDAO;
import vo.BookListBean;

public class BookModifyService {

	public boolean modifyBookArticle(BookListBean bean) throws Exception{
		boolean isModifySuccess=false;
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		int updateCount=bookDAO.updateArticle(bean);
	
		if(updateCount>0) {
			commit(con);
			isModifySuccess=true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isModifySuccess;
	}
	
}
