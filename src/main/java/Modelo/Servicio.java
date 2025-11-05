package Modelo;

public class Servicio {

    private int idServicio;
    private String nombreServicio;
    private double precioServicio;
    private int idEmpleado;

    public Servicio(int idServicio, String nombreServicio, double precioServicio, int idEmpleado) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
        this.idEmpleado = idEmpleado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
