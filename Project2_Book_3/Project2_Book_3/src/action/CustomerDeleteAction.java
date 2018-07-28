package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CustomerDeleteService;
import vo.ActionForward;

public class CustomerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		boolean isDeleteSuccess=false;
		String customer_id=req.getParameter("customer_id");
		CustomerDeleteService deleteService=new CustomerDeleteService();
		isDeleteSuccess=deleteService.removeCustomer(customer_id);
		
		if(!isDeleteSuccess) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();
		}
		
		else {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("customerList.lo");
		}
		
		return forward;
	}

}
