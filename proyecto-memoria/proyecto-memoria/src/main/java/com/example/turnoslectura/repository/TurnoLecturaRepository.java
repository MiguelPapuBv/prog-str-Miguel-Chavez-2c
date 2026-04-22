package com.example.turnoslectura.repository;

import com.example.turnoslectura.model.TurnoLectura;
import java.util.ArrayList;
import java.util.List;

public class TurnoLecturaRepository {

    // Lista principal en memoria (Simula una base de datos)
    private final List<TurnoLectura> registros = new ArrayList<>();

    // Guarda un nuevo objeto en la lista
    public void guardar(TurnoLectura registro) {
        registros.add(registro);
    }

    // Retorna todos los registros actuales
    public List<TurnoLectura> obtenerTodos() {
        return registros;
    }

    // Busca un alumno por nombre (ignora mayúsculas y espacios extra)
    public TurnoLectura buscarPorNombreAlumno(String nombreAlumno) {
        if (nombreAlumno == null) return null;

        for (TurnoLectura actual : registros) {
            if (actual.getNombreAlumno().trim().equalsIgnoreCase(nombreAlumno.trim())) {
                return actual;
            }
        }
        return null;
    }

    // Elimina un registro si coincide el nombre del alumno
    public boolean eliminarPorNombreAlumno(String nombreAlumno) {
        if (nombreAlumno == null) return false;

        for (int i = 0; i < registros.size(); i++) {
            TurnoLectura actual = registros.get(i);
            if (actual.getNombreAlumno().trim().equalsIgnoreCase(nombreAlumno.trim())) {
                registros.remove(i);
                return true; // Éxito al eliminar
            }
        }
        return false; // No se encontró
    }
}