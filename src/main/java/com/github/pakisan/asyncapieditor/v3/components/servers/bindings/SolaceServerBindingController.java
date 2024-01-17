package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SolaceServerBindingController {

    @FXML
    private TextField msgVpn;

    @FXML
    private Label msgVpnDescription;

    @FXML
    public void initialize() {
        msgVpnDescription.setText(
                """
                Message VPN of the Solace Broker
                """
        );
    }

}
