package model;

import java.sql.*;

public class ReadBill {
	
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
		
		public String getAllBills(String account) {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for reading";
				}

				// Prepare the html table to be displayed
				output = "<table class='table' border='1'><tr><th scope='col'>Bill No</th>" + "<th scope='col'>Account No</th><th scope='col'>User Name</th>"
						+"<th scope='col'> Consumed Units</th><th scope='col'> Monthly Bill Amount</th><th scope='col'>Month</th></tr>";

				Statement stmt = con.createStatement();
				String query = "select * from bill where accountNo='" + account + "'";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {

					String bill_no = Integer.toString(rs.getInt("billNo"));
					String user_account = rs.getString("accountNo");
					String name = rs.getString("name");
					String consumed_units = rs.getString("consumed_units");
					String total = rs.getString("total");
					String month = rs.getString("month");

					// Add new row to the html table
					output += "<tr><td>" + bill_no + "</td>";
					output += "<td>" + user_account + "</td>";
					output += "<td>" + name + "</td>";
					output += "<td>" + consumed_units + "</td>";
					output += "<td>" + total + "</td>";
					output += "<td>" + month + "</td>";

				
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
