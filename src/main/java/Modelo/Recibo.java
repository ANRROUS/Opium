package Modelo;

public class Recibo {

    private int idRecibo;
    private int idServicio;
    private int numProducto;
    private double montoServicio;
    private int idEmpleado;
    private int idCliente;
    private String fechaRecibo;

    public Recibo(int idRecibo, int idServicio, int numProducto, double montoServicio, int idEmpleado, int idCliente, String fechaRecibo) {
        this.idRecibo = idRecibo;
        this.idServicio = idServicio;
        this.numProducto = numProducto;
        this.montoServicio = montoServicio;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.fechaRecibo = fechaRecibo;
    }

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public double getMontoServicio() {
        return montoServicio;
    }

    public void setMontoServicio(double montoServicio) {
        this.montoServicio = montoServicio;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaRecibo() {
        return fechaRecibo;
    }

    public void setFechaRecibo(String fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

}
