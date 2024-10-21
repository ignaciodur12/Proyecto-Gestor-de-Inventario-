package com.hexagonal.adaptadores;

import com.hexagonal.dominio.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepositorio extends JpaRepository<Tarea, Long> {
}
