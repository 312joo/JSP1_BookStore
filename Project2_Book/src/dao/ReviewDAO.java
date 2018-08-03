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
	
	//���� ����ϱ�
	@SuppressWarnings("resource")
	public int insertReview(ReviewBean bean) {
		int insertCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int avg=0;
		
		try {
			pstmt=con.prepareStatement("insert into review values(?,?,?,?)");
			pstmt.setInt(1, bean.getBook_num());
			pstmt.setInt(2, bean.getBook_star());
			pstmt.setString(3, bean.getCustomer_id());
			pstmt.setString(4, bean.getBook_review());
			
			insertCount=pstmt.executeUpdate();
			
			//������ ���� �ҷ�����
			if(insertCount>0) {
			
				ReviewDAO reviewDAO=getInstance();
				int count=reviewDAO.countReview(bean.getBook_num());
				pstmt=con.prepareStatement("select star_average from book where book_num=?");
				pstmt.setInt(1, bean.getBook_num());
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					avg=rs.getInt(1);
				}
				
				//���� �ٽ� ��� �� �ݿ�
															//DB���� *10, input���� 1
				avg=Math.round((avg*(count-1)+bean.getBook_star()*10)/count);
				pstmt=con.prepareStatement("update book set star_average=? where book_num=?");
				pstmt.setInt(1, avg);
				pstmt.setInt(2, bean.getBook_num());
				insertCount=pstmt.executeUpdate();
					
			}
		}catch(SQLException e) {
			System.out.println("insertReview ����: "+e);
			
		}finally {
			close(rs);
			close(pstmt);
		}
			
		return insertCount;
	}
	
	//������ ���� ����
	public int countReview(int book_num) {
		int count=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement("select count(*) from review where book_num=?");
			pstmt.setInt(1, book_num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}catch(SQLException e) {
			System.out.println("countReview ����: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	//������ - ���� ����Ʈ
	public ArrayList<ReviewBean> selectReview(int book_num) {
		int selectCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ReviewBean> list=new ArrayList<ReviewBean>();
		ReviewBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from review where book_num=?");
			pstmt.setInt(1, book_num);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new ReviewBean();
				bean.setBook_num(book_num);
				bean.setBook_review(rs.getString("book_review"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setStar_point(rs.getInt("book_star"));
				list.add(bean);
			}
			
			
		}catch(SQLException e) {
			System.out.println("selectReview_booknum ����: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	//���� - ���� ����Ʈ
	public ArrayList<ReviewBean> selectReview(String customer_id) {
		int selectCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ReviewBean> list=new ArrayList<ReviewBean>();
		ReviewBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from review where customer_id=?");
			pstmt.setString(1, customer_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new ReviewBean();
				bean.setBook_num(rs.getInt("book_num"));
				bean.setBook_review(rs.getString("book_review"));
				bean.setCustomer_id(rs.getString(customer_id));
				bean.setStar_point(rs.getInt("book_star"));
				list.add(bean);
			}
			
			
		}catch(SQLException e) {
			System.out.println("selectReview_booknum ����: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	
	//���� ����
	@SuppressWarnings("resource")
	public int deleteReview(String customer_id, int book_num) {
		int deleteCount	=0, insertCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int avg=0, deletPoint=0;
		
		try {
			
			//�����Ϸ��� ���� ���� �ҷ�����
			pstmt=con.prepareStatement("select book_star from review where customer_id=? and book_num=?");
			pstmt.setString(1, customer_id);
			pstmt.setInt(2, book_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				deletPoint=rs.getInt(1);	
			}
			
			
			int count=countReview(book_num);	
			
			//����
			pstmt=con.prepareStatement("delete from review where customer_id=? and book_num=?");
			pstmt.setString(1, customer_id);
			pstmt.setInt(2, book_num);
			deleteCount=pstmt.executeUpdate();

			
			//���� ���� �ҷ�����
			if(deleteCount>0) {
			pstmt=con.prepareStatement("select star_average from book where book_num=?");	
			pstmt.setInt(1, book_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				avg=rs.getInt(1);	
			}
			
			
			//���� �ٽ� ��� �� �ݿ�
													//DB���� *10, input���� 1
			avg=Math.round(((avg*count)-deletPoint*10)/(count-1));
			pstmt=con.prepareStatement("update book set star_average=? where book_num=?");
			pstmt.setInt(1, avg);
			pstmt.setInt(2, book_num);
			insertCount=pstmt.executeUpdate();
				
			}
			
		}catch(SQLException e) {
			System.out.println("deleteReview ����: "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

}
