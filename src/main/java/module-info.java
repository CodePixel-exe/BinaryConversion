module nclan.ac.spa {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires com.google.genai;


    opens nclan.ac.spa to javafx.fxml;
    exports nclan.ac.spa;
    exports nclan.ac.spa.controllers;
    opens nclan.ac.spa.controllers to javafx.fxml;
}