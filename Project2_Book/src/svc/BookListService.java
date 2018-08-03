package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;
import vo.BookListBean;



public class BookListService {

	//총 list 수 반환
	public int getListCount() throws Exception{
		int listCount=0;
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		listCount=bookDAO.selectListCount();
		close(con);
		
		return listCount;
	}
	
	//list 반환
	public ArrayList<BookListBean> getBookList(int nowPage, int limit) throws Exception{
		ArrayList<BookListBean> list=null;
		Connection con=getConnection();
		BookDAO bookDAO=BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		list=bookDAO.selectList(nowPage, limit);
		
		close(con);
		
		return list;
	}
	
}
