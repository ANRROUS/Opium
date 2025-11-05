package Modelo;

public class Empleado {

    public int idEmpleado;
    public String nombreEmpleado;
    public int telefonoEmpleado;
    public int añosExperiencia;
    public double porcentajeComision;
    public String fechaRegistro;
    public String rolEmpleado;

    public Empleado(int idEmpleado, String nombreEmpleado, int telefonoEmpleado, int añosExperiencia, double porcentajeComision, String fechaRegistro, String rolEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.añosExperiencia = añosExperiencia;
        this.porcentajeComision = porcentajeComision;
        this.fechaRegistro = fechaRegistro;
        this.rolEmpleado = rolEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(int telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

}
