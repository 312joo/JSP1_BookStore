package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.GroupListBean;
import vo.PageInfo;

public class ListMineProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		ArrayList<GroupListBean> articleList=new ArrayList<GroupListBean>();
		BoardListService boardListService=new BoardListService();
		String id=null;
		
		//id받기
		if(req.getParameter("cutomer_id")!=null) {
			id=req.getParameter("cutomer_id");
		}else {
			//id없으면 로그인 페이지로
			ActionForward forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("LoginForm.lo");
		}
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
		//MyListBean list
			articleList=boardListService.getMyList(id, nowPage, limit);
		
		int maxPage=(int) Math.ceil(listCount/limit);
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
