package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookDeleteService;
import vo.ActionForward;

public class BookDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=null;
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		String nowPage=req.getParameter("nowPage");
		BookDeleteService bookDeleteService=new BookDeleteService();
		
		boolean isDeleteSuccess = bookDeleteService.removeBook(book_num);
		
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
			forward.setRedirect(true);
			forward.setPath("bookList.book?nowPage"+nowPage);
		}
		
		return forward;
	}

}
