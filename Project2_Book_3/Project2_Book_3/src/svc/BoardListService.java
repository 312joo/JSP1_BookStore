package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.GroupListBean;

public class BoardListService{

	//총 list수 반환
	public int getListCount() throws Exception{
		int listCount=0;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount=boardDAO.selectListCount();
		close(con);
		
		return listCount;
	}

	//list반환
	public ArrayList<GroupListBean> getArticleList(int nowPage, int limit) throws Exception{
		ArrayList<GroupListBean> articleList=null;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		articleList=boardDAO.selectList(nowPage, limit);
		
		close(con);
		
		return articleList;
		
	}
	
	//나의 list만 반환
	public ArrayList<GroupListBean> getMyList(String id, int nowPage, int limit) throws Exception{
		ArrayList<GroupListBean> myList=null;
		Connection con=getConnection();
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		myList=boardDAO.selectMyList(id, nowPage, limit);
		
		close(con);
		
		return myList;
	}
}
