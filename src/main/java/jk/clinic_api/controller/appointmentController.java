package jk.clinic_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jk.clinic_api.model.appointment;
import jk.clinic_api.repository.appointmentRepository;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class appointmentController {

    private final appointmentRepository appointmentRepository;

    public appointmentController(appointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping
    @Operation(summary = "Agendar cita")
    public ResponseEntity<appointment> createAppointment(@RequestBody appointment appointment) {
        appointment saved = appointmentRepository.save(appointment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta la cita")
    public ResponseEntity<appointment> getAppointmentById(@PathVariable Long id) {
        Optional<appointment> appointment = appointmentRepository.findById(id);
        return appointment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}