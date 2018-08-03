package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BookViewForCustomerService;
import svc.ReviewDeleteService;
import vo.ActionForward;
import vo.BookListBean;

public class ReviewDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=new ActionForward();
		HttpSession session=req.getSession();
		String customer_id=(String) session.getAttribute("customer_id");
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		ReviewDeleteService deleteService=new ReviewDeleteService();
		
		BookViewForCustomerService bookService=new BookViewForCustomerService();
		BookListBean bean=new BookListBean();
		bean=bookService.getBookView(book_num);
		req.setAttribute("bean", bean);

		
		boolean isDeleteSuccess=deleteService.deleteReview(customer_id, book_num);
		
		if(!isDeleteSuccess) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();
		}
		else {
			forward=new ActionForward();
			
			forward.setPath("cusBookViewBack.book");	
		}

		
		return forward;
	}

}
