package com.github.pakisan.asyncapieditor.v3.components;

import com.asyncapi.v3._0_0.model.info.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class ContactComponentController {

    @FXML
    private TextField name;

    @FXML
    private TextField url;

    @FXML
    private TextField email;

    @NotNull
    private Contact contact;

    public void bindContact(@NotNull Contact contact) {
        this.contact = contact;

        name.setText(contact.getName());
        url.setText(contact.getUrl());
        email.setText(contact.getEmail());
    }

    @FXML
    public void initialize() {
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            contact.setName(newValue);
        });

        url.textProperty().addListener((observable, oldValue, newValue) -> {
            contact.setUrl(newValue);
        });

        email.textProperty().addListener((observable, oldValue, newValue) -> {
            contact.setEmail(newValue);
        });
    }

}
