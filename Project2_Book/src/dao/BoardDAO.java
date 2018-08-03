package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.GroupListBean;

public class BoardDAO {

	Connection con;
	
	private static BoardDAO boardDAO;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(boardDAO==null) boardDAO=new BoardDAO();
		
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	//총 list개수 구하기
	public int selectListCount() {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
			pstmt=con.prepareStatement("select count(*) from readingGroup");
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
	
	//GroupListBean클래스를 ArrayList로 반환
	public ArrayList<GroupListBean> selectList(int nowPage, int limit){
	
		ArrayList<GroupListBean> articleList=null;
		GroupListBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int startrow=(nowPage-1)*limit;
		
		try {
			pstmt=con.prepareStatement("select * from readingGroup order by group_num desc limit ?, ? ");
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs=pstmt.executeQuery();
			articleList=new ArrayList<GroupListBean>();
			
			while(rs.next()) {
				
				bean=new GroupListBean();
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setField(rs.getInt("field"));
				bean.setGroup_area(rs.getInt("group_area"));
				bean.setGroup_content(rs.getString("group_content"));
				bean.setGroup_date(rs.getDate("group_date"));
				bean.setGroup_name(rs.getString("group_name"));
				bean.setGroup_num(rs.getInt("group_num"));
				bean.setGroup_recruiting(rs.getBoolean("group_recruiting"));
				bean.setGroup_subject(rs.getString("group_subject"));
				bean.setGroup_readcount(rs.getInt("group_readcount"));
				
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
	
	//나의 list만 반환
	@SuppressWarnings("null")
	public ArrayList<GroupListBean> selectMyList(String id, int nowPage, int limit){
		
		ArrayList<GroupListBean> articleList=null;
		GroupListBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int startrow=(nowPage-1)*limit;
		
		try {
			pstmt=con.prepareStatement("select * from readingGroup where customer_id=? order by group_num desc limit ?, ? ");
			pstmt.setString(1, id);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new GroupListBean();
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setField(rs.getInt("field"));
				bean.setGroup_area(rs.getInt("group_area"));
				bean.setGroup_content(rs.getString("group_content"));
				bean.setGroup_date(rs.getDate("group_date"));
				bean.setGroup_name(rs.getString("group_name"));
				bean.setGroup_num(rs.getInt("group_num"));
				bean.setGroup_recruiting(rs.getBoolean("group_recruiting"));
				bean.setGroup_subject(rs.getString("group_subject"));
				bean.setGroup_readcount(rs.getInt("group_readcount"));
				
				articleList.add(bean);
			}
			
		}catch(SQLException e) {
			System.out.println("selectMyList 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	
	//글 등록
	@SuppressWarnings("resource")
	public int insertArticle(GroupListBean bean) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int num, insertCount=0;
		
		try {
			pstmt=con.prepareStatement("select max(group_num) from readingGroup");
			rs=pstmt.executeQuery();
			
			if(rs.next()) num=rs.getInt(1)+1;
			else num=1;
			
			String sql="insert into readingGroup (group_name,field,group_area,group_subject,group_content,group_recruiting,customer_id,group_date,group_readcount) values(?,?,?,?,?,?,?,now(),?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, bean.getGroup_name());
			pstmt.setInt(2, bean.getField());
			pstmt.setInt(3, bean.getGroup_area());
			pstmt.setString(4, bean.getGroup_subject());
			pstmt.setString(5, bean.getGroup_content());
			pstmt.setBoolean(6, bean.getGroup_recruiting());
			pstmt.setString(7, bean.getCustomer_id());
			pstmt.setInt(8, 1);
			
			insertCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertArticle 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	
	//자세히 보기
	public GroupListBean selectDetail(int group_num) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		GroupListBean bean=null;
		
		try {
			pstmt=con.prepareStatement("select * from readingGroup where group_num=?");
			pstmt.setInt(1, group_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new GroupListBean();
				bean.setGroup_num(group_num);
				bean.setGroup_name(rs.getString("group_name"));
				bean.setField(rs.getInt("field"));
				bean.setGroup_area(rs.getInt("group_area"));
				bean.setGroup_subject(rs.getString("group_subject"));
				bean.setGroup_content(rs.getString("group_content"));
				bean.setGroup_recruiting(rs.getBoolean("group_recruiting"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setGroup_date(rs.getDate("group_date"));
				bean.setGroup_readcount(rs.getInt("group_readcount"));
			
			}
		}catch(SQLException e) {
			System.out.println("selectBoardDetail 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return bean;
	}
	
	
	//조회수 올리기
	public int UpdateReadCount(int group_num) {
		
		PreparedStatement pstmt=null;
		int updateCount=0;
		String sql="update readingGroup set group_readcount=group_readcount+1 where group_num="+group_num;
		
		try {
			pstmt=con.prepareStatement(sql);
			updateCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("UpdateReadCount 에러 : "+e);
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	
	//글 수정
	public int UpdateArticle(GroupListBean bean) {
		
		PreparedStatement pstmt=null;
		int updateArticle=0;
		String sql="update readingGroup set group_subject=?, group_name=?, field=?, group_area=?";
		sql+=", group_content=?, group_recruiting=? where group_num=?";

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bean.getGroup_subject());
			pstmt.setString(2, bean.getGroup_name());
			pstmt.setInt(3, bean.getField());
			pstmt.setInt(4, bean.getGroup_area());
			pstmt.setString(5, bean.getGroup_content());
			pstmt.setBoolean(6, bean.getGroup_recruiting());
			pstmt.setInt(7, bean.getGroup_num());
			
			updateArticle=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("UpdateArticle 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return updateArticle;
	}
	
	//글 삭제
	public int DeleteArticle(int group_num) {
		
		PreparedStatement pstmt=null;
		int deleteCount=0;
		try {
			pstmt=con.prepareStatement("delete from readingGroup where group_num=?");
			pstmt.setInt(1, group_num);
			deleteCount=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("DeleteArticle 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}