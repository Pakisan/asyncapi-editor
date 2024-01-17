package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MQTT5ServerBindingController {

    @FXML
    private TextField sessionExpiryInterval;

    @FXML
    private Label sessionExpiryIntervalDescription;

    @FXML
    public void initialize() {
        sessionExpiryInterval.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    sessionExpiryInterval.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });

        sessionExpiryIntervalDescription.setText(
                """
                Session Expiry Interval in seconds
                """
        );
    }

}
