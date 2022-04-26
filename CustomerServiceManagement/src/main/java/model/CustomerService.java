package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerService {
	
	private Connection connect() {
		Connection con = null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "kishan2000");
		System.out.println("Database is Connected");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
	
public String insertCusService(String Name, String Address, String Issue, String TelNo, String Status) {
		
		String output= "";
		
		
		try {
			
			Connection con = connect();
			
			if(con == null){
				
				return ("Error while connecting the database");
			}
			
			
			
			String query = "insert into customer(`Id`,`Name`, `Address`, `Issue`, `TelNo`, `Status`)"
					+ "values(?,?,?,?,?,?)";
			
			//Preparing Statement
			PreparedStatement preparedstmt = con.prepareStatement(query);
			
			//Binding the values
			preparedstmt.setInt(1, 0);
			preparedstmt.setString(2, Name);
			preparedstmt.setString(3, Address);
			preparedstmt.setString(4, Issue);
			preparedstmt.setInt(5, Integer.parseInt(TelNo));
			preparedstmt.setString(6, Status);
			
			//execute the statement
			preparedstmt.execute();
			con.close();
			output = "Inserted Successfully";
		} catch (Exception e)
		{
			output = "Error while inserting the item";
			System.err.println(e.getMessage());
		}
		return output;
	}

public String readCusService() {
	String output= "";
	try {
		Connection con = connect();
		if(con == null) {
			return ("Errror while connecting with the database");
		}
		
		//Preparing the html table for View
		output = "<table border='1'><tr><th>Customer ID</th>"+
		         "<th>Customer name</th>"+ 
		         "<th>Customer address</th>"+
				 "<th>Issue</th>"+
		         "<th>Phone no.</th>"+
				 "<th>Status</th>"+
		         "<th>Update</th><th>Remove</th></tr>";
		
		//Retrieving from SQL
		String query = "select * from customer";
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(query);
		
		//iterate through the rows in the results set
		while(rs.next()) {
			String Id = Integer.toString(rs.getInt("Id"));
			String Name = rs.getString("Name");
			String Address = rs.getString("Address");
			String Issue = rs.getString("Issue");
			String TelNo = Integer.toString(rs.getInt("TelNo"));
			String Status = rs.getString("Status");
			
		//Adding into the html table
			output += "<tr><td>" +Id+ "</td>";
			output += "<td>" +Name+ "</td>";
			output += "<td>" +Address+ "</td>";
			output += "<td>" +Issue+ "</td>";
			output += "<td>" +TelNo+ "</td>";
			output += "<td>" +Status+ "</td>";
			
		//Making place for the buttons
			output +=  "<td><form method='post' action='UpdateCus.jsp'>"
		              +"<input name='btn-update' type='button' value='update' class='btn-second'>"
					  +"<input name='Id' type='hidden' value='"+Id+"'>"
					  +"</form></td>"
					  +"<td><form method='post' action='DeleteCus.jsp'>"
					  +"<input name='btn-delete' type='submit' value='delete' class='btn-third'>"
					  + "<input name='Id' type='hidden' value='" + Id + "'>"
					  + "</form></td></tr>";
			
			/*
			 output += "<td><form method='post' action='updatePaymentMethod.jsp'>"
									+"<input name='btnUpdate' type='submit' value='Update' class='btn btn-secondary'>"
									+ "<input name='ID' type='hidden' value='" + ID + "'>"
									+ "</form></td>"
									+"<td><form method='post' action='deletePaymentMethod.jsp'>"
									+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
									+ "<input name='ID' type='hidden' value='" + ID + "'>"
									+ "<input name='account' type='hidden' value='" + accont + "'>"
									+ "</form></td></tr>";*/
		}
		con.close();
		
		//Complete the html code
		output += "</table>";
		}catch (Exception e) {
			output = "Error while reading the data";
			System.err.println(e.getMessage());
		}
		return output;
	}

/*public String readCusOne(String TelNo) {
	String output = "";
	
	try {
		Connection con = Connect.connect();
		if(con == null) {
			return "Error while connecting to the database";
		}
		
		//Prepare html form to view
		output = "<table border='1'><tr><th>Id</th>"+
		         "<th>Name</th>" + 
		         "<th>Address</th>"+
		         "<th>Issue</th>"+
				 "<th>Phone Number</th>"+
		         "<th>Status</th></tr>";
		System.out.println("Html created");
		
		//Retrieving from SQL
		Statement stmt = con.createStatement();
		String query = "select * from customer where TelNo='"+TelNo+"'";
        ResultSet rs = stmt.executeQuery(query);
        
        System.out.println("Retrieved from SQL");
        
      //iterate through the rows in the results set
      		while(rs.next()) {
      			String Id = Integer.toString(rs.getInt("Id"));
      			String Name = rs.getString("Name");
      			String Address = rs.getString("Address");
      			String Issue = rs.getString("Issue");
      			String TelNo1 = Integer.toString(rs.getInt("TelNo"));
      			String Status = rs.getString("Status");
        	
        System.out.println("Binding the values");
        //Add new row to the HTML table
        output += "<td>" +Id+ "</td>";
        output += "<td>" +Name+ "</td>";
        output += "<td>" +Address+ "</td>";
        output += "<td>" +Issue+ "</td>";
        output += "<td>" +TelNo1+ "</td>";
        output += "<td>" +Status+ "</td></tr>";
        System.out.println("Output");
        //Buttons
       
        }
        
        con.close();
        output += "</table>";
	}catch(Exception e) {
		output = "Error while retrieving data";
		System.err.println(e.getMessage());
	}
	return output;
}*/



public String updateCusService(String Id, String Address, String Issue, String TelNo){
	String output = "";
	
	try {
		Connection con = connect();
		if(con==null) {
			return ("Error while loading to the database for updating");
		}
		
		//Create a prepared statement
		String query = "UPDATE customer SET Address=?, Issue=?, TelNo=? WHERE Id=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		//Binding values
		preparedStmt.setString(1, Address);
		preparedStmt.setString(2, Issue);
		preparedStmt.setInt(3, Integer.parseInt(TelNo));
		preparedStmt.setInt(4,Integer.parseInt(Id));
		
		//Execute the statement
		preparedStmt.execute();
		con.close();
		output = "Updated Successfuly";
	}catch(Exception e) {
		output = "Error while updating the database";
		System.err.println(e.getMessage());
	}
	return output;
}

public String updateAdmin(String Id, String Status) {
	String output = "";
	try {
		Connection con = connect();
		if(con==null) {
			output = "Error while connecting the database for update";
		}
		//Create a prepared Statement
		String query = "UPDATE customer SET Status=? WHERE Id=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		//Binding the values
		preparedStmt.setString(1,Status);
		preparedStmt.setString(2, Id);
		
		//Executing the Statement
		preparedStmt.execute();
		con.close();
		output = "Updated Status Successfully";
	}catch(Exception e) {
		output = "Error while updating the items";
		System.err.println(e.getMessage());
	}
	return output;
}

public String deleteCusService(String Id) {
	String output= "";
	try {
		Connection con = connect();
		if(con==null) {
			return ("Error while conencting to the Database for deleting.");
		}
		
		//Create a prepared statement
		String query = "DELETE from customer where Id=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		//Binding the values
		preparedStmt.setString(1, Id);
		
		//Execute the statement
		preparedStmt.execute();
		con.close();
		output = "Deleted successfully";
	}catch(Exception e) {
		output = "Error while deleting the Customer details";
		System.err.println(e.getMessage());
	}
	return output;
}

public String getOneCus(String Id) {

	String output = "";

	try {
		Connection con = connect();

		if (con == null) {
			return "Error while connecting to the database for reading";
		}

		// check from here..................................
		// Prepare the html table to be displayed
		output = "<table border='1'><tr><th>ID</th><th>Name</th>" + "<th>Address</th><th>Issue</th>"
				+ "<th>Phone Number</th>"+ "<th>Status</th>";

		Statement stmt = con.createStatement();
		String query = "select * from customer where Id='" +Id+ "'";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {

			String ID = Integer.toString(rs.getInt("Id"));
			String Name = rs.getString("Name");
			String Address = rs.getString("Address");
			String Issue = rs.getString("Issue");
			String TelNo = Integer.toString(rs.getInt("TelNo"));
			String Status = rs.getString("Status");

			// Add new row to the html table
			output += "<tr><td>" + ID + "</td>";
			output += "<td>" + Name + "</td>";
			output += "<td>" + Address + "</td>";
			output += "<td>" + Issue + "</td>";
			output += "<td>" + TelNo + "</td>";
			output += "<td>" + Status + "</td>";

			// buttons
			output += "<td><form method='get' action='updateCus.jsp'>" + "<input name='ID' type='hidden' value='"
					+ ID + "'>" + "</form></td></tr>";
		}

		con.close();

		// Complete the html table
		output += "</table>";

	} catch (Exception e) {
		output = "Error while retrieving!";
		System.err.println(e.getMessage());
	}

	return output;

}


}
