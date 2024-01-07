package com.github.pakisan.asyncapieditor.views.modals.createnewspecification;

import atlantafx.base.theme.Styles;
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
        // TODO: remove mock
        specificationName.setText("Test specification");
        specificationName.textProperty().addListener(
                (observable, oldValue, newValue) -> createButton.setDisable(newValue.isBlank())
        );
        specificationDescription.setText(
                """
                This service is in charge of processing user signups :rocket:
                
                It's easy to use:
                - choose user
                - authenticate
                - receive incoming messages
                """
        );

        ObservableList<SpecificationVersion> specificationVersions = FXCollections.observableArrayList();
        specificationVersions.addAll(SpecificationVersion.values());
        specificationVersion.setItems(specificationVersions);

        cancelButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.DANGER);

        if (specificationName.getText().isBlank()) {
            createButton.setDisable(true);
        }
        createButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.SUCCESS);
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
