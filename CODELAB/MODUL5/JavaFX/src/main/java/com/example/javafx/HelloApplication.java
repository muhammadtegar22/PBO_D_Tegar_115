package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label lblnama = new Label("Nama");
        TextField nama = new TextField();

        Label lblgender = new Label("Jenis Kelamin: ");
        TextField gender = new TextField();

        Label lblnim = new Label("NIM: ");
        TextField nim = new TextField();


        VBox root = new VBox(10,lblnama,nama,lblnim,nim,lblgender,gender);
        Scene scene = new Scene(root,500,500);
        stage.setTitle("Hello!");
        stage.setTitle("Jenis Kelamin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}