package com.asadel.ventas.services;

import java.math.BigDecimal;

public class Articulo {

    private String id;
    private String nombre;
    private BigDecimal precio;
    private String info;
    private String tipo;
    private int cantidad;
    private BigDecimal subtotal;
    private BigDecimal descuento;

    public Articulo() {
        this("", "", BigDecimal.ZERO.setScale(2), "", "");
    }

    public Articulo(String ida, String nom, BigDecimal pre, String inf, String tip) {
        this.id = ida;
        this.nombre = nom;

        if (pre.signum() >= 0) {
            this.precio = pre;
        } else {
            this.precio = BigDecimal.ZERO.setScale(2);
        }

        this.info = inf;
        this.tipo = tip;
        this.cantidad = 0;
        this.subtotal = null;
    }

    public Articulo(String ida, String nom, BigDecimal pre, String inf, String tip, int cant, BigDecimal sub) {
        this.id = ida;
        this.nombre = nom;

        if (pre.signum() >= 0) {
            this.precio = pre;
        } else {
            this.precio = BigDecimal.ZERO.setScale(2);
        }

        this.info = inf;
        this.tipo = tip;
        this.cantidad = cant;
        this.subtotal = sub;
    }

    public Articulo(String ida, String nom, String inf, String tip, BigDecimal pre, BigDecimal desc) {
        this.id = ida;
        this.nombre = nom;
        this.info = inf;
        this.tipo = tip;
        this.precio = pre;
        descuento = desc;
    }

    public void setId(String ida) {
        this.id = ida;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(BigDecimal pre) {
        if (pre.signum() >= 0) {
            this.precio = pre;
        } else {
            this.precio = BigDecimal.ZERO.setScale(2);
        }
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setInfo(String inf) {
        this.info = inf;
    }

    public String getInfo() {
        return info;
    }

    public void setTipo(String tip) {
        this.tipo = tip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCantidad(int cant) {
        this.cantidad = cant;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setSubtotal(int cantidad) {
        this.subtotal = this.precio.multiply(new BigDecimal(String.valueOf(cantidad)));
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "\nNombre: " + nombre
                + "\nInfo: " + info
                + "\nTipo: " + tipo
                + "\nPrecio: " + precio
                + "\nDescuento: " + descuento;
    }
}
