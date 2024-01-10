package com.github.pakisan.asyncapieditor;

import com.asyncapi.v3._0_0.model.server.Server;
import com.asyncapi.v3._0_0.model.AsyncAPI;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.info.Info;
import com.github.pakisan.asyncapieditor.v3.views.editor.AsyncApiEditorViewController;
import com.github.pakisan.asyncapieditor.views.modals.createnewspecification.dto.CreateNewSpecification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public final class ViewsRouter {

    private static Stage root;

    public static void init(Stage stage) {
        root = stage;
    }

    public static void asyncApiEditorView(CreateNewSpecification createNewSpecification) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("asyncapi-editor-view.fxml"));
        Parent asyncApiEditorView = fxmlLoader.load();
        AsyncApiEditorViewController asyncApiEditorViewController = fxmlLoader.getController();

        var asyncApi = new AsyncAPI();
        var tags = new LinkedList<>();
        tags.add(new Tag("asyncapi", null, null));
        tags.add(new Tag("v1.0", null, null));
        tags.add(new Tag("user accounts", null, null));
        tags.add(new Tag("first tag", null, null));
        tags.add(new Tag("second tag", null, null));
        tags.add(new Tag("third tag", null, null));
        asyncApi.setInfo(
                Info.builder()
                        .title(createNewSpecification.specificationName())
                        .description(createNewSpecification.specificationDescription())
                        .tags(tags)
                        .build()
        );
        var servers = new HashMap<String, Object>();
        servers.put("amqp demo server", Server.builder().build());
        servers.put("amqps demo server", Server.builder().build());
        servers.put("amqp1 demo server", Server.builder().build());
        servers.put("amqps1 demo server", Server.builder().build());
        servers.put("anypointmq demo server", Server.builder().build());
        servers.put("googlepubsub demo server", Server.builder().build());
        servers.put("http demo server", Server.builder().build());
        servers.put("ibmmq demo server", Server.builder().build());
        servers.put("jms demo server", Server.builder().build());
        servers.put("kafka demo server", Server.builder().build());
        servers.put("mercure demo server", Server.builder().build());
        servers.put("mqtt demo server", Server.builder().build());
        servers.put("mqtt5 demo server", Server.builder().build());
        servers.put("nats demo server", Server.builder().build());
        servers.put("pulsar demo server", Server.builder().build());
        servers.put("redis demo server", Server.builder().build());
        servers.put("sns demo server", Server.builder().build());
        servers.put("solace demo server", Server.builder().build());
        servers.put("sqs demo server", Server.builder().build());
        servers.put("stomp demo server", Server.builder().build());
        servers.put("ws demo server", Server.builder().build());
        asyncApi.setServers(servers);
        asyncApiEditorViewController.bindSpecification(asyncApi);

        root.setScene(new Scene(asyncApiEditorView, 802, 651));
        root.setTitle(createNewSpecification.specificationName());
    }

    public static void createNewSpecificationModal(Parent parent) throws IOException {
        var fxmlLoader = new FXMLLoader(ViewsRouter.class.getResource("/ui/views/create-new-specification-view.fxml"));

        var stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Create a New API Design");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent.getScene().getWindow());
        stage.showAndWait();
    }

}
