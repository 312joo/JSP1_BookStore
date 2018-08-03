package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ModifyService;
import vo.ActionForward;
import vo.GroupListBean;

public class ModifyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		boolean isModifySuccess=false;

		GroupListBean bean=new GroupListBean();
		ModifyService modifyService=new ModifyService();
		
			bean.setGroup_num(Integer.parseInt(req.getParameter("group_num")));
			bean.setGroup_subject(req.getParameter("group_subject"));
			bean.setGroup_name(req.getParameter("group_name"));
			bean.setField(Integer.parseInt(req.getParameter("selectField")));
			bean.setGroup_area(Integer.parseInt(req.getParameter("selectArea")));
			bean.setGroup_content(req.getParameter("group_content"));
			
			String recruiting=req.getParameter("group_recruiting");
			if(recruiting.equals("open")) bean.setGroup_recruiting(true);
			else bean.setGroup_recruiting(false);
			bean.setCustomer_id(req.getParameter("customer_id"));
			
			
			isModifySuccess=modifyService.modifyArticle(bean);
			
			if(!isModifySuccess) {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.println("<script>");
				out.println("alert('수정실패')");
				out.println("history.back();");
				out.println("</script>");			
			}
			else {System.out.println(bean.getCustomer_id());
				forward=new ActionForward();
				forward.setPath("detail.bo?group_num="+bean.getGroup_num()+"&customer_id="+bean.getCustomer_id()+"&nowPage="+req.getParameter("nowPage"));
			}
		
		
		return forward;
	}
		
	

}
