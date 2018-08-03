package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeleteService;
import vo.ActionForward;

public class DeleteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward=null;
		int group_num=Integer.parseInt(req.getParameter("group_num"));
		String nowPage=req.getParameter("nowPage");
		DeleteService deleteService=new DeleteService();
		
		boolean isDeleteSuccess=deleteService.removeArticle(group_num);
		
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
			forward.setPath("boardList.bo?nowPage="+nowPage);	
		}
		
		return forward;		
	}

}
