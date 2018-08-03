package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CartAddAction;
import action.CartDeleteAction;
import action.CartListAction;
import action.CartUpdateAmountAction;
import vo.ActionForward;


@WebServlet("*.ca")
public class CartFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action =null;
		
		
		//장바구니 담기
		if(command.equals("/bookCartAdd.ca")) {
			action=new CartAddAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//장바구니 list 보기
		else if(command.equals("/bookCartList.ca")) {
			action=new CartListAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//장바구니 도서 수량변경
		else if(command.equals("/updateCartAmount.ca")) {
			action=new CartUpdateAmountAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.getStackTrace();
			}
		}

		//장바구니 삭제하기
		else if(command.equals("/bookCartDelete.ca")) {
			action=new CartDeleteAction();
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

