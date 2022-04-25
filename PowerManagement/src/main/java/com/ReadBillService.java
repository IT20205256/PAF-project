package com;

import model.ReadBill;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
//import com.google.gson.*;

//For XML
//import org.jsoup.*;
//import org.jsoup.parser.*;
//import org.jsoup.nodes.Document;

@Path("/ReadBills")
public class ReadBillService {
	
	ReadBill ReadBillObj = new ReadBill();
	
	@GET
	@Path("/read/{account}")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String getAllBills(@PathParam("account") String account) {
		String output = ReadBillObj.getAllBills(account);
		return output;
	}
	
	
}
