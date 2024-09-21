package com.upc.tp_moneycontrol.repository;

import com.upc.tp_moneycontrol.dto.ListarPrestamosUsuarioDTO;
import com.upc.tp_moneycontrol.dto.ListarUsuariosRolDTO;
import com.upc.tp_moneycontrol.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


    @Query("SELECT new com.upc.tp_moneycontrol.dto.ListarUsuariosRolDTO(u.idUsuario, u.nombre,u.email,u.telefono,u.rol.idRol," +
            "u.rol.nombreRol) FROM Usuario u WHERE u.rol.idRol = :idRol")
    public List<ListarUsuariosRolDTO> listarUsuarioPorRol(@Param("idRol") Long idRol);

}
