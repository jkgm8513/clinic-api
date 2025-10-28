package jk.clinic_api.repository;

import jk.clinic_api.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<patient, Long> {
}
