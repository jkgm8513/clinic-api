package jk.clinic_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import jk.clinic_api.model.patient;
import jk.clinic_api.repository.patientRepository;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/patients")
public class patientController {

    private final patientRepository patientRepository;

    public patientController(patientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping
    @Operation(summary = "Crea un paciente")
    public ResponseEntity<?> createPatient(@Valid @RequestBody patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        patient saved = patientRepository.save(patient);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta un paciente por ID")
    public ResponseEntity<patient> getPatientById(@PathVariable Long id) {
        Optional<patient> patient = patientRepository.findById(id);
        return patient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
