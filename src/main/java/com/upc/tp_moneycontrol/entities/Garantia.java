package com.upc.tp_moneycontrol.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Garantia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarantia;
    private String tipoGarantia;
    private String descripcion;
    private BigDecimal valorGarantia;
    @ManyToOne
    @JoinColumn(name = "usuario_user_id")
    private Usuario usuario;

}