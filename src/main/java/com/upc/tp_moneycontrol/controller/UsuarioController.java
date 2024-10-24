package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.UsuarioServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.UsuarioService;
import com.upc.tp_moneycontrol.dto.ListarUsuariosRolDTO;
import com.upc.tp_moneycontrol.dto.UsuarioDTO;
import com.upc.tp_moneycontrol.entities.Usuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImplement usuarioServiceImplement;

    @PostMapping("/UsuarioInsertar")
    public UsuarioDTO insertar(@RequestBody UsuarioDTO usuarioDTO){
        ModelMapper modelMapper= new ModelMapper();
        Usuario usuario= modelMapper.map(usuarioDTO, Usuario.class);
        usuario= usuarioServiceImplement.savedUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
    @GetMapping("/UsuarioListar")
    public List<UsuarioDTO> list(){
        return usuarioServiceImplement.list().stream().map(y -> {
            ModelMapper modelMapper= new ModelMapper();
            return  modelMapper.map(y, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/UsuarioModificar")
    public UsuarioDTO modificarUsuraio(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioServiceImplement.modificarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @DeleteMapping("/UsuraioDelete")
    public void eliminarUsuraio(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioServiceImplement.eliminarUsuario(usuario.getIdUsuario());
    }

    @GetMapping("/ListarUsuarioPorRol/{idRol}")
    public List<ListarUsuariosRolDTO> listarUsuarioPorRol(@PathVariable Long idRol){
        return usuarioServiceImplement.listarUsuarioPorRol(idRol);
    }


}
