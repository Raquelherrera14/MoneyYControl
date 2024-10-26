package com.upc.tp_moneycontrol.ServiceImplement;

import com.upc.tp_moneycontrol.ServiceInterface.BancarioService;
import com.upc.tp_moneycontrol.entities.Bancario;
import com.upc.tp_moneycontrol.repository.BancarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancarioServiceImpl implements BancarioService {

@Autowired
    private BancarioRepository bancarioRepository;


    @Override
    public Bancario insertar(Bancario bancario) {
        return bancarioRepository.save(bancario);
    }

    @Override
    public Bancario editar(Bancario bancario) {
        if (bancarioRepository.findById(bancario.getIdBancario()).isPresent()){
            return bancarioRepository.save(bancario);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(bancarioRepository.findById(id).isPresent()){
            bancarioRepository.deleteById(id);
        }
    }

    @Override
    public List<Bancario> listar() {
        return bancarioRepository.findAll();
    }

    @Override
    public Bancario buscarPorId(long id) {
        if(bancarioRepository.findById(id).isPresent()){
            return bancarioRepository.findById(id).get();
        }
        return null;  }
}
