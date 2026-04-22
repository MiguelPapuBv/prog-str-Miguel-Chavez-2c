package com.example.turnoslectura.model;

public class TurnoLectura {
    private String nombreAlumno;
    private String libro;
    private String turno;

    // Constructor vacío
    public TurnoLectura() {
    }

    // Constructor con parámetros
    public TurnoLectura(String nombreAlumno, String libro, String turno) {
        this.nombreAlumno = nombreAlumno;
        this.libro = libro;
        this.turno = turno;
    }

    // Getters y Setters
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Método toString para visualizar en el ListView
    @Override
    public String toString() {
        return nombreAlumno + " | " + libro + " | " + turno;
    }
}