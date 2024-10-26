package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceInterface.BancarioService;
import com.upc.tp_moneycontrol.dto.BancarioDTO;
import com.upc.tp_moneycontrol.entities.Bancario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")

public class BancarioController {
    @Autowired
    private BancarioService bancarioService;

    @GetMapping("/bancarios")
    public List<BancarioDTO> listaBancario() {
        List<Bancario> bancarios = bancarioService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return bancarios.stream()
                .map(bancario -> modelMapper.map(bancario, BancarioDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/bancario")
    public ResponseEntity<BancarioDTO> adicionaBancario(@RequestBody BancarioDTO bancarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Bancario bancario = modelMapper.map(bancarioDTO, Bancario.class);
        bancario = bancarioService.insertar(bancario);
        bancarioDTO = modelMapper.map(bancario, BancarioDTO.class);
        return ResponseEntity.ok(bancarioDTO);
    }
    @PutMapping("/bancario")
    public ResponseEntity<BancarioDTO>  editarCliente(@RequestBody BancarioDTO bancarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Bancario bancario = modelMapper.map(bancarioDTO, Bancario.class);
        bancario = bancarioService.editar(bancario);
        bancarioDTO = modelMapper.map(bancario, BancarioDTO.class);
        return ResponseEntity.ok(bancarioDTO);
    }
    @DeleteMapping("/bancario/{id}")
    public void eliminarbancario(@PathVariable int id) {
        bancarioService.eliminar(id);
    }
    @GetMapping("/bancario/{id}")
    public ResponseEntity<BancarioDTO> buscaBancario(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Bancario bancario = bancarioService.buscarPorId(id);
        BancarioDTO bancarioDTO = modelMapper.map(bancario, BancarioDTO.class);
        return ResponseEntity.ok(bancarioDTO);
    }
}
