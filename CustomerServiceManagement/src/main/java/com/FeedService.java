package com;

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

import model.Feedback;

@Path("/feed")
public class FeedService {

Feedback feed = new Feedback();
	
	@POST
	@Path("/feedinsert") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertFeedback(@FormParam("RepairId") String RepairId, 
	 @FormParam("Rate") String Rate, 
	 @FormParam("Feedback") String Feedback) 
	{ 
	 String output = feed.insertFeedback(RepairId, Rate, Feedback); 
	return output; 
	}
	
	@GET
	@Path("/feedread") 
	@Produces(MediaType.TEXT_HTML) 
	public String readFeedback() 
	 { 
	 return feed.readFeedback(); 
	}
	
	@PUT
	@Path("/feedupdate") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateFeedback(String feedData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject feedObject = new JsonParser().parse(feedData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String FeedId = feedObject.get("FeedId").getAsString(); 
	 String RepairId = feedObject.get("RepairId").getAsString(); 
	 String Rate = feedObject.get("Rate").getAsString(); 
	 String Feedback = feedObject.get("Feedback").getAsString();  
	 String output = feed.updateFeedback(FeedId, RepairId, Rate, Feedback); 
	return output; 
	}
	
	@DELETE
	@Path("/feeddelete") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteFeedback(String feedData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(feedData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String FeedId = doc.select("FeedId").text(); 
	 String output = feed.deleteFeedback(FeedId); 
	return output; 
	}

}
