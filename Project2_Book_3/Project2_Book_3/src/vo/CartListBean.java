package vo;


public class CartListBean {

	private int book_num;
	private String customer_id;
	private int cart_amount;
	private String book_subject;
	private int price;
	private String image_file;
	
	//book number
	public int getBook_num() {
		return this.book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num=book_num;
	}
	
	//��id
	public String getcustomer_id() {
		return this.customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id=customer_id;
	}
	
	//���� ����
	public int getCart_amount() {
		return this.cart_amount;
	}
	public void setCart_amount(int cart_amount) {
		this.cart_amount=cart_amount;
	}	
	
	
	//��������
	public String getBook_subject() {
		return this.book_subject;
	}
	public void setBook_subject(String sub) {
		this.book_subject=sub;
	}
	
	
	//����
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	
	
	//�̹������� �̸�
	public String getImage_file() {
		return this.image_file;
	}
	public void setImage_file(String img) {
		this.image_file=img;
	}
}
