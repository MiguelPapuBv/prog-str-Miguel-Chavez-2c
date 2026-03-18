package org.example.demolistviewfile.controllers;

import org.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        String[] parts = newValue.split("-");
                        txtNombre.setText(parts[0]);
                        txtEmail.setText(parts[1]);
                        txtEdad.setText(parts[2]);
                    }
                }
    )  ;
        loadFromFile();

    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){
        try{
            String name = txtNombre.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.addPerson(name,email,edad);
            lblMsg.setText("Usuario creado correctamente");
            lblMsg.setStyle("-fx-text-alignment: green");
            txtNombre.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("Es error de arhcivo"+ e.getMessage());
            lblMsg.setStyle("-fx-text-alignment: green");

        } catch (IllegalArgumentException e){
            lblMsg.setText("Es error de datos" + e.getMessage());
            lblMsg.setStyle("-fx-text-alignment: red");
        }
    }
    @FXML
    public void onUpdate(){
        try{
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtNombre.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.updatePerson(index,name,email,edad);
            loadFromFile();
            txtNombre.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("Se Actualizo correctamente");
        }catch (IOException e){
          lblMsg.setText("Hubo un error en el archivo");
        } catch (IllegalArgumentException error){
            lblMsg.setText("Hubo un error con los datos" +error.getMessage());
        }

    }
@FXML
    public void onDelete(){
    try{
        int index = listView.getSelectionModel().getSelectedIndex();
        service.onDelete(index);
        loadFromFile();
        txtNombre.clear();
        txtEmail.clear();
        txtEdad.clear();
        lblMsg.setText("Se Elimino correctamente");
    }catch (IOException e){
        lblMsg.setText("Hubo un error en el archivo");
    } catch (IllegalArgumentException error){
        lblMsg.setText("Hubo un error con los datos" +error.getMessage());
    }

    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
