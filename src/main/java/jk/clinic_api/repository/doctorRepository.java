package jk.clinic_api.repository;

import jk.clinic_api.model.doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<doctor, Long> {
}