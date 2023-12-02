package com.example.TreasuryReporting.Models;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TreasuryReportingModel  {
   
    private UUID id;
	private String description;
	private Date transactionDate;
	private double value;
    private double exchangeRateValue;  

    public double getExchangeRateValue() {
        return this.exchangeRateValue;
    }

    public void setExchangeRateValue(double exchangeRateValue) {
        this.exchangeRateValue = exchangeRateValue;
    }

    public double getExchangeValue() {
        return this.exchangeValue;
    }

    public void setExchangeValue(double exchangeValue) {
        this.exchangeValue = exchangeValue;
    }
    private double exchangeValue;

    public TreasuryReportingModel() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }   

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }    
}