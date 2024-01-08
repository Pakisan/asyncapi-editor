package com.github.pakisan.asyncapieditor.v3.components;

import atlantafx.base.theme.Styles;
import com.asyncapi.v3._0_0.model.Tag;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TagsComponentController {

    @FXML
    private TextField name;

    @FXML
    private TextArea description;

    @FXML
    private Button addTagButton;

    @NotNull
    private List<Object> tags;

    @NotNull
    private ObservableList<TreeItem<String>> tagTreeItems;

    public void initialize(@NotNull List<Object> tags, @NotNull ObservableList<TreeItem<String>> tagTreeItems) {
        this.tags = tags;
        this.tagTreeItems = tagTreeItems;
    }

    @FXML
    public void initialize() {
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            name.pseudoClassStateChanged(Styles.STATE_DANGER, newValue.isBlank());

            addTagButton.setDisable(newValue.isBlank());
        });

        if (name.getText().isBlank()) {
            addTagButton.setDisable(true);
        }
        addTagButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.SUCCESS);
    }

    public void addTag() {
        if (name.getText().isBlank()) {
            return;
        }

        var tag = new Tag(name.getText(), description.getText(), null);
        tags.add(tag);
        tagTreeItems.add(new TagTreeItem(tag));

        name.setText("");
        description.setText("");
    }

}
