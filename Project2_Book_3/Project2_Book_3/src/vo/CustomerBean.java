package vo;


public class CustomerBean {


	private String customer_id;
	private String customer_pass;
	private String customer_name;
	private int customer_gender;
	private int customer_age;
	private String customer_email;
	
	//id
	public String getCustomer_id() {
		return this.customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id=customer_id;
	}
	
	//password
	public String getCustomer_pass() {
		return this.customer_pass;
	}
	public void setCustomer_pass(String customer_pass) {
		this.customer_pass=customer_pass;
	}
	
	//name
	public String getCustomer_name() {
		return this.customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name=customer_name;
	}
	
	//gender
	public int getCustomer_gender() {
		return this.customer_gender;
	}
	public void setCustomer_gender(int customer_gender) {
		this.customer_gender=customer_gender;
	}
	
	//age
	public int getCustomer_age() {
		return this.customer_age;
	}
	public void setCustomer_age(int customer_age) {
		this.customer_age=customer_age;
	}
	
	//email
	public String getCustomer_email() {
		return this.customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email=customer_email;
	}
}
