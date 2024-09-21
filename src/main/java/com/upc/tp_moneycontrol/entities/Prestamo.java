package com.upc.tp_moneycontrol.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "usuario_user_id")
    private Usuario usuario;
}