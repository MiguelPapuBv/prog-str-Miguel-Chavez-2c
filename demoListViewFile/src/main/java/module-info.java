module org.example.demolistviewfile {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demolistviewfile to javafx.fxml;
    exports org.example.demolistviewfile;
    opens org.example.demolistviewfile.controllers to javafx.fxml;
    opens org.example.demolistviewfile.services to javafx.fxml;
    opens org.example.demolistviewfile.repositories to javafx.fxml;

}