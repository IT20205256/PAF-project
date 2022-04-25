package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class model {
	
	//A common method to connect to the DB
	private Connection connect()
	{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world", "root", "");
			}
			catch (Exception e)
			{e.printStackTrace();}
			
			return con;
		}
		
	
	
	
		public String insertStaff(String name, String title, String mail, String contact, String gender, String password)
		{
			String output = "";
			try
			{
				Connection con = connect();
				
				if (con == null)
				{return "Error while connecting to the database for inserting."; }
				
				// create a prepared statement
				String query = " insert into staff(`StaffId`,`StaffName`,`JobTitle`,`StaffMail`,`StaffContact`,`StaffGender`)"
				+ " values (?, ?, ?, ?, ?, ?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, title);
				preparedStmt.setString(4, mail);
				preparedStmt.setInt(5, Integer.parseInt(contact));
				preparedStmt.setString(6, gender);
				// execute the statement
				
				preparedStmt.execute();
				con.close();
				
				String insertStaffLogin = insertStaffLogin(mail,password);
				
				output = "Inserted successfully" + insertStaffLogin;
		}
		catch (Exception e)
		{
				output = "Error while inserting the item.";
				System.err.println(e.getMessage());
		}
		return output;
	}
		
	
		//*************************************For Staff Login input************************
		public String insertStaffLogin (String email, String password) {
			String output="";
			String staffId="", semail="";
			
			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database";
				}
				
				Statement stmt = con.createStatement();
				String query = "select * from staff where StaffMail='" + email + "'";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					staffId = Integer.toString(rs.getInt("staffId"));
					semail = rs.getString("StaffMail");

				}
				
				// create a prepared statement
				String query2 = "insert into stafflogin(`StaffId`,`StaffMail`,`Password`)"
						+ " values (?, ?, ?)";
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);

				// binding values
				preparedStmt2.setString(1, staffId);
				preparedStmt2.setString(2, semail);
				preparedStmt2.setString(3, password);

				// execute the statement
				preparedStmt2.execute();
				con.close();
				output = "Inserted Successfully!";
				
			} catch (Exception e) {
				output = "Error while inserting!";
				System.err.println(e.getMessage());
			}
			
			return output;
			
		}

		//****************************************************Validate		
		public String validate(String email, String password) {
			
			String output = "";

			
			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database";
				}

				Statement stmt = con.createStatement();
				String query = "select * from stafflogin where StaffMail='" + email + "' and Password='"+password+"'";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					//int StaffId = rs.getInt("StaffId");
					//String semail = rs.getString("StaffMail");
					password = rs.getString("Password");

				}

				
				con.close();
				
				String getStaffDetails = readStaff();
				
				

				output = getStaffDetails;
				
			} catch (Exception e) {
				output = "Error while inserting!";
				System.err.println(e.getMessage());
			}

			return output;
			
		}
		
	
		
	public String readStaff()
	{
			String output = "";
			try
			{
				Connection con = connect();
				
				if (con == null)
				{return "Error while connecting to the database for reading."; }
				
				// Prepare the html table to be displayed
				output = "<table class='table' border='1'><tr><th scope='col'>Staff ID</th><th scope='col'>Staff Name</th>" +
						"<th scope='col'>JobTitle</th>" +
						"<th scope='col'>Mail</th>" +
						"<th scope='col'>Contact Number</th>" +
						"<th scope='col'>Gender</th>" +
						"<th scope='col'>Update</th><th>Remove</th></tr>";
				
				String query = "select * from staff";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		
				// iterate through the rows in the result set
				while (rs.next())
				{
						String StaffId = Integer.toString(rs.getInt("StaffId"));
						String StaffName = rs.getString("StaffName");
						String JobTitle = rs.getString("JobTitle");
						String StaffMail = rs.getString("StaffMail");
						String StaffContact = rs.getString("StaffContact");
						String StaffGender = rs.getString("StaffGender");
						
						// Add into the html table
						output += "<tr><td>" + StaffId + "</td>";
						output += "<td>" + StaffName + "</td>";
						output += "<td>" + JobTitle + "</td>";
						output += "<td>" + StaffMail + "</td>";
						output += "<td>" + StaffContact + "</td>";
						output += "<td>" + StaffGender + "</td>";
						
						// buttons
						output += "<td><form method='post' action='updateStaff.jsp'>"
						+"<input name='btnUpdate' type='submit' value='Update' class='btn btn-success'>"
						+ "<input name='StaffId' type='hidden' value='" + StaffId + "'>"
						+ "</form></td>"
						+ "<td><form method='post' action='deleteStaff.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='StaffId' type='hidden' value='" + StaffId
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
	
	
	public String getOneStaff(String ID) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading";
			}

			// check from here..................................
			// Prepare the html table to be displayed
			

			Statement stmt = con.createStatement();
			String query = "select * from staff where StaffId='" + ID + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String ID1 = Integer.toString(rs.getInt("StaffId"));
				String Title = rs.getString("JobTitle");
				String Mail = rs.getString("StaffMail");
				String Contact = rs.getString("StaffContact");
				String Name = rs.getString("StaffName");
				String Gender = rs.getString("StaffGender");

				// Add new row to the html table
				output = "<form method = 'post' action = 'updateStaffProcess.jsp'>"
						+"<input name='ID1' type ='hidden' value ='" +ID1 + "' class='form-control'><br>"
						+"<input name='Name' type ='text' value ='" +Name + "' class='form-control'><br>"
						+"<input name='Title' type ='text' value ='" +Title + "' class='form-control' readonly><br>"
						+"<input name='Mail' type ='text' value ='" +Mail + "' class='form-control'><br>"
						+"<input name='Contact' type ='text' value ='" +Contact + "' class='form-control'><br>"
						+"<input name='Gender' type ='text' value ='" +Gender + "' class='form-control' readonly><br>"
						+"<input name = 'btnSubmit' type ='submit' value='Update' class='btn btn-secondary'>";
						
			}

			con.close();

			// Complete the html table
			output += "</form>";

		} catch (Exception e) {
			output = "Error while retrieving!";
			System.err.println(e.getMessage());
		}

		return output;

	}

	
	
	
	
	
	public String updateStaff(String ID, String name, String title, String mail, String contact)
	
	{
			String output = "";
			try
			{
					Connection con = connect();
					
					if (con == null)
					{return "Error while connecting to the database for updating."; }
					
					// create a prepared statement
					String query = "UPDATE staff SET StaffName=?,JobTitle=?,StaffMail=?,StaffContact=? WHERE StaffId=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, title);
					preparedStmt.setString(3, mail);
					preparedStmt.setInt(4, Integer.parseInt(contact));
					preparedStmt.setInt(5, Integer.parseInt(ID));
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					
					output = "Updated successfully";
			}
			catch (Exception e)
			{
					output = "Error while updating the staff.";
					System.err.println(e.getMessage());
			}
			
			return output;
	}
	
	
	
	
	
	
	
	
	public String deleteStaff(String ID)
	{
			String output = "";
			try
			{
					Connection con = connect();
					if (con == null)
					{return "Error while connecting to the database for deleting."; }
					
					// create a prepared statement
					String query = "delete from staff where StaffId=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(ID));
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					
					output = "Deleted successfully";
			}
			catch (Exception e)
			{
					output = "Error while deleting the staff.";
					System.err.println(e.getMessage());
			}
			
			return output;
	}
	
	
	
	
	
	
	
	
	
	public String insertSalary(String Name, String Salary)
	{
		String output="";
		try {
			Connection con = connect();
			
			if(con == null) {
				return "Error with connecting to the database";
			}
			
			String query = "UPDATE staff SET Salary=? WHERE StaffName=?";
			PreparedStatement preparedstmt = con.prepareStatement(query);
			
			//Binding the values
			preparedstmt.setString(1, Salary);
			preparedstmt.setString(2, Name);
			
			//executing the query
			preparedstmt.execute();
			con.close();
			output = "Salary added successfully";
		}catch(Exception e) {
			output = "Error while inputting the salary";
			System.out.print(e.getMessage());
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	public String readSalary()
	{
		int hra;
		int speacialallowance;
		int pf;
		int lta;
		int netsalary;
	
		
		
		String output = "";
		try
		{
			Connection con = connect();
			
			if (con == null)
			{return "Error while connecting to the database for reading."; }
			
			// Prepare the html table to be displayed
			output = "<table class='table' border='1'><tr><th scope='col'>Staff ID</th><th scope='col'>Staff Name</th>" +
					"<th scope='col'>JobTitle</th>" +
					"<th scope='col'>Salary</th>"+
					"<th scope='col'>Update</th><th>Remove</th></tr>";
			
			String query = "select StaffId,StaffName, JobTitle, Salary from staff";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	
			//Assigning calculations
			// iterate through the rows in the result set
			while (rs.next())
			{
					String StaffId = Integer.toString(rs.getInt("StaffId"));
					String StaffName = rs.getString("StaffName");
					String JobTitle = rs.getString("JobTitle");
					Integer BasicSalary = Integer.parseInt(rs.getString("Salary"));
					

					lta=(8*BasicSalary)/100;
					hra=(50*BasicSalary)/100;
					speacialallowance=(75*BasicSalary)/100;
					
					pf=(12*BasicSalary)/100;
					netsalary= BasicSalary+hra+lta+speacialallowance+pf;
					
					// Add into the html table
					output += "<tr><td>" + StaffId + "</td>";
					output += "<td>" + StaffName + "</td>";
					output += "<td>" + JobTitle + "</td>";
					output += "<td>" + netsalary + "</td>";
					
					// buttons
					output += "<td><form method='post' action='insertSalary.jsp'>"
					+"<input name='btnUpdate' type='submit' value='Update' class='btn btn-secondary'>"
					+ "<input name='StaffId' type='hidden' value='" + StaffId + "'>"
					+ "</form></td>"
					+ "<td><form method='post' action='deleteStaff.jsp'>"
					+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
					+ "<input name='StaffId' type='hidden' value='" + StaffId
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

}
