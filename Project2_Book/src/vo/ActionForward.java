package vo;

public class ActionForward {

	private String path;
	private boolean redirect;
	
	//경로
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path=path;
	}
	
	//재설정 여부
	public boolean isRedirect() {
		return this.redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect=redirect;
	}	
}
