package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.CustomerBean;

public class LoginDAO {

	private static LoginDAO loginDAO;
	private Connection con;
	
	public LoginDAO() {
		
	}
	
	public static LoginDAO getInstance() {
		if(loginDAO==null) {
			loginDAO=new LoginDAO();
		}
		return loginDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	

	
	//로그인한 고객 정보 반환
	public CustomerBean selectLoginCustomer(String id, String pass) {

		CustomerBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			pstmt=con.prepareStatement("select * from customer where customer_id=? and customer_pass=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new CustomerBean();
				bean.setCustomer_email(rs.getString("customer_email"));
				bean.setCustomer_age(rs.getInt("customer_age"));
				bean.setCustomer_gender(rs.getInt("customer_gender"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setCustomer_name(rs.getString("customer_name"));
				bean.setCustomer_pass(rs.getString("customer_pass"));
				
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	//회원정보 수정요청한 회원정보 반환
	public CustomerBean selectLoginCustomer(String id) {

		CustomerBean bean=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			pstmt=con.prepareStatement("select * from customer where customer_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new CustomerBean();
				bean.setCustomer_email(rs.getString("customer_email"));
				bean.setCustomer_age(rs.getInt("customer_age"));
				bean.setCustomer_gender(rs.getInt("customer_gender"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setCustomer_name(rs.getString("customer_name"));
				bean.setCustomer_pass(rs.getString("customer_pass"));		
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
	
	//회원가입
	public int insertJoinCustomer(CustomerBean bean) {
		
		PreparedStatement pstmt=null;
		int insertCustomer=0;

		try {
			pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pstmt.setString(1, bean.getCustomer_id());
			pstmt.setString(2, bean.getCustomer_pass());
			pstmt.setString(3, bean.getCustomer_name());
			pstmt.setInt(4, bean.getCustomer_gender());
			pstmt.setInt(5, bean.getCustomer_age());
			pstmt.setString(6, bean.getCustomer_email());
			
			insertCustomer=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("insertJoinCustomer 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return insertCustomer;
	}
	
	//아이디 중복확인
	public int selectIdCheck(String id) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int selectId=0;
		
		try {
			pstmt=con.prepareStatement("select customer_id from readingGroup where customer_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				selectId++;
			}
			
		}catch(SQLException e) {
			System.out.println("selectIdCheck 에러: "+e);;
		}finally {
			close(pstmt);
		}
		
		return selectId;
	}
	
	
	//회원정보 리스트 반환
	public ArrayList<CustomerBean> selectCustomerList(){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CustomerBean bean;
		ArrayList<CustomerBean> list=new ArrayList<CustomerBean>();
	
		try {
			pstmt=con.prepareStatement("select * from customer");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bean=new CustomerBean();
				bean.setCustomer_age(rs.getInt("customer_age"));
				bean.setCustomer_email(rs.getString("customer_email"));
				bean.setCustomer_gender(rs.getInt("customer_gender"));
				bean.setCustomer_id(rs.getString("customer_id"));
				bean.setCustomer_name(rs.getString("customer_name"));
				list.add(bean);
			}
		}catch(SQLException e) {
			System.out.println("selectCustomer 에러: "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	//회원 정보 삭제
	public int deleteCustomer(String customer_id) {
		
		PreparedStatement pstmt=null;
		int deleteCount=0;
		
		try {
			pstmt=con.prepareStatement("delete from customer where customer_id=?");
			pstmt.setString(1, customer_id);
			
			deleteCount=pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteCustomer 에러: "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

}
