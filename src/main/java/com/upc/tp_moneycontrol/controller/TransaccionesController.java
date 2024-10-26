package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.TransaccionesServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.TransaccionesService;
import com.upc.tp_moneycontrol.dto.PagoCorrespondienteDTO;
import com.upc.tp_moneycontrol.dto.TransaccionPeriodoDTO;
import com.upc.tp_moneycontrol.dto.TransaccionesDTO;
import com.upc.tp_moneycontrol.entities.Transacciones;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class TransaccionesController {
    @Autowired
    private TransaccionesServiceImplement transaccionesServiceImplement;

    @PostMapping("/TransaccionInsertar")
    public TransaccionesDTO insertarHistoriaTransacciones(@RequestBody TransaccionesDTO transaccionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Transacciones transacciones = modelMapper.map(transaccionesDTO, Transacciones.class);
        transacciones = transaccionesServiceImplement.insertarPago(transacciones);
        return modelMapper.map(transacciones, TransaccionesDTO.class);
    }

    @GetMapping("/TransaccionesListar")
    public List<TransaccionesDTO> listarHistorialTransacciones() {
        List<Transacciones> lista = transaccionesServiceImplement.listarTransacciones();
        ModelMapper modelMapper = new ModelMapper();
        List<TransaccionesDTO> listaDTO = modelMapper.map(lista , List.class);
        return listaDTO;
    }

    @PutMapping("/TransaccionModificar")
    public TransaccionesDTO modificarHistorialTransacciones(@RequestBody TransaccionesDTO transaccionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Transacciones transacciones = modelMapper.map(transaccionesDTO, Transacciones.class);
        transacciones = transaccionesServiceImplement.modificarPago(transacciones);
        return modelMapper.map(transacciones, TransaccionesDTO.class);
    }

    @DeleteMapping("/TransaccionDelete")
    public void eliminarHistorialTransacciones(@RequestBody TransaccionesDTO transaccionesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Transacciones transacciones = modelMapper.map(transaccionesDTO, Transacciones.class);
        transaccionesServiceImplement.eliminarPago(transacciones.getIdTransacciones());
    }

    @GetMapping("/TransaccionPeriodo/{fechaInicio}/{fechaFin}")
    public List<TransaccionPeriodoDTO> listarTransaccionesPorPeriodo(@PathVariable LocalDate fechaInicio,@PathVariable LocalDate fechaFin) {
        return transaccionesServiceImplement.listarTransaccionesPorPeriodo(fechaInicio, fechaFin);
    }


}
