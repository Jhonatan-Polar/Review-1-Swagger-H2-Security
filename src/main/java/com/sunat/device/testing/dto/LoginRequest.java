package com.sunat.device.testing.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @Schema(description = "Correo de login", example = "juan@correo.com")
    private String email;

    @Schema(description = "Password de login", example = "123456")
    private String password;
}