package org.paypal.project.TrueCaller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	private UserService userService = new UserService();
	
	@GET
	@Path("/{username}/contacts")
	public List<Contact> getUserPBContacts(@PathParam("username")String uName){
		return userService.getUserPBDetails(uName);
	}
	
	@POST
	@Path("/signup")
	public String addUserPB(PhoneBook pbUser){
		System.out.println(pbUser.getUserName() + pbUser.getPhoneNo());
		return userService.createUserPBDetails(pbUser);
	}

}
