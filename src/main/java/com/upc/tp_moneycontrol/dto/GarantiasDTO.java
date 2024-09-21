package com.upc.tp_moneycontrol.dto;

import com.upc.tp_moneycontrol.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GarantiasDTO {
    private Long idGarantias;
    private String tipoGarantia;
    private String descripcion;
    private BigDecimal valorGarantia;
    private Usuario usuarioUser;
}
