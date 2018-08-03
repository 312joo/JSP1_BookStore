package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartDeleteService;
import vo.ActionForward;

public class CartDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=null;
		HttpSession session=req.getSession();
		String customer_id=(String)session.getAttribute("customer_id");
		CartDeleteService cartDeleteService=new CartDeleteService();
		
		boolean isDeleteSuccess=cartDeleteService.removeCart(customer_id, Integer.parseInt(req.getParameter("book_num")));
		
		if(!isDeleteSuccess) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('장바구니 삭제 실패')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bookCartList.ca");
		}
		return forward;
	}

}
