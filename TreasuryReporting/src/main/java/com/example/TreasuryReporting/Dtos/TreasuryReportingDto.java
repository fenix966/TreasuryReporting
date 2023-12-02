package com.example.TreasuryReporting.Dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TreasuryReportingDto(@Size(min = 0, max = 50 ) String description, @NotNull Date transactionDate, @NotNull @Positive double value) {

}
