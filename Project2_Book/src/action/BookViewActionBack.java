package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookViewForCustomerService;
import svc.ReviewListService;
import vo.ActionForward;
import vo.BookListBean;
import vo.ReviewBean;

public class BookViewActionBack implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=new ActionForward();
		

		BookListBean bean=(BookListBean) req.getAttribute("bean");
		int book_num=bean.getBook_num();
		req.setAttribute("bean", bean);
		
		//리뷰리스트 불러오기
		ReviewListService reviewService=new ReviewListService();
		ArrayList<ReviewBean> review=new ArrayList<ReviewBean>();
		review=reviewService.getReivewList(book_num);
		req.setAttribute("review", review);
		
		forward.setPath("/book/qna_book_view_cus.jsp");
		
		return forward;
	}

}
