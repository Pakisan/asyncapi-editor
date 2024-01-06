package com.github.pakisan.asyncapieditor.v3.components;

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
        description.setText(info.getDescription());
        termsOfService.setText(info.getTermsOfService());
    }

}
