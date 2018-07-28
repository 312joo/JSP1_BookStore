package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class LogoutProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward=new ActionForward();
		HttpSession session=req.getSession();
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("template.jsp");
	
		return forward;
	}

}
