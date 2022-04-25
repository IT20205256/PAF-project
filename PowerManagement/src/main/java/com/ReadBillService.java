package com;

import model.ReadBill;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/ReadBills")
public class ReadBillService {

	ReadBill ReadBillObj = new ReadBill();

	@GET
	@Path("/read/{account}")
	@Produces(MediaType.TEXT_HTML)
	public String getAllBills(@PathParam("account") String account) {
		String output = ReadBillObj.getAllBills(account);
		return output;
	}

}
