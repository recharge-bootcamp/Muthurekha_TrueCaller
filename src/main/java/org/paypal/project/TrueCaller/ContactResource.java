package org.paypal.project.TrueCaller;


	import java.util.List;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	@Path("/contacts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public class ContactResource {
		
		private ContactService contactService = new ContactService();
		
		/*@GET
		public List<Contact> getContacts(){
			return contactService.getAllPBContacts();
		}
		*/
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/{username}/addContacts")
		public String addContacts(@PathParam("username")String uName,List<Contact> contact){
		System.out.println("Calling ContactService");
			return contactService.addUserContacts(uName,contact);
		}
		
		@GET
		@Path("/{phoneNo}")
		public List<Contact> searchContact(@PathParam("phoneNo") String phoneNo){
			System.out.println("Phone NO = " + phoneNo);
			return contactService.searchUserContacts(phoneNo);
		}

	}

