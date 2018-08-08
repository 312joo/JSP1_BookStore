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
		
		
	//������ ��ٱ��Ͽ� ���� �߰��Ǵ� �׸����� ���� Ȯ��
		
		ArrayList<CartListBean> cartlist=new ArrayList<CartListBean>();
		boolean isNewCart=true;
		cartlist=cartDAO.selectCartList(bean.getcustomer_id());
		
		for(int i=0;i<cartlist.size();i++) {
				//������ ����ִ� �׸��̸� �����÷��ֱ�
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

				//���� �߰��Ǵ� �׸��̸� ��ٱ��� �߰�
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
