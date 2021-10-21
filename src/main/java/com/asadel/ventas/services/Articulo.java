package com.asadel.ventas.services;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

@Data
public class Articulo {
    private String id;
    private String nombre;
    private BigDecimal precioVenta;
    private BigDecimal precioCompra;
    private String tiendaCompra;
    private Date fechaCompra;
    private int inventarioCompra;
    private int inventarioVenta;
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
            this.precioVenta = pre;
        } else {
            this.precioVenta = BigDecimal.ZERO.setScale(2);
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
            this.precioVenta = pre;
        } else {
            this.precioVenta = BigDecimal.ZERO.setScale(2);
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
        this.precioVenta = pre;
        descuento = desc;
    }

    public void setSubtotal(int cantidad) {
        this.subtotal = this.precioVenta.multiply(new BigDecimal(String.valueOf(cantidad)));
    }
}
