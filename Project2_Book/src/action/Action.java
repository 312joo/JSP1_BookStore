package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {

	ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
