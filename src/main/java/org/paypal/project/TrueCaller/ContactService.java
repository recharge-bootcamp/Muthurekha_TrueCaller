package org.paypal.project.TrueCaller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ContactService {
	
	//private List<Contacts> contacts = new ArrayList<Contacts>();
	
	public List<Contact> getAllPBContacts(String uName){
		return (new DatabaseService().getDBPBContacts( uName));
		 		
	}
	

	public String addUserContacts(String uName, List<Contact> e){

		return (new DatabaseService().addContacts(uName,e));
	}
	
	public List<Contact> searchUserContacts(String phoneNo){

		return (new DatabaseService().searchContact(phoneNo));
	}
	
	

}