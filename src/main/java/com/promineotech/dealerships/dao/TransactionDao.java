package com.promineotech.dealerships.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.promineotech.dealerships.entity.Transaction;

public class TransactionDao {
    
        public List<Transaction> getTransaction(Integer transactionID){
            final String getTransaction = "SELECT * FROM transactions where transaction_id = ?";

            try (
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                            "root", "Dolphins");

                    // create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                        
                ) {
                    preparedStatement.setInt(1, transactionID);
                // execute the car query
                ResultSet rs = preparedStatement.executeQuery();
                List<Transaction> list = new ArrayList<>();
                while (rs.next()) {
                    int transaction_id = rs.getInt("transaction_id");
                    int vehicleID = rs.getInt("vehicleID");
                    int customerID = rs.getInt("customerID");
                    int employeeNum = rs.getInt("employeeNum");
                    int dealershipID = rs.getInt("dealershipID");
                    String date = rs.getString("date");
                    Transaction transaction = new Transaction(transaction_id, vehicleID, customerID, employeeNum, dealershipID, date);
                    list.add(transaction);
                }
                return list;
            } catch (SQLException e) {
                printSQLException(e);
                return null;
            } 
        }

        
        public void newTransaction(int vehicleID, int customerID, int employeeNum, int dealershipID, 
            String date) {
             
            final String updateTransaction = "INSERT into transactions (vehicleID, customerID, employeeNum, dealershipID, date)" +
                "Values (?, ?, ?, ?, ?);";
    
            // establish a connection
    
            try (
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                            "root", "Dolphins");
    
                    // create a car statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                        preparedStatement.setInt(1, vehicleID);
                        preparedStatement.setInt(2, customerID);
                        preparedStatement.setInt(3, employeeNum);
                        preparedStatement.setInt(4, dealershipID);
                        preparedStatement.setString(5, date);
    
                // execute query or update query
    
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
    
                // print SQLException info
                printSQLException(e);
            }
        }


        public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeNum, int dealershipID, 
            String date) {
             
            final String updateTransaction = "update transactions set vehicleID = ?, customerID = ? , employeeNum = ?, dealershipID = ?, date = ? where transactionID = ?;";
    
            // establish a connection
    
            try (
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                            "root", "Dolphins");
    
                    // create a car statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                        preparedStatement.setInt(1, vehicleID);
                        preparedStatement.setInt(2, customerID);
                        preparedStatement.setInt(3, employeeNum);
                        preparedStatement.setInt(4, dealershipID);
                        preparedStatement.setString(5, date);
                        preparedStatement.setInt(6, transactionID);
    
                // execute query or update query
    
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
    
                // print SQLException info
                printSQLException(e);
            }
        }


        public void deleteTransaction(Integer transactionID){
            final String getTransaction = "DELETE * FROM transactions where transaction_id = ?";

            try (
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                            "root", "Dolphins");

                    // create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                        
                ) {
                    preparedStatement.setInt(1, transactionID);
                // execute the car query
                int result = preparedStatement.executeUpdate();
                System.out.println("Number of customer records affected :: " + result);
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
