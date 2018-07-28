package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BookListService;
import vo.ActionForward;
import vo.BookListBean;
import vo.PageInfo;

public class BookListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		ArrayList<String> todayImageList=new ArrayList<String>();
		
		//페이지값
		int nowPage=1;
		int limit=10;
		
		if(req.getParameter("nowPage")!=null) {
			nowPage=Integer.parseInt(req.getParameter("nowPage"));
		}
//		if(req.getParameter("limit")!=null) {
//			limit=Integer.parseInt(req.getParameter("limit"));
//		}
		
		//쿠키
		Cookie[] cookieArray=req.getCookies();
		
		if(cookieArray!=null) {
			for(int i=0; i<cookieArray.length;i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
	
		//list 개수
		BookListService bookListService =new BookListService();
		int listCount=bookListService.getListCount();
		
		//list받아오기
		ArrayList<BookListBean> bookList=bookListService.getBookList(nowPage, limit);

		//page정보
		double limit_d=(double)limit;
		double listCount_d=(double)listCount;
		int maxPage=(int)Math.ceil(listCount_d/limit_d);
		int startPage= (nowPage-4);
			if(startPage<=0) startPage=1; 	 
		int endPage= (nowPage+5);	
			if(endPage>maxPage) endPage=maxPage;
			else if(nowPage<5) endPage+= Math.abs(nowPage-4)+1;
											
		PageInfo pageInfo=new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setNowPage(nowPage);
		pageInfo.setStartPage(startPage);

		//session setting
		req.setAttribute("pageInfo",pageInfo);
		req.setAttribute("bookList", bookList);
		req.setAttribute("todayImageList", todayImageList);
		
		ActionForward forward=new ActionForward();
		forward.setPath("/book/qna_book_list.jsp");
		
		return forward;
	}
	
}
