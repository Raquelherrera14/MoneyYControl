package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.RolServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.RolService;
import com.upc.tp_moneycontrol.dto.RolDTO;
import com.upc.tp_moneycontrol.dto.UsuarioDTO;
import com.upc.tp_moneycontrol.entities.Rol;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolServiceImplement rolServiceImplement;
   /* @PostMapping("/rolInsertar")
    public RolDTO insertarRol(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
            Rol rol = modelMapper.map(rolDTO, Rol.class);
        rol = rolServiceImplement.insertarrol(rol);
        return modelMapper.map(rol, RolDTO.class);
    }
*/
    @GetMapping("/tiporoles")
    public List<RolDTO> listaTiposRol() {
        List<Rol> tipos = rolServiceImplement.listarrol();
        ModelMapper modelMapper = new ModelMapper();
        return tipos.stream()
                .map(tipo -> modelMapper.map(tipo, RolDTO.class))
                .collect(Collectors.toList());
    }


    @PostMapping("/tiporol")//add
    public ResponseEntity<RolDTO> adicionaTipo(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        rol = rolServiceImplement.insertarrol(rol);
        rolDTO = modelMapper.map(rol, RolDTO.class);
        return ResponseEntity.ok(rolDTO);
    }

}
