module com.example.swe206project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.swe206project to javafx.fxml;
    exports com.example.swe206project;
}