package br.edu.ifrs.riogrande.tads.tds.util.controller;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.dto.BusinessDayRequest;
import br.edu.ifrs.riogrande.tads.tds.util.dto.BusinessDayResponse;
import br.edu.ifrs.riogrande.tads.tds.util.service.BusinessDayCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class BusinessDayController {

    private final BusinessDayCalculatorService calculatorService;

    @Autowired
    public BusinessDayController(BusinessDayCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @Deprecated(since = "2025-04-30", forRemoval = false)
    @PostMapping("/date/business-days")
    public ResponseEntity<BusinessDayResponse> calculateBusinessDays(@RequestBody BusinessDayRequest request) {
        LocalDate resultDate = calculatorService.calculateDateAfterBusinessDays(
                request.getStartDate(), request.getBusinessDays());
        
        return ResponseEntity.ok(new BusinessDayResponse(resultDate));
    }

    @PostMapping(
        value = "/v1/business-days", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<BusinessDayResponse> calculateBusinessDaysV1(@RequestBody BusinessDayRequest request) {
        LocalDate resultDate = calculatorService.calculateDateAfterBusinessDays(
                request.getStartDate(), request.getBusinessDays());

        return new ApiResponse<BusinessDayResponse>(new BusinessDayResponse(resultDate));
    } 
}