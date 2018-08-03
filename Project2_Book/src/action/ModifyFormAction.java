package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DetailService;
import vo.ActionForward;
import vo.GroupListBean;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward=new ActionForward();
		int board_num=Integer.parseInt(req.getParameter("group_num"));
		DetailService detailService =new DetailService();
		GroupListBean bean=detailService.getDetail(board_num);
		req.setAttribute("bean", bean);
		forward.setPath("/groupBoard/qna_board_modify.jsp");
		
		return forward;
	}

	

}
