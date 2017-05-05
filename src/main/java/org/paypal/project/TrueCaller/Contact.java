package org.paypal.project.TrueCaller;

import java.util.Date;

public class Contact {
	
	   private int contact_id;
	   private int phone_book_id ;
	   private String contact_name ;
	   private String contact_ph_no;
	   private String contact_description;
	   private String contact_location;
	   private Date created_time ;
	   private int preferredCtr;
	   
	public Contact(){}
	
	public Contact(int contact_id,int phone_book_id ,String contact_name,String contact_ph_no,String contact_description,String contact_location,Date created_time){
		   this.contact_id=contact_id;
		   this.phone_book_id =phone_book_id;
		   this.contact_name= contact_name;
		   this.contact_ph_no=contact_ph_no;
		   this.contact_description=contact_description;
		   this.contact_location=contact_location;
		   this.created_time=created_time ;
	}
	public Contact(String contact_name,String contact_ph_no,String contact_description,String contact_location,int preferredCtr){
		   this.contact_name= contact_name;
		   this.contact_ph_no=contact_ph_no;
		   this.contact_description=contact_description;
		   this.contact_location=contact_location;
		   this.preferredCtr= preferredCtr;
	}
	
	
	public int getPreferredCtr() {
		return preferredCtr;
	}

	public void setPreferredCtr(int preferredCtr) {
		this.preferredCtr = preferredCtr;
	}

	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public int getPhone_book_id() {
		return phone_book_id;
	}
	public void setPhone_book_id(int phone_book_id) {
		this.phone_book_id = phone_book_id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_ph_no() {
		return contact_ph_no;
	}
	public void setContact_ph_no(String contact_ph_no) {
		this.contact_ph_no = contact_ph_no;
	}
	public String getContact_description() {
		return contact_description;
	}
	public void setContact_description(String contact_description) {
		this.contact_description = contact_description;
	}
	public String getContact_location() {
		return contact_location;
	}
	public void setContact_location(String contact_location) {
		this.contact_location = contact_location;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	   
	   

}