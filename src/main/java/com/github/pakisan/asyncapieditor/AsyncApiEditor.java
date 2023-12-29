package com.github.pakisan.asyncapieditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AsyncApiEditor extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AsyncApiEditor.class.getResource("welcome-view_empty-state.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 802, 651);

        stage.setTitle("Welcome to AsyncAPI Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}