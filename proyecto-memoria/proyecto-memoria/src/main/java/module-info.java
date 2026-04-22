module turnos_lectura_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.turnoslectura to javafx.fxml;
    opens com.example.turnoslectura.controller to javafx.fxml;

    exports com.example.turnoslectura;
    exports com.example.turnoslectura.controller;
    exports com.example.turnoslectura.model;
    exports com.example.turnoslectura.service;
    exports com.example.turnoslectura.repository;
}
