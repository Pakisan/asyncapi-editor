package com.github.pakisan.asyncapieditor.v3.components;

import atlantafx.base.theme.Styles;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.List;

public class ServersComponentController {

    @FXML
    private TextField title;

    @FXML
    private ComboBox<String> protocol;

    @FXML
    private TextField host;

    @FXML
    private TextField pathname;

    @FXML
    private TextField summary;

    @FXML
    private TextArea description;

    @FXML
    private Button addServerButton;

    @FXML
    public void initialize() {
        host.textProperty().addListener((observable, oldValue, newValue) -> {
            host.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());

            addServerButton.setDisable(newValue.isBlank());
        });

        protocol.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            protocol.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());

            addServerButton.setDisable(newValue.isBlank());
        });
        protocol.getSelectionModel().select(3);
        var protocolVariants = new LinkedList<>(List.of(
                "amqp",
                "amqps",
                "amqp1",
                "amqps1",
                "anypointmq",
                "googlepubsub",
                "http",
                "ibmmq",
                "jms",
                "kafka",
                "mercure",
                "mqtt",
                "mqtt5",
                "nats",
                "pulsar",
                "redis",
                "sns",
                "solace",
                "sqs",
                "stomp",
                "ws"
        ));
        protocol.setItems(FXCollections.observableList(protocolVariants));

        addServerButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.SUCCESS);
    }

}
