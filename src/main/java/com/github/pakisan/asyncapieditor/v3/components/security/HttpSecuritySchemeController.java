package com.github.pakisan.asyncapieditor.v3.components.security;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HttpSecuritySchemeController {

    @FXML
    private TextField description;

    @FXML
    private Label descriptionDescription;

    @FXML
    private TextField scheme;

    @FXML
    private Label schemeDescription;

    @FXML
    private TextField bearerFormat;

    @FXML
    private Label bearerFormatDescription;

    @FXML
    public void initialize() {
        descriptionDescription.setText(
                """
                A short description for security scheme.
                """
        );
        schemeDescription.setText(
                """
                The name of the HTTP Authorization scheme to be used in the Authorization header as defined in RFC7235
                
                https://tools.ietf.org/html/rfc7235#section-5.1
                """
        );
        bearerFormatDescription.setText(
                """
                A hint to the client to identify how the bearer token is formatted. Bearer tokens are usually generated
                by an authorization server, so this information is primarily for documentation purposes.
                """
        );
    }

}
