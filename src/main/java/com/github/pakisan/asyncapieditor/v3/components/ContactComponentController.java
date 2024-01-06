package com.github.pakisan.asyncapieditor.v3.components;

import com.asyncapi.v3._0_0.model.info.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.Nullable;

public class ContactComponentController {

    @FXML
    private TextField name;

    @FXML
    private TextField url;

    @FXML
    private TextField email;

    @Nullable
    private Contact contact;

    public void bindContact(@Nullable Contact contact) {
        this.contact = contact;

        name.setText(contact == null ? null : contact.getName());
        url.setText(contact == null ? null : contact.getUrl());
        email.setText(contact == null ? null : contact.getEmail());
    }

}
