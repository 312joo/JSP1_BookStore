package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.LoginDAO;

public class CustomerDeleteService {

	public boolean removeCustomer(String customer_id) {
		
		boolean isRemoveSuccess=false;
		Connection con=getConnection();
		LoginDAO loginDAO=LoginDAO.getInstance();
		loginDAO.setConnection(con);
		int deleteCount=loginDAO.deleteCustomer(customer_id);
		
		
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
