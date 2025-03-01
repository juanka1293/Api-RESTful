package com.apirest.proyecto.ejercicio5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductoControllerTest {

    @Autowired
    private ProductoController productoController;

    @Test
    public void testListaProductos() {
        Flux<Producto> productos = productoController.listarProductos();

        StepVerifier.create(productos)
                .expectNextMatches(p -> p.getNombre().equals("Laptop"))
                .expectNextMatches(p -> p.getNombre().equals("Mouse"))
                .expectNextMatches(p -> p.getNombre().equals("Teclado"))
                .verifyComplete();
    }
}
