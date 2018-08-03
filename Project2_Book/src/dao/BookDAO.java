package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BookListBean;

public class BookDAO {

	Connection con;
	
	private static BookDAO bookDAO;
	
	private BookDAO() {
		
	}
	
	public static BookDAO getInstance() {
		if(bookDAO==null) bookDAO=new BookDAO();
		
		return bookDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	//책 등록하기
	public int insertBook(BookListBean bean) {
		int insertCount=0;
		PreparedStatement pstmt=null;
		
		try{
			
			String sql="insert into book (book_subject,author,translator,publisher,field,";
			sql+="price,book_content1,book_content2,stock,sales,image_file,special,star_average)";
			sql+=" values(?,?,?,?,?,?,?,?,?,0,?,?,0)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bean.getBook_subject());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setString(3, bean.getTranslator());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setInt(5, bean.getField());
			pstmt.setInt(6, bean.getPrice());
			pstmt.setString(7, bean.getBook_content1());
			pstmt.setString(8, bean.getBook_content2());
			pstmt.setInt(9, bean.getStock());
			//pstmt.setInt(10, bean.getSales());
			pstmt.setString(10, bean.getImage_file());
			pstmt.setInt(11, bean.getSpecial());
			//pstmt.setInt(12, bean.getStar_average());
			
			insertCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertBook 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		
		return insertCount;
	}
	
	
	//총 list개수 구하기
	public int selectListCount() {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
			pstmt=con.prepareStatement("select count(*) from book");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("selectListCount 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	
	//책 목록 보기
	public ArrayList<BookListBean> selectList(int nowPage, int limit){
		
		ArrayList<BookListBean> articleList=null;
		BookListBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int startrow=(nowPage-1)*limit;
		
		try {
			pstmt=con.prepareStatement("select * from book order by book_num desc limit ?, ? ");
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs=pstmt.executeQuery();
			articleList=new ArrayList<BookListBean>();
			
			while(rs.next()) {
				
				bean=new BookListBean(rs.getInt("book_num"),rs.getString("book_subject"),rs.getString("author"),
										rs.getString("translator"),rs.getString("publisher"),rs.getInt("field"),
										rs.getInt("price"),rs.getString("book_content1"), rs.getString("book_content2"),
										rs.getInt("stock"),rs.getInt("sales"),rs.getString("image_file"),rs.getInt("special"),
										rs.getInt("star_average"));

				articleList.add(bean);
			}
			
		}catch(SQLException e) {
			System.out.println("selectList 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	

	
	//자세히 보기
	public BookListBean selectBookDetail(int book_num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BookListBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from book where book_num=?");
			pstmt.setInt(1, book_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new BookListBean();
				bean.setBook_num(rs.getInt("book_num"));
				bean.setBook_subject(rs.getString("book_subject"));
				bean.setAuthor(rs.getString("author"));
				bean.setTranslator(rs.getString("translator"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setField(rs.getInt("field"));
				bean.setPrice(rs.getInt("price"));
				bean.setBook_content1(rs.getString("book_content1"));
				bean.setBook_content2(rs.getString("book_content2"));
				bean.setStock(rs.getInt("stock"));
				bean.setSales(rs.getInt("sales"));
				bean.setImage_file(rs.getString("image_file"));
				bean.setStar_average(rs.getInt("star_average"));
			}
		}catch(SQLException e) {
			System.out.println("selectBookDetail 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return bean;
	}
	
	
	//책 수정
	public int updateArticle(BookListBean bean) {
		
		PreparedStatement pstmt=null;
		int updateArticle=0;
		String sql="update book set book_subject=?, author=?, translator=?, publisher=?";
		sql+=", field=?, price=?, book_content1=?, book_content2=?, stock=?, sales=?, image_file=?, special=? where book_num=?";

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bean.getBook_subject());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setString(3, bean.getTranslator());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setInt(5, bean.getField());
			pstmt.setInt(6, bean.getPrice());
			pstmt.setString(7, bean.getBook_content1());
			pstmt.setString(8, bean.getBook_content2());
			pstmt.setInt(9, bean.getStock());
			pstmt.setInt(10, bean.getSales());
			pstmt.setString(11, bean.getImage_file());
			pstmt.setInt(12, bean.getSpecial());
			pstmt.setInt(13, bean.getBook_num());
			
			
			updateArticle=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("UpdateBookArticle 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return updateArticle;
	}
	
	//책 삭제
	public int DeleteArticle(int book_num) {
		
		PreparedStatement pstmt=null;
		int deleteCount=0;
		try {
			pstmt=con.prepareStatement("delete from book where book_num=?");
			pstmt.setInt(1, book_num);
			deleteCount=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("DeleteBookArticle 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	
	//////////////////////////////////////고객 뷰
	
	//추천도서
	public ArrayList<BookListBean> selectListForCustomer(int field){
			
			ArrayList<BookListBean> bookList=new ArrayList<BookListBean>();
			BookListBean bean=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
		
			int limit=20;
			
			
			try {
		
				pstmt=con.prepareStatement("select * from book where field=? and (special=1 or special=2) limit 0, ?");
				pstmt.setInt(1, field);
				pstmt.setInt(2, limit);
	
			
				rs=pstmt.executeQuery();
				while(rs.next()) {
					
					bean=new BookListBean(rs.getInt("book_num"),rs.getString("book_subject"),rs.getString("author"),
											rs.getString("translator"),rs.getString("publisher"),rs.getInt("field"),
											rs.getInt("price"),rs.getString("book_content1"), rs.getString("book_content2"),
											rs.getInt("stock"),rs.getInt("sales"),rs.getString("image_file"),rs.getInt("special"),
											rs.getInt("star_average"));
		
					bookList.add(bean);
				}
				
			}catch(SQLException e) {
				System.out.println("selectListForCustomer 에러: "+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return bookList;
	}
			
	
	//도서 리스트
	public ArrayList<BookListBean> selectListForCustomer(String push){
		
		ArrayList<BookListBean> bookList=new ArrayList<BookListBean>();
		BookListBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		int limit=20;
		
		
		try {
			
			//AwardWinners
			if(push.equals("award")) {
				pstmt=con.prepareStatement("select * from book where special=2 limit 0, ?" );
				pstmt.setInt(1, limit);
			}
			
			//bestsellers & new books
			else {
					pstmt=con.prepareStatement("select * from book order by ? desc limit 0, ?");
						
					if(push.equals("bestseller")) pstmt.setString(1, "sales");
					else if(push.equals("newbook")) pstmt.setString(1, "book_num");
					
					pstmt.setInt(2, limit);
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				bean=new BookListBean(rs.getInt("book_num"),rs.getString("book_subject"),rs.getString("author"),
										rs.getString("translator"),rs.getString("publisher"),rs.getInt("field"),
										rs.getInt("price"),rs.getString("book_content1"), rs.getString("book_content2"),
										rs.getInt("stock"),rs.getInt("sales"),rs.getString("image_file"),rs.getInt("special"),
										rs.getInt("star_average"));

				bookList.add(bean);
			}
			
		}catch(SQLException e) {
			System.out.println("selectListForCustomer 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return bookList;
	}
	
}
