package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookViewService;
import vo.ActionForward;
import vo.BookListBean;

public class BookModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=new ActionForward();
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		BookViewService bookViewService=new BookViewService();
		BookListBean bean=bookViewService.getBookView(book_num);
		req.setAttribute("bean", bean);
		forward.setPath("/book/qna_book_modify.jsp");
		
		return forward;
	}

}
