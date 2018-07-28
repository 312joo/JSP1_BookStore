package vo;

public class ReviewBean {

	private int book_num;
	private int book_star;
	private String customer_id;
	private String book_review;
	
	
	//book number
	public int getBook_num() {
		return this.book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num=book_num;
	}
	
	//°í°´id
	public String getCustomer_id() {
		return this.customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id=customer_id;
	}
	
	//º°Á¡
	public int getBook_star() {
		return this.book_star;
	}
	public void setStar_point(int book_star) {
		this.book_star=book_star;
	}	
	
	//¸®ºä³»¿ë
	public String getBook_review() {
		return this.book_review;
	}
	public void setBook_review(String book_review) {
		this.book_review=book_review;
	}

	
}
