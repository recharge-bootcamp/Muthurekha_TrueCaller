package org.paypal.project.TrueCaller;

import java.util.List;

public class UserService {

	public List<Contact> getUserPBDetails(String uName){
		
		return (new DatabaseService().getDBPBContacts(uName));
	}
	
	public String createUserPBDetails(PhoneBook uName){
		
		return (new DatabaseService().createDBPBUser(uName));
	}
	
}
