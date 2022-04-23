package com;

import model.Bill;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Bills")
public class BillService {
	
	Bill BillObj = new Bill();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBill() {
		return BillObj.readBill();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBill(@FormParam("accountNo") String accountNo,
			@FormParam("name") String name, @FormParam("address") String address, 
			@FormParam("month") String month,
			@FormParam("current_reading") Integer current_reading, @FormParam("previous_reading") Integer previous_reading) {
		String output = BillObj.insertBill(accountNo, name, address, month, current_reading, previous_reading);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBill(String BillData) {

		// Convert the input string to a JSON object
		JsonObject BillObject = new JsonParser().parse(BillData).getAsJsonObject();

		// Read the values from the JSON object
		String billNo = BillObject.get("billNo").getAsString();
		String accountNo = BillObject.get("accountNo").getAsString();
		String name = BillObject.get("name").getAsString();
		String address = BillObject.get("address").getAsString();
		String month = BillObject.get("month").getAsString();
		String current_reading = BillObject.get("current_reading").getAsString();
		String previous_reading = BillObject.get("previous_reading").getAsString();
		String consumed_units = BillObject.get("consumed_units").getAsString();
		String total = BillObject.get("total").getAsString();
		String due = BillObject.get("due").getAsString();
		String status = BillObject.get("status").getAsString();
		
		String output = BillObj.updateBill(billNo,accountNo, name, address, month, current_reading, previous_reading, 
				consumed_units, total,due,status);
		return output;
	}



}


