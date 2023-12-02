package com.example.TreasuryReporting.Controllers;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.TreasuryReporting.Dtos.TreasuryReportingDto;
import com.example.TreasuryReporting.Models.TreasuryReportingDataDetailsModel;
import com.example.TreasuryReporting.Models.TreasuryReportingDataModel;
import com.example.TreasuryReporting.Models.TreasuryReportingModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/treasuryreportingcontroller")
public class TreasuryReportingController {

    public static List<TreasuryReportingModel> treasuriesList;

    static {
        // Initialize the static list
        treasuriesList = new ArrayList<TreasuryReportingModel>();
    }

    @PostMapping("/treasuries")
	public ResponseEntity<Object> saveTreasury(@RequestBody @Valid TreasuryReportingDto treasuryReporting){        
		var treasuryReportingModel = new TreasuryReportingModel();        
		BeanUtils.copyProperties(treasuryReporting, treasuryReportingModel);    
        treasuriesList.add(treasuryReportingModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(treasuryReportingModel);
	}

    @GetMapping("/treasuries")
	public ResponseEntity<List<TreasuryReportingModel>> getAllTreasuries() {        
		return ResponseEntity.status(HttpStatus.OK).body(treasuriesList);
	}

    @GetMapping("/treasuries/{id}")
	public ResponseEntity<Object> getOneTreasury(@PathVariable(value="id") UUID id) {     
        
        int size = treasuriesList.size();
        for (int i = 0; i < size; i++) {
            TreasuryReportingModel treasury = treasuriesList.get(i);
            if(treasury.getId().toString().equalsIgnoreCase(id.toString())){
                return ResponseEntity.status(HttpStatus.OK).body(treasury);
            }       
        }
        return ResponseEntity.status(HttpStatus.OK).body("ID not found!");		
	}

    @GetMapping("/treasuriesRateExchange/{id}")
	public ResponseEntity<Object> getOneTreasuryRateExchange(@PathVariable(value="id") UUID id) {   
        TreasuryReportingModel treasuryAux = null;
        List<TreasuryReportingModel> treasuryListReturn = new ArrayList<TreasuryReportingModel>();

        

        int size = treasuriesList.size();
        for (int i = 0; i < size; i++) {
            TreasuryReportingModel treasury = treasuriesList.get(i);
            if(treasury.getId().toString().equalsIgnoreCase(id.toString())){
                treasuryAux = treasury;
            }       
        }  

        if(treasuryAux == null){
            return ResponseEntity.status(HttpStatus.OK).body("ID not found!");	
        }        
        Instant instant = treasuryAux.getTransactionDate().toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate().minusMonths(6);


        String uri = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v1/accounting/od/rates_of_exchange?filter=record_date:gte:"+localDate+"";
        RestTemplate restTemplate = new RestTemplate();
        TreasuryReportingDataModel treasuryReportingData = restTemplate.getForObject(uri, TreasuryReportingDataModel.class);

        if(treasuryReportingData == null){
            return ResponseEntity.status(HttpStatus.OK).body("The purchase cannot be converted to the target currency.");	
        }

        for (TreasuryReportingDataDetailsModel treasuryReportingDataDetail : treasuryReportingData.data) {
            TreasuryReportingModel treasuryAdd = new TreasuryReportingModel();
            treasuryAdd.setDescription(treasuryAux.getDescription());
            treasuryAdd.setValue(treasuryAux.getValue());
            treasuryAdd.setTransactionDate(treasuryAux.getTransactionDate());
            treasuryAdd.setId(treasuryAux.getId());
            treasuryAdd.setExchangeRateValue(treasuryReportingDataDetail.getExchange_rate());            
            BigDecimal result = BigDecimal.valueOf(treasuryAdd.getValue() * treasuryReportingDataDetail.getExchange_rate());
            result = result.setScale(2, RoundingMode.HALF_UP);
            treasuryAdd.setExchangeValue( result.doubleValue() );
            treasuryListReturn.add(treasuryAdd);
        }

        return ResponseEntity.status(HttpStatus.OK).body(treasuryListReturn);
	}
}
