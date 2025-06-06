package org.generation.DreamKeyAPI.repository;

import java.util.Optional;

import org.generation.DreamKeyAPI.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	Optional<Usuarios> findByCorreo(String correo);
}//UsuariosRepository
