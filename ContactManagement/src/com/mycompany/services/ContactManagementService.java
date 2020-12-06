package com.mycompany.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.model.Contact;
import com.mycompany.persistence.ContactDao;

@Path("management")
public class ContactManagementService {

	private ContactDao contactDao = new ContactDao();
	
	@GET
	@Path("/get/{firstName}/{lastName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContact(@PathParam("firstName") String firstName,@PathParam("lastName") String lastName){
		
		
		Contact contact = contactDao.getContact(firstName, lastName);
		
		ResponseBuilder response = Response.ok();
		ObjectMapper mapper = (ObjectMapper) new ObjectMapper();
		
		try {
			String json = mapper.writeValueAsString(contact);
			response.entity(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.build();
	}
	
	@PUT
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createContact(String newContact){
		ResponseBuilder response = Response.ok();
		
		ObjectMapper mapper = (ObjectMapper) new ObjectMapper();
		
		try {
			Contact contact = mapper.readValue(newContact, Contact.class);
			contactDao.createContact(contact);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.serverError();
		}
		return response.build();
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateContact(String newContact){
		
		ResponseBuilder response = Response.ok();
		
		ObjectMapper mapper = (ObjectMapper) new ObjectMapper();
		
		try {
			Contact contact = mapper.readValue(newContact, Contact.class);
			contactDao.updateContact(contact);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.serverError();
		}
		return response.build();
	}
	
	@DELETE
	@Path("/delete/{firstName}/{lastName}")
	public void deleteContact(@PathParam("firstName") String firstName,@PathParam("lastName") String lastName){
		contactDao.deleteContact(firstName, lastName);
		
	}
}
