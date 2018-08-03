package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.BookDAO;
import vo.BookListBean;

public class BookListForCustomerService {

	
	//Category List
	public ArrayList<BookListBean> getCategoryList(int field) throws Exception{
		
		ArrayList<BookListBean> list=null;
		
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		list=bookDAO.selectListForCustomer(field);

		close(con);
		
		return list;
	}
	
	//그 외 리스트
	public ArrayList<BookListBean> getEtcList(String push) throws Exception{
		 
		ArrayList<BookListBean> list=null;
		
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		list=bookDAO.selectListForCustomer(push);
			
		close(con);
		
		return list;
	}
	
}
