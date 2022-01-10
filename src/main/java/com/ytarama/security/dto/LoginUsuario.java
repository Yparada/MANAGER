package com.ytarama.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String password;
}
