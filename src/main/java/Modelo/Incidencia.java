package Modelo;

public class Incidencia {

    private int idIncidencia;
    private int idRecibo;
    private String tipoIncidencia;
    private double montoAdicional;
    private double montoDescuento;
    private String fechaIncidencia;

    public Incidencia(int idIncidencia, int idRecibo, String tipoIncidencia, double montoAdicional, double montoDescuento, String fechaIncidencia) {
        this.idIncidencia = idIncidencia;
        this.idRecibo = idRecibo;
        this.tipoIncidencia = tipoIncidencia;
        this.montoAdicional = montoAdicional;
        this.montoDescuento = montoDescuento;
        this.fechaIncidencia = fechaIncidencia;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public double getMontoAdicional() {
        return montoAdicional;
    }

    public void setMontoAdicional(double montoAdicional) {
        this.montoAdicional = montoAdicional;
    }

    public double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(String fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

}
