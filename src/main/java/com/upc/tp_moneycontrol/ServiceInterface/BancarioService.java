package com.upc.tp_moneycontrol.ServiceInterface;

import com.upc.tp_moneycontrol.entities.Bancario;

import java.rmi.Remote;
import java.util.List;

public interface BancarioService {

    public Bancario insertar(Bancario bancario);
    public Bancario editar(Bancario bancario);
    public void eliminar(long id);
    public List<Bancario> listar();
    public Bancario buscarPorId(long id);

}
