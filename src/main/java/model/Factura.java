package model;

import java.util.Map;

public class Factura {
    private String id;
    private String idUsuario;
    private Map<String, Integer> detalle; // Diccionario de ID de producto a cantidad
    private double total;
    private String metodoPago;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Map<String, Integer> getDetalle() {
        return detalle;
    }

    public void setDetalle(Map<String, Integer> detalle) {
        this.detalle = detalle;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
