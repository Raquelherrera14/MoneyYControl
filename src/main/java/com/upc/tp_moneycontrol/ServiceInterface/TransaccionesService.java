package com.upc.tp_moneycontrol.ServiceInterface;

import com.upc.tp_moneycontrol.dto.PagoCorrespondienteDTO;
import com.upc.tp_moneycontrol.dto.TransaccionPeriodoDTO;
import com.upc.tp_moneycontrol.entities.Transacciones;
import jakarta.transaction.Transaction;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransaccionesService {

    public Transacciones insertarPago(Transacciones transacciones);
    public void eliminarPago(Long id);
    public Transacciones modificarPago(Transacciones transacciones);
    public List<Transacciones> listarTransacciones();

    public List<TransaccionPeriodoDTO> listarTransaccionesPorPeriodo(LocalDate fechaInicio,LocalDate fechaFin);



}
