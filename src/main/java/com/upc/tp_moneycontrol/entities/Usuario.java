package com.upc.tp_moneycontrol.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    @ManyToOne
    @JoinColumn(name = "rol_roles_id")
    private Rol rol;
}