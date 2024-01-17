package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PulsarServerBindingController {

    @FXML
    private TextField tenant;

    @FXML
    private Label tenantDescription;

    @FXML
    public void initialize() {
        tenant.setText("public");
        tenant.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isBlank()) {
                tenant.setText("public");
            }
        });

        tenantDescription.setText(
                """
                The pulsar tenant
                """
        );
    }

}
