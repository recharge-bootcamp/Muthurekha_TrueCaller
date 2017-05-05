package org.paypal.project.TrueCaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class DatabaseService {

	private static Connection conn; 
	
	
	public  void getDBConnectionProperty() {
	
	Properties props = new Properties();
	FileInputStream in;
	try {
		in = new FileInputStream("C:\\Rekha\\Eclipse_WS\\TrueCaller\\src\\db.properties");
		props.load(in);

			String driver = props.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver) ;
				String url = props.getProperty("jdbc.url");
				String username = props.getProperty("jdbc.username");
				String password = props.getProperty("jdbc.password");
				System.out.println("username "+ username + " password"+ password);
					
				conn = DriverManager.getConnection(url, username, password);
				in.close();
				}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
					
}
	
		public  List<Contact> getDBPBContacts(String uName) {
			List<Contact> contacts = new ArrayList<Contact>();
			try{  
				getDBConnectionProperty();
				Statement stmt=conn.createStatement();  
				ResultSet rs=stmt.executeQuery(("select * from tc_contacts where phone_book_id=(select phone_book_id from tc_phonebook where username='"+uName+"')"));
				while(rs.next()) 
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(5)+" " +rs.getString(3)+"  "+rs.getString(4)+ " " +rs.getDate(7));  
					contacts.add(new Contact(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));	
				}  
				conn.close(); 
				}
				catch(Exception e)
				{
				System.out.println(e);
				e.printStackTrace();
				} 
	 			
			return contacts;
		}

		public  String addContacts(String uName, List<Contact> contacts)
		  {
		    try
		    {
		    	getDBConnectionProperty();
		    	Calendar calendar = Calendar.getInstance();
		    	java.sql.Date currDate = new java.sql.Date(calendar.getTime().getTime());
		    	System.out.println("Contacts is = "+ contacts.size());
		    	Statement stmt=conn.createStatement();  
				ResultSet rs=stmt.executeQuery(("select phone_book_id from tc_phonebook where username='"+uName+"'"));
				rs.next();
		    	for(Contact contact : contacts )
		    	{
		    		System.out.println("Contacts = " + contact.getContact_name() + "rs.getInt(1)" +rs.getInt(1));
		    	   String query = " insert into tc_contacts (phone_book_id,contact_name,contact_ph_no,contact_description,contact_location,created_time)"
		    			   + " values (?, ?, ?, ?, ?, ?)";

		  	      PreparedStatement preparedStmt = conn.prepareStatement(query);
		  	      preparedStmt.setInt (1, rs.getInt(1));
		  	      preparedStmt.setString(2, contact.getContact_name());
		  	      preparedStmt.setString(3, contact.getContact_ph_no());
		  	      preparedStmt.setString(4, contact.getContact_description());
		  	      preparedStmt.setString(5, contact.getContact_location());
		  	      preparedStmt.setDate(6, currDate);
		  	      preparedStmt.execute();
		  	      System.out.println(contact.getContact_name() + " End of DB insert()" + contact.getContact_description());
		    	}
		      
		    	conn.close();
		    	return "Insert Successful";
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      e.printStackTrace();
		      return "Insert Failure";
		    }
}
		
		
		public  PhoneBook getUserDetails(String uName) {
			PhoneBook pb=new PhoneBook();
			try{  
				getDBConnectionProperty();				
				Statement stmt=conn.createStatement();  
				ResultSet rs=stmt.executeQuery(("select * from tc_phonebook where username='"+uName+"'"));
				while(rs.next()) 
				{	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" " +rs.getString(3)+"  "+rs.getString(4)+ " " +rs.getDate(5));  
				pb=new PhoneBook(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));	
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				} 
				}
				catch(Exception e)
				{ System.out.println(e);
				e.printStackTrace();
				}
				finally{
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				}
			
				return pb;


			}

/*		public  List<Contact> searchContact(String phoneNo) {
			List<Contact> contact = new ArrayList<Contact>();
			try{  
			getDBConnectionProperty();
			Statement stmt=conn.createStatement(); 
			String query="select * from tc_contacts where contact_ph_no='"+phoneNo+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" " +rs.getString(3)+"  "+rs.getString(4)+ " " +rs.getDate(7));  
				contact.add(new Contact(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7)));	
			}  
			conn.close();  
			}
			catch(Exception e)
			{ System.out.println(e);
			e.printStackTrace();
			} 
	
		return contact;

	} */
		 
		public  List<Contact> searchContact(String phoneNo) {
			List<Contact> contact = new ArrayList<Contact>();
			try{  
			getDBConnectionProperty();
			Statement stmt=conn.createStatement(); 
			String query="select contact_name, contact_ph_no,contact_description,contact_location,count(created_time) from tc_contacts where contact_ph_no='"+phoneNo+"' group by created_time order by created_time desc limit 1";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) 
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+" " +rs.getString(3)+"  "+rs.getString(5));  
				contact.add(new Contact(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));	
			}  
			conn.close();  
			}
			catch(Exception e)
			{ System.out.println(e);
			e.printStackTrace();
			} 
	
		return contact;

	}
		public String createDBPBUser(PhoneBook phBook)
		 {
		    try
		    {
		    	
		      getDBConnectionProperty();
		      
		      String query1 = " insert into tc_phonebook (username, email, password)" + " values (?, ?, ?)";
		      
		      System.out.println("CreateDBUser " + phBook.getUserName());
		      PreparedStatement preparedStmt = conn.prepareStatement(query1);
		      preparedStmt.setString (1, phBook.getUserName());
		      preparedStmt.setString (2, phBook.getEmailID());
		      preparedStmt.setString (3, phBook.getPassword());
		      preparedStmt.execute();
		           
		      PhoneBook pb=getUserDetails(phBook.getUserName());
		      getDBConnectionProperty();
		      
		      String query2 =  " insert into tc_contacts (phone_book_id,contact_name,contact_ph_no,contact_description,contact_location)"
	    			   + " values (?, ?, ?, ?, ?)";
		      System.out.println(pb +" getPhoneBookId " + pb.getPhoneBookId());
		      preparedStmt = conn.prepareStatement(query2);
		      preparedStmt.setInt(1, pb.getPhoneBookId());
		      preparedStmt.setString (2, phBook.getUserName());
		      preparedStmt.setString (3, phBook.getPhoneNo());
		      preparedStmt.setString (4, phBook.getDescription());
		      preparedStmt.setString (5, phBook.getLocation());
		      preparedStmt.execute();
		      
		      System.out.println(phBook.getUserName() + " End of DB insert()");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		      return e.getMessage();
		    }
		    finally{
		    	try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }
		    return "User PhoneBook Created Successfully";
		  }
		}


