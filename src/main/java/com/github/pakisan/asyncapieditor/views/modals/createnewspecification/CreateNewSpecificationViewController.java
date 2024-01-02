package com.github.pakisan.asyncapieditor.views.modals.createnewspecification;

import com.github.pakisan.asyncapieditor.ViewsRouter;
import com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto.CreateNewSpecification;
import com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto.SpecificationTemplate;
import com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto.SpecificationVersion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateNewSpecificationViewController {

    @FXML
    private TextField specificationName;

    @FXML
    private TextArea specificationDescription;

    @FXML
    private ChoiceBox<SpecificationVersion> specificationVersion;

    @FXML
    private ChoiceBox<SpecificationTemplate> specificationTemplate;

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    public void initialize() {
        ObservableList<SpecificationVersion> specificationVersions = FXCollections.observableArrayList();
        specificationVersions.addAll(SpecificationVersion.values());
        specificationVersion.setItems(specificationVersions);
    }

    @FXML
    public void cancelButtonOnAction() {
        close();
    }

    @FXML
    public void createButtonOnAction() throws IOException {
        ViewsRouter.asyncApiEditorView(new CreateNewSpecification(specificationName.getText(),
                specificationDescription.getText(),
                specificationVersion.getValue(),
                specificationTemplate.getValue()));

        close();
    }

    private void close() {
        var stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
