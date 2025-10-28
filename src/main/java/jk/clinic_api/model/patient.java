package jk.clinic_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Email(message = "El email debe ser un correo válido")
    private String email;
    @NotBlank(message = "El teléfono es obligatorio")
    private String phone;

    public patient() {}

    public patient(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}