package org.generation.DreamKeyAPI.repository;

import java.util.Optional;

import org.generation.DreamKeyAPI.model.Afiliados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadosRepository extends JpaRepository<Afiliados, Long>{
	Optional<Afiliados> findByNombre(String nombre);
}//class AfiliadosRepository
