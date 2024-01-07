package com.github.pakisan.asyncapieditor.v3.components;

import atlantafx.base.theme.Styles;
import com.asyncapi.v3._0_0.model.info.License;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class LicenseComponentController {

    @FXML
    private TextField name;

    @FXML
    private TextField url;

    @NotNull
    private License license;

    public void bindLicense(@NotNull License license) {
        this.license = license;

        name.setText(license.getName());
        if (license.getName().isBlank()) {
            name.pseudoClassStateChanged(Styles.STATE_DANGER, true);
        }

        url.setText(license.getUrl());
    }

    @FXML
    public void initialize() {
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            name.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());
            license.setName(newValue);
        });

        url.textProperty().addListener((observable, oldValue, newValue) -> {
            license.setUrl(newValue);
        });
    }

}
