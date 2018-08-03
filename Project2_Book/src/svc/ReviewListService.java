package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.ReviewDAO;
import vo.ReviewBean;

public class ReviewListService {

	public ArrayList<ReviewBean> getReivewList(int book_num){
		
		Connection con=getConnection();
		ReviewDAO reviewDAO=ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		
		ArrayList<ReviewBean> list=new ArrayList<ReviewBean>();
		list=reviewDAO.selectReview(book_num);
				
		close(con);
		
		
		return list;
		
	}
}
