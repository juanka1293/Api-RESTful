package com.apirest.proyecto.ejercicio4;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    // 📌 Constructor vacío (obligatorio para frameworks como Spring)
    public Producto() {
    }

    // 📌 Constructor con parámetros
    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // 📌 Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
