package com.eclipse.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {

    @FXML
    private MediaView logomp4;
    @FXML
    private ImageView logo;
    @FXML
    public static TextField LoginField;
    @FXML
    public static ToggleButton inToggleButt,upToggleButt;
    @FXML
    public static AnchorPane signInPanel, signUpPanel;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("src/main/resources/assets/logounscreenmp4.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        logomp4.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        ToggleGroup group = new ToggleGroup();
        inToggleButt = new ToggleButton("in");
        upToggleButt = new ToggleButton("up");
        inToggleButt.setToggleGroup(group);
        upToggleButt.setToggleGroup(group);
    }
}
