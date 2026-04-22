package com.example.turnoslectura;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Cargar el FXML desde resources.
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/example/turnoslectura/main-view.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Turnos de lectura");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
