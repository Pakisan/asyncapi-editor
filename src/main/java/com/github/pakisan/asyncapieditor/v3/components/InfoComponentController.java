package com.github.pakisan.asyncapieditor.v3.components;

import atlantafx.base.theme.Styles;
import com.asyncapi.v3._0_0.model.info.Info;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

public class InfoComponentController {

    @FXML
    private TextField title;

    @FXML
    private TextField version;

    @FXML
    private TextArea description;

    @FXML
    private TextField termsOfService;

    @NotNull
    private Info info;

    public void bindInfo(@NotNull Info info) {
        this.info = info;

        title.setText(info.getTitle());

        version.setText(info.getVersion());
        if (info.getVersion().isBlank()) {
            version.pseudoClassStateChanged(Styles.STATE_DANGER, true);
        }

        description.setText(info.getDescription());
        termsOfService.setText(info.getTermsOfService());
    }

    @FXML
    public void initialize() {
        title.textProperty().addListener((observable, oldValue, newValue) -> {
            title.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());
            info.setTitle(newValue);
        });

        version.textProperty().addListener((observable, oldValue, newValue) -> {
            version.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());
            info.setVersion(newValue);
        });

        description.textProperty().addListener((observable, oldValue, newValue) -> {
            info.setDescription(newValue);
        });

        termsOfService.textProperty().addListener((observable, oldValue, newValue) -> {
            info.setTermsOfService(newValue);
        });
    }

}
