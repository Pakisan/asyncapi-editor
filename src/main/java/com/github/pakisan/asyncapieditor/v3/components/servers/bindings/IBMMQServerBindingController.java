package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import atlantafx.base.util.IntegerStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class IBMMQServerBindingController {

    @FXML
    private TextField groupId;

    @FXML
    private Label groupIdDescription;

    @FXML
    private TextField ccdtQueueManagerName;

    @FXML
    private Label ccdtQueueManagerNameDescription;

    @FXML
    private TextField cipherSpec;

    @FXML
    private Label cipherSpecDescription;

    @FXML
    private CheckBox multiEndpointServer;

    @FXML
    private Label multiEndpointServerDescription;

    @FXML
    private Spinner<Integer> heartBeatInterval;

    @FXML
    private Label heartBeatIntervalDescription;

    @FXML
    public void initialize() {
        groupIdDescription.setText(
                """
                Defines a logical group of IBM MQ server objects. This is necessary to specify multi-endpoint configurations used in high availability deployments.
                   
                If omitted, the server object is not part of a group.
                """
        );
        ccdtQueueManagerNameDescription.setText(
                """
                The name of the IBM MQ queue manager to bind to in the CCDT file.
                """
        );
        cipherSpecDescription.setText(
                """
                The recommended cipher specification used to establish a TLS connection between the client and the IBM MQ queue manager.
                """
        );
        multiEndpointServerDescription.setText(
                """
                If multiEndpointServer is true then multiple connections can be workload balanced and applications should not make
                assumptions as to where messages are processed. Where message ordering, or affinity to specific message resources
                is necessary, a single endpoint (multiEndpointServer = false) may be required.
                """
        );

        heartBeatInterval.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 999999, 300)
        );
        IntegerStringConverter.createFor(heartBeatInterval);
        heartBeatIntervalDescription.setText(
                """
                The recommended value (in seconds) for the heartbeat sent to the queue manager during periods of inactivity.
                A value of zero means that no heart beats are sent. A value of 1 means that the client will use the value defined by the queue manager.
                """
        );
    }

}
