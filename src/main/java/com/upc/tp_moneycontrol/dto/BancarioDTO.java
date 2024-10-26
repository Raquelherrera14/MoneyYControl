package com.upc.tp_moneycontrol.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BancarioDTO {

    private Long      idBancario;
    private String     nombre;
    private LocalDate  fechaIngreso;
    private String     direccion;
    private String     telefono;
    private String     email;

}
