package com;

import model.CustomerService;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Customer")
public class Service {
	
CustomerService cusobj = new CustomerService();
	
	@POST
	 @Path("/insert") 
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String insertCusService( @FormParam("Name") String Name, 
	  @FormParam("Address") String Address, @FormParam("Issue") String Issue, 
	  @FormParam("TelNo") String TelNo, @FormParam("Status") String Status) 
	 { 
	  String output = cusobj.insertCusService(Name, Address, Issue, TelNo, Status); 
	 return output; 
	 }
	
	@GET
	@Path("/read") 
	@Produces(MediaType.TEXT_HTML) 
	public String readCusService() 
	 { 
	 return cusobj.readCusService(); 
	 } 
 	 
	@PUT
	@Path("/cusupdate") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateCusService(String cusData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject cusObject = new JsonParser().parse(cusData).getAsJsonObject();
	 
	//Read the values from the JSON object
	 String Id = cusObject.get("Id").getAsString(); 
	 String Address = cusObject.get("Address").getAsString();
	 String Issue = cusObject.get("Issue").getAsString();
	 String TelNo = cusObject.get("TelNo").getAsString();
	 
	 String output = cusobj.updateCusService(Id,Address,Issue,TelNo); 
	return output; 
	}
	
	@GET
	@Path("/{Id}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String getOneCus(@PathParam("Id") String Id) {
		// Convert the input string to an XML document
		//Document doc = Jsoup.parse(methodData, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		//String ID = doc.select("ID").text();
		String output = cusobj.getOneCus(Id);
		return output;
	}

	
	@PUT
	@Path("/adupdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAdmin(String cusAdData)
	{
		//Convert the input string to a JSON object
		JsonObject cusAdobject = new JsonParser().parse(cusAdData).getAsJsonObject();
		
		//Read the values from the JSON object
		String Id = cusAdobject.get("Id").getAsString();
		String Status = cusAdobject.get("Status").getAsString();
		
		String output = cusobj.updateAdmin(Id, Status);
		return output;
	}
	
	@DELETE
	@Path("/delete") 
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCusService(String cusData) {
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(cusData, "", Parser.xmlParser());
		
		//Read the Values from the element<Name>
		String Name = doc.select("Id").text();
		String output = cusobj.deleteCusService(Name);
		return output;
	}

	
	
}
