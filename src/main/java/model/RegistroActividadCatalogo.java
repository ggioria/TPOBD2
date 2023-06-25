package model;

import java.time.LocalDateTime;

public class RegistroActividadCatalogo {
    private String idProducto;
    private LocalDateTime fechaHoraCambio;
    private String detalleCambio;
    private String valorAnterior;
    private String nuevoValor;
    private String idOperador;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDateTime getFechaHoraCambio() {
        return fechaHoraCambio;
    }

    public void setFechaHoraCambio(LocalDateTime fechaHoraCambio) {
        this.fechaHoraCambio = fechaHoraCambio;
    }

    public String getDetalleCambio() {
        return detalleCambio;
    }

    public void setDetalleCambio(String detalleCambio) {
        this.detalleCambio = detalleCambio;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getNuevoValor() {
        return nuevoValor;
    }

    public void setNuevoValor(String nuevoValor) {
        this.nuevoValor = nuevoValor;
    }

    public String getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(String idOperador) {
        this.idOperador = idOperador;
    }
}
