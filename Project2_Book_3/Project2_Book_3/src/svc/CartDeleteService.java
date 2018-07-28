package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CartDAO;

public class CartDeleteService{
	
	public boolean removeCart(String customer_id, int book_num){
	
		boolean isRemoveSuccess=false;
		Connection con =getConnection();
		CartDAO cartDAO=CartDAO.getInstance();
		cartDAO.setConnection(con);
		int deleteCount=cartDAO.deleteCart(customer_id, book_num);
		
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