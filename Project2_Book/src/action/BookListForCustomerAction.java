package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookListForCustomerService;
import vo.ActionForward;
import vo.BookListBean;

public class BookListForCustomerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		BookListForCustomerService customerService=new BookListForCustomerService();
		ArrayList<BookListBean> list=new ArrayList<BookListBean>();
		
		
		String push=req.getParameter("push");
		
		if(push.equals("category")) {
			int field=Integer.parseInt(req.getParameter("field"));
			list=customerService.getCategoryList(field);
		}

		else if(push.equals("award")) {
			list=customerService.getEtcList(push);
		}
		
		req.setAttribute("bookList", list);		
		forward=new ActionForward();
		forward.setPath("/bookList.jsp");
		
		
		return forward;
	}

}
