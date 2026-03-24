package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import org.example.Contactos.contacto;
import org.example.Value.value;

public class controller {

    private value validar = new value();
    public int id = 0;

    @FXML private ComboBox<String> parentestos;
    @FXML private TextField nombre;
    @FXML private TextField telefono;
    @FXML private Label Mensaje;
    @FXML private TextField buscarCon;

    @FXML private ListView<contacto> listaContactos;
    private ObservableList<contacto> contactos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        String[] parentescos = {
                "Padre", "Madre", "Hermano", "Hermana",
                "Abuelo", "Abuela", "Tío", "Tía"
        };
        parentestos.getItems().addAll(parentescos);
        listaContactos.setItems(contactos);
    }

    @FXML
    public void agregar() {
        String txtNombre = nombre.getText();
        String txtTelefono = telefono.getText();
        String txtParentesco = parentestos.getValue();

        for (contacto c : contactos) {
            if (txtNombre.equals(c.getNombre())) {
                Mensaje.setText("Error: El nombre ingresado ya existe.");
                Mensaje.setStyle("-fx-text-fill: red");
                return;
            }
        }

        if (validar.Validar(txtNombre, txtTelefono, txtParentesco)) {
            contacto nuevoContacto = new contacto(txtNombre, txtTelefono, txtParentesco, id);
            contactos.add(nuevoContacto);
            nombre.clear();
            telefono.clear();
            parentestos.setValue(null);
            Mensaje.setText("Contacto registrado exitosamente.");
            Mensaje.setStyle("-fx-text-fill: green");
            id++;
        } else {
            Mensaje.setText("Error: Verifique los datos ingresados.");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void actualizar() {
        String buscarC = buscarCon.getText();
        String txtNombre = nombre.getText();
        String txtTelefono = telefono.getText();
        String txtParentesco = parentestos.getValue();

        if (validar.Validar(txtNombre, txtTelefono, txtParentesco)) {
            for (int i = 0; i < contactos.size(); i++) {
                contacto c = contactos.get(i);
                if (buscarC.equals(c.getNombre())) {
                    contacto contactoActualizado = new contacto(txtNombre, txtTelefono, txtParentesco, c.getId());
                    contactos.set(i, contactoActualizado);
                    buscarCon.clear();
                    nombre.clear();
                    telefono.clear();
                    parentestos.setValue(null);
                    Mensaje.setText("Contacto actualizado exitosamente.");
                    Mensaje.setStyle("-fx-text-fill: green");
                    return;
                }
            }
            Mensaje.setText("Error: No se encontró el contacto para actualizar.");
            Mensaje.setStyle("-fx-text-fill: red");
        } else {
            Mensaje.setText("Error: Verifique los datos ingresados.");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void eliminar() {
        String txtNombre = nombre.getText();
        contacto contactoAEliminar = null;

        for (contacto c : contactos) {
            if (txtNombre.equals(c.getNombre())) {
                contactoAEliminar = c;
                break;
            }
        }

        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            nombre.clear();
            telefono.clear();
            parentestos.setValue(null);
            buscarCon.clear();
            Mensaje.setText("Contacto eliminado exitosamente.");
            Mensaje.setStyle("-fx-text-fill: green");
        } else {
            Mensaje.setText("Error: El contacto ingresado no existe.");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void buscar() {
        boolean encontrado = false;
        String txtNombre = buscarCon.getText();

        for (contacto c : contactos) {
            if (txtNombre.equals(c.getNombre())) {
                buscarCon.setText(c.getNombre());
                nombre.setText(c.getNombre());
                telefono.setText(c.getTelefono());
                parentestos.setValue(c.getParentesco());
                Mensaje.setText("Contacto encontrado.");
                Mensaje.setStyle("-fx-text-fill: green");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Mensaje.setText("Error: Contacto no encontrado.");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void limpiar() {
        buscarCon.clear();
        nombre.clear();
        telefono.clear();
        parentestos.setValue(null);
        Mensaje.setText("");
    }
}