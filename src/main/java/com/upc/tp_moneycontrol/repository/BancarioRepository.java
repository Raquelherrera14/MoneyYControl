package com.upc.tp_moneycontrol.repository;

import com.upc.tp_moneycontrol.entities.Bancario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancarioRepository extends JpaRepository<Bancario, Long> {


}
