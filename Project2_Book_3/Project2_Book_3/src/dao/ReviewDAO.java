package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ReviewBean;

public class ReviewDAO {

	Connection con;
	private static ReviewDAO reviewDAO;
	
	private ReviewDAO() {
		
	}
	
	public static ReviewDAO getInstance() {
		if(reviewDAO==null) reviewDAO=new ReviewDAO();
		
		return reviewDAO;
	}
	
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	//리뷰 등록하기
	@SuppressWarnings("resource")
	public int insertReview(ReviewBean bean) {
		int insertCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int avg=0;
		
		try {
			pstmt=con.prepareStatement("insert into bookReview values(?,?,?,?)");
			pstmt.setInt(1, bean.getBook_num());
			pstmt.setString(2, bean.getCustomer_id());
			pstmt.setInt(3, bean.getBook_star());
			pstmt.setString(4, bean.getBook_review());
			
			insertCount=pstmt.executeUpdate();
			
			//기존의 평점 불러오기
			if(insertCount>0) {
			
				ReviewDAO reviewDAO=getInstance();
				int count=reviewDAO.countReview(bean.getBook_num());
				pstmt=con.prepareStatement("select star_average from book where book_num=?");
				pstmt.setInt(1, bean.getBook_num());
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					avg=rs.getInt(1);
				}
				
				
				//평점 다시 계산 후 반영
																	//DB값은 *10, input값은 1
				avg=Math.round((avg+bean.getBook_star()*10)/count);
				pstmt=con.prepareStatement("update bookReview set star_average=?");
				pstmt.setInt(1, avg);
				
				insertCount=pstmt.executeUpdate();
					
			}
		}catch(SQLException e) {
			System.out.println("insertReview 에러: "+e);
			
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return insertCount;
	}
	
	//도서별 리뷰 개수
	public int countReview(int book_num) {
		int count=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement("select count(*) from bookReview where book_num=?");
			pstmt.setInt(1, book_num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}catch(SQLException e) {
			System.out.println("countReview 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	//도서별 - 리뷰 리스트
	public ArrayList<ReviewBean> selectReview(int book_num) {
		int selectCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ReviewBean> list=new ArrayList<ReviewBean>();
		ReviewBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from bookReview where book_num=?");
			pstmt.setInt(1, book_num);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new ReviewBean();
				bean.setBook_num(book_num);
				bean.setBook_review(rs.getString("book_review"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setStar_point(rs.getInt("star_point"));
				list.add(bean);
			}
			
			
		}catch(SQLException e) {
			System.out.println("selectReview_booknum 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	//고객별 - 리뷰 리스트
	public ArrayList<ReviewBean> selectReview(String customer_id) {
		int selectCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ReviewBean> list=new ArrayList<ReviewBean>();
		ReviewBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from bookReview where customer_id=?");
			pstmt.setString(1, customer_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new ReviewBean();
				bean.setBook_num(rs.getInt("book_num"));
				bean.setBook_review(rs.getString("book_review"));
				bean.setCustomer_id(rs.getString(customer_id));
				bean.setStar_point(rs.getInt("star_point"));
				list.add(bean);
			}
			
			
		}catch(SQLException e) {
			System.out.println("selectReview_booknum 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	

}
