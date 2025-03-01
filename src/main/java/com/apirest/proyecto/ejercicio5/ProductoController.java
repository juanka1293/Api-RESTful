package com.apirest.proyecto.ejercicio5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping
    public Flux<Producto> listarProductos() {
        return Flux.just(
                new Producto("Laptop"),
                new Producto("Mouse"),
                new Producto("Teclado")
        );
    }
}
