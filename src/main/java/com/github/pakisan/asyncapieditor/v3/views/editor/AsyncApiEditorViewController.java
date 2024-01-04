package com.github.pakisan.asyncapieditor.v3.views.editor;

import com.github.pakisan.asyncapieditor.ViewsRouter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class AsyncApiEditorViewController {

    @FXML
    private TreeView<String> specificationStructure;

    @FXML
    private AnchorPane specificationEditor;

    @FXML
    public void initialize() {
        var specificationInfo       = new TreeItem<>("Info");
        specificationInfo.getChildren().add(new TreeItem<>("Contact"));
        specificationInfo.getChildren().add(new TreeItem<>("License"));

        var specificationInfoTags   = new TreeItem<>("Tags");
        specificationInfoTags.getChildren().add(new TreeItem<>("asyncapi"));
        specificationInfoTags.getChildren().add(new TreeItem<>("v1.0"));
        specificationInfoTags.getChildren().add(new TreeItem<>("user accounts"));
        specificationInfo.getChildren().add(specificationInfoTags);

        var specificationServers    = new TreeItem<>("Servers");
        var specificationChannels   = new TreeItem<>("Channels");
        var specificationOperations = new TreeItem<>("Operations");
        var specificationComponents = new TreeItem<>("Components");

        var specification = new TreeItem<>("Account Service");
        specification.setExpanded(true);
        specification.getChildren().add(specificationInfo);
        specification.getChildren().add(specificationServers);
        specification.getChildren().add(specificationChannels);
        specification.getChildren().add(specificationOperations);
        specification.getChildren().add(specificationComponents);

        specificationStructure.setRoot(specification);
        specificationStructure.setOnMouseClicked(event -> {
            if (!event.getButton().equals(MouseButton.PRIMARY)) {
                return;
            }

            var target = event.getTarget();
            if (target instanceof Text) {
                try {
                    if ("Info".equalsIgnoreCase(((Text) target).getText())) {
                        loadEditor("/ui/v3/components/info-component.fxml");
                    } else if ("Contact".equalsIgnoreCase(((Text) target).getText())) {
                        loadEditor("/ui/v3/components/contact-component.fxml");
                    } else if ("License".equalsIgnoreCase(((Text) target).getText())) {
                        loadEditor("/ui/v3/components/license-component.fxml");
                    } else if ("Tags".equalsIgnoreCase(((Text) target).getText())) {
                        loadEditor("/ui/v3/components/tags-component.fxml");
                    }
                } catch (Exception ignored) {
                }
            }
        });
    }

    private void loadEditor(String editorView) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource(editorView));
        specificationEditor.getChildren().clear();
        specificationEditor.getChildren().add(fxmlLoader.load());
    }

}
