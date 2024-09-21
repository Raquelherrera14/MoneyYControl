package com.upc.tp_moneycontrol.dto;

import com.upc.tp_moneycontrol.entities.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {
    private Long idPrestamo;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Usuario usuarioUser;
}
