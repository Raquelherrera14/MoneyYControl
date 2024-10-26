package com.upc.tp_moneycontrol.dto;

import com.upc.tp_moneycontrol.entities.Rol;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long      idUsuario   ;
    private String    contrasena   ;
    private String    nombre      ;
    private String    apellido   ;
    private String     direccion    ;
    private String    telefono     ;
    private String    email       ;

    private Rol rol;
}
