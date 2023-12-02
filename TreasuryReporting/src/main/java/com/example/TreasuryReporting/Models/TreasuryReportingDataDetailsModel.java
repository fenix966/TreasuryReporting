package com.example.TreasuryReporting.Models;

import org.springframework.stereotype.Component;

@Component
public class TreasuryReportingDataDetailsModel  {
    private String record_date;
    private String country;
    private String currency;
    private String country_currency_desc;
    private double exchange_rate;
    private String effective_date;
    private String src_line_nbr;
    private String record_fiscal_year;
    private String record_fiscal_quarter;
    private String record_calendar_year;
    private String record_calendar_quarter;
    private String record_calendar_month;
    private String record_calendar_day;


    public String getRecord_date() {
        return this.record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry_currency_desc() {
        return this.country_currency_desc;
    }

    public void setCountry_currency_desc(String country_currency_desc) {
        this.country_currency_desc = country_currency_desc;
    }

    public double getExchange_rate() {
        return this.exchange_rate;
    }

    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public String getEffective_date() {
        return this.effective_date;
    }

    public void setEffective_date(String effective_date) {
        this.effective_date = effective_date;
    }

    public String getSrc_line_nbr() {
        return this.src_line_nbr;
    }

    public void setSrc_line_nbr(String src_line_nbr) {
        this.src_line_nbr = src_line_nbr;
    }

    public String getRecord_fiscal_year() {
        return this.record_fiscal_year;
    }

    public void setRecord_fiscal_year(String record_fiscal_year) {
        this.record_fiscal_year = record_fiscal_year;
    }

    public String getRecord_fiscal_quarter() {
        return this.record_fiscal_quarter;
    }

    public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
        this.record_fiscal_quarter = record_fiscal_quarter;
    }

    public String getRecord_calendar_year() {
        return this.record_calendar_year;
    }

    public void setRecord_calendar_year(String record_calendar_year) {
        this.record_calendar_year = record_calendar_year;
    }

    public String getRecord_calendar_quarter() {
        return this.record_calendar_quarter;
    }

    public void setRecord_calendar_quarter(String record_calendar_quarter) {
        this.record_calendar_quarter = record_calendar_quarter;
    }

    public String getRecord_calendar_month() {
        return this.record_calendar_month;
    }

    public void setRecord_calendar_month(String record_calendar_month) {
        this.record_calendar_month = record_calendar_month;
    }

    public String getRecord_calendar_day() {
        return this.record_calendar_day;
    }

    public void setRecord_calendar_day(String record_calendar_day) {
        this.record_calendar_day = record_calendar_day;
    }



}


