package vo;

public class ActionForward {

	private String path;
	private boolean redirect;
	
	//���
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path=path;
	}
	
	//�缳�� ����
	public boolean isRedirect() {
		return this.redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect=redirect;
	}	
}
