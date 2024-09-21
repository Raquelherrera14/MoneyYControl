package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.RolServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.RolService;
import com.upc.tp_moneycontrol.dto.RolDTO;
import com.upc.tp_moneycontrol.dto.UsuarioDTO;
import com.upc.tp_moneycontrol.entities.Rol;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://3.144.144.160/"})

@RestController
@RequestMapping("/api/Rol")
public class RolController {
    @Autowired
    private RolServiceImplement rolServiceImplement;
    @PostMapping("/rolInsertar")
    public RolDTO insertarRol(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
            Rol rol = modelMapper.map(rolDTO, Rol.class);
        rol = rolServiceImplement.insertarrol(rol);
        return modelMapper.map(rol, RolDTO.class);
    }

    @GetMapping("/rolListar")
    public List<RolDTO> listarRol() {
        List<Rol> lista = rolServiceImplement.listarrol();
        ModelMapper modelMapper = new ModelMapper();
        List<RolDTO> listaDTO = modelMapper.map(lista , List.class);
        return listaDTO;
    }

    @PutMapping("/rolModificar")
    public RolDTO modificarRol(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        rol = rolServiceImplement.modificarrol(rol);
        return modelMapper.map(rol, RolDTO.class);
    }

    @DeleteMapping("/rolDelete")
    public void eliminarRol(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        rolServiceImplement.eliminarrol(rol.getIdRol());
    }
}
