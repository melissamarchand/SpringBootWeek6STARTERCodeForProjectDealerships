package com.promineotech.dealerships.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.dealerships.entity.Location;

// Dealerships' Locations Dao:
	
@Service
public class LocationDao {
	//
	    public List<Location> listAllLocations() {
	        final String sql = "SELECT * FROM locations";

	        try (
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
							"", "");

					// create a location statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ) {

				// execute the location query
				ResultSet rs = preparedStatement.executeQuery();
	            List<Location> list = new ArrayList<>();
	            while (rs.next()) {
					int locationID = rs.getInt("locationID");
					String location_name = rs.getString("location_name");
					Location location = new Location(locationID, location_name);
	                list.add(location);
				}
	            return list;
	        } catch (SQLException e) {
				printSQLException(e);
	            return null;
			} 
	            
	    }

	    public void updateLocation(int locationID, String location_name) {
	        final String sql = "update locations set locationID = ?, location_name = ?;";

	        try (
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
							"", "");

					// create a location statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            ) {

	                preparedStatement.setInt(1, locationID);
	                preparedStatement.setString(2, location_name);
	               

				    // execute the location query
				    preparedStatement.executeQuery();
	            
	        } catch (SQLException e) {
				printSQLException(e);
			} 
	            
	    }



	    public static void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	    
	}

	
	
	
	
	

