package com.example.turnoslectura.controller;

import com.example.turnoslectura.model.TurnoLectura;
import com.example.turnoslectura.service.TurnoLecturaService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;

public class MainController {

    @FXML private TextField txtNombreAlumno;
    @FXML private TextField txtLibro;
    @FXML private ComboBox<String> cbTurno;
    @FXML private ListView<String> lvRegistros;

    private final TurnoLecturaService service = new TurnoLecturaService();
    private String nombreOriginal;

    @FXML
    public void initialize() {
        cargarTurnos();
        actualizarLista();
        lvRegistros.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                cargarSeleccion(newValue);
            }
        });
    }

    private void cargarTurnos() {
        cbTurno.getItems().addAll(service.obtenerTurnos());
    }

    @FXML
    public void agregar() {
        // 1. Leer datos
        String nombre = txtNombreAlumno.getText();
        String libro = txtLibro.getText();
        String turno = cbTurno.getValue();

        // 2. Enviar al service
        String error = service.agregar(nombre, libro, turno);

        // 3. Validar respuesta
        if (error != null) {
            mostrarMensaje("Error", error, Alert.AlertType.ERROR);
        } else {
            // 4 y 5. Refrescar y limpiar
            actualizarLista();
            limpiar();
            mostrarMensaje("Éxito", "Registro agregado correctamente", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    public void buscar() {
        TurnoLectura registro = service.buscarPorNombreAlumno(txtNombreAlumno.getText());
        if (registro == null) {
            mostrarMensaje("Aviso", "Registro no encontrado", Alert.AlertType.WARNING);
            return;
        }
        txtNombreAlumno.setText(registro.getNombreAlumno());
        txtLibro.setText(registro.getLibro());
        cbTurno.setValue(registro.getTurno());
        nombreOriginal = registro.getNombreAlumno();
    }

    @FXML
    public void actualizar() {
        // 1-3. Se gestionan mediante la variable 'nombreOriginal'
        String nuevoNombre = txtNombreAlumno.getText();
        String nuevoLibro = txtLibro.getText();
        String nuevoTurno = cbTurno.getValue();

        // 4. Mandar al service
        String error = service.actualizar(nombreOriginal, nuevoNombre, nuevoLibro, nuevoTurno);

        if (error != null) {
            mostrarMensaje("Error de Actualización", error, Alert.AlertType.ERROR);
        } else {
            // 7. Refrescar y limpiar
            actualizarLista();
            limpiar();
            mostrarMensaje("Éxito", "Registro actualizado correctamente", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    public void eliminar() {
        // 1-2. Tomar nombre y mandar al service
        String nombre = txtNombreAlumno.getText();
        String error = service.eliminar(nombre);

        if (error != null) {
            mostrarMensaje("Error", error, Alert.AlertType.ERROR);
        } else {
            // 5-6. Refrescar y limpiar
            actualizarLista();
            limpiar();
            mostrarMensaje("Éxito", "Registro eliminado", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    public void limpiar() {
        txtNombreAlumno.clear();
        txtLibro.clear();
        cbTurno.setValue(null);
        lvRegistros.getSelectionModel().clearSelection();
        nombreOriginal = null;
    }

    private void actualizarLista() {
        lvRegistros.getItems().clear();
        List<TurnoLectura> registros = service.obtenerTodos();
        for (TurnoLectura t : registros) {
            lvRegistros.getItems().add(t.toString());
        }
    }

    private void cargarSeleccion(String textoSeleccionado) {
        List<TurnoLectura> registros = service.obtenerTodos();
        for (TurnoLectura actual : registros) {
            if (actual.toString().equals(textoSeleccionado)) {
                txtNombreAlumno.setText(actual.getNombreAlumno());
                txtLibro.setText(actual.getLibro());
                cbTurno.setValue(actual.getTurno());
                nombreOriginal = actual.getNombreAlumno();
                break;
            }
        }
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}