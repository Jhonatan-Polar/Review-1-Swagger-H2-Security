package com.sunat.device.testing.controller;

import com.sunat.device.testing.dto.AuthResponse;
import com.sunat.device.testing.dto.LoginRequest;
import com.sunat.device.testing.entity.Cuenta;
import com.sunat.device.testing.repository.CuentaRepository;
import com.sunat.device.testing.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findByEmail(loginRequest.getEmail());

        if (cuentaOpt.isPresent() && cuentaOpt.get().getPassword().equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(cuentaOpt.get().getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        }

        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest request) {
        if(cuentaRepository.findByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.status(400).body("Email ya registrado");
        }
        Cuenta nueva = new Cuenta();
        nueva.setEmail(request.getEmail());
        nueva.setPassword(request.getPassword());
        cuentaRepository.save(nueva);
        return ResponseEntity.ok("Usuario registrado");
    }
}