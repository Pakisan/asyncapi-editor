package com.github.pakisan.asyncapieditor.v3.components.security;

import com.asyncapi.v3.security_scheme.http.HttpApiKeySecurityScheme;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HttpApiKeySecuritySchemeController {

    @FXML
    private TextField description;

    @FXML
    private Label descriptionDescription;

    @FXML
    private TextField name; // TODO: Required

    @FXML
    private Label nameDescription;

    @FXML
    private ComboBox<HttpApiKeySecurityScheme.ApiKeyLocation> in;

    @FXML
    private Label inDescription;

    @FXML
    public void initialize() {
        descriptionDescription.setText(
                """
                A short description for security scheme.
                """
        );
        nameDescription.setText(
                """
                The name of the header, query or cookie parameter to be used.
                """
        );

        var inVariants = new ArrayList<>(
                List.of(HttpApiKeySecurityScheme.ApiKeyLocation.values())
        );
        in.setItems(FXCollections.observableList(inVariants));
        inDescription.setText(
                """
                The location of the API key.
                """
        );
    }

}
