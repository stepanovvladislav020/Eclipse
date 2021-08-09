package com.eclipse;
import com.eclipse.controllers.mainPageController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootApplication
public class EclipseApplication extends Application{

    private ConfigurableApplicationContext applicationContext;
    private Parent rootNode;
    private double xOffset;
    private double yOffset;
    private static final String cssMainPage = "src/main/resources/Style/mainPageStyle.css";

    public static void main(String[] args) {
        Application.launch(EclipseApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(rootNode));
        stage.getScene().getStylesheets().add(new File(cssMainPage).toURI().toURL().toExternalForm());
        Image image = new Image("/assets/staticLogo2.png");
        stage.getIcons().add(image);
        stage.initStyle(StageStyle.TRANSPARENT);
        rootNode.getScene().setFill(Color.TRANSPARENT);
        stage.show();

        rootNode.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        rootNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

    }

    @Override
    public void stop() throws Exception{
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void init() throws Exception{
        applicationContext = new SpringApplicationBuilder(EclipseApplication.class).run();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainPage.fxml"));
        rootNode = fxmlLoader.load();
    }


}
