package jk.clinic_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDate date;
    private LocalTime time;

    public appointment() {}

    public appointment(Long patientId, Long doctorId, LocalDate date, LocalTime time) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    // Getters y setters
}