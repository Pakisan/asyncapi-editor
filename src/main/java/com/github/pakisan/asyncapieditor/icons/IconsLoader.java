package com.github.pakisan.asyncapieditor.icons;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;

public class IconsLoader {

    @NotNull
    public static Node getInfoIcon() {
        return new FontIcon(AntDesignIconsOutlined.INFO_CIRCLE);
    }

    @NotNull
    public static Node getTagsIcon() {
        return new FontIcon(AntDesignIconsOutlined.TAGS);
    }

    @NotNull
    public static Node getTagIcon() {
        return new FontIcon(AntDesignIconsOutlined.TAG);
    }

    @NotNull
    public static Node getServersIcon() {
        return new FontIcon(AntDesignIconsOutlined.CLUSTER);
    }

    @NotNull
    public static ImageView getServerIcon(@NotNull String serverProtocol) {
        ImageView icon;

        switch (serverProtocol.toLowerCase()) {
            case "amqp", "amqps", "amqp1", "amqps1": {
                icon = treeViewIcon(loadImageResource("/ui/icons/amqp.png"));
                break;
            } case "anypointmq": {
                icon = treeViewIcon(loadImageResource("/ui/icons/anypointmq.png"));
                break;
            } case "googlepubsub": {
                icon = treeViewIcon(loadImageResource("/ui/icons/googlepubsub.png"));
                break;
            } case "http": {
                icon = treeViewIcon(loadImageResource("/ui/icons/http.png"));
                break;
            } case "ibmmq": {
                icon = treeViewIcon(loadImageResource("/ui/icons/ibmmq.png"));
                break;
            } case "jms": {
                icon = treeViewIcon(loadImageResource("/ui/icons/jms.png"));
                break;
            } case "kafka": {
                icon = treeViewIcon(loadImageResource("/ui/icons/kafka.png"));
                break;
            } case "mercure": {
                icon = treeViewIcon(loadImageResource("/ui/icons/mercure.png"));
                break;
            } case "mqtt", "mqtt5": {
                icon = treeViewIcon(loadImageResource("/ui/icons/mqtt.png"));
                break;
            } case "nats": {
                icon = treeViewIcon(loadImageResource("/ui/icons/nats.png"));
                break;
            } case "pulsar": {
                icon = treeViewIcon(loadImageResource("/ui/icons/pulsar.png"));
                break;
            } case "redis": {
                icon = treeViewIcon(loadImageResource("/ui/icons/redis.png"));
                break;
            } case "sns": {
                icon = treeViewIcon(loadImageResource("/ui/icons/sns.png"));
                break;
            } case "solace": {
                icon = treeViewIcon(loadImageResource("/ui/icons/solace.png"));
                break;
            } case "sqs": {
                icon = treeViewIcon(loadImageResource("/ui/icons/sqs.png"));
                break;
            } case "stomp": {
            } case "ws": {
                icon = treeViewIcon(loadImageResource("/ui/icons/ws.png"));
                break;
            }
            default: {
                icon = null;
            }
        }

        return icon;
    }

    @NotNull
    public static Node getServerBindingsIcon() {
        return new FontIcon(AntDesignIconsOutlined.SUBNODE);
    }

    @NotNull
    public static Node getServerSecurityIcon() {
        return new FontIcon(AntDesignIconsOutlined.SAFETY);
    }

    @NotNull
    public static Node getServerVariablesIcon() {
        return new FontIcon(AntDesignIconsOutlined.FORM);
    }

    @NotNull
    private static ImageView treeViewIcon(@NotNull Image image) {
        var imageView = new ImageView(image);
        imageView.setFitHeight(16.0);
        imageView.setSmooth(true);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    @NotNull
    private static Image loadImageResource(@NotNull String resourceName) {
        return new Image(IconsLoader.class.getResource(resourceName).toExternalForm());
    }

}
