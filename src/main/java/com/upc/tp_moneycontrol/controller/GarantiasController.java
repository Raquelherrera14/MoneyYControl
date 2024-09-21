package com.upc.tp_moneycontrol.controller;

import com.upc.tp_moneycontrol.ServiceImplement.GarantiasServiceImplement;
import com.upc.tp_moneycontrol.ServiceInterface.GarantiasService;
import com.upc.tp_moneycontrol.dto.GarantiasDTO;
import com.upc.tp_moneycontrol.entities.Garantia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://3.144.144.160/"})

@RestController
@RequestMapping("/api/Garantias")
public class GarantiasController {

    @Autowired
    private GarantiasServiceImplement garantiaServicioImplement;
    @PostMapping("/garantiaInsertar")
    public GarantiasDTO insertarGarantia(@RequestBody GarantiasDTO garantiaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Garantia garantia = modelMapper.map(garantiaDTO, Garantia.class);
        garantia = garantiaServicioImplement.insertarGarantia(garantia);
        return modelMapper.map(garantia, GarantiasDTO.class);
    }

    @GetMapping("/garantiaListar")
    public List<GarantiasDTO> listarGarantia() {
        List<Garantia> lista = garantiaServicioImplement.listarGarantia();
        ModelMapper modelMapper = new ModelMapper();
        List<GarantiasDTO> listaDTO = modelMapper.map(lista , List.class);
        return listaDTO;
    }

    @PutMapping("/garantiaModicar")
    public GarantiasDTO modificarGarantia(@RequestBody GarantiasDTO garantiaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Garantia garantia = modelMapper.map(garantiaDTO, Garantia.class);
        garantia = garantiaServicioImplement.modificarGarantia(garantia);
        return modelMapper.map(garantia, GarantiasDTO.class);
    }

    @DeleteMapping("/garantiaDelete")
    public void eliminarGarantia(@RequestBody GarantiasDTO garantiaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Garantia garantia = modelMapper.map(garantiaDTO, Garantia.class);
        garantiaServicioImplement.eliminarGarantia(garantia.getIdGarantia());
    }
}
