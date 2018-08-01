package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CustomerDeleteAction;
import action.CustomerListAction;
import action.JoinProAction;
import action.LoginProAction;
import action.LogoutProAction;
import action.idCheckAction;
import vo.ActionForward;

@WebServlet("*.lo")
public class LoginFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("/LoginForm.lo")) {
			forward=new ActionForward();
			forward.setPath("login/qna_login.jsp");

		}
		
		else if(command.equals("/LoginPro.lo")) {
			action=new LoginProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/JoinForm.lo")) {
			forward=new ActionForward();
			forward.setPath("login/qna_join.jsp");
		}
		
		else if(command.equals("/JoinPro.lo")) {
			action=new JoinProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/LogoutPro.lo")) {
			action=new LogoutProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(commadn.equals("/cusInfoModifyForm.lo")) {
			action=new LogoutProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/idCheck.lo")) {
			action=new idCheckAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//회원 리스트
		else if(command.equals("/customerList.lo")) {
			action=new CustomerListAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//회원 삭제
		else if(command.equals("/customerDelete.lo")) {
			action=new CustomerDeleteAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward !=null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher= req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
				
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	
}
