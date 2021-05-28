package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Transaction;
import com.promineotech.dealerships.service.DealershipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDealershipController implements DealershipController{
    
    @Autowired
    private DealershipService dealershipService;

    @Override
    @GetMapping("Customers")
    public ResponseEntity<List<Customer>> listCustomers(){
        log.info("customer list requested");
        List<Customer> customers = dealershipService.listCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    public void updateCustomer(int customer_id, String name, String address, String phone){
        dealershipService.updateCustomer(customer_id, name, address, phone);
    }
    
    // Delete operation on customers table
     public void deleteCustomer(int customerID, String name, String address, String phone){
        dealershipService.deleteCustomer(customerID, name, address, phone);
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(int transactionID) {
        List<Transaction> transactions = dealershipService.getTransactions(transactionID);
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
        
    }

    @Override
    public void deleteTransaction(int transactionID) {
        dealershipService.deleteTransaction(transactionID);
        
    }

    @Override
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeNum, int dealershipID,
            String date) {
        dealershipService.updateTransaction(transactionID, vehicleID, customerID, employeeNum, dealershipID, date);
        
    }

    @Override
    public void newTransaction(int vehicleID, int customerID, int employeeNum, int dealershipID, String date) {
       dealershipService.newTransaction(vehicleID, customerID, employeeNum, dealershipID, date);
        
    }
}
