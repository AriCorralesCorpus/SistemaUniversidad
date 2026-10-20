package com.universidad.sistema.repository;

import com.universidad.sistema.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    List<Carrera> findByEstado(String estado);
}
