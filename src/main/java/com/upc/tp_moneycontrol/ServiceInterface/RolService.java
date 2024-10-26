package com.upc.tp_moneycontrol.ServiceInterface;

import com.upc.tp_moneycontrol.entities.Rol;

import java.util.List;

public interface RolService {
    public Rol insertarrol(Rol rol);
    public void eliminarrol(Long id);
    public Rol modificarrol(Rol usuario);
    public List<Rol> listarrol();

    public Rol buscarTipoRolPorId(long id);


}
