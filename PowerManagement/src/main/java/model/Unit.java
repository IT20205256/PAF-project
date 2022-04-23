package model;

import java.sql.*;

public class Unit {
	
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

			public String insertUnit(String Tariff_Block, String Charge_per_Unit, String Type) {

				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database";
					}

					// create a prepared statement
					String query = "insert into unit_management(`Unit_Record_Id`,`Tariff_Block`,`Charge_per_Unit`,`Type`)"
							+ " values (?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, Tariff_Block);
					preparedStmt.setDouble(3, Double.parseDouble(Charge_per_Unit));
					preparedStmt.setString(4, Type);

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

			public String readUnits() {

				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for reading";
					}

					// Prepare the html table to be displayed
					output = "<table class='table' border='1'><tr><th scope='col'>Tariff Block</th>" + "<th scope='col'>Charge Per Unit</th><th scope='col'>Type</th>" + 
					  "<th>Update</th><th >Remove</th></tr>";

					String query = "select * from unit_management";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);

					// iterate through the rows in the result set
					while (rs.next()) {
						String Unit_Record_Id = Integer.toString(rs.getInt("Unit_Record_Id"));
						String Tariff_Block = rs.getString("Tariff_Block");
						String Charge_per_Unit = Double.toString(rs.getDouble("Charge_per_Unit"));
						String Type = rs.getString("Type");

						// Add new row to the html table
						output += "<tr><td>" + Tariff_Block + "</td>";
						output += "<td>" + Charge_per_Unit + "</td>";
						output += "<td>" + Type + "</td>";

						// buttons
						output += "<td><form method='post' action='GetUnitForUpdate.jsp'>"
								+"<input name='btnUpdate' type='submit' value='Update' class='btn btn-secondary'></td>"
								+ "<input name='Unit_Record_Id' type='hidden' value='" + Unit_Record_Id + "'>"
								+ "</form></td>"
								+ "<td><form method='post' action='deleteUnit.jsp'>"
								+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
								+ "<input name='Unit_Record_Id' type='hidden' value='" + Unit_Record_Id + "'>" 
								+ "</form></td></tr>";
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

			public String updateUnit(String Unit_Record_Id, String Tariff_Block, String Charge_per_Unit, String Type) {

				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for updating.";
					}

					// create a prepared statement
					String query = "UPDATE unit_management SET Tariff_Block=?,Charge_per_Unit=?,Type=?  WHERE Unit_Record_Id=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setString(1, Tariff_Block);
					preparedStmt.setDouble(2, Double.parseDouble(Charge_per_Unit));
					preparedStmt.setString(3, Type);
					preparedStmt.setInt(4, Integer.parseInt(Unit_Record_Id));

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

			// Delete Details...............................

			public String deleteUnit(String Unit_Record_Id) {
				
				String output = "";
				
				try {
					Connection con = connect();
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}
					
					// create a prepared statement
					String query = "delete from unit_management where Unit_Record_Id=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(Unit_Record_Id));
					
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
			public String getUnit(String Unit_Record_Id) {

				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for reading";
					}


					Statement stmt = con.createStatement();
					String query = "select * from unit_management where Unit_Record_Id='" + Unit_Record_Id + "'";
					ResultSet rs = stmt.executeQuery(query);

					while (rs.next()) {
						String UnitRecordId= Integer.toString(rs.getInt("Unit_Record_Id"));
						String Tariff_Block1 = rs.getString("Tariff_Block");
						String Charge_per_Unit= rs.getString("Charge_per_Unit");
						String Type = rs.getString("Type");
						

						output = "<form method='post' action='updateUnit.jsp'>"
								+"<label>UNIT RECORD UNIT : </label><span>"
								+ "<input name='Unit_Record_Id' type='text' value='" + UnitRecordId + "' class='form-control' readonly><br>"
								+"<label>TARIFF BLOCK : </label><span>"
								+ "<input name='Tariff_Block' type='text' value='" + Tariff_Block1+ "' class='form-control' ><br>"
								+"<label>CHARGE PER UNIT : </label><span>"
								+ "<input name='Charge_per_Unit' type='text' value='" + Charge_per_Unit+ "' class='form-control' ><br>"
								+"<label>CONSUMER TYPE : </label><span>"
								+ "<input name='Type' type='text' value='" + Type+ "' class='form-control' ><br>"
								+"<input name='btnUpdate' type='submit' value='Update Unit Record' class='btn btn-secondary'>"
								+"</form>";
					}

					con.close();

			

				} catch (Exception e) {
					output = "Error while searching!";
					System.err.println(e.getMessage());
				}

				return output;

			}
	


}
