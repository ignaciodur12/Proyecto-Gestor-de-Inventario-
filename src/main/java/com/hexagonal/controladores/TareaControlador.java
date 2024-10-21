package com.hexagonal.controladores;

import com.hexagonal.dominio.ServicioTarea;
import com.hexagonal.dominio.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaControlador {

    @Autowired
    private ServicioTarea servicioTarea;

    // Método para crear una nueva tarea
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return servicioTarea.crearTarea(tarea);
    }

    // Método para obtener una tarea por ID
    @GetMapping("/{id}")
    public Optional<Tarea> obtenerTarea(@PathVariable Long id) {
        return servicioTarea.obtenerTareaPorId(id);
    }

    // Método para obtener todas las tareas
    @GetMapping
    public List<Tarea> obtenerTareas() {
        return servicioTarea.obtenerTodasLasTareas();
    }

    // Método para actualizar una tarea
    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        return servicioTarea.actualizarTarea(id, tareaActualizada);
    }



    // Método para eliminar una tarea por ID
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        servicioTarea.eliminarTarea(id);
    }
}
