package com.apirest.proyecto.ejercicio5;

import lombok.Getter;

@Getter
public class Producto {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

}
