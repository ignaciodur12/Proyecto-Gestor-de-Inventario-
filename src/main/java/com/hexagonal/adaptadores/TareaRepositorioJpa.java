package com.hexagonal.adaptadores;

import com.hexagonal.dominio.Tarea;
import com.hexagonal.puertos.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;  // Importa la clase List
import java.util.Optional;

@Repository
public class TareaRepositorioJpa implements TareaRepositorio {

    @Autowired
    private JpaRepositorio jpaRepositorio;

    @Override
    public Tarea guardar(Tarea tarea) {
        return jpaRepositorio.save(tarea);
    }

    @Override
    public Optional<Tarea> obtenerPorId(Long id) {
        return jpaRepositorio.findById(id);
    }

    @Override
    public List<Tarea> obtenerTodas() {  // Implementa el método para obtener todas las tareas
        return jpaRepositorio.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {  // Implementa el método para eliminar una tarea por ID
        jpaRepositorio.deleteById(id);
    }
}
