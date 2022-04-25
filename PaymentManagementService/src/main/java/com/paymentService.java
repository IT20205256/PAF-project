package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.payment;

@Path("/Payment")
public class paymentService {
	
	payment methodObj = new payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return methodObj.allPayment();
	}
	
	@GET
	@Path("/{account}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String searchMethod(@PathParam("account") String account) {
		String output = methodObj.getPaymentHistory(account);
		return output;
	}
	
	@GET
	@Path("bills/{account}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String viewBills(@PathParam("account") String account) {
		String output = methodObj.getAllBills(account);
		return output;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertMethod(@FormParam("bill_no") String bill_no, @FormParam("name") String name, @FormParam("amount_paying") String amount_paying) {
		String output = methodObj.insertMethod(bill_no, name, amount_paying);
		return output;
	}
	

}
