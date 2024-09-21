package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.PrestamoServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.PrestamoService;
import com.upc.tp_moneycontrol.dto.*;
import com.upc.tp_moneycontrol.entities.Prestamo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://3.144.144.160/"})

@RestController
@RequestMapping("/api/Prestamo")
public class PrestamoController {
    @Autowired
    private PrestamoServiceImplement prestamoServicioImplement;
    @PostMapping("/prestamo")
    public PrestamoDTO insertarPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prestamo prestamo = modelMapper.map(prestamoDTO, Prestamo.class);
        prestamo = prestamoServicioImplement.insertarPrestamo(prestamo);
        return modelMapper.map(prestamo, PrestamoDTO.class);
    }

    @GetMapping("/prestamoList")
    public List<PrestamoDTO> listarPrestamo() {
        List<Prestamo> lista = prestamoServicioImplement.listarPrestamo();
        ModelMapper modelMapper = new ModelMapper();
        List<PrestamoDTO> listaDTO = modelMapper.map(lista , List.class);
        return listaDTO;
    }

    @PutMapping("/prestamoModifi")
    public PrestamoDTO modificarPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prestamo prestamo = modelMapper.map(prestamoDTO, Prestamo.class);
        prestamo = prestamoServicioImplement.modificarPrestamo(prestamo);
        return modelMapper.map(prestamo, PrestamoDTO.class);
    }

    @DeleteMapping("/prestamoDelete")
    public void eliminarPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prestamo prestamo = modelMapper.map(prestamoDTO, Prestamo.class);
        prestamoServicioImplement.eliminarPrestamo(prestamo.getIdPrestamo());
    }

    @GetMapping("/ListarPrestamosUsuarios")
    public List<ListarPrestamosUsuarioDTO> listarPrestamosUsuarioPorRol() {
        return prestamoServicioImplement.listarPrestamosUsuarioPorRol();
    }

    @GetMapping("/CalcularMonto/{prestamoId}")
    public List<PagoCorrespondienteDTO> obtenerPagoCalculado(@PathVariable Long prestamoId) {

        return prestamoServicioImplement.ObtenerPagoCorrespondiente(prestamoId);
    }

    @GetMapping("/PrestamosPeriodo/{fechaInicio}/{fechaFin}")
    public List<PrestamoPeriodoDTO> listarPrestamosPorPeriodo(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin){
        return prestamoServicioImplement.listarPrestamosPorPeriodo(fechaInicio, fechaFin);
    }

    @GetMapping("/PrestamosEstadisticas")
    public List<EstadisticasPrestamoDTO> calcularEstadisticasPrestamos() {
        return prestamoServicioImplement.calcularEstadisticasPrestamos();
    }

}
