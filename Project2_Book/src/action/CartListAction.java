package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CartListService;
import vo.ActionForward;
import vo.CartListBean;
import vo.PageInfo;

public class CartListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward=null;
		ArrayList<CartListBean> cartList=new ArrayList<CartListBean>();
		CartListService cartListService=new CartListService();

		//id¼¼¼Ç°ª
		HttpSession session=req.getSession();
		String customer_id=(String) session.getAttribute("customer_id");
		
		cartList=cartListService.getCartList(customer_id);
		req.setAttribute("cartList", cartList);
	
		forward=new ActionForward();
		forward.setPath("/cart/qna_cart_list.jsp");
		
		return forward;
	}

}
