package com.github.pakisan.asyncapieditor.v3;

import com.asyncapi.v3._0_0.model.AsyncAPI;
import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;

public class SpecificationStructureProvider {

    @NotNull
    private final AsyncAPI specification;

    public SpecificationStructureProvider(@NotNull AsyncAPI specification) {
        this.specification = specification;
    }

    public TreeItem<String> getSpecificationInfo() {
        var specificationInfo       = new TreeItem<>("Info");
        specificationInfo.getChildren().add(new TreeItem<>("Contact"));
        specificationInfo.getChildren().add(new TreeItem<>("License"));
        specificationInfo.getChildren().add(specificationInfoTags());

        return specificationInfo;
    }

    private TreeItem<String> specificationInfoTags() {
        var specificationInfoTags   = new TreeItem<>("Tags");
        specificationInfoTags.getChildren().add(new TreeItem<>("asyncapi"));
        specificationInfoTags.getChildren().add(new TreeItem<>("v1.0"));
        specificationInfoTags.getChildren().add(new TreeItem<>("user accounts"));

        return specificationInfoTags;
    }

    public TreeItem<String> getSpecificationServers() {
        return new TreeItem<>("Servers");
    }

    public TreeItem<String> getSpecificationChannels() {
        return new TreeItem<>("Channels");
    }

    public TreeItem<String> getSpecificationOperations() {
        return new TreeItem<>("Operations");
    }

    public TreeItem<String> getSpecificationComponents() {
        return new TreeItem<>("Components");
    }

}
