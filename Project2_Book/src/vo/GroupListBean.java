package vo;

import java.sql.Date;

public class GroupListBean {

	private int group_num;
	private String group_name;
	private int field;
	private int group_area;
	private String group_subject;
	private String group_content;
	private boolean group_recruiting;
	private String customer_id;
	private Date group_date;
	private int group_readcount;
	

	//��ȣ
	public int getGroup_num() {
		return this.group_num;
	}
	public void setGroup_num(int num) {
		this.group_num=num;
	}
	
	//�׷� �̸�
	public String getGroup_name() {
		return this.group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name=group_name;
	}	
	
	//�о�
	public int getField() {
		return this.field;
	}
	public void setField(int field) {
		this.field=field;
	}	
	
	//�׷� ����
	public int getGroup_area() {
		return this.group_area;
	}
	public void setGroup_area(int group_area) {
		this.group_area=group_area;
	}
	
	//�׷� ����
	public String getGroup_subject() {
		return this.group_subject;
	}
	public void setGroup_subject(String group_subject) {
		this.group_subject=group_subject;
	}	
	
	//�׷� ����
	public String getGroup_content() {
		return this.group_content;
	}
	public void setGroup_content(String group_content) {
		this.group_content=group_content;
	}
	
	//�ο� ��������
	public boolean getGroup_recruiting() {
		return this.group_recruiting;
	}
	public void setGroup_recruiting(boolean group_recruiting) {
		this.group_recruiting=group_recruiting;
	}
	
	//�� �ø� ��id
	public String getCustomer_id() {
		return this.customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id=customer_id;
	}
	
	//�� �ø� date
	public Date getGroup_date() {
		return this.group_date;
	}
	public void setGroup_date(Date group_date) {
		this.group_date=group_date;
	}		
	
	//��ȸ�� 
	public int getGroup_readcount() {
		return this.group_readcount;
	}
	public void setGroup_readcount(int g) {
		this.group_readcount=g;
	}
}