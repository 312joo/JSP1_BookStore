package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BookDAO;

public class BookDeleteService {

	public boolean removeBook(int book_num) {
		
		boolean isRemoveSuccess=false;
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		int deleteCount=bookDAO.DeleteArticle(book_num);
		
		if(deleteCount>0) {
			commit(con);
			isRemoveSuccess=true;
		}
		else {
			rollback(con);
		}
		
		close (con);
		
		return isRemoveSuccess;
	}
}
