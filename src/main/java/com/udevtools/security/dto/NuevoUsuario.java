package com.udevtools.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class NuevoUsuario {

    @NotBlank
    private String nombre;

    @NotBlank
    private String nombreUsuario;

    @Email
    private String email;

    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
}
