package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.WriteProService;
import vo.ActionForward;
import vo.GroupListBean;

public class BoardWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		GroupListBean bean=new GroupListBean();
	
		bean.setCustomer_id(req.getParameter("customer_id"));
		bean.setField(Integer.parseInt(req.getParameter("selectField")));
		bean.setGroup_area(Integer.parseInt(req.getParameter("selectArea")));
		bean.setGroup_content(req.getParameter("group_content"));
		bean.setGroup_name(req.getParameter("group_name"));
		bean.setGroup_subject(req.getParameter("group_subject"));
		String recruiting=req.getParameter("group_recruiting");
		if(recruiting.equals("open")) bean.setGroup_recruiting(true);
		else bean.setGroup_recruiting(false);
			
		WriteProService writeProService=new WriteProService();
		boolean isWriteSuccess=writeProService.registArticle(bean);
		
		if(isWriteSuccess) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
			
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out=resp.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
