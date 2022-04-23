package com;

import model.Admin;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Admin")
public class AdminService {
	
	Admin consumerObj = new Admin();

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

