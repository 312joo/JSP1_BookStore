package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.LoginDAO;
import vo.BookListBean;
import vo.CustomerBean;

public class CustomerListService {
	
	//list 반환
	public ArrayList<CustomerBean> getCustomerList() throws Exception{
		ArrayList<CustomerBean> list=new ArrayList<CustomerBean>();
		Connection con=getConnection();
		LoginDAO loginDAO=LoginDAO.getInstance();
		loginDAO.setConnection(con);
		
		list=loginDAO.selectCustomerList();
		
		close(con);
		
		return list;
	}
	
	
	//회원 1인 정보 반환
	public CustomerBean getCustomerDetail(String customer_id) throws Exception{
		CustomerBean bean=new CustomerBean();
		Connection con=getConnection();
		LoginDAO loginDAO=LoginDAO.getInstance();
		loginDAO.setConnection(con);
		bean=loginDAO.selectLoginCustomer(customer_id);
		
		close(con);
		
		return bean;
	}
}
