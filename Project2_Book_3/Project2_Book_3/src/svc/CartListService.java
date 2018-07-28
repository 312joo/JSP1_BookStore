package svc;
import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.CartDAO;
import vo.CartListBean;
import vo.GroupListBean;

public class CartListService {

	//list¹ÝÈ¯
	public ArrayList<CartListBean> getCartList(String customer_id) throws Exception{
		ArrayList<CartListBean> cartList=null;
		Connection con=getConnection();
		CartDAO cartDAO=CartDAO.getInstance();
		cartDAO.setConnection(con);
		
		cartList=cartDAO.selectCartList(customer_id);
		
		close(con);
		
		return cartList;
		
	}
	
}
