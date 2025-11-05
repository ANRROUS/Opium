package Modelo;

public class Cliente {

    private int idCliente;
    private String nombreCliente;
    private int numeroCliente;
    private String fechaRegistro;

    public Cliente(int idCliente, String nombreCliente, int numeroCliente, String fechaRegistro) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.numeroCliente = numeroCliente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
