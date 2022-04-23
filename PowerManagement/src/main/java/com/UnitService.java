package com;

import model.Unit;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Units")
public class UnitService {

	Unit UnitObj = new Unit();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUnits() {
		return UnitObj.readUnits();
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
		String output = UnitObj.getUnit(account);
		return output;
	}
	

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUnit(@FormParam("Tariff_Block") String Tariff_Block,
			@FormParam("Charge_per_Unit") String Charge_per_Unit, @FormParam("Type") String Type) {
		String output = UnitObj.insertUnit(Tariff_Block, Charge_per_Unit, Type);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUnits(String UnitData) {

		// Convert the input string to a JSON object
		JsonObject UnitObject = new JsonParser().parse(UnitData).getAsJsonObject();

		// Read the values from the JSON object
		String Unit_Record_Id = UnitObject.get("Unit_Record_Id").getAsString();
		String Tariff_Block = UnitObject.get("Tariff_Block").getAsString();
		String Charge_per_Unit = UnitObject.get("Charge_per_Unit").getAsString();
		String Type = UnitObject.get("Type").getAsString();
		String output = UnitObj.updateUnit(Unit_Record_Id, Tariff_Block, Charge_per_Unit, Type);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUnit(String UnitData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(UnitData, "", Parser.xmlParser());

		// Read the value from the element <consumerAccountNo>
		String Unit_Record_Id = doc.select("Unit_Record_Id").text();
		String output = UnitObj.deleteUnit(Unit_Record_Id);
		return output;
	}

}
