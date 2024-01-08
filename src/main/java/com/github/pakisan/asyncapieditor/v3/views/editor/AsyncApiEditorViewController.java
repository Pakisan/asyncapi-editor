package com.github.pakisan.asyncapieditor.v3.views.editor;

import com.asyncapi.v3._0_0.model.AsyncAPI;
import com.asyncapi.v3._0_0.model.info.Contact;
import com.asyncapi.v3._0_0.model.info.License;
import com.github.pakisan.asyncapieditor.ViewsRouter;
import com.github.pakisan.asyncapieditor.v3.SpecificationStructureProvider;
import com.github.pakisan.asyncapieditor.v3.components.ContactComponentController;
import com.github.pakisan.asyncapieditor.v3.components.InfoComponentController;
import com.github.pakisan.asyncapieditor.v3.components.LicenseComponentController;
import com.github.pakisan.asyncapieditor.v3.components.TagsComponentController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedList;

public class AsyncApiEditorViewController {

    @FXML
    private TreeView<String> specificationStructure;

    @FXML
    private AnchorPane specificationEditor;

    @NotNull
    private AsyncAPI specification;

    @NotNull
    private SpecificationStructureProvider specificationStructureProvider;

    public void bindSpecification(@NotNull AsyncAPI specification) {
        this.specification = specification;
        this.specificationStructureProvider = new SpecificationStructureProvider(specification);

        initializeSpecificationStructure();
    }

    private void initializeSpecificationStructure() {
        var specification           = new TreeItem<>(this.specification.getInfo().getTitle());
        var specificationInfo       = specificationStructureProvider.getSpecificationInfo();
        var specificationServers    = specificationStructureProvider.getSpecificationServers();
        var specificationChannels   = specificationStructureProvider.getSpecificationChannels();
        var specificationOperations = specificationStructureProvider.getSpecificationOperations();
        var specificationComponents = specificationStructureProvider.getSpecificationComponents();

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
                        renderInfoEditor();
                    } else if ("Contact".equalsIgnoreCase(((Text) target).getText())) {
                        renderContactEditor();
                    } else if ("License".equalsIgnoreCase(((Text) target).getText())) {
                        renderLicenseEditor();
                    } else if ("Tags".equalsIgnoreCase(((Text) target).getText())) {
                        renderTagsEditor();
                    }
                } catch (Exception e) {
                    throw new RuntimeException("View exception", e);
                }
            }
        });
    }

    private void renderInfoEditor() throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("/ui/v3/components/info-component.fxml"));
        Parent infoComponent = fxmlLoader.load();
        InfoComponentController infoComponentController = fxmlLoader.getController();
        infoComponentController.bindInfo(specification.getInfo());

        specificationEditor.getChildren().clear();
        specificationEditor.getChildren().add(infoComponent);
        fitToEditorPane(infoComponent);
    }

    private void renderContactEditor() throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("/ui/v3/components/contact-component.fxml"));
        Parent contactComponent = fxmlLoader.load();
        ContactComponentController contactComponentController = fxmlLoader.getController();

        if (specification.getInfo().getContact() == null) {
            specification.getInfo().setContact(new Contact());
        }
        contactComponentController.bindContact(specification.getInfo().getContact());

        specificationEditor.getChildren().clear();
        specificationEditor.getChildren().add(contactComponent);
        fitToEditorPane(contactComponent);
    }

    private void renderLicenseEditor() throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("/ui/v3/components/license-component.fxml"));
        Parent licenseComponent = fxmlLoader.load();
        LicenseComponentController licenseComponentController = fxmlLoader.getController();

        if (specification.getInfo().getLicense() == null) {
            specification.getInfo().setLicense(new License());
        }
        licenseComponentController.bindLicense(specification.getInfo().getLicense());

        specificationEditor.getChildren().clear();
        specificationEditor.getChildren().add(licenseComponent);
        fitToEditorPane(licenseComponent);
    }

    private void renderTagsEditor() throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("/ui/v3/components/tags-component.fxml"));
        Parent tagsComponent = fxmlLoader.load();
        TagsComponentController tagsComponentController = fxmlLoader.getController();

        if (specification.getInfo().getLicense() == null) {
            specification.getInfo().setLicense(new License());
        }
        if (specification.getInfo().getTags() == null) {
            specification.getInfo().setTags(new LinkedList<>());
        }
        tagsComponentController.initialize(
                specification.getInfo().getTags(),
                specificationStructureProvider.getSpecificationInfoTags()
        );

        specificationEditor.getChildren().clear();
        specificationEditor.getChildren().add(tagsComponent);
        fitToEditorPane(tagsComponent);
    }

    private void fitToEditorPane(@NotNull Parent component) {
        AnchorPane.setTopAnchor(component, 0.0);
        AnchorPane.setBottomAnchor(component, 0.0);
        AnchorPane.setLeftAnchor(component, 0.0);
        AnchorPane.setRightAnchor(component, 0.0);
    }

}
