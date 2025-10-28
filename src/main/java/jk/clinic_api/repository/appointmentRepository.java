package jk.clinic_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jk.clinic_api.model.appointment;

public interface appointmentRepository extends JpaRepository<appointment, Long> {
}