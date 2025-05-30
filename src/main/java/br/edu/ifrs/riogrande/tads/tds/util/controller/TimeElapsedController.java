package br.edu.ifrs.riogrande.tads.tds.util.controller;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.TimeElapsedResponseDTOV2;
import br.edu.ifrs.riogrande.tads.tds.util.dto.TimeElapsedRequest;
import br.edu.ifrs.riogrande.tads.tds.util.dto.TimeElapsedResponse;
import br.edu.ifrs.riogrande.tads.tds.util.service.TimeElapsedCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
public class TimeElapsedController {

    private final TimeElapsedCalculatorService calculatorService;

    @Autowired
    public TimeElapsedController(TimeElapsedCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/elapsed")
    public ResponseEntity<TimeElapsedResponse> calculateTimeElapsed(@RequestBody TimeElapsedRequest request) {
        String elapsedTime = calculatorService.calculateTimeElapsed(
                request.getStartTime(), request.getEndTime());
        
        return ResponseEntity.ok(new TimeElapsedResponse(elapsedTime));
    }
    
    @PostMapping(
        value = "v2/elapsed",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<TimeElapsedResponseDTOV2>> calculateTimeElapsedV2(@RequestBody TimeElapsedRequest request) {
        String elapsedTime = calculatorService.calculateTimeElapsed(
                request.getStartTime(), request.getEndTime());
        
        return ResponseEntity.ok(new ApiResponse<>(new TimeElapsedResponseDTOV2(elapsedTime)));
    }
}