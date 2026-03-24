package org.example.Contactos;

public class contacto {
    private int id;
    private String nombre;
    private String telefono;
    private String parentesco;


    public contacto(String nombre, String telefono, String parentesco, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getParentesco() { return parentesco; }
    public void setParentesco(String parentesco) { this.parentesco = parentesco; }

    @Override
    public String toString() {
        return nombre + " - " + telefono + " - " + parentesco;
    }
}