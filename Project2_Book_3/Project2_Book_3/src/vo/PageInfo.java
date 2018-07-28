package vo;

public class PageInfo {

	private int nowPage;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int listCount;
	
	public int getNowPage() {
		return this.nowPage;
	}
	public void setNowPage(int page) {
		this.nowPage=page;
	}
	
	public int getMaxPage() {
		return this.maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage=maxPage;
	}
	
	public int getStartPage() {
		return this.startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage=startPage;
	}
	
	public int getEndPage() {
		return this.endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage=endPage;
	}
	
	public int getListCount() {
		return this.listCount;
	}
	public void setListCount(int listCount) {
		this.listCount=listCount;
	}
}
