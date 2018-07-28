package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ReviewRegistService;
import vo.ActionForward;
import vo.ReviewBean;

public class ReviewRegistAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		HttpSession session=req.getSession();
		String customer_id=(String)session.getAttribute("customer_id");
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		int book_star=Integer.parseInt(req.getParameter("rating"));
		String book_review=req.getParameter("book_review");
		
		ReviewBean bean=new ReviewBean();
		bean.setBook_num(book_num);
		bean.setBook_review(book_review);
		bean.setCustomer_id(customer_id);
		bean.setStar_point(book_star);
		
		ReviewRegistService reviewRegistService=new ReviewRegistService();
		
		boolean isRegistSuccess = reviewRegistService.registReview(bean);
		
				
		if(isRegistSuccess) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("customerBookView.book");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('리뷰 등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
