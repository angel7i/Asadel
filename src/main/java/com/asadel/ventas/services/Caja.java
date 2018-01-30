package com.asadel.ventas.services;

import java.math.BigDecimal;

public class Caja
{

    private int idCajaDia;
    private boolean estado;
    private String abierta;
    private String cierre;
    private BigDecimal inicio;
    private BigDecimal recaudado;

    public Caja()
    {
        this(false, null, null, null, null);
    }

    public Caja(boolean estado, String abierta, String cierre, BigDecimal inicio, BigDecimal recaudado)
    {
        this.estado = estado;
        this.abierta = abierta;
        this.cierre = cierre;
        this.inicio = inicio;
        this.recaudado = recaudado;
    }

    public int getIdCajaDia()
    {
        return idCajaDia;
    }

    public void setIdCajaDia(int idCajaDia)
    {
        this.idCajaDia = idCajaDia;
    }

    public boolean getEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public String getAbierta()
    {
        return abierta;
    }

    public void setAbierta(String abierta)
    {
        this.abierta = abierta;
    }

    public String getCierre()
    {
        return cierre;
    }

    public void setCierre(String cierre)
    {
        this.cierre = cierre;
    }

    public BigDecimal getInicio()
    {
        return inicio;
    }

    public void setInicio(BigDecimal inicio)
    {
        this.inicio = inicio;
    }

    public BigDecimal getRecaudado()
    {
        return recaudado;
    }

    public void setRecaudado(BigDecimal recaudado)
    {
        this.recaudado = recaudado;
    }
}
