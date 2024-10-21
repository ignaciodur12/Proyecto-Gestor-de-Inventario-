package com.hexagonal.gestor_tareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class GestorTareasApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void testConexionMySQL() {
		System.out.println("Conectando a la base de datos...");

		// Ejecutar un SELECT de prueba
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList("SELECT * FROM Productos");

		// Mostrar los resultados en la consola
		System.out.println("Resultados de la consulta:");
		resultados.forEach(System.out::println);

		// Verificar que haya al menos un resultado
		assertFalse(resultados.isEmpty(), "No se encontraron tareas en la base de datos.");
	}
}
