package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BookRegistService;
import vo.ActionForward;
import vo.BookListBean;

public class BookRegistAction implements Action{


	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		ActionForward forward=null;
		
		BookRegistService bookRegistService=new BookRegistService();
		
		//업로드경로
		String saveFolder="C:\\Users\\User\\git\\JSP1_BookStore\\Project2_Book\\WebContent\\imgs";
		int maxSize=5*1025*1024;
		//한번에 업로드 할 수 있는 파일 크기
		
		MultipartRequest multi=new MultipartRequest(req,saveFolder,maxSize,"UTF-8",
				new DefaultFileRenamePolicy());
		
		BookListBean book=new BookListBean(multi.getParameter("book_subject"),
											multi.getParameter("author"), multi.getParameter("translator"),
											multi.getParameter("publisher"), Integer.parseInt(multi.getParameter("selectField")),
											Integer.parseInt(multi.getParameter("price")), multi.getParameter("book_content1"),
											multi.getParameter("book_content2"), Integer.parseInt(multi.getParameter("stock")),
											0, multi.getOriginalFileName((String)multi.getFileNames().nextElement()), 
											Integer.parseInt(multi.getParameter("special"))
											);
		
		boolean isRegistSuccess=bookRegistService.registBook(book);
		
		if(isRegistSuccess) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bookList.book");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
