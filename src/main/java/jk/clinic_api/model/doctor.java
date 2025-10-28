package jk.clinic_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;

    public doctor() {}

    public doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Getters y setters
}
