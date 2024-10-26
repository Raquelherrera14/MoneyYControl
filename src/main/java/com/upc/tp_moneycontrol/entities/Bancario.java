package com.upc.tp_moneycontrol.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Bancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBancario;
    private String nombre;
    private LocalDate fechaIngreso;
    private String direccion;
    private String telefono;
    @Column(unique = true)
    private String email;

}
