package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;
import vo.CustomerBean;

public class LoginService {

	public CustomerBean getLoginCustomer(String customer_id, String customer_pass) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		CustomerBean bean=loginDAO.selectLoginCustomer(customer_id, customer_pass);
		close(con);
		
		return bean;
	}
}
