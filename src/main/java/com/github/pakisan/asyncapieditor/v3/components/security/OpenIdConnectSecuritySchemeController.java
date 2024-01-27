package com.github.pakisan.asyncapieditor.v3.components.security;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

import java.util.LinkedList;

public class OpenIdConnectSecuritySchemeController {

    @FXML
    private TextField description;

    @FXML
    private Label descriptionDescription;

    @FXML
    private TextField openIdConnectUrl; // TODO: Required

    @FXML
    private Label openIdConnectUrlDescription;

    @FXML
    private TextField scope;

    @FXML
    private Button addScopeButton;

    @FXML
    private ListView<String> scopes;

    @FXML
    private Label scopesDescription;

    @FXML
    public void initialize() {
        descriptionDescription.setText(
                """
                A short description for security scheme.
                """
        );
        openIdConnectUrlDescription.setText(
                """
                OpenId Connect URL to discover OAuth2 configuration values.
                """
        );

        var givenScopes = FXCollections.observableList(new LinkedList<String>());
        givenScopes.add("read");
        givenScopes.add("write");
        scopes.setItems(givenScopes);
        scopes.setEditable(true);
        scopes.setCellFactory(TextFieldListCell.forListView());
        scopesDescription.setText(
                """
                List of the needed scope names.
                """
        );
    }

    @FXML
    protected void onAddScopeButtonClick() {
        scopes.getItems().add(scope.getText());
        scope.setText("");
    }

}
