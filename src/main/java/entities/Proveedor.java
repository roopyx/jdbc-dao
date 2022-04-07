package entities;

import java.util.Objects;

public class Proveedor
{
    private int idProveedor;
    private String empresa;
    private String contacto;
    private String direccion;

    public Proveedor () {}

    public Proveedor (int idProveedor)
    {
        this.idProveedor = idProveedor;
    }

    public Proveedor (int idProveedor, String empresa, String contacto, String direccion)
    {
        this.idProveedor = idProveedor;
        this.empresa = empresa;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public int getIdProveedor()
    {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor)
    {
        this.idProveedor = idProveedor;
    }

    public String getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(String empresa)
    {
        this.empresa = empresa;
    }

    public String getContacto()
    {
        return contacto;
    }

    public void setContacto(String contacto)
    {
        this.contacto = contacto;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return idProveedor == proveedor.idProveedor &&
                Objects.equals(empresa, proveedor.empresa) &&
                Objects.equals(contacto, proveedor.contacto) &&
                Objects.equals(direccion, proveedor.direccion);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idProveedor, empresa, contacto, direccion);
    }

    @Override
    public String toString()
    {
        return "Proveedor{" +
                "idProveedor=" + idProveedor +
                ", empresa='" + empresa + '\'' +
                ", contacto='" + contacto + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
