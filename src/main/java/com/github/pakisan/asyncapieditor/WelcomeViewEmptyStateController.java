package com.github.pakisan.asyncapieditor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomeViewEmptyStateController {

    @FXML
    private Button newSpecificationButton;

    @FXML
    private Button openSpecificationButton;

    @FXML
    protected void onNewSpecificationButtonClick() throws IOException {
        ViewsRouter.createNewSpecificationModal(newSpecificationButton);
    }

    @FXML
    protected void onOpenSpecificationButtonClick() {
        Platform.runLater(() -> {
            System.out.println("onOpenSpecificationButtonClick");
        });
    }

}
