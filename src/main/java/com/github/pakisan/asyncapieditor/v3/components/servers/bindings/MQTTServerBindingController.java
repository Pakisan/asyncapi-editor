package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MQTTServerBindingController {

    @FXML
    private TextField clientId;

    @FXML
    private Label clientIdDescription;

    @FXML
    private CheckBox cleanSession;

    @FXML
    private Label cleanSessionDescription;

    @FXML
    private TextField keepAlive;

    @FXML
    private Label keepAliveDescription;

    @FXML
    private TextField lastWillTopic;

    @FXML
    private Label lastWillTopicDescription;

    @FXML
    private Spinner<Integer> lastWillQos;

    @FXML
    private Label lastWillQosDescription;

    @FXML
    private TextField lastWillMessage;

    @FXML
    private Label lastWillMessageDescription;

    @FXML
    private CheckBox lastWillRetain;

    @FXML
    private Label lastWillRetainDescription;

    @FXML
    public void initialize() {
        clientIdDescription.setText(
                """
                The client identifier
                """
        );
        cleanSessionDescription.setText(
                """
                Whether to create a persisten connection or not. When false, the connection will be persistent.
                """
        );

        keepAlive.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                keepAlive.setText(newValue.replaceAll("\\D", ""));
            }
        });
        keepAliveDescription.setText(
                """
                Interval in seconds of the longest period of time the broker and the client can endure without sending a message.
                """
        );

        lastWillTopicDescription.setText(
                """
                The topic where the Last Will and Testament message will be sent.
                """
        );
        lastWillQos.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2, 0)
        );
        lastWillQosDescription.setText(
                """
                Defines how hard the broker/client will try to ensure that the Last Will and Testament message is received.
                """
        );
        lastWillMessageDescription.setText(
                """
                Last Will message.
                """
        );
        lastWillRetainDescription.setText(
                """
                Whether the broker should retain the Last Will and Testament message or not.
                """
        );
    }

}
