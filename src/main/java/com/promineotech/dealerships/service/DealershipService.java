package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Transaction;

public interface DealershipService {

    List<Customer> listCustomers();

    void updateCustomer(int customer_id, String name, String address, String phone);

    public List<Transaction> getTransactions(int transactionID);

    public void deleteTransaction(int transactionID);

    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeNum, int dealershipID, String date);

    public void newTransaction(int vehicleID, int customerID, int employeeNum, int dealershipID, 
            String date);

	void deleteCustomer(int customerID, String name, String address, String phone);
    
}
