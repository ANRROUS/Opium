package Modelo;

public class Pago {

    private int idPago;
    private int idEmpleado;
    private String fechaPago;
    private double montoPago;

    public Pago(int idPago, int idEmpleado, String fechaPago, double montoPago) {
        this.idPago = idPago;
        this.idEmpleado = idEmpleado;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

}
