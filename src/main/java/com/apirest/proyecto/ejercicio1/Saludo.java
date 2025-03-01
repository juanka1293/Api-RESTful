package com.apirest.proyecto.ejercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que maneja las solicitudes relacionadas con saludos.
 */
@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/api") // Define la ruta base para los endpoints de este controlador.
public class Saludo {

    /**
     * Endpoint que devuelve un mensaje de saludo.
     *
     * @return Un mensaje de saludo en formato String.
     */
    @GetMapping("/saludo") // Define la ruta específica para acceder a este método.
    public String obtenerSaludo() {
        return "¡Hola, API RESTful!"; // Respuesta que se enviará al cliente.
    }
}
