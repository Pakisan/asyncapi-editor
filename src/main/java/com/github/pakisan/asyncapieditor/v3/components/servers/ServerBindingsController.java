package com.github.pakisan.asyncapieditor.v3.components.servers;

import com.github.pakisan.asyncapieditor.ViewsRouter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ServerBindingsController {

    @FXML
    private VBox serverBindingsEditor;

    @FXML
    private ComboBox<String> protocol;

    @FXML
    public void initialize() {
        var protocolVariants = new LinkedList<>(List.of(
                "ibmmq",
                "kafka",
                "mqtt",
                "mqtt5",
                "pulsar",
                "solace"
        ));
        protocol.setItems(FXCollections.observableList(protocolVariants));
        protocol.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> renderView(newValue)
        );
    }

    private void renderView(@NotNull String protocol) {
        try {
            if (serverBindingsEditor.getChildren().size() == 2) {
                serverBindingsEditor.getChildren().set(1, loadView(protocol));
            } else {
                serverBindingsEditor.getChildren().add(loadView(protocol));
            }
        } catch (Exception e) {
            // do nothing.
        }
    }

    private Parent loadView(@NotNull String protocolName) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource(
                String.format("/ui/v3/components/servers/bindings/%s.fxml", protocolName)
        ));

        return fxmlLoader.load();
    }

}
