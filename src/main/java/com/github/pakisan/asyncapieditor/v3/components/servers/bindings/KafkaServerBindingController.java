package com.github.pakisan.asyncapieditor.v3.components.servers.bindings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KafkaServerBindingController {

    @FXML
    private TextField schemaRegistryUrl;

    @FXML
    private Label schemaRegistryUrlDescription;

    @FXML
    private TextField schemaRegistryVendor;

    @FXML
    private Label schemaRegistryVendorDescription;

    @FXML
    public void initialize() {
        schemaRegistryUrlDescription.setText(
                """
                API URL for the Schema Registry used when producing Kafka messages (if a Schema Registry was used)
                """
        );
        schemaRegistryVendorDescription.setText(
                """
                The vendor of Schema Registry and Kafka serdes library that should be used (e.g. apicurio, confluent, ibm, or karapace)
                """
        );
    }

}
