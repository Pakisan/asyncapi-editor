package com.github.pakisan.asyncapieditor.v3.components.security;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

import java.util.LinkedList;

public class OAuth2SecuritySchemeController {

    @FXML
    private TextField description;

    @FXML
    private Label descriptionDescription;

    @FXML
    private TextField scope;

    @FXML
    private Button addScopeButton;

    @FXML
    private ListView<String> scopes;

    @FXML
    private Label scopesDescription;

    // Implicit flow
    @FXML
    private TextField implicitAuthorizationUrl;

    @FXML
    private Label implicitAuthorizationUrlDescription;

    // Password flow
    @FXML
    private TextField passwordTokenUrl;

    @FXML
    private Label passwordTokenUrlDescription;

    // Client credentials flow
    @FXML
    private TextField clientCredentialsTokenUrl;

    @FXML
    private Label clientCredentialsTokenUrlDescription;

    // Authorization code flow
    @FXML
    private TextField authorizationCodeAuthorizationUrl;

    @FXML
    private Label authorizationCodeAuthorizationUrlDescription;

    @FXML
    private TextField authorizationCodeTokenUrl;

    @FXML
    private Label authorizationCodeTokenUrlDescription;

    @FXML
    public void initialize() {
        descriptionDescription.setText(
                """
                A short description for security scheme.
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

        implicitAuthorizationUrlDescription.setText("The authorization URL to be used for this flow.");
        passwordTokenUrlDescription.setText("The token URL to be used for this flow.");
        clientCredentialsTokenUrlDescription.setText("The token URL to be used for this flow.");
        authorizationCodeAuthorizationUrlDescription.setText("The authorization URL to be used for this flow.");
        authorizationCodeTokenUrlDescription.setText("The token URL to be used for this flow.");
    }

    @FXML
    protected void onAddScopeButtonClick() {
        scopes.getItems().add(scope.getText());
        scope.setText("");
    }

}
