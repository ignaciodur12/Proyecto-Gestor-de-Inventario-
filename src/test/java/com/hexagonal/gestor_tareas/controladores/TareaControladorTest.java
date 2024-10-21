package com.hexagonal.gestor_tareas.controladores;

import com.hexagonal.controladores.TareaControlador; // Importa el controlador
import com.hexagonal.dominio.ServicioTarea;
import com.hexagonal.dominio.Tarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class TareaControladorTest {

    @Mock
    private ServicioTarea servicioTarea;

    @InjectMocks
    private TareaControlador tareaControlador; // Asegúrate de que el nombre sea correcto

    private Tarea tarea;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        tarea = new Tarea(); // Puedes setear los valores de la tarea según tu clase
        tarea.setId(1); // Asegúrate de que el tipo de ID sea correcto
        tarea.setNombre("Tarea de prueba"); // Ajusta el nombre según tu clase
    }

    @Test
    void testCrearTarea() {
        when(servicioTarea.crearTarea(any(Tarea.class))).thenReturn(tarea);

        Tarea resultado = tareaControlador.crearTarea(tarea);

        assertEquals(tarea.getNombre(), resultado.getNombre());
        verify(servicioTarea, times(1)).crearTarea(any(Tarea.class));

        System.out.println("Test Crear Tarea: Éxito");
    }

    @Test
    void testObtenerTarea() {
        when(servicioTarea.obtenerTareaPorId(anyLong())).thenReturn(Optional.of(tarea));

        Optional<Tarea> resultado = tareaControlador.obtenerTarea(1L);

        assertEquals(tarea.getNombre(), resultado.get().getNombre());
        verify(servicioTarea, times(1)).obtenerTareaPorId(anyLong());

        System.out.println("Test Obtener Tarea: Éxito");
    }

    @Test
    void testObtenerTareas() {
        when(servicioTarea.obtenerTodasLasTareas()).thenReturn(List.of(tarea));

        List<Tarea> resultado = tareaControlador.obtenerTareas();

        assertEquals(1, resultado.size());
        assertEquals(tarea.getNombre(), resultado.get(0).getNombre());
        verify(servicioTarea, times(1)).obtenerTodasLasTareas();

        System.out.println("Test Obtener Tareas: Éxito");
    }

    @Test
    void testActualizarTarea() {
        when(servicioTarea.actualizarTarea(anyLong(), any(Tarea.class))).thenReturn(tarea);

        Tarea resultado = tareaControlador.actualizarTarea(1L, tarea);

        assertEquals(tarea.getNombre(), resultado.getNombre());
        verify(servicioTarea, times(1)).actualizarTarea(anyLong(), any(Tarea.class));

        System.out.println("Test Actualizar Tarea: Éxito");
    }

    @Test
    void testEliminarTarea() {
        doNothing().when(servicioTarea).eliminarTarea(anyLong());

        tareaControlador.eliminarTarea(1L);

        verify(servicioTarea, times(1)).eliminarTarea(anyLong());

        System.out.println("Test Eliminar Tarea: Éxito");
    }
}
