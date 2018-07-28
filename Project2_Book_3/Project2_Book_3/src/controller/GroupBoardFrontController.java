package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardListProAction;
import action.BoardWriteProAction;
import action.DeleteProAction;
import action.DetailFormAction;
import action.ListMineProAction;
import action.ModifyFormAction;
import action.ModifyProAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class GroupBoardFrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("/boardList.bo")) {
			action=new BoardListProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/writeForm.bo")) {
			forward=new ActionForward(); 
			forward.setPath("/groupBoard/qna_board_write.jsp");
		
		}
		else if(command.equals("/writePro.bo")) {
			action=new BoardWriteProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/listMinePro.bo")) {
			action=new ListMineProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/detail.bo")) {
			action=new DetailFormAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ModifyForm.bo")) {
			action=new ModifyFormAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ModifyPro.bo")) {
			action=new ModifyProAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/DeletePro.bo")) {
			action=new DeleteProAction();
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
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	
}
