package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.JoinService;
import vo.ActionForward;
import vo.CustomerBean;

public class JoinProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		
		CustomerBean bean=new CustomerBean();
		bean.setCustomer_email(req.getParameter("customer_email"));
		bean.setCustomer_age(Integer.parseInt(req.getParameter("customer_age")));
		if(req.getParameter("customer_gender").equals("남")) bean.setCustomer_gender(0);
		else bean.setCustomer_gender(1);
		bean.setCustomer_id(req.getParameter("customer_id"));
		bean.setCustomer_name(req.getParameter("customer_name"));
		bean.setCustomer_pass(req.getParameter("customer_pass"));
	
		JoinService joinService=new JoinService();
		boolean isJoinSuccess=joinService.joinArticle(bean);
		
		if(isJoinSuccess) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("LoginForm.lo");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
