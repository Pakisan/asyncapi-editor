package com.github.pakisan.asyncapieditor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public final class ViewsRouter {

    public static void asyncApiEditorView(Parent parent) throws IOException {
        var fxmlLoader = new FXMLLoader(WelcomeViewEmptyStateController.class.getResource("asyncapi-editor-view.fxml"));

        var scene = parent.getScene();
        scene.setRoot(fxmlLoader.load());
    }

    public static void createNewSpecificationModal(Parent parent) throws IOException {
        var fxmlLoader = new FXMLLoader(WelcomeViewEmptyStateController.class.getResource("create-new-specification-view.fxml"));

        var stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Create a New API Design");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent.getScene().getWindow());
        stage.showAndWait();
    }

}
