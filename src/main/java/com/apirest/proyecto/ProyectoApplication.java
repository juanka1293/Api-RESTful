package com.apirest.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // Indica que esta es la clase principal de la aplicación Spring Boot
@ComponentScan(basePackages = "com.apirest.proyecto.ejercicio4")
// 🔹 Se especifica explícitamente que solo se deben escanear los componentes dentro de "ejercicio4"
// Esto evita conflictos con la clase ProductoController de "ejercicio2", que aún debe permanecer en el proyecto
// pero no se está usando activamente en esta ejecución.
public class ProyectoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		// 🔹 Inicia la aplicación Spring Boot
	}
}
