package com.apirest.proyecto.ejercicio3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Controlador REST que maneja la internacionalización del saludo.
 * Permite obtener un mensaje en diferentes idiomas según el encabezado "Accept-Language".
 */
@RestController
@RequestMapping("/api/ejercicio3")
public class SaludoController {

    // Inyección de la fuente de mensajes desde los archivos de properties
    @Autowired
    private MessageSource messageSource;

    /**
     * Endpoint para obtener un saludo en el idioma solicitado.
     *
     * @param locale Objeto que representa el idioma recibido en el encabezado "Accept-Language".
     * @return Mensaje de saludo en el idioma correspondiente.
     */
    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        // Obtiene el mensaje de saludo desde los archivos de properties según el idioma
        return messageSource.getMessage("saludo", null, locale);
    }
}
