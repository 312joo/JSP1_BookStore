package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BookDAO;
import vo.BookListBean;

public class BookViewService {

	public BookListBean getBookView(int book_num) {
		
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);

		BookListBean bean=bookDAO.selectBookDetail(book_num);
		close(con);
		
		return bean;
	}
}
