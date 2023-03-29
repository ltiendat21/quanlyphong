package com.example.baitaplon_ttnt;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FormQuanLy.fxml"));
        stage.setTitle("Form Quản Lý");
        stage.setScene(new Scene(root));
        stage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("FormQuanLy.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}