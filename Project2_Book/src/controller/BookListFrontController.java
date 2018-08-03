package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BookDeleteAction;
import action.BookListAction;
import action.BookListForCustomerAction;
import action.BookModifyAction;
import action.BookModifyFormAction;
import action.BookRegistAction;
import action.BookViewAction;
import action.BookViewActionBack;
import action.BookViewActionForCustomer;
import action.ReviewDeleteAction;
import action.ReviewRegistAction;
import vo.ActionForward;

@WebServlet("*.book")
public class BookListFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String RequestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action =null;
		
		
		///////////////////////////////////////////////////������ å ����
		
		//å ��Ϻ���
		if(command.equals("/bookList.book")) {
			action=new BookListAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//å �ڼ��� ����
		else if(command.equals("/bookView.book")) {
			action=new BookViewAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//å ���� ���� ���
		else if(command.equals("/bookModifyForm.book")) {
			action=new BookModifyFormAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//å ���� ����
		else if(command.equals("/bookModify.book")) {
			action=new BookModifyAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//å ��� ���
		else if(command.equals("/bookRegistForm.book")) {
			forward=new ActionForward();
			forward.setPath("book/qna_book_regist.jsp");
		}
		
		//å ����ϱ�
		else if(command.equals("/bookRegist.book")) {
			action=new BookRegistAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//å �����ϱ�
		else if(command.equals("/bookDelete.book")) {
			action=new BookDeleteAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		//////////////////////////////////////////////���� ���� ���� ������
		
		//���� ������
		//�о� �� ��������Ʈ(category)
		//����Ʈ����, �� å , �뺧 ���л� ... (left)
		else if(command.equals("/cusBookList.book")) {
			action=new BookListForCustomerAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		//���� �󼼺��� ������
		else if(command.equals("/cusBookView.book")) {
			action=new BookViewActionForCustomer();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/cusBookViewBack.book")) {
			action=new BookViewActionBack();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/////////////////////////////////////////////////////����
		
		//���� ����ϱ�
		else if(command.equals("/reviewRegist.book")) {
			action=new ReviewRegistAction();
			try {
				forward=action.execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		//���� �����ϱ�
		else if(command.equals("/reviewDelete.book")) {
			action=new ReviewDeleteAction();
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
