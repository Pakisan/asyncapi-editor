module com.github.pakisan.asyncapieditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.pakisan.asyncapieditor to javafx.fxml;
    exports com.github.pakisan.asyncapieditor;
}