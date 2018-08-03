package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookModifyService;
import vo.ActionForward;
import vo.BookListBean;

public class BookModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=null;
		boolean isModifySuccess=false;
		
		BookListBean bean=new BookListBean();
		BookModifyService modifyService=new BookModifyService();
		
		bean.setBook_num(Integer.parseInt(req.getParameter("book_num")));
		bean.setAuthor(req.getParameter("author"));
		bean.setBook_content1(req.getParameter("book_content1"));
		bean.setBook_content2(req.getParameter("book_content2"));
		bean.setBook_subject(req.getParameter("book_subject"));
		bean.setField(Integer.parseInt(req.getParameter("selectField")));
		bean.setImage_file(req.getParameter("image_file"));
		bean.setPrice(Integer.parseInt(req.getParameter("price")));
		bean.setPublisher(req.getParameter("publisher"));
		bean.setStock(Integer.parseInt(req.getParameter("stock")));
		bean.setTranslator(req.getParameter("translator"));
		bean.setBook_subject(req.getParameter("book_subject"));
		bean.setSales(Integer.parseInt(req.getParameter("sales")));
		bean.setSpecial(Integer.parseInt(req.getParameter("special")));
		
		
		isModifySuccess=modifyService.modifyBookArticle(bean);
		
		if(!isModifySuccess) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back();");
			out.println("</script>");			
		}
		
		else {
			forward=new ActionForward();
			forward.setPath("bookView.book?book_num="+bean.getBook_num()+"&nowPage="+req.getParameter("nowPage"));
		}


		return forward;
	
	}

}
