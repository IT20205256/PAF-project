package model;

import java.sql.*;

public class Admin {
	
	// A common method to connect to the DB
		public Connection connect() {

			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/consumer", "root", "Nethma");
				// For testing
				System.out.print("Successfully connected");
			} catch (Exception e) {
				e.printStackTrace();
			}

			return con;
		}

		
		// Read Details...............................

		public String readDetails() {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for reading";
				}

				// Prepare the html table to be displayed
				output = "<table class='table' border='1'><tr><th scope='col'>Account Number</th>" + "<th scope='col'>Name</th>"
						+ "<th scope='col'>Address</th><th scope='col'>Phone</th>" + "<th scope='col'>Email</th>"
						+ "<th scope='col'>Remove</th></tr>";

				String query = "select * from consumer_details";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {
					String account_no = Integer.toString(rs.getInt("account_no"));
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					//String username = rs.getString("username");
					//String password = rs.getString("password");

					// Add new row to the html table
					output += "<tr><td>" + account_no + "</td>"; 
					output += "<td>" + name + "</td>";
					output += "<td>" + address + "</td>";
					output += "<td>" + phone + "</td>";
					output += "<td>" + email + "</td>";
					//output += "<td>" + username + "</td>";
					//output += "<td>" + password + "</td>";

					// buttons
					output +="<td><form method='post' action='consumerDelete.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'></td>"
							+"<input name='account_no' type='hidden' value='"+ account_no +"'>"
							+"</from></td></tr>";
					
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


		// Delete Details...............................

		public String deleteDetail(String account_no) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from consumer_details where account_no=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(account_no));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";

			} catch (Exception e) {
				output = "Error while deleting the item.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		

		// to show one particular consumer method
		public String getAccount(String account_no) {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database for reading";
				}

				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Account Number</th>" + "<th>Name</th>"
						+ "<th>Address</th><th>Phone</th>" + "<th>Email</th><th>UserName</th>" + "<th>Password</th>"
						+ "<th>Update</th><th>Remove</th></tr>";

				Statement stmt = con.createStatement();
				String query = "select * from consumer_details where account_no='" + account_no + "'";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					String uaccount_no = Integer.toString(rs.getInt("account_no"));
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					//String username = rs.getString("username");
					//String password = rs.getString("password");

					// Add new row to the html table
					output += "<tr><td>" + uaccount_no + "</td>";
					output += "<td>" + name + "</td>";
					output += "<td>" + address + "</td>";
					output += "<td>" + phone + "</td>";
					output += "<td>" + email + "</td>";
					//output += "<td>" + username + "</td>";
					//output += "<td>" + password + "</td>";

					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
							+ "<td><form method='post' action='#'>"
							+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>";
				}

				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while searching!";
				System.err.println(e.getMessage());
			}

			return output;

		}
	
		
		// Insert Details...............................

		public String insertDetail(String name, String address, String phone, String email, String username,
				String password) {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = "insert into consumer_details(`account_no`,`name`,`address`,`phone`,`email`,`username`,`password`)"
						+ " values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, address);
				preparedStmt.setString(4, phone);
				preparedStmt.setString(5, email);
				preparedStmt.setString(6, username);
				preparedStmt.setString(7, password);

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


	}


