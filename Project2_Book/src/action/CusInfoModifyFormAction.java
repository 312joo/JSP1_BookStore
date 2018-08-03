package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CustomerListService;
import vo.ActionForward;
import vo.CustomerBean;

public class CusInfoModifyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=new ActionForward();
		CustomerListService service=new CustomerListService();
		CustomerBean bean=new CustomerBean();
		HttpSession session=req.getSession();
		String customer_id=(String) session.getAttribute("customer_id"); 
		bean=service.getCustomerDetail(customer_id);
		req.setAttribute("bean", bean);
		forward.setPath("/login/qna_cusInfo_modify.jsp");
		
		return forward;
	}

}
