package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookViewService;
import vo.ActionForward;
import vo.BookListBean;

public class BookViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BookViewService bookViewService = new BookViewService();
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		BookListBean bean=bookViewService.getBookView(book_num);
		
		ActionForward forward=new ActionForward();
		String nowPage=(String) req.getParameter("nowPage");
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("bean", bean);
		forward.setPath("book/qna_book_view.jsp");
		
		return forward;
	}

	
}
