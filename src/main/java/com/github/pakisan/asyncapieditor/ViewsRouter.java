package com.github.pakisan.asyncapieditor;

import com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto.CreateNewSpecification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public final class ViewsRouter {

    private static Stage root;

    public static void init(Stage stage) {
        root = stage;
    }

    public static void asyncApiEditorView(CreateNewSpecification createNewSpecification) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("asyncapi-editor-view.fxml"));

        root.setScene(new Scene(fxmlLoader.load(), 802, 651));
        root.setTitle(createNewSpecification.specificationName());
    }

    public static void createNewSpecificationModal(Parent parent) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("create-new-specification-view.fxml"));

        var stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Create a New API Design");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent.getScene().getWindow());
        stage.showAndWait();
    }

}
