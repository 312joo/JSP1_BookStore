package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CartDAO;
import vo.CartListBean;

public class CartAddService {

	public boolean addCart(CartListBean bean) {

		CartDAO cartDAO=new CartDAO();
		Connection con=getConnection();
		cartDAO.setConnection(con);
		boolean addCartSuccess=false;
		int updateCount=0;
		
		
	//도서가 장바구니에 새로 추가되는 항목인지 여부 확인
		
		ArrayList<CartListBean> cartlist=new ArrayList<CartListBean>();
		boolean isNewCart=true;
		cartlist=cartDAO.selectCartList(bean.getcustomer_id());
		
		for(int i=0;i<cartlist.size();i++) {
				//기존에 담겨있는 항목이면 수량올려주기
			if(cartlist.get(i).getBook_num()==bean.getBook_num())  {
				isNewCart=false;
				updateCount=cartDAO.addCartAmount(bean.getCart_amount(),bean.getcustomer_id(), bean.getBook_num());	
				if(updateCount>0) {
					commit(con);
					addCartSuccess=true;
				}else rollback(con);
				
				close(con);
				return addCartSuccess;
			}
		}

				//새로 추가되는 항목이면 장바구니 추가
		if(isNewCart) {
			int insertCount=cartDAO.insertCart(bean);
			
			if(insertCount>0) {
				commit(con);
				addCartSuccess=true;
			}else rollback(con);
			
			close(con);
			return addCartSuccess;
		}
		
		return addCartSuccess;
	}
	
	public boolean updateAmount(int cart_amount, String customer_id, int book_num) {
		
		CartDAO cartDAO=new CartDAO();
		Connection con=getConnection();
		cartDAO.setConnection(con);
		int updateCount=0;
		boolean isUpdateSuccess=false;
		
		updateCount=cartDAO.updateCartAmount(cart_amount, customer_id, book_num);
		
		if(updateCount>0) {
			commit(con);
			isUpdateSuccess=true;
		}
		
		else {
			rollback(con);
		}
		
		close(con);
		
		return isUpdateSuccess;
		
	}
}
