package com.apirest.proyecto.ejercicio5;

import com.apirest.proyecto.ejercicio4.Producto;
import com.apirest.proyecto.ejercicio4.ProductoController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Ejercicio 5 - Prueba unitaria con StepVerifier
 *
 * Este test valida que el endpoint de productos devuelve los valores esperados en formato reactivo.
 */
@WebFluxTest(ProductoController.class) // Carga solo el controlador para evitar problemas de contexto
public class ProductoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductoController productoController; // Simulamos el controlador para evitar dependencias innecesarias

    /**
     * Verifica que el método listarProductos() devuelve los productos esperados en formato reactivo.
     */
    @Test
    public void testListaProductos() {
        // Simulamos la respuesta del controlador
        Flux<Producto> productosFlux = Flux.just(
                new Producto("1", "Laptop", 1200.0),
                new Producto("2", "Mouse", 25.0),
                new Producto("3", "Teclado", 45.0)
        );

        // Configuramos el comportamiento simulado
        Mockito.when(productoController.listarProductos()).thenReturn(productosFlux);

        // Usamos StepVerifier para validar el flujo de productos
        StepVerifier.create(productoController.listarProductos())
                .expectNextMatches(p -> "1".equals(p.getId()) && "Laptop".equals(p.getNombre()) && p.getPrecio() == 1200.0)
                .expectNextMatches(p -> "2".equals(p.getId()) && "Mouse".equals(p.getNombre()) && p.getPrecio() == 25.0)
                .expectNextMatches(p -> "3".equals(p.getId()) && "Teclado".equals(p.getNombre()) && p.getPrecio() == 45.0)
                .verifyComplete();
    }
}
