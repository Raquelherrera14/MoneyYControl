package com.upc.tp_moneycontrol.ServiceImplement;

import com.upc.tp_moneycontrol.ServiceInterface.RolService;
import com.upc.tp_moneycontrol.entities.Rol;
import com.upc.tp_moneycontrol.repository.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplement implements RolService {
    @Autowired
    private RolRepository rolRepository;
    @Transactional
    @Override
    public Rol insertarrol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminarrol(Long id) {
        if(rolRepository.existsById(id))
        {
            rolRepository.deleteById(id);
        }

    }

    @Override
    public Rol modificarrol(Rol rol) {
        if(rolRepository.existsById(rol.getIdRol()))
        {
            return rolRepository.save(rol);
        }
        return null;
    }

    @Override
    public List<Rol> listarrol() {
        return rolRepository.findAll();
    }
}
