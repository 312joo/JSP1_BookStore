package svc;

import java.sql.Connection;

import dao.ReviewDAO;
import vo.ReviewBean;
import static db.JdbcUtil.*;

public class ReviewRegistService {

	public boolean registReview(ReviewBean bean) {
		
		boolean isRegistSuccess=false;
		Connection con=getConnection();
		ReviewDAO reviewDAO=ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		int insertCount=reviewDAO.insertReview(bean);
		
		if(insertCount>0) {
			commit(con);
			isRegistSuccess=true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		
		
		return isRegistSuccess;
	}
}
