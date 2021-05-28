package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.dao.CustomerDao;
import com.promineotech.dealerships.dao.DealershipDao;
import com.promineotech.dealerships.dao.EmployeeDao;
import com.promineotech.dealerships.dao.TransactionDao;
import com.promineotech.dealerships.dao.VehicleDao;
import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDealershipService implements DealershipService{
    
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DealershipDao dealeshipDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private VehicleDao vehicleDao;

    public List<Customer> listCustomers(){
        return customerDao.listAllCustomers();
    }

    public void updateCustomer(int customer_id, String name, String address, String phone){
        customerDao.updateCustomer(customer_id, name, address, phone);
    }
    
    // Delete operation from customers table
     public void deleteCustomer(int customerID, String name, String address, String phone){
        customerDao.deleteCustomer(customerID, name, address, phone);
    }

    public List<Transaction> getTransactions(int transactionID){
       return transactionDao.getTransaction(transactionID);
    }

    @Override
    public void deleteTransaction(int transactionID) {
        transactionDao.deleteTransaction(transactionID);
    }

    @Override
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeNum, int dealershipID,
            String date) {
        transactionDao.updateTransaction(transactionID, vehicleID, customerID, employeeNum, dealershipID, date);
        
    }

    @Override
    public void newTransaction(int vehicleID, int customerID, int employeeNum, int dealershipID, String date) {
        vehicleDao.updateVehicle(vehicleID, true);
        transactionDao.newTransaction(vehicleID, customerID, employeeNum, dealershipID, date);        
    }

}
