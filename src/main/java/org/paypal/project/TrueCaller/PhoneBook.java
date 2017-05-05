package org.paypal.project.TrueCaller;


	import java.util.Date;

	import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class PhoneBook {
		private String userName;
		private int phoneBookId;
		private Date dateCreated;
		private String emailID;
		private String password;
		private String phoneNo,description,location;
		
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public PhoneBook(){}
		public PhoneBook(int phoneBookId,String userName, String emailid,String pwd, Date dateCreated,String phoneNo,String description,String location) {
			super();
			this.userName = userName;
			this.phoneBookId = phoneBookId;
			this.dateCreated = dateCreated;
			this.emailID= emailid;
			this.password=pwd;	
			this.phoneNo=phoneNo;
			this.description=description;
			this.location=location;
		}
		public PhoneBook(int phoneBookId,String userName, String emailid,String pwd, Date dateCreated) {
			super();
			this.userName = userName;
			this.phoneBookId = phoneBookId;
			this.dateCreated = dateCreated;
			this.emailID= emailid;
			this.password=pwd;
		}
		public String getUserName() {
			return userName;
		}
		public String getEmailID() {
			return emailID;
		}
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getPhoneBookId() {
			return phoneBookId;
		}
		public void setPhoneBookId(int phoneBookId) {
			this.phoneBookId = phoneBookId;
		}
		public Date getDateCreated() {
			return dateCreated;
		}
		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}
		
		

	}