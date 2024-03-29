package com.github.pakisan.asyncapieditor.v3;

import com.asyncapi.v3._0_0.model.AsyncAPI;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.server.Server;
import com.github.pakisan.asyncapieditor.icons.IconsLoader;
import com.github.pakisan.asyncapieditor.v3.components.TagTreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;

public class SpecificationStructureProvider {

    @NotNull
    private final AsyncAPI specification;

    @NotNull
    private ObservableList<TreeItem<String>> tagTreeItems = FXCollections.emptyObservableList();

    public SpecificationStructureProvider(@NotNull AsyncAPI specification) {
        this.specification = specification;
    }

    public TreeItem<String> getSpecificationInfo() {
        var specificationInfo       = new TreeItem<>("Info", IconsLoader.getInfoIcon());
        specificationInfo.getChildren().add(new TreeItem<>("Contact"));
        specificationInfo.getChildren().add(new TreeItem<>("License"));
        specificationInfo.getChildren().add(specificationInfoTags());

        return specificationInfo;
    }

    private TreeItem<String> specificationInfoTags() {
        var specificationInfoTags   = new TreeItem<>("Tags", IconsLoader.getTagsIcon());
        if (specification.getInfo().getTags() != null) {
            specification.getInfo().getTags().forEach(tag -> {
                if (tag instanceof Tag) {
                    specificationInfoTags.getChildren().add(new TagTreeItem((Tag) tag));
                }
            });
        }

        tagTreeItems = specificationInfoTags.getChildren();
        return specificationInfoTags;
    }

    public ObservableList<TreeItem<String>> getSpecificationInfoTags() {
        return tagTreeItems;
    }

    public TreeItem<String> getSpecificationServers() {
        var specificationServers = new TreeItem<>("Servers", IconsLoader.getServersIcon());
        if (specification.getServers() != null) {
            specification.getServers().keySet().forEach(serverName -> {
                var server = specification.getServers().getOrDefault(serverName, null);
                if (server instanceof Server) {
                    var serverTreeItem = new TreeItem<>(serverName, IconsLoader.getServerIcon(((Server) server).getProtocol()));
                    serverTreeItem.getChildren().add(new TreeItem<>("Tags", IconsLoader.getTagsIcon()));
                    serverTreeItem.getChildren().add(new TreeItem<>("Bindings", IconsLoader.getServerBindingsIcon()));
                    serverTreeItem.getChildren().add(new TreeItem<>("Security", IconsLoader.getServerSecurityIcon()));
                    serverTreeItem.getChildren().add(new TreeItem<>("Variables", IconsLoader.getServerVariablesIcon()));

                    specificationServers.getChildren().add(serverTreeItem);
                }
            });
        }

        return specificationServers;
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
