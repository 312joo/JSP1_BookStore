package vo;

public class BookListBean {

	private int book_num;
	private String book_subject;
	private String author;
	private String translator;
	private String publisher;
	private int field;
	private int price;
	private String book_content1;
	private String book_content2;
	private int stock;
	private int sales;
	private String image_file;
	private int special;
	private int star_average;
	
	public BookListBean() {
		
	}
	public BookListBean(int num,String subject, String author, String translator, String publisher,
			int field, int price, String content1, String content2, int stock, int sales,
			String image_file, int special, int star_average) {
		
		super();
		this.book_num=num;
		this.book_subject=subject;
		this.author=author;
		this.translator=translator;
		this.publisher=publisher;
		this.field=field;
		this.price=price;
		this.book_content1=content1;
		this.book_content2=content2;
		this.stock=stock;
		this.sales=sales;
		this.image_file=image_file;
		this.special=special;
		this.star_average=star_average;

	}
	
	public BookListBean(String subject, String author, String translator, String publisher,
			int field, int price, String content1, String content2, int stock, int sales,
			String image_file, int special) {
		
		super();
		this.book_subject=subject;
		this.author=author;
		this.translator=translator;
		this.publisher=publisher;
		this.field=field;
		this.price=price;
		this.book_content1=content1;
		this.book_content2=content2;
		this.stock=stock;
		this.sales=sales;
		this.image_file=image_file;
		this.special=special;
	}
	
	//book number
	public int getBook_num() {
		return this.book_num;
	}
	public void setBook_num(int num	) {
		this.book_num=num;
	}
	
	//å����
	public String getBook_subject() {
		return this.book_subject;
	}
	public void setBook_subject(String book_subject) {
		this.book_subject=book_subject;
	}		
	
	//����
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}	
	
	//����
	public String getTranslator() {
		return this.translator;
	}
	public void setTranslator(String translator) {
		this.translator=translator;
	}	
	
	//���ǻ�
	public String getPublisher() {
		return this.publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}		
	
	//�о�
	public int getField() {
		return this.field;
	}
	public void setField(int field) {
		this.field=field;
	}		
	
	//����
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}	
	
	//������ ����_�����Ͽ�
	public String getBook_content1() {
		return this.book_content1;
	}
	public void setBook_content1(String book_content1) {
		this.book_content1=book_content1;
	}
	
	//�ڼ��� ����
	public String getBook_content2() {
		return this.book_content2;
	}
	public void setBook_content2(String book_content2) {
		this.book_content2=book_content2;
	}
	
	//���
	public int getStock() {
		return this.stock;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}	
	
	//�Ǹŷ�
	public int getSales() {
		return this.sales;
	}
	public void setSales(int sales) {
		this.sales=sales;
	}	
	
	//�̹��� �����̸�
	public String getImage_file() {
		return this.image_file;
	}
	public void setImage_file(String image_file) {
		this.image_file=image_file;
	}	
	
	//special
	public int getSpecial() {
		return this.special;
	}
	public void setSpecial(int special) {
		this.special=special;
	}
	
	//���� ���
	public int getStar_average() {
		return this.star_average;
	}
	public void setStar_average(int star_average) {
		this.star_average=star_average;
	}
}
