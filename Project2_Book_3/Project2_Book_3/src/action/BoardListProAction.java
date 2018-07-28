package action;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.GroupListBean;
import vo.PageInfo;

public class BoardListProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
	ArrayList<GroupListBean> articleList=new ArrayList<GroupListBean>();
	BoardListService boardListService=new BoardListService();
	
	int nowPage=1;
	int limit=10;
	
	//페이지값 받아오기
	if(req.getParameter("nowPage")!=null) {
		nowPage=Integer.parseInt(req.getParameter("nowPage"));
	}
	//한계값 받아오기
	if(req.getParameter("limit")!=null) {
		limit=Integer.parseInt(req.getParameter("limit"));
	}
	
	
	//list개수
		int listCount=boardListService.getListCount();
	//GroupListBean list
		articleList=boardListService.getArticleList(nowPage,limit);
	
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

	req.setAttribute("pageInfo",pageInfo);
	req.setAttribute("articleList", articleList);

	ActionForward forward=new ActionForward();
	forward.setPath("/groupBoard/qna_board_list.jsp");
	
	return forward;
	}

}
