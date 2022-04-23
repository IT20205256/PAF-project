package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.paymentMethod;

@Path("/PaymentMethods")
public class paymentMethodService {
	
	paymentMethod methodObj = new paymentMethod();

	@GET
	@Path("/AllMethods")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return methodObj.allPaymentMethods();
	}


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertMethod(@FormParam("account") String account, @FormParam("type") String type, @FormParam("number") String number,
			@FormParam("date") String date, @FormParam("cvv") String cvv, @FormParam("name") String name, @FormParam("cardName") String cardName) {
		String output = methodObj.insertMethod(account, type, number, date, cvv, name, cardName);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateMethod(String methodData) {
		// Convert the input string to a JSON object
		JsonObject methodObject = new JsonParser().parse(methodData).getAsJsonObject();
		// Read the values from the JSON object
		String ID = methodObject.get("ID").getAsString();
		//String type = methodObject.get("type").getAsString();
		//String number = methodObject.get("number").getAsString();
		String date = methodObject.get("date").getAsString();
		String cvv = methodObject.get("cvv").getAsString();
		//String name = methodObject.get("name").getAsString();
		//String cardName = methodObject.get("cardName").getAsString();
		String output = methodObj.updateMethod(ID, date, cvv);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMethod(String methodData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(methodData, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		String ID = doc.select("ID").text();
		String output = methodObj.deleteMethod(ID);
		return output;
	}
	
	//searchMethod
	
	@GET
	@Path("/{account}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String searchMethod(@PathParam("account") String account) {
		// Convert the input string to an XML document
		//Document doc = Jsoup.parse(methodData, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		//String ID = doc.select("ID").text();
		String output = methodObj.searchMethod(account);
		return output;
	}


}
