package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ReviewDAO;


public class ReviewDeleteService {

	public boolean deleteReview(String customer_id, int book_num) {
		
		boolean isDeleteSuccess=false;
		int deleteCount=0;
		ReviewDAO reviewDAO=ReviewDAO.getInstance();
		Connection con = getConnection();
		reviewDAO.setConnection(con);
		
		deleteCount=reviewDAO.deleteReview(customer_id, book_num);
		
		if(deleteCount>0) {
			commit(con);
			isDeleteSuccess=true;
		}else rollback(con);
		
		close(con);
		
		return isDeleteSuccess;
	}
}
