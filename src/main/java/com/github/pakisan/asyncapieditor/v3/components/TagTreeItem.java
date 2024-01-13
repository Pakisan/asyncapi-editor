package com.github.pakisan.asyncapieditor.v3.components;

import com.asyncapi.v3._0_0.model.Tag;
import com.github.pakisan.asyncapieditor.icons.IconsLoader;
import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;

public class TagTreeItem extends TreeItem<String> {

    @NotNull
    private final Tag tag;

    public TagTreeItem(@NotNull Tag tag) {
        super(tag.getName(), IconsLoader.getTagIcon());

        this.tag = tag;
    }

}
