package com.sunat.device.testing.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cuentas")
@Schema(description = "Entidad Cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la cuenta", example = "1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Correo electrónico", example = "juan@correo.com")
    private String email;

    @Column(nullable = false)
    @Schema(description = "Password encriptado", example = "********")
    private String password;
}