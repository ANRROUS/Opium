package Modelo;

public class Administrador extends Empleado{

    private int idAdministrador;
    private double bonoSemanal;
    private String usuarioAdministrador;
    private String passwordAdministrador;

    public Administrador(int idEmpleado, String nombreEmpleado, int telefonoEmpleado, int añosExperiencia, double porcentajeComision, String fechaRegistro, String rolEmpleado, int idAdministrador, double bonoSemanal, String usuarioAdministrador, String passwordAdministrador) {

        super(idEmpleado, nombreEmpleado, telefonoEmpleado, añosExperiencia, porcentajeComision, fechaRegistro, rolEmpleado);
        this.idAdministrador = idAdministrador;
        this.bonoSemanal = bonoSemanal;
        this.usuarioAdministrador = usuarioAdministrador;
        this.passwordAdministrador = passwordAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public double getBonoSemanal() {
        return bonoSemanal;
    }

    public void setBonoSemanal(double bonoSemanal) {
        this.bonoSemanal = bonoSemanal;
    }

    public String getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(String usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }

    public String getPasswordAdministrador() {
        return passwordAdministrador;
    }

    public void setPasswordAdministrador(String passwordAdministrador) {
        this.passwordAdministrador = passwordAdministrador;
    }

}
