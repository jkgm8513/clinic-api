package jk.clinic_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jk.clinic_api.security.JwUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwUtil jwtUtil;

    public AuthController(JwUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Validación mock (en producción hacer consulta a base de datos)
        if ("user".equals(username) && "password".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
