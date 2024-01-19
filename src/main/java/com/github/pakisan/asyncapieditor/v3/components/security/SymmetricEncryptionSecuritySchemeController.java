package com.github.pakisan.asyncapieditor.v3.components.security;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SymmetricEncryptionSecuritySchemeController {

    @FXML
    private TextField description;

    @FXML
    private Label descriptionDescription;

    @FXML
    public void initialize() {
        descriptionDescription.setText(
                """
                A short description for security scheme.
                """
        );
    }

}
