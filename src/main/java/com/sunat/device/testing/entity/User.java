package com.sunat.device.testing.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
@Schema(description = "Entidad Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Schema(description = "Nombre completo", example = "Juan Pérez")
    private String name;

    @Schema(description = "Correo electrónico", example = "juan@correo.com")
    private String email;
}