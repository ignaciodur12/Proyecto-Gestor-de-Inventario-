package com.hexagonal.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexagonal.puertos.TareaRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioTarea {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepositorio.obtenerPorId(id);
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepositorio.obtenerTodas();
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepositorio.guardar(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepositorio.eliminarPorId(id);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        Optional<Tarea> tareaOpt = tareaRepositorio.obtenerPorId(id);
        if (tareaOpt.isPresent()) {
            Tarea tarea = tareaOpt.get();
            tarea.setNombre(tareaActualizada.getNombre());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setFechaEntrada(tareaActualizada.getFechaEntrada());
            tarea.setCantidadPedidos(tareaActualizada.getCantidadPedidos());
            tarea.setEstadoProducto(tareaActualizada.getEstadoProducto());
            tarea.setFechaVencimiento(tareaActualizada.getFechaVencimiento());
            return tareaRepositorio.guardar(tarea);
        } else {
            return null;  // o lanza una excepción


        }
    }
}
