package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CustomerListService;
import vo.ActionForward;
import vo.CustomerBean;

public class CustomerListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		ArrayList<CustomerBean> list=new ArrayList<CustomerBean>();
		CustomerListService customerListService=new CustomerListService();
		list=customerListService.getCustomerList();
		
		req.setAttribute("customerList", list);
		forward=new ActionForward();
		forward.setPath("/login/qna_customer_list.jsp");
		
		return forward;
	}

}
