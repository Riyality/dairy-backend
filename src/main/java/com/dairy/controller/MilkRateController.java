package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.dto.milkRate.MilkRateRequestDto;
import com.dairy.service.MilkRateService;

@RestController
@RequestMapping( "/milkRate" )
public class MilkRateController {
	
	@Autowired
	private MilkRateService milkRateService;
	
	@GetMapping( "/type/{type}/fat/{fat}/snf/{snf}/branchId/{branchId}" )
	public ResponseEntity<Float> getMilkRateByFatAndSNF( @PathVariable String type, @PathVariable float fat, @PathVariable float snf, @PathVariable int branchId) {
		
		return new ResponseEntity<>( milkRateService.getMilkRateByTypeAndFatAndSNFAndBranch(type,fat,snf,branchId), HttpStatus.OK );
	}

	@PostMapping("/saveMilkRates")
    public ResponseEntity<String> saveMilkRates(@RequestBody List<MilkRateRequestDto> milkRates) {
        try {
        	boolean allRatesSaved = true;
            for (MilkRateRequestDto milkRate : milkRates) {
                boolean rateSaved = milkRateService.saveMilkRate(milkRate);

                if (!rateSaved) {
                    // If any rate fails to save, set the flag to false
                    allRatesSaved = false;
                }
            }
            return new ResponseEntity<>("Milk rates saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving milk rates", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
}
}