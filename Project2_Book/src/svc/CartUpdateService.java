package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.CartDAO;

public class CartUpdateService {

	public boolean updateAmount(int cart_amount, String customer_id, int book_num) {
		
		boolean isUpdateSuccess=false;
		CartDAO cartDAO=CartDAO.getInstance();
		Connection con = getConnection();
		cartDAO.setConnection(con);
		
		int count=cartDAO.updateCartAmount(cart_amount, customer_id, book_num);

		if(count>0) {
			commit(con);
			isUpdateSuccess=true;
		}else rollback(con);
		
		close(con);
		
		return isUpdateSuccess;
		
	}
	
	
}
