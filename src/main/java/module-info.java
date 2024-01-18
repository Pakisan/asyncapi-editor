module com.github.pakisan.asyncapieditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.asyncapi;
    requires org.jetbrains.annotations;
    requires atlantafx.base;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.antdesignicons;

    opens com.github.pakisan.asyncapieditor to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.views.modals.createnewspecification to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.views.welcome to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.v3.views.editor to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.v3.components to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.v3.components.servers to javafx.fxml;
    opens com.github.pakisan.asyncapieditor.v3.components.servers.bindings to javafx.fxml;

    exports com.github.pakisan.asyncapieditor;
    exports com.github.pakisan.asyncapieditor.v3.views.editor;
    exports com.github.pakisan.asyncapieditor.views.welcome;
    exports com.github.pakisan.asyncapieditor.views.modals.createnewspecification;
    exports com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto;
}