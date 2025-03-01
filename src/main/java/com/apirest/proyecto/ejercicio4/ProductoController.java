package com.apirest.proyecto.ejercicio4;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/productos") // Define la ruta base para los endpoints de productos
public class ProductoController {

    /**
     * Endpoint para listar los productos en formato reactivo.
     *
     * - Usamos Flux<Producto> porque es una secuencia reactiva que envía los productos uno por uno.
     * - Se usa "MediaType.TEXT_EVENT_STREAM_VALUE" para que la respuesta sea un flujo de datos (streaming),
     *   en lugar de un JSON estático.
     * - Esto permite que los clientes reciban los datos de manera asíncrona y en tiempo real.
     */
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Producto> listarProductos() {
        return Flux.just( // Crea un flujo reactivo con varios productos
                new Producto("1", "Laptop", 1200.0),
                new Producto("2", "Mouse", 25.0),
                new Producto("3", "Teclado", 45.0)
        );
    }
}
