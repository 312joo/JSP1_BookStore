package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DetailService;
import vo.ActionForward;
import vo.GroupListBean;

public class DetailFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int group_num=Integer.parseInt(req.getParameter("group_num"));
		DetailService detailService =new DetailService();
		GroupListBean bean=detailService.getDetail(group_num);
		
		ActionForward forward=new ActionForward();
		String nowPage=req.getParameter("nowPage");
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("bean", bean);
		req.setAttribute("customer_id", req.getParameter("customer_id"));
		forward.setPath("groupBoard/qna_board_detail.jsp");
		
		return forward;
	}

}
