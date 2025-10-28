package jk.clinic_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class availabilityController {

    @GetMapping("/{doctorId}")
    @Operation(summary = "Retorna los horarios disponibles")
    public ResponseEntity<List<LocalTime>> getAvailability(
            @PathVariable Long doctorId) {
        // Demo: horarios fijos disponibles
        List<LocalTime> availableTimes = Arrays.asList(
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0),
                LocalTime.of(15, 0),
                LocalTime.of(16, 0)
        );
        return ResponseEntity.ok(availableTimes);
    }
}