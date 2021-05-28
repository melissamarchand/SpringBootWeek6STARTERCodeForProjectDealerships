package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/Dealerships")
public interface DealershipController {
    

    @GetMapping("Customers")
    ResponseEntity<List<Customer>> listCustomers();

    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void updateCustomer(
        @RequestParam(required = true) int customer_id, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);
    
    // Delete operation on customers table
    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteCustomer(
        @RequestParam(required = true) int customer_id, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);
    

    @GetMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<Transaction>> getTransactions(
        @RequestParam(required = true) int transactionID
    );

    @DeleteMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteTransaction(
        @RequestParam(required = true) int transactionID
    );

    @PostMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void newTransaction( 
        @RequestParam(required = true) int vehicleID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeNum, 
        @RequestParam(required = true) int dealershipID, 
        @RequestParam(required = true) String date);

    @PutMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void updateTransaction(
        @RequestParam(required = true) int transactionID, 
        @RequestParam(required = false) int vehicleID, 
        @RequestParam(required = false) int customerID, 
        @RequestParam(required = false) int employeeNum, 
        @RequestParam(required = false) int dealershipID, 
        @RequestParam(required = false) String date);
}
