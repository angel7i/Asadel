package com.asadel.ventas.services;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Angel
 */
@Getter
@Setter
public class Factura {

    private BigDecimal anticipo;
    private String telefono;
    private String nombreCliente;
    private String observaciones;

    public Factura() {
        anticipo = BigDecimal.ZERO;
        telefono = "";
        nombreCliente = "";
        observaciones = "";
    }
}
