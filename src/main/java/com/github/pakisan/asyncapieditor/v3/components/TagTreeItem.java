package com.github.pakisan.asyncapieditor.v3.components;

import com.asyncapi.v3._0_0.model.Tag;
import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;

public class TagTreeItem extends TreeItem<String> {

    @NotNull
    private final Tag tag;

    public TagTreeItem(@NotNull Tag tag) {
        super(tag.getName(), new FontIcon(AntDesignIconsOutlined.TAG));

        this.tag = tag;
    }

}
