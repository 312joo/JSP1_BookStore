package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartAddService;
import vo.ActionForward;

public class CartUpdateAmountAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		boolean isUpdateSuccess=false;
		
		HttpSession session=req.getSession();
		String customer_id=(String)session.getAttribute("customer_id");
		int cart_amount=Integer.parseInt(req.getParameter("cart_amount"));
		int book_num=Integer.parseInt(req.getParameter("book_num"));
		
		CartAddService cartAddService=new CartAddService();
		isUpdateSuccess=cartAddService.updateAmount(cart_amount, customer_id, book_num);
		
		if(!isUpdateSuccess) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('수량 변경 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		else {
			forward=new ActionForward();
			forward.setPath("bookCartList.ca");
		}
		
		return forward;
	}

}
