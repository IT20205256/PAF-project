package model;

import java.sql.*;

public class Bill {

	// A common method to connect to the DB
	public Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/power", "root", "Raveesha");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// Insert Details...............................

	public String insertBill(String accountNo, String name, String address, String month, String current_reading,String previous_reading) {

		String output = "";
		Integer consumed_units = Integer.parseInt(current_reading) - Integer.parseInt(previous_reading);
		Double due = 0.00;

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}
			
			
			

			// create a prepared statement
			String query = "insert into bill(`billNo`,`accountNo`,`name`,`address`,`month`,`current_reading`,`previous_reading`,"
					+ "`consumed_units`,`total`,`due`,`status`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 
			Double total = 0.00;
		 
		    if(consumed_units < 32)
			 {
		    	total = consumed_units*7.85;
			  }
			else if(consumed_units < 63 )
			 {
				total = 31*7.85 + (consumed_units-31)*10.00;
			 }
			else if(consumed_units < 94 )
			 {
				total = 31*7.85 + 31* 10.00 + (consumed_units - 62)*15.00;
			 }
			else if(consumed_units > 93)
			{
				total = 31*7.85 + 31* 10.00 + 31*15.00 + (consumed_units - 93)*27.75;
			}

		    due = total;
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, accountNo);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, month);
			preparedStmt.setInt(6, Integer.parseInt(current_reading));
			preparedStmt.setInt(7, Integer.parseInt(previous_reading));
			preparedStmt.setInt(8, (consumed_units));
			preparedStmt.setDouble(9, total);
			preparedStmt.setDouble(10, due);
			

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted Successfully!";

		} catch (Exception e) {
			output = "Error while inserting!";
			System.err.println(e.getMessage());
		}

		return output;

	}

	// Read Details...............................

	public String readBill() {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading";
			}

			// Prepare the html table to be displayed
			output = "<table class='table' border='1'><tr><th scope='col'>Bill No</th>" + "<th scope='col'>Account No</th><th scope='col'>Name</th>"
					+ "<th scope='col'>Address</th><th>Month</th>" + "<th scope='col'>Current Reading</th><th scope='col'>Previous Reading</th>"
					+ "<th scope='col'>Consumed Unit</th><th scope='col'>Total</th>" + "<th scope='col'>Due</th><th scope='col'>Status</th>"
					;

			String query = "select * from bill";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String billNo = Integer.toString(rs.getInt("billNo"));
				String accountNo = rs.getString("accountNo");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String month = rs.getString("month");
				String current_reading = rs.getString("current_reading");
				String previous_reading = rs.getString("previous_reading");
				String consumed_units = rs.getString("consumed_units");
				String total = Double.toString(rs.getDouble("total"));
				String due = Double.toString(rs.getDouble("due"));
				String status = rs.getString("status");

				// Add new row to the html table
				output += "<tr><td>" + billNo + "</td>";
				output += "<td>" + accountNo + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + month + "</td>";
				output += "<td>" + current_reading + "</td>";
				output += "<td>" + previous_reading + "</td>";
				output += "<td>" + consumed_units + "</td>";
				output += "<td>" + total + "</td>";
				output += "<td>" + due + "</td>";
				output += "<td>" + status + "</td>";

				// buttons
				output += //"<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						 "<td><form method='post' action='billAdd.jsp'>";
						//+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>";
				// + "<input name='itemID' type='hidden' value='" + Unit_Record_Id + "'>" +
				// "</form></td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading!";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Update Details...............................

	public String updateBill(String billNo,String accountNo, String name, String address, String month, String current_reading,
			String previous_reading, String consumed_units, String total, String due, String status) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE bill SET accountNo=?, name=?, address=? , month=?, current_reading=?, previous_reading=?, consumed_units=?, total=?, due=?, status=? WHERE billNo=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1,accountNo);
			preparedStmt.setString(2,name);
			preparedStmt.setString(3,address);
			preparedStmt.setString(4,month);
			preparedStmt.setString(5,current_reading);
			preparedStmt.setString(6,previous_reading);
			preparedStmt.setString(7,consumed_units);
		    preparedStmt.setDouble(8, Double.parseDouble(total));
		    preparedStmt.setDouble(9, Double.parseDouble(due));
		    preparedStmt.setString(10,status);
			preparedStmt.setInt(11, Integer.parseInt(billNo));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";

		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
