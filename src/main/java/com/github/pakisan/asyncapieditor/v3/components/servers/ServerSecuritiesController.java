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

public class ServerSecuritiesController {

    @FXML
    private VBox serverSecuritiesEditor;

    @FXML
    private ComboBox<String> securityScheme;

    @FXML
    public void initialize() {
        var securitySchemeVariants = new LinkedList<>(List.of(
                "apiKey",
                "asymmetricEncryption",
                "gssapi",
                "http",
                "httpApiKey",
                "oauth2",
                "openIdConnect",
                "plain",
                "scramSha256",
                "scramSha512",
                "symmetricEncryption",
                "userPassword",
                "X509"
        ));
        securityScheme.setItems(FXCollections.observableList(securitySchemeVariants));
        securityScheme.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> renderView(newValue)
        );
    }

    private void renderView(@NotNull String protocol) {
        try {
            if (serverSecuritiesEditor.getChildren().size() == 2) {
                serverSecuritiesEditor.getChildren().set(1, loadView(protocol));
            } else {
                serverSecuritiesEditor.getChildren().add(loadView(protocol));
            }
        } catch (Exception e) {
            System.err.printf(
                    "Can't load security view - %s: %s%n",
                    protocol, e.getMessage()
            );
        }
    }

    private Parent loadView(@NotNull String protocolName) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource(
                String.format("/ui/v3/components/security/%s.fxml", protocolName)
        ));

        return fxmlLoader.load();
    }

}
