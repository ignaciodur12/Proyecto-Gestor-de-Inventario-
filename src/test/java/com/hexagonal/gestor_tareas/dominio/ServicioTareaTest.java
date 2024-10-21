package com.hexagonal.gestor_tareas.dominio;

import com.hexagonal.dominio.ServicioTarea;
import com.hexagonal.dominio.Tarea;
import com.hexagonal.puertos.TareaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ServicioTareaTest {

    @Mock
    private TareaRepositorio tareaRepositorio;

    @InjectMocks
    private ServicioTarea servicioTarea;

    private Tarea tarea;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tarea = new Tarea();
        tarea.setId(1);
        tarea.setNombre("Tarea de prueba");
    }

    @Test
    void testCrearTarea() {
        when(tareaRepositorio.guardar(any(Tarea.class))).thenReturn(tarea);

        Tarea resultado = servicioTarea.crearTarea(tarea);

        assertEquals(tarea.getNombre(), resultado.getNombre());
        verify(tareaRepositorio, times(1)).guardar(any(Tarea.class));
        System.out.println("testCrearTarea: Prueba realizada con éxito.");
    }

    @Test
    void testObtenerTareaPorId() {
        when(tareaRepositorio.obtenerPorId(anyLong())).thenReturn(Optional.of(tarea));

        Optional<Tarea> resultado = servicioTarea.obtenerTareaPorId(1L);

        assertEquals(tarea.getNombre(), resultado.get().getNombre());
        verify(tareaRepositorio, times(1)).obtenerPorId(anyLong());
        System.out.println("testObtenerTareaPorId: Prueba realizada con éxito.");
    }

    @Test
    void testObtenerTodasLasTareas() {
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea);
        when(tareaRepositorio.obtenerTodas()).thenReturn(tareas);

        List<Tarea> resultado = servicioTarea.obtenerTodasLasTareas();

        assertEquals(1, resultado.size());
        assertEquals(tarea.getNombre(), resultado.get(0).getNombre());
        verify(tareaRepositorio, times(1)).obtenerTodas();
        System.out.println("testObtenerTodasLasTareas: Prueba realizada con éxito.");
    }

    @Test
    void testActualizarTarea() {
        Tarea tareaActualizada = new Tarea();
        tareaActualizada.setNombre("Tarea actualizada");
        tareaActualizada.setDescripcion("Descripción actualizada");

        when(tareaRepositorio.obtenerPorId(anyLong())).thenReturn(Optional.of(tarea));
        when(tareaRepositorio.guardar(any(Tarea.class))).thenReturn(tarea);

        Tarea resultado = servicioTarea.actualizarTarea(1L, tareaActualizada);

        assertEquals(tareaActualizada.getNombre(), resultado.getNombre());
        verify(tareaRepositorio, times(1)).obtenerPorId(anyLong());
        verify(tareaRepositorio, times(1)).guardar(any(Tarea.class));
        System.out.println("testActualizarTarea: Prueba realizada con éxito.");
    }

    @Test
    void testEliminarTarea() {
        doNothing().when(tareaRepositorio).eliminarPorId(anyLong());

        servicioTarea.eliminarTarea(1L);

        verify(tareaRepositorio, times(1)).eliminarPorId(anyLong());
        System.out.println("testEliminarTarea: Prueba realizada con éxito.");
    }

    @Test
    void testActualizarTareaNoExistente() {
        Tarea tareaActualizada = new Tarea();

        when(tareaRepositorio.obtenerPorId(anyLong())).thenReturn(Optional.empty());

        Tarea resultado = servicioTarea.actualizarTarea(1L, tareaActualizada);

        assertNull(resultado);
        verify(tareaRepositorio, times(1)).obtenerPorId(anyLong());
        System.out.println("testActualizarTareaNoExistente: Prueba realizada con éxito.");
    }
}
