package com.apirest.proyecto.ejercicio2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST que maneja el CRUD de productos.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Lista en memoria para almacenar los productos temporalmente
    private final List<Producto> listaProductos = new ArrayList<>();

    /**
     * Agrega un nuevo producto a la lista.
     * @param producto Objeto Producto enviado en el cuerpo de la solicitud.
     * @return El producto agregado.
     */
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        listaProductos.add(producto);
        return producto;
    }

    /**
     * Obtiene la lista de todos los productos.
     * @return Lista de productos.
     */
    @GetMapping
    public List<Producto> listarProductos() {
        return listaProductos;
    }

    /**
     * Obtiene un producto por su ID.
     * @param id Identificador del producto.
     * @return Producto encontrado o null si no existe.
     */
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable String id) {
        return listaProductos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Actualiza los datos de un producto existente.
     * @param id Identificador del producto.
     * @param producto Datos actualizados del producto.
     * @return Producto actualizado o null si no se encuentra.
     */
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable String id, @RequestBody Producto producto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId().equals(id)) {
                listaProductos.set(i, producto);
                return producto;
            }
        }
        return null;
    }

    /**
     * Elimina un producto de la lista.
     * @param id Identificador del producto a eliminar.
     * @return Mensaje de confirmación.
     */
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable String id) {
        boolean eliminado = listaProductos.removeIf(producto -> producto.getId().equals(id));
        return eliminado ? "Producto eliminado correctamente." : "Producto no encontrado.";
    }
}
