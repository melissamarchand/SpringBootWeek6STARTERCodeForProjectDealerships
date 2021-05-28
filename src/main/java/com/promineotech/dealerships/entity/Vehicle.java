package com.promineotech.dealerships.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int vehicleID;
    private int dealershipID;
    private boolean isSold;
    private String make;
    private String model;
    private double price;
}
