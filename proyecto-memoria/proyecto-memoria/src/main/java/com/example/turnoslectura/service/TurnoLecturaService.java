package com.example.turnoslectura.service;

import com.example.turnoslectura.model.TurnoLectura;
import com.example.turnoslectura.repository.TurnoLecturaRepository;
import java.util.List;

public class TurnoLecturaService {
    private final TurnoLecturaRepository repository = new TurnoLecturaRepository();
    private final String[] turnos = {"Mañana", "Tarde"};

    public String[] obtenerTurnos() {
        return turnos;
    }

    public List<TurnoLectura> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public TurnoLectura buscarPorNombreAlumno(String nombreAlumno) {
        if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) {
            return null;
        }
        return repository.buscarPorNombreAlumno(nombreAlumno.trim());
    }

    public String agregar(String nombreAlumno, String libro, String turno) {
        // 1, 2 y 3. Validaciones de campos vacíos
        if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) return "El nombre del alumno es obligatorio.";
        if (libro == null || libro.trim().isEmpty()) return "el nombre del libro es obligatorio.";
        if (turno == null) return "Debe seleccionar un turno.";

        // 4. Validar duplicados
        if (repository.buscarPorNombreAlumno(nombreAlumno.trim()) != null) {
            return "Ya existe un registro para este alumno.";
        }

        // 5 y 6. Crear y guardar
        TurnoLectura nuevo = new TurnoLectura(nombreAlumno.trim(), libro.trim(), turno);
        repository.guardar(nuevo);

        // 7. Todo bien
        return null;
    }

    public String actualizar(String nombreOriginal, String nombreNuevo, String libroNuevo, String turnoNuevo) {
        // 1. Validar nombre original
        if (nombreOriginal == null || nombreOriginal.isEmpty()) return "No hay un registro seleccionado para actualizar.";

        // 2 y 3. Buscar original
        TurnoLectura registro = repository.buscarPorNombreAlumno(nombreOriginal);
        if (registro == null) return "El registro original ya no existe.";

        // 4. Validar nuevos datos
        if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) return "El nuevo nombre no puede estar vacío.";
        if (libroNuevo == null || libroNuevo.trim().isEmpty()) return "El libro no puede estar vacío.";

        // 5. Si el nombre cambió, verificar que el nuevo no exista ya
        if (!nombreOriginal.equalsIgnoreCase(nombreNuevo.trim())) {
            if (repository.buscarPorNombreAlumno(nombreNuevo.trim()) != null) {
                return "El nuevo nombre ya pertenece a otro registro.";
            }
        }

        // 6. Modificar mediante setters
        registro.setNombreAlumno(nombreNuevo.trim());
        registro.setLibro(libroNuevo.trim());
        registro.setTurno(turnoNuevo);

        return null; // Éxito
    }

    public String eliminar(String nombreAlumno) {
        // 1. Validar vacío
        if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) return "Debe ingresar el nombre del alumno a eliminar.";

        // 2, 3 y 4. Intentar eliminar
        boolean eliminado = repository.eliminarPorNombreAlumno(nombreAlumno.trim());
        if (!eliminado) {
            return "No se encontró el alumno para eliminar.";
        }
        return null;
    }
}