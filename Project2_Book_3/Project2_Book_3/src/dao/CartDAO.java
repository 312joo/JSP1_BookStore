package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.CartListBean;
import vo.GroupListBean;

public class CartDAO {

	Connection con;
	
	private static CartDAO cartDAO;
	
	public CartDAO() {
		
	}
	
	public static CartDAO getInstance() {
		if(cartDAO==null) cartDAO=new CartDAO();
		
		return cartDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	
	//장바구니 책 추가
	public int insertCart(CartListBean bean) {
		int insertCount=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("insert into cart values(?,?,?,?,?,?)");
			pstmt.setInt(1, bean.getBook_num());
			pstmt.setString(2, bean.getcustomer_id());
			pstmt.setInt(3, bean.getCart_amount());
			pstmt.setString(4,bean.getBook_subject());
			pstmt.setInt(5, bean.getPrice());
			pstmt.setString(6, bean.getImage_file());
	
			insertCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("InsertCart 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	

	
	//장바구니 상품 수량 변경
	public int updateCartAmount(int cart_amount, String customer_id, int book_num) {
		int updateCount=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("update cart set cart_amount=? where customer_id=? and book_num=?");
			pstmt.setInt(1, cart_amount);
			pstmt.setString(2, customer_id);
			pstmt.setInt(3, book_num);
			updateCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("UpdateCartAmount 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	
	//CartListBean클래스를 ArrayList로 반환
	public ArrayList<CartListBean> selectCartList(String customer_id){
	
		ArrayList<CartListBean> cartList=null;
		CartListBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		
		try {
			pstmt=con.prepareStatement("select * from cart where customer_id=? ");
			cartList=new ArrayList<CartListBean>();
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new CartListBean();
				bean.setBook_num(rs.getInt("book_num"));
				bean.setCart_amount(rs.getInt("cart_amount"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setBook_subject(rs.getString("book_subject"));
				bean.setPrice(rs.getInt("price"));
				bean.setImage_file(rs.getString("image_file"));
				
				cartList.add(bean);
			}
			
		}catch(SQLException e) {
			System.out.println("selectCartList 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return cartList;
	}
	
	
	//장바구니 삭제
	public int deleteCart(String customer_id, int book_num) {
		
		PreparedStatement pstmt=null;
		int deleteCount=0;
		try {
			pstmt=con.prepareStatement("delete from cart where customer_id=? and book_num=?");
			pstmt.setString(1, customer_id);
			pstmt.setInt(2, book_num);
			deleteCount=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("DeleteCart 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
}
