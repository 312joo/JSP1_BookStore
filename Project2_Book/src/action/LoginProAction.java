package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;
import vo.CustomerBean;

public class LoginProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		CustomerBean customerBean=null;
		String id=req.getParameter("customer_id");
		String pass=req.getParameter("customer_pass");
		
		LoginService loginService = new LoginService();
		customerBean = loginService.getLoginCustomer(id,pass);

		if(customerBean!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("customer_id", id);
			forward=new ActionForward();
			forward.setPath("/template.jsp");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
