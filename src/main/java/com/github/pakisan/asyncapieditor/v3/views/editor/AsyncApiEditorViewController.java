package com.github.pakisan.asyncapieditor.v3.views.editor;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class AsyncApiEditorViewController {

    @FXML
    private TreeView<String> specificationStructure;

    @FXML
    private AnchorPane specificationEditor;

    @FXML
    public void initialize() {
        var specificationInfo       = new TreeItem<>("Info");
        var specificationServers    = new TreeItem<>("Servers");
        var specificationChannels   = new TreeItem<>("Channels");
        var specificationOperations = new TreeItem<>("Operations");
        var specificationComponents = new TreeItem<>("Components");

        var specification = new TreeItem<>("Account Service");
        specification.setExpanded(false);
        specification.getChildren().add(specificationInfo);
        specification.getChildren().add(specificationServers);
        specification.getChildren().add(specificationChannels);
        specification.getChildren().add(specificationOperations);
        specification.getChildren().add(specificationComponents);

        specificationStructure.setRoot(specification);
    }

}
