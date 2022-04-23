package com;

import model.Register;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Register")
public class RegisterService {
	
	Register consumerObj = new Register();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDetails() {
		return consumerObj.readDetails();
	}
	
	@GET
	@Path("/{account}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String searchMethod(@PathParam("account") String account) {
		// Convert the input string to an XML document
		//Document doc = Jsoup.parse(methodData, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		//String ID = doc.select("ID").text();
		String output = consumerObj.getAccount(account);
		return output;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDetail(@FormParam("name") String name, @FormParam("address") String address,
			@FormParam("phone") String phone, @FormParam("email") String email, @FormParam("username") String username,
			@FormParam("password") String password) {
		String output = consumerObj.insertDetail(name, address, phone, email, username, password);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDetails(String consumerData) {

		// Convert the input string to a JSON object
		JsonObject consumerObject = new JsonParser().parse(consumerData).getAsJsonObject();

		// Read the values from the JSON object
		String account_no = consumerObject.get("account_no").getAsString();
		String name = consumerObject.get("name").getAsString();
		String address = consumerObject.get("address").getAsString();
		String phone = consumerObject.get("phone").getAsString();
		String email = consumerObject.get("email").getAsString();
		String username = consumerObject.get("username").getAsString();
		String password = consumerObject.get("password").getAsString();
		String output = consumerObj.updateDetail(account_no, name, address, phone, email, username, password);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDetail(String consumerData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(consumerData, "", Parser.xmlParser());

		// Read the value from the element <consumerAccountNo>
		String account_no = doc.select("account_no").text();
		String output = consumerObj.deleteDetail(account_no);
		return output;
	}

}

