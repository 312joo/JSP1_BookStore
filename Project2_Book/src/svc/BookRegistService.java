package svc;

import java.sql.Connection;

import dao.BookDAO;
import vo.BookListBean;
import static db.JdbcUtil.*;

public class BookRegistService {

	public boolean registBook(BookListBean bean) {
		
		BookDAO bookDAO=BookDAO.getInstance();
		Connection con=getConnection();
		bookDAO.setConnection(con);
		boolean isRegistSuccess=false;
		int insertCount=bookDAO.insertBook(bean);
		
		if(insertCount>0) {
			
			commit(con);
			isRegistSuccess=true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
}
