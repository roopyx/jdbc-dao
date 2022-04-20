package entities;

import java.util.Objects;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private Empleado idJefe;

    public Empleado () {}

    public Empleado (int idEmpleado, String nombre, Empleado idJefe) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.idJefe = idJefe;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(Empleado idJefe) {
        this.idJefe = idJefe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return idEmpleado == empleado.idEmpleado &&
                Objects.equals(nombre, empleado.nombre) &&
                Objects.equals(idJefe, empleado.idJefe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, nombre, idJefe);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id_empleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", id_jefe=" + idJefe +
                '}';
    }
}
