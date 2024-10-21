package com.hexagonal.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para el campo 'id' con autoincremento
    private Integer id; // Cambiado a Integer para coincidir con INT en la base de datos
    private String nombre; // Nombre del producto
    private String descripcion; // Descripción del producto
    private LocalDate fechaEntrada; // Fecha de entrada del producto
    private LocalDate fechaPedidos; // Fecha para hacer el pedido de nuevo
    private Integer cantidadPedidos; // Cantidad a pedir
    private Integer cantidad; // Cantidad del producto
    private String estadoProducto; // Estado del producto (por ejemplo, "disponible", "agotado")
    private LocalDate fechaVencimiento; // Fecha de vencimiento del producto

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaPedidos() {
        return fechaPedidos;
    }

    public void setFechaPedidos(LocalDate fechaPedidos) {
        this.fechaPedidos = fechaPedidos;
    }

    public Integer getCantidadPedidos() {
        return cantidadPedidos;
    }

    public void setCantidadPedidos(Integer cantidadPedidos) {
        this.cantidadPedidos = cantidadPedidos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
