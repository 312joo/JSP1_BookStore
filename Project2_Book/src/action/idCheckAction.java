package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.IdCheckService;
import vo.ActionForward;

public class idCheckAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward=null;
		boolean isIdDuplicated=false;
		req.setCharacterEncoding("UTF-8");
		String checkId=req.getParameter("customer_id");
		IdCheckService idCheckService=new IdCheckService();
		isIdDuplicated=idCheckService.checkIdDuplicated(checkId);
		PrintWriter out=resp.getWriter();
		
		if(isIdDuplicated) {
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<b><font color='red'>"+checkId+"</font>�� �̹� ������� ���̵��Դϴ�.</b><br>");
			out.println("<form name='checkForm' method='post' action='idCheck.lo'>");
			out.println("<b>�ٸ� ���̵� �����ϼ���.</b>");
			out.println("<input type='text' name='customer_id'/>");
			out.println("<input type='submit' value='���̵� �ߺ�Ȯ��'/>");
			out.println("</form>");
		}
		else {
			resp.setContentType("text/html;charset=UTF-8");
			req.setAttribute("checkId", checkId);
			out.println("<b>�Է��Ͻ� <font color='red'>"+checkId+"</font>�� ����Ͻ� �� �ֽ��ϴ�.</b>");
			out.println("<br>");
			out.println("<input type='button' value='�ݱ�' onClick='close()'/>");
		}
		
		
		return forward;
	}

}
