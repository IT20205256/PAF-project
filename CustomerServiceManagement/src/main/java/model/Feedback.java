package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Feedback {
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.cj.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "kishan2000"); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 } 
	public String insertFeedback(String RepairId, String Rate, String Feedback) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = "insert into feedback (`FeedId`, `RepairId`, `Rate`,`Feedback`)"
	 + " values (?, ?, ?, ?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, RepairId);
	 preparedStmt.setString(3, Rate); 
	 preparedStmt.setString(4, Feedback); 
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the feedback"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 }
	
	public String readFeedback() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Feedback ID</th><th>Service ID</th>" +
	 "<th>Rate</th>" + 
	 "<th>Feedback</th>" +
	 "<th>Update</th>" +
	 "<th>Remove</th></tr>"; 
	 
	 String query = "select * from feedback"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String FeedId = Integer.toString(rs.getInt("FeedId")); 
	 String RepairId = rs.getString("RepairId"); 
	 String Rate = rs.getString("Rate"); 
	 String Feedback = rs.getString("Feedback"); 

	 // Add into the html table
	 output += "<tr><td>" + FeedId + "</td>"; 
	 output += "<td>" + RepairId + "</td>"; 
	 output += "<td>" + Rate + "</td>"; 
	 output += "<td>" + Feedback + "</td>"; 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" 
			 +"<td><form method='post' action='DeleteFeed.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='FeedId' type='hidden' value='" + FeedId 
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the items."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String updateFeedback(String FeedId, String RepairId, String Rate, String Feedback)
	{ 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE feedback SET RepairId=?,Rate=?,Feedback=? WHERE FeedId=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, RepairId); 
		 preparedStmt.setString(2, Rate); 
		 preparedStmt.setString(3, Feedback);  
		 preparedStmt.setInt(4, Integer.parseInt(FeedId)); 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
	
	public String deleteFeedback(String FeedId) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for deleting."; } 
	 // create a prepared statement
	 String query = "delete from feedback where FeedId=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(FeedId)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while deleting the Feedback"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	

}
