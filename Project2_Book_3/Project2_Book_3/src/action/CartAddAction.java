package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartAddService;
import vo.ActionForward;
import vo.CartListBean;

public class CartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		CartAddService cartAddService =null;
		boolean addCartSuccess=false;
		CartListBean bean=new CartListBean();
		HttpSession session=req.getSession();
		
		bean.setBook_num(Integer.parseInt(req.getParameter("book_num")));
		bean.setCart_amount(Integer.parseInt(req.getParameter("cart_amount")));
		bean.setCustomer_id((String)session.getAttribute("customer_id"));
		bean.setBook_subject(req.getParameter("book_subject"));
		bean.setPrice(Integer.parseInt(req.getParameter("price")));
		bean.setImage_file(req.getParameter("image_file"));
		
		cartAddService=new CartAddService();
		addCartSuccess=cartAddService.addCart(bean);
		
		if(addCartSuccess) {
			req.setAttribute("book_num", Integer.parseInt(req.getParameter("book_num")));
			forward=new ActionForward();
			forward.setPath("bookView.book");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('장바구니 담기 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
		
	}

}
