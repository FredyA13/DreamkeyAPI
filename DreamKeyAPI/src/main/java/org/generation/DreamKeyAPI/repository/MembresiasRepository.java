package org.generation.DreamKeyAPI.repository;

import java.util.Optional;

import org.generation.DreamKeyAPI.model.Membresias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiasRepository extends JpaRepository<Membresias,Long>{
	Optional<Membresias> findByNombre(String nombre);
}
