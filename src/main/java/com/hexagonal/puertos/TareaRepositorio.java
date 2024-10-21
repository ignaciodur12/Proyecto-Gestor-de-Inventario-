package com.hexagonal.puertos;

import com.hexagonal.dominio.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepositorio {
    Tarea guardar(Tarea tarea);  // Método para guardar o actualizar una tarea
    Optional<Tarea> obtenerPorId(Long id);  // Método para obtener una tarea por ID
    List<Tarea> obtenerTodas();  // Método para obtener todas las tareas
    void eliminarPorId(Long id);  // Método para eliminar una tarea por ID
}
